package application.main;

import aerolinea.logica.Vuelo;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class View extends javax.swing.JFrame implements Observer {

    public View() {
        initComponents();

        setLocationRelativeTo(null);

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("aerolinea/media/avionIcon.png"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descuento = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        buscarViajes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        origenBusqueda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        destinoBusqueda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fechaBusqueda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TiquetesBusqueda = new javax.swing.JTextField();
        BotonBuscar = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aerolinea");
        setIconImage(getIconImage());
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel1.setBackground(new java.awt.Color(31, 75, 119));

        descuento.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(descuento);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vuelos en Descuento");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-descuento-50.png"))); // NOI18N

        buscarViajes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(buscarViajes);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Origen");

        origenBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origenBusquedaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Destino");

        destinoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoBusquedaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha");

        fechaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaBusquedaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tiquetes");

        TiquetesBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiquetesBusquedaActionPerformed(evt);
            }
        });

        BotonBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BotonBuscar.setForeground(new java.awt.Color(238, 191, 108));
        BotonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-búsqueda-50.png"))); // NOI18N
        BotonBuscar.setText("Buscar");
        BotonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonBuscarMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buscar Viajes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(538, 538, 538)
                        .addComponent(BotonBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(origenBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(destinoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(fechaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(TiquetesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(518, 518, 518)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(origenBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(destinoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(fechaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(TiquetesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BotonBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-undefined-64.png"))); // NOI18N
        jMenu1.setText("Log In");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(null);
        jMenu2.setForeground(new java.awt.Color(0, 0, 0));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-ajustes-50.png"))); // NOI18N
        jMenu2.setText("Administracion");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu4.setBorder(null);
        jMenu4.setForeground(new java.awt.Color(0, 0, 0));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/historia.png"))); // NOI18N
        jMenu4.setText("Historia");
        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(null);
        jMenu5.setForeground(new java.awt.Color(0, 0, 0));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aerolinea/media/icons8-información-50.png"))); // NOI18N
        jMenu5.setText("Contactenos");
        jMenuBar1.add(jMenu5);

        jMenu3.setBorder(null);
        jMenu3.setForeground(new java.awt.Color(0, 0, 0));
        jMenu3.setText("Referente Institucional");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:

        //login
        controladora.loginShow();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:

        //administracion
        controladora.adminShow();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void origenBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origenBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origenBusquedaActionPerformed

    private void destinoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoBusquedaActionPerformed

    private void fechaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaBusquedaActionPerformed

    private void TiquetesBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiquetesBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiquetesBusquedaActionPerformed

    private void BotonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonBuscarMouseClicked
        // TODO add your handling code here:
        //boton de buscar
        String origen,destino,fecha,tiquetes;
        
        origen = origenBusqueda.getText();
        destino = destinoBusqueda.getText();
        fecha = fechaBusqueda.getText();
        tiquetes = TiquetesBusqueda.getText();
        
        try {
            if(origen.equals("") && destino.equals("") && fecha.equals("")){
                controladora.buscarTodos();
            }
            else{
                controladora.buscarVuelo(origen, destino, fecha);
            }
        } catch (Exception ex) {
            
        }
        
    }//GEN-LAST:event_BotonBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonBuscar;
    private javax.swing.JTextField TiquetesBusqueda;
    private javax.swing.JTable buscarViajes;
    private javax.swing.JTable descuento;
    private javax.swing.JTextField destinoBusqueda;
    private javax.swing.JTextField fechaBusqueda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField origenBusqueda;
    // End of variables declaration//GEN-END:variables
    private Model model;
    private Controller controladora;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public Controller getControladora() {
        return controladora;
    }

    public void setControladora(Controller controladora) {
        this.controladora = controladora;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.buscarViajes.setModel(new VuelosTableModel(model.getVuelosBuscar()));
        this.buscarViajes.setRowHeight(25);
        this.buscarViajes.getTableHeader().setBackground(Color.DARK_GRAY);
        this.buscarViajes.getTableHeader().setForeground(Color.white);
        this.buscarViajes.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.buscarViajes.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.buscarViajes.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.buscarViajes.getColumnModel().getColumn(3).setPreferredWidth(80);
        
        this.descuento.setModel(new VuelosTableModel(model.getVuelosDescuento()));
        this.descuento.setRowHeight(20);
        this.descuento.getTableHeader().setBackground(Color.DARK_GRAY);
        this.descuento.getTableHeader().setForeground(Color.white);
        this.descuento.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.descuento.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.descuento.getColumnModel().getColumn(3).setPreferredWidth(50);
    }
}
