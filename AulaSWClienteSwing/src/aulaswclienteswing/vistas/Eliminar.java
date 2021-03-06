/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaswclienteswing.vistas;

import aulaswclienteswing.modelo.Alumno;
import aulaswclienteswing.modelo.Usuario;
import aulaswclienteswing.utils.Utilidad;
import java.awt.HeadlessException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author link
 */
public class Eliminar extends javax.swing.JFrame {

    private javax.swing.JFrame anterior;
    private Usuario usuario;
    private Alumno alumno;
    private int clave = 0;

    public void setAnterior(javax.swing.JFrame anterior) {
        this.anterior = anterior;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void iniciarComponentes() {
        datos();
        clave();
    }

    /**
     * Creates new form Registrar
     */
    public Eliminar() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lClave = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        tNombre = new javax.swing.JTextField();
        tNota = new javax.swing.JTextField();
        tValor = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        tId = new javax.swing.JTextField();

        setTitle("Eliminar alumno/a");
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar alumno/a:"));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Nota:");

        lClave.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lClave.setText("Clave:");

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

        tNombre.setEditable(false);

        tNota.setEditable(false);

        jLabel3.setText("Nº:");

        tId.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bAceptar)
                .addGap(18, 18, 18)
                .addComponent(bCancelar)
                .addGap(114, 114, 114))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(lClave, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tValor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tNota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lClave)
                    .addComponent(tValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addContainerGap())
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
        borrar();
    }//GEN-LAST:event_bAceptarActionPerformed

    private void error(String error) {
        JOptionPane.showMessageDialog(this, "Existe un error en la eliminación, por favor, inténtelo de nuevo\n" + error, "Error al eliminar", JOptionPane.ERROR_MESSAGE);
    }
    
    private void mensaje(String m) {
        JOptionPane.showMessageDialog(this, "Alumno/a y calificaciones eliminados con éxito:\n"+m, "Alumno/a eliminado", JOptionPane.INFORMATION_MESSAGE);
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
        ((Principal) this.anterior).iniciarComponentes();
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
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lClave;
    private javax.swing.JTextField tId;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tNota;
    private javax.swing.JPasswordField tValor;
    // End of variables declaration//GEN-END:variables

    private void clave() {
        clave = firmar(this.alumno.getId());
        this.lClave.setText("Clave: " + this.clave);
    }

    private static int firmar(int id) {
        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
        return port.firmar(id);
    }

    private void datos() {
        this.tId.setText(Integer.toString(this.alumno.getId()));
        this.tNombre.setText(this.alumno.getNombre());
        this.tNota.setText(Float.toString(this.alumno.getNota()));
    }

    private void borrar() {
        boolean cValor;
        String valor = this.tValor.getText();
        if (valor.length() > 0) {
            cValor = true;
        } else {
            cValor = false;
        }

        if (cValor) {
            int result = validar(this.usuario.getId(), this.clave, valor);
            if (result == 1) {
                remover();
            } else {
                error("");
            }
        } else {
            error("");
        }

    }

    private static int validar(int id, int clave, java.lang.String valor) {
        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
        return port.validar(id, clave, valor);
    }

    private void remover() {
        int result = eliminar(this.usuario.getId(), this.alumno.getId());
        if (result == 1) {
            this.mensaje("");
            this.volver();
        } else {
            error("");
        }
    }

    private static int eliminar(int usuarioId, int alumnoId) {
        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
        return port.eliminar(usuarioId, alumnoId);
    }

   

}
