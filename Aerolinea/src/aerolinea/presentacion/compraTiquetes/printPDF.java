/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.presentacion.compraTiquetes;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ian Rodriguez
 */
public class printPDF extends javax.swing.JFrame {

    /**
     * Creates new form printPDF
     */
    public printPDF() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 75, 119));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 153, 51));
        jButton1.setText("Imprimir Tiquetes");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-comprobado-50.png"))); // NOI18N
        jLabel1.setText("Compra Realizada con Exito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        createPDF(new File("FacturasGeneradas/file1.pdf"));
    }//GEN-LAST:event_jButton1MouseClicked

    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
    private static final Font VUEL_FONT = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.BLACK);
    private static final Font PRECIO_FONT = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLACK);
    private static final Font Visa_FONT = new Font(Font.FontFamily.HELVETICA, 18, Font.NORMAL, BaseColor.BLUE);

    public void br(Chapter chapter,int i) {
        Font ENTER_FONT = new Font(Font.FontFamily.HELVETICA, i, Font.NORMAL, BaseColor.WHITE);
        chapter.add(new Paragraph("ENTER", ENTER_FONT));
    }

    public void createPDF(File pdfNewFile) {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
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
            chapter.add(new Paragraph("Tiquete de compra numero 1", paragraphFont));
            br(chapter,5);
            chapter.add(new Paragraph("Nombre de la persona + @", paragraphFont));
            br(chapter,5);
            chapter.add(new Paragraph("Correo: + @", paragraphFont));
            
            chapter.add(new Chunk(ls));

            chapter.add(new Paragraph("Pago:", VUEL_FONT));
            br(chapter,10);
            chapter.add(new Paragraph("Metodo de pago: + @", paragraphFont));
            br(chapter,5);
            chapter.add(new Paragraph("Numero de Tarjeta: + @", paragraphFont));
            br(chapter,5);
            chapter.add(new Paragraph("Vencimiento: + @", paragraphFont));
            br(chapter,5);
            chapter.add(new Paragraph("Holder: + @", paragraphFont));

            chapter.add(new Chunk(ls));

            chapter.add(new Paragraph("Informacion del vuelo:", VUEL_FONT));
            br(chapter,10);
            chapter.add(new Paragraph("IdVuelo: + @", paragraphFont));
            br(chapter,4);
            chapter.add(new Paragraph("Ruta: + @", paragraphFont));
            br(chapter,4);
            chapter.add(new Paragraph("Ciudad de Destino: + @", paragraphFont));
            br(chapter,4);
            chapter.add(new Paragraph("Ciudad de Origen: + @", paragraphFont));
            br(chapter,4);
            chapter.add(new Paragraph("Fecha de salida: + @", paragraphFont));
            br(chapter,4);
            chapter.add(new Paragraph("Hora de salida: + @", paragraphFont));
            br(chapter,4);
            chapter.add(new Paragraph("Hora de Llegada: + @", paragraphFont));
            br(chapter,4);
            chapter.add(new Paragraph("Cantidad de pasajeros: + @", paragraphFont));
            br(chapter,4);
            chapter.add(new Paragraph("Tipo de Avion: + @", paragraphFont));
            
            chapter.add(new Chunk(ls));
            chapter.add(new Chunk(ls));
            
            chapter.add(new Paragraph("Total por pagar: $", paragraphFont));
            chapter.add(new Paragraph("@", PRECIO_FONT));

            document.add(chapter);
            document.close();
            System.out.println("¡Se ha generado tu factura!");
        } catch (DocumentException documentException) {
            System.out.println("(Se ha producido un error al generar un documento): " + documentException);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(printPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(printPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(printPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(printPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                printPDF generatePDFFileIText = new printPDF();
                generatePDFFileIText.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}