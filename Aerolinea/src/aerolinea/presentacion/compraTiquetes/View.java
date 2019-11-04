/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.compraTiquetes;

import Listado.Admin.VuelosTableModel;
import aerolinea.Application;
import aerolinea.logica.MetodoPago;
import aerolinea.logica.Reservacion;
import aerolinea.logica.Tiquete;
import aerolinea.logica.Usuario;
import aerolinea.logica.Vuelo;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ian Rodriguez
 */
public class View extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        Paypal.setVisible(false);
        MasterCard.setVisible(false);
        Visa.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        generarFacturaBoton.setVisible(false);
    }
            
    Reservacion reserva;
    Tiquete tiquete;
    MetodoPago metodo;
    
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
    private static final Font VUEL_FONT = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.BLACK);
    private static final Font PRECIO_FONT = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLACK);

    public void br(Chapter chapter,int i) {
        Font ENTER_FONT = new Font(Font.FontFamily.HELVETICA, i, Font.NORMAL, BaseColor.WHITE);
        chapter.add(new Paragraph("ENTER", ENTER_FONT));
    }

    public void createPDF(File pdfNewFile) {
        String linea = "";
        Usuario u=null;
        Vuelo vu = null;
        try {
            u = aerolinea.logica.ModelUsuarios.instanciar().consultarPorCorreo(metodo.getCorreoP());
            vu = aerolinea.logica.ModelVuelo.instanciar().consultarPorRuta(reserva.getVuelo());
        } catch (Exception ex) {
            
        }
        try {
            Document document = new Document();
            try {

                PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream(pdfNewFile));

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            document.addTitle("Facturas");
            document.addSubject("Facturas");
            document.addKeywords("Facturas");
            document.addAuthor("Ian Rodriguez");
            document.addCreator("Ian Rodriguez");

            Chapter chapter = new Chapter(1);
            Font black = new Font(Font.FontFamily.HELVETICA, 36, Font.NORMAL, BaseColor.BLACK);
            LineSeparator ls = new LineSeparator();
            
            chapter.add(new Chunk(ls));
            br(chapter,10);
            
            chapter.add(new Chunk("Factura de Compra", black));
            
            br(chapter,15);
            chapter.add(new Paragraph("Informacion del cliente", VUEL_FONT));
            br(chapter,10);
            linea = tiquete.getNumTiquete();
            chapter.add(new Paragraph("Tiquete de compra numero: "+linea, paragraphFont));
            br(chapter,5);
            linea = u.getNombre() +" "+ u.getApellidos();
            chapter.add(new Paragraph("Nombre de la persona: "+linea, paragraphFont));
            br(chapter,5);
            linea =u.getCorreo();
            chapter.add(new Paragraph("Correo: "+linea, paragraphFont));
            
            chapter.add(new Chunk(ls));

            chapter.add(new Paragraph("Pago:", VUEL_FONT));
            br(chapter,10);
            linea = metodo.getId();
            chapter.add(new Paragraph("Metodo de pago: "+linea, paragraphFont));
            br(chapter,5);
            linea = metodo.getCardNum();
            chapter.add(new Paragraph("Numero de Tarjeta: "+linea, paragraphFont));
            br(chapter,5);
            linea = metodo.getVemc();
            chapter.add(new Paragraph("Vencimiento: "+linea, paragraphFont));
            br(chapter,5);
            linea = metodo.getHolder();
            chapter.add(new Paragraph("Holder: "+linea, paragraphFont));

            chapter.add(new Chunk(ls));

            chapter.add(new Paragraph("Informacion del vuelo:", VUEL_FONT));
            br(chapter,10);
            
            linea = vu.getIdVuelo();
            chapter.add(new Paragraph("Id del Vuelo: "+linea, paragraphFont));
            br(chapter,4);
            linea = vu.getRuta().getCodigoRuta();
            chapter.add(new Paragraph("Codigo de Ruta: "+linea, paragraphFont));
            br(chapter,4);
            linea = vu.getRuta().getCiudadDestino();
            chapter.add(new Paragraph("Ciudad de Destino: "+linea, paragraphFont));
            br(chapter,4);
            linea = vu.getRuta().getCiudadOrigen();
            chapter.add(new Paragraph("Ciudad de Origen: "+linea, paragraphFont));
            br(chapter,4);
            linea = vu.getHorario().getHoraSalida();
            chapter.add(new Paragraph("Fecha de salida: "+linea, paragraphFont));
            br(chapter,4);
            linea = vu.getHorario().getHoraLlegada();
            chapter.add(new Paragraph("Hora de salida: "+linea, paragraphFont));
            br(chapter,4);
            linea = vu.getAvion().getModelo() + " " + vu.getAvion().getMarca() + " " + vu.getAvion().getAnno();
            chapter.add(new Paragraph("Tipo de Avion: "+linea, paragraphFont));
            
            chapter.add(new Chunk(ls));
            chapter.add(new Chunk(ls));
            
            br(chapter,8);
            linea = vu.getHorario().getPrecio();
            chapter.add(new Paragraph("Total por pagar: $"+linea, PRECIO_FONT));

            document.add(chapter);
            document.close();
            System.out.println("¡Se ha generado tu factura!");
        } catch (DocumentException documentException) {
            System.out.println("(Se ha producido un error al generar un documento): " + documentException);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVuelos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboPagos = new javax.swing.JComboBox();
        LayerPane = new javax.swing.JLayeredPane();
        Visa = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        visaCard = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        visaVenc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        VisaVcc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        VisaCardHolder = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Paypal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        PaypalCorreo = new javax.swing.JTextField();
        PaypalPass = new javax.swing.JTextField();
        PagarPayPal = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        MasterCard = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        MCHolder = new javax.swing.JTextField();
        MCVcc = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        MCCard = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        MCVenc = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        selecRuta = new javax.swing.JTextField();
        selectFecha = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        generarFacturaBoton = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compra de Tiquetes");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(31, 75, 119));

        tablaVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVuelosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVuelos);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Compra de Tiquetes");

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Seleccione un Vuelo");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Metodo de pago");

        comboPagos.setMaximumRowCount(3);
        comboPagos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Visa", "PayPal", "MasterCard", " " }));
        comboPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboPagosMouseClicked(evt);
            }
        });
        comboPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPagosActionPerformed(evt);
            }
        });

        LayerPane.setMaximumSize(new java.awt.Dimension(1250, 1250));

        Visa.setBackground(new java.awt.Color(31, 75, 119));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Card Number:");

        visaCard.setText("4151 1234 5678 1478");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Vencimiento");

        visaVenc.setText("11/22");
        visaVenc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visaVencActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("VCC");

        VisaVcc.setText("122");
        VisaVcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisaVccActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Card Holder");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-visa-50.png"))); // NOI18N
        jLabel8.setText("Visa");

        javax.swing.GroupLayout VisaLayout = new javax.swing.GroupLayout(Visa);
        Visa.setLayout(VisaLayout);
        VisaLayout.setHorizontalGroup(
            VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VisaLayout.createSequentialGroup()
                .addGroup(VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(VisaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(visaCard)
                            .addGroup(VisaLayout.createSequentialGroup()
                                .addComponent(visaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VisaVcc))
                            .addComponent(VisaCardHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, VisaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        VisaLayout.setVerticalGroup(
            VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addGroup(VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(visaCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(visaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(VisaVcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(VisaCardHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        Paypal.setBackground(new java.awt.Color(31, 75, 119));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/pp.png"))); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(100, 100));

        PagarPayPal.setBackground(new java.awt.Color(0, 153, 255));
        PagarPayPal.setForeground(new java.awt.Color(255, 255, 255));
        PagarPayPal.setText("Acceder");
        PagarPayPal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PagarPayPal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarPayPalActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Correo");

        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Contraseña");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PaypalPass, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PaypalCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(PagarPayPal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaypalCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaypalPass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addComponent(PagarPayPal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-paypal-50.png"))); // NOI18N
        jLabel10.setText("PayPal");

        javax.swing.GroupLayout PaypalLayout = new javax.swing.GroupLayout(Paypal);
        Paypal.setLayout(PaypalLayout);
        PaypalLayout.setHorizontalGroup(
            PaypalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaypalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaypalLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        PaypalLayout.setVerticalGroup(
            PaypalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaypalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        MasterCard.setBackground(new java.awt.Color(31, 75, 119));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-mastercard-50.png"))); // NOI18N
        jLabel9.setText("MasterCard");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("VCC");

        MCVcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCVccActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Card Holder");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Vencimiento");

        MCVenc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCVencActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Card Number:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout MasterCardLayout = new javax.swing.GroupLayout(MasterCard);
        MasterCard.setLayout(MasterCardLayout);
        MasterCardLayout.setHorizontalGroup(
            MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterCardLayout.createSequentialGroup()
                .addGroup(MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MasterCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(MasterCardLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18))
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MCCard)
                            .addGroup(MasterCardLayout.createSequentialGroup()
                                .addComponent(MCVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MCVcc))
                            .addComponent(MCHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MasterCardLayout.setVerticalGroup(
            MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterCardLayout.createSequentialGroup()
                .addGroup(MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MasterCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(42, 42, 42)
                        .addGroup(MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(MCCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(MCVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(MCVcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MasterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(MCHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MasterCardLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LayerPaneLayout = new javax.swing.GroupLayout(LayerPane);
        LayerPane.setLayout(LayerPaneLayout);
        LayerPaneLayout.setHorizontalGroup(
            LayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayerPaneLayout.createSequentialGroup()
                .addComponent(Visa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
            .addGroup(LayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayerPaneLayout.createSequentialGroup()
                    .addComponent(Paypal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 47, Short.MAX_VALUE)))
            .addGroup(LayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MasterCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LayerPaneLayout.setVerticalGroup(
            LayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Visa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LayerPaneLayout.createSequentialGroup()
                    .addComponent(Paypal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 81, Short.MAX_VALUE)))
            .addGroup(LayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MasterCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LayerPane.setLayer(Visa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LayerPane.setLayer(Paypal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        LayerPane.setLayer(MasterCard, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Seleccionar Metodo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Vuelo Seleccionado");

        selecRuta.setEditable(false);
        selecRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecRutaActionPerformed(evt);
            }
        });

        selectFecha.setEditable(false);
        selectFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFechaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 255, 255));
        jLabel20.setText("$");

        precioLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        precioLabel.setForeground(new java.awt.Color(153, 255, 255));
        precioLabel.setText("0.00");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/avion.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-búsqueda-50.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Ruta");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Fecha");

        jButton1.setText("Check in");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        generarFacturaBoton.setText("Generar Factura");
        generarFacturaBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generarFacturaBotonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2)
                        .addGap(305, 305, 305)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LayerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(comboPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(precioLabel))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel12))
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(selecRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(selectFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(generarFacturaBoton)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(comboPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton2))
                                .addGap(6, 6, 6)
                                .addComponent(LayerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selecRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selectFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(precioLabel))
                                .addGap(15, 15, 15)
                                .addComponent(jLabel12)
                                .addGap(47, 47, 47)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(generarFacturaBoton))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void visaVencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visaVencActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_visaVencActionPerformed

    private void VisaVccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisaVccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VisaVccActionPerformed

    private void PagarPayPalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagarPayPalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PagarPayPalActionPerformed

    private void comboPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPagosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPagosActionPerformed

    private void comboPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboPagosMouseClicked
        // TODO add your handling code here:
        //combo Elegir

    }//GEN-LAST:event_comboPagosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int i;
        i = comboPagos.getSelectedIndex();
        switch (i) {
            case 0:
                Visa.setVisible(true);
                MasterCard.setVisible(false);
                Paypal.setVisible(false);
                break;
            case 1:
                Paypal.setVisible(true);
                MasterCard.setVisible(false);
                Visa.setVisible(false);
                break;
            case 2:
                MasterCard.setVisible(true);
                Visa.setVisible(false);
                Paypal.setVisible(false);
                break;
            default:
                break;

        }
        VisaCardHolder.setText((Application.Perfil_Controller.getModel().getSesion().getIdUsuario()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selecRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecRutaActionPerformed

    private void selectFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectFechaActionPerformed

    private void MCVencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MCVencActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MCVencActionPerformed

    private void MCVccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MCVccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MCVccActionPerformed

    private void tablaVuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVuelosMouseClicked
        // TODO add your handling code here:
        //seleccionar
        String id;
        if (evt.getClickCount() == 2) {
            int row = this.tablaVuelos.getSelectedRow();
            id = tablaVuelos.getValueAt(row, 1).toString();
            selecRuta.setText(id);
            id = tablaVuelos.getValueAt(row, 4).toString();
            selectFecha.setText(id);
            id = tablaVuelos.getValueAt(row, 8).toString();
            precioLabel.setText(id);
        }
    }//GEN-LAST:event_tablaVuelosMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        controller.leerDatos();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //checkIn
        
    }//GEN-LAST:event_jButton1ActionPerformed
    String idTiquete,vuelo;
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        String metodoPago="",holder="",cardNum="",vence="",vcc="",correo="";
        int i;
        i = comboPagos.getSelectedIndex();
        switch (i) {
            case 0:
                metodoPago = "Visa";
                holder = VisaCardHolder.getText();
                cardNum = visaCard.getText();
                vence = visaVenc.getText();
                vcc = VisaVcc.getText();
                correo = "";
                break;
            case 1:
                metodoPago = "PayPal";
                holder = "PagoPayPal";
                cardNum = "PagoPayPal";
                vence = "PagoPayPal";
                vcc = "PagoPayPal";
                correo = PaypalCorreo.getText();
                break;
            case 2:
                metodoPago = "MasterCard";
                holder = MCHolder.getText();
                cardNum = MCCard.getText();
                vence = MCVenc.getText();
                vcc = MCVcc.getText();
                correo = "";
                break;
            default:
                break;

        }
        String idReserva,user,asiento;
        Random r = new Random();
        int asientoNumero = r.nextInt(180);
        char letra = (char)(r.nextInt(91) + 65);
        asiento = letra + asientoNumero + "";
        
        int row = this.tablaVuelos.getSelectedRow();
        
        idReserva = tablaVuelos.getValueAt(row, 0).toString();
        vuelo = tablaVuelos.getValueAt(row, 1).toString();
        idTiquete = idReserva;

        correo = Application.Perfil_Controller.getModel().getSesion().getCorreo();
        user = (Application.Perfil_Controller.getModel().getSesion().getIdUsuario());
        
        reserva = new Reservacion(idReserva,vuelo,metodoPago);
        tiquete = new Tiquete(idTiquete,idTiquete,user,asiento);
        metodo = new MetodoPago(metodoPago,cardNum,vence,vcc,holder,correo);
        
        try {
            controller.agregar(reserva, tiquete, metodo);
            JOptionPane.showMessageDialog(this, "Compra exitosa");
            generarFacturaBoton.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Compra No fue realizada");
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void generarFacturaBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarFacturaBotonMouseClicked
        // TODO add your handling code here:
        Usuario user = Application.Perfil_Controller.getModel().getSesion();
        String factura;
        factura = "FacturasGeneradas/"+user.getNombre()+user.getApellidos()+"-"+idTiquete+"-"+vuelo+".pdf";
        createPDF(new File(factura));
        generarFacturaBoton.setVisible(false);
        
        try {
            Desktop.getDesktop().open(new File(factura));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generarFacturaBotonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane LayerPane;
    private javax.swing.JTextField MCCard;
    private javax.swing.JTextField MCHolder;
    private javax.swing.JTextField MCVcc;
    private javax.swing.JTextField MCVenc;
    private javax.swing.JPanel MasterCard;
    private javax.swing.JButton PagarPayPal;
    private javax.swing.JPanel Paypal;
    private javax.swing.JTextField PaypalCorreo;
    private javax.swing.JTextField PaypalPass;
    private javax.swing.JPanel Visa;
    private javax.swing.JTextField VisaCardHolder;
    private javax.swing.JTextField VisaVcc;
    private javax.swing.JComboBox comboPagos;
    private javax.swing.JButton generarFacturaBoton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JTextField selecRuta;
    private javax.swing.JTextField selectFecha;
    private javax.swing.JTable tablaVuelos;
    private javax.swing.JTextField visaCard;
    private javax.swing.JTextField visaVenc;
    // End of variables declaration//GEN-END:variables
       
    
    public Model model;
    public Controller controller;

    public void setModelo(Model modelo) {
        this.model = modelo;
        this.model.addObserver(this);
    }

    public void setControlador(Controller controlador) {
        this.controller = controlador;
    }

    public Model getModel() {
        return model;
    }

    public Controller getController() {
        return controller;
    }
    public JTextField getCardHolderTextField(){
        return VisaCardHolder;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        
        
        this.tablaVuelos.setModel(new VuelosTableModel(model.getVuelos()));
        this.tablaVuelos.setRowHeight(20);
        this.tablaVuelos.getTableHeader().setBackground(Color.DARK_GRAY);
        this.tablaVuelos.getTableHeader().setForeground(Color.white);

    }
    
}
