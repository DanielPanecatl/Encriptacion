/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptar;

import java.math.BigInteger;

/**
 *
 * @author Daniel
 */
public class Ventana2 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana2
     */
    public Ventana2() {
        initComponents();
  
    }
    Imagen img = new Imagen();
    public static String imagen1;
    public static String imagen2;
    public static String textoDescifrado1;
    public static String textoDescifrado2;
//    public static String imagen3;
//    public static String imagen4;
//    public static String imagen5;
    AlgoritmoRSA rsa = new AlgoritmoRSA();
    BigInteger [] textoCifrado1;
    BigInteger [] textoCifrado2;
//    BigInteger [] textoCifrado3;
//    BigInteger [] textoCifrado4;
//    BigInteger [] textoCifrado5;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione la imagen 1");

        jLabel2.setText("Seleccione la imagen 2");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/encriptar/icon/cargar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/encriptar/icon/cargar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/encriptar/icon/encriptar.png"))); // NOI18N
        jButton6.setText("Encriptar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/encriptar/icon/descifrar.png"))); // NOI18N
        jButton7.setText("Desencriptar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setText("...");

        jLabel7.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(jLabel7))
                .addGap(335, 335, 335)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dir = img.obtenerDireccion();
        jLabel6.setText(dir);
        imagen1 = img.leerImagen(dir);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String dir = img.obtenerDireccion();
        jLabel7.setText(dir);
        imagen2 = img.leerImagen(dir);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        long TInicio, TFin, tiempo;           //Para determinar el tiempo
        TInicio = System.currentTimeMillis(); //de ejecución
        rsa.generaPrimos();
        rsa.generaClaves();
        String cadena1 = "";
        String cadena2 = "";
//        String cadena3 = "";
//        String cadena4 = "";
//        String cadena5 = "";
        textoCifrado1 = rsa.encripta(imagen1);
        for(int i=0; i<textoCifrado1.length; i++)
            cadena1 += textoCifrado1[i].toString();
        textoCifrado2 = rsa.encripta(imagen2);
        for(int i=0; i<textoCifrado2.length; i++)
            cadena2 += textoCifrado2[i].toString();
//        textoCifrado3 = rsa.encripta(imagen3);
//        for(int i=0; i<textoCifrado3.length; i++)
//            cadena3 += textoCifrado3[i].toString();
//        textoCifrado4 = rsa.encripta(imagen4);
//        for(int i=0; i<textoCifrado4.length; i++)
//            cadena4 += textoCifrado4[i].toString();
//        textoCifrado5 = rsa.encripta(imagen5);
//        for(int i=0; i<textoCifrado5.length; i++)
//            cadena5 += textoCifrado5[i].toString();
        TFin = System.currentTimeMillis();
        tiempo = (TFin - TInicio)/1000;
        System.out.println("Tiempo de ejecución en segundos: " + tiempo);
        //Guardar cadena
        img.guardarRSA(cadena1,jLabel6.getText());
        img.guardarRSA(cadena2,jLabel7.getText());
//        img.guardarRSA(cadena3,jLabel8.getText());
//        img.guardarRSA(cadena4,jLabel9.getText());
//        img.guardarRSA(cadena5,jLabel10.getText());
        
    }//GEN-LAST:event_jButton6ActionPerformed
    //System.out.print(dir);
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        String dir1 = img.obtenerDireccion();
        String dir2 = img.obtenerDireccion();
//        String dir3 = img.obtenerDireccion();
//        String dir4 = img.obtenerDireccion();
//        String dir5 = img.obtenerDireccion();
        long TInicio, TFin, tiempo;           //Para determinar el tiempo
        TInicio = System.currentTimeMillis();
        textoDescifrado1 = rsa.desencripta(textoCifrado1);//,rsa.getD(),rsa.getN());
        textoDescifrado2 = rsa.desencripta(textoCifrado2);//,rsa.getD(),rsa.getN());
//        String textoDescifrado3 = rsa.desencripta(textoCifrado3,rsa.getD(),rsa.getN());
//        String textoDescifrado4 = rsa.desencripta(textoCifrado4,rsa.getD(),rsa.getN());
//        String textoDescifrado5 = rsa.desencripta(textoCifrado5,rsa.getD(),rsa.getN());
        TFin = System.currentTimeMillis();
        tiempo = (TFin - TInicio)/1000;
        System.out.println("Tiempo de ejecución en segundos: " + tiempo);
        //System.out.print(cadenaNueva);
        img.guardarRSA(textoDescifrado1, dir1);
        img.guardarRSA(textoDescifrado2, dir2);
//        img.guardarRSA(textoDescifrado3, dir3);
//        img.guardarRSA(textoDescifrado4, dir4);
//        img.guardarRSA(textoDescifrado5, dir5);
        Ventana3 v3 = new Ventana3();
        v3.show(true);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}