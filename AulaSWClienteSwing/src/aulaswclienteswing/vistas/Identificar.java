/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaswclienteswing.vistas;

import aulaswclienteswing.modelo.Usuario;
import aulaswclienteswing.utils.Utilidad;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.awt.HeadlessException;
import java.util.Arrays;
import javax.swing.JOptionPane;


/**
 *
 * @author link
 */
public class Identificar extends javax.swing.JFrame {
    private javax.swing.JFrame anterior;

    
    public void setAnterior(javax.swing.JFrame anterior){
        this.anterior= anterior;
    }

    /**
     * Creates new form Registrar
     */
    public Identificar() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        tCorreo = new javax.swing.JTextField();
        tPassword = new javax.swing.JPasswordField();

        setTitle("Identificar Usuario/a");
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de usuario/a:"));

        jLabel2.setText("E-Mail:");

        jLabel3.setText("Password:");

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tCorreo)
                    .addComponent(tPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 137, Short.MAX_VALUE)
                .addComponent(bAceptar)
                .addGap(18, 18, 18)
                .addComponent(bCancelar)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        indentificacion();
           

    }//GEN-LAST:event_bAceptarActionPerformed

    private void indentificacion() throws HeadlessException {
        // TODO add your handling code here:
        // Validamos los datos
        Utilidad u = Utilidad.nuevaInstancia();
        
        boolean cCorreo;
        String correo = this.tCorreo.getText();
        if(correo.length()>0 && u.emailValido(correo))
            cCorreo = true;
        else
            cCorreo = false;
        
        boolean cPassword;
        String password = this.tPassword.getText();
        if(password.length()>0)
            cPassword = true;
        else
            cPassword = false;
        
        if(cCorreo && cPassword){
            //System.out.println("Correcto");
            password = u.getHash(password);
            
            // Llamamos al servicio
            try {
                int result = this.indetificar(correo, password);
                if (result > 1) {
                    procesarUsuario(result);
                }else{
                    error("");
                }
                
            } catch (Exception ex) {
                //error(ex.getLocalizedMessage());
                System.err.println(ex.toString());
            }
            
            
        }else{
            error("");
        }
    }

    private void procesarUsuario(int result) throws JsonSyntaxException {
        String correo;
        String password;
        // Nos movemos a una nueva dirección, que somos nosotros mismo
        //System.out.println("OK");
        // Obtenemos los datos del usuario
        int id = result;
        String json = usuario(id);
        JsonParser parser = new JsonParser();
        String nombre = parser.parse(json).getAsJsonObject().get("nombre").getAsString();
        correo = parser.parse(json).getAsJsonObject().get("email").getAsString();
        password = parser.parse(json).getAsJsonObject().get("password").getAsString();
        String momento = parser.parse(json).getAsJsonObject().get("momento").getAsString();
        Usuario usuario = new Usuario(id, nombre, correo, password, momento);
        principal(usuario);
    }

    private void principal(Usuario usuario) {
        //System.out.println(usuario.toString());
        // Abrimos principal
        this.setVisible(false);        
        Principal p = new Principal();
        p.setLocationRelativeTo(null);
        p.setResizable(false);
        p.setAnterior(this.anterior);
        p.setUsuario(usuario);
        p.iniciarComponentes();
        p.setVisible(true);
        this.dispose();
    }

    private void error(String error) throws HeadlessException {
        JOptionPane.showMessageDialog(this, "Existe un error en la identificación por favor, inténtelo de nuevo\n"+error, "Error al identificar", JOptionPane.ERROR_MESSAGE);
    }

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        volver();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.volver();
    }//GEN-LAST:event_formWindowClosing

    private void volver() {
        // TODO add your handling code here:
        this.anterior.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(Identificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Identificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Identificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Identificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Identificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tCorreo;
    private javax.swing.JPasswordField tPassword;
    // End of variables declaration//GEN-END:variables

    private static int indetificar(java.lang.String email, java.lang.String password) {
        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
        return port.indetificar(email, password);
    }

    private static String usuario(int id) {
        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
        return port.usuario(id);
    }

   
}
