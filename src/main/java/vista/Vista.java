/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import javax.swing.DefaultListModel;
/**
 *
 * @author dyllan
 */
public class Vista extends javax.swing.JFrame {
    public DefaultListModel listaRegistrados = new DefaultListModel();
    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        listaRegistrados = new DefaultListModel(); 
        ListaRegistrados.setModel(listaRegistrados);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TituloNombre = new javax.swing.JLabel();
        BotonLogearse = new javax.swing.JButton();
        TituloContrasena = new javax.swing.JLabel();
        InputNameUser = new javax.swing.JTextField();
        InputPassUser = new javax.swing.JPasswordField();
        statusLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaRegistrados = new javax.swing.JList<>();
        TextRegistrados = new javax.swing.JLabel();
        BotonRegistrar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TituloNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloNombre.setText("Nombre");

        BotonLogearse.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonLogearse.setText("Logearse");
        BotonLogearse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLogearseActionPerformed(evt);
            }
        });

        TituloContrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloContrasena.setText("Contrasena");

        InputNameUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        InputPassUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusLabel.setText("Esperando una accion...");

        ListaRegistrados.setToolTipText("");
        jScrollPane1.setViewportView(ListaRegistrados);

        TextRegistrados.setText("Registrados");

        BotonRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonRegistrar.setText("Registrarse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(BotonRegistrar)
                                .addGap(42, 42, 42)
                                .addComponent(BotonLogearse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TituloNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TituloContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InputPassUser)
                                    .addComponent(InputNameUser)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(188, 188, 188))
                    .addComponent(TextRegistrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InputNameUser)
                        .addGap(2, 2, 2))
                    .addComponent(TituloNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InputPassUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonLogearse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(TextRegistrados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLogearseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLogearseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonLogearseActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonLogearse;
    public javax.swing.JButton BotonRegistrar;
    public javax.swing.JTextField InputNameUser;
    public javax.swing.JPasswordField InputPassUser;
    public javax.swing.JList<String> ListaRegistrados;
    private javax.swing.JLabel TextRegistrados;
    private javax.swing.JLabel TituloContrasena;
    private javax.swing.JLabel TituloNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
