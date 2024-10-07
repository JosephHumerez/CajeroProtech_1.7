/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static ventanas.Login.clienteActual;
import manejoarchivos.Convertir;
import static ventanas.Login.banco;
import java.text.DecimalFormat;

/**
 * Clase que representa la ventana de conversión de monedas en la interfaz gráfica.
 * 
 * <p>Esta clase extiende {@code javax.swing.JFrame} y se encarga de
 * inicializar la ventana de conversión de monedas, estableciendo sus componentes
 * gráficos y configuraciones iniciales.
 * 
 * @author Joseph Humerez
 * @version 1.0
 */
public class ConvMoneda extends javax.swing.JFrame {

    /**
     * Objeto que maneja la conversión de monedas.
     */
    private Convertir moneda;

    /**
     * Crea una nueva instancia de la clase {@code ConvMoneda}.
     * 
     * <p>Inicializa los componentes de la ventana, establece el tamaño,
     * título, y agrega las imágenes de fondo y logotipo.
     */
    public ConvMoneda() {
        initComponents();
        setSize(400, 600);
        setResizable(false);
        setTitle("Abonar - Cajero Automatico PROTECH");
        setLocationRelativeTo(null);

        ImageIcon wallpaper = new ImageIcon("src/images/fondo_login.png");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        ImageIcon wallpaper_logo = new ImageIcon("src/images/logo_protech.png");
        Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(jLabel_Logo.getWidth(), jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);
        this.repaint();

        //Imagen de ConvMoneda
        ImageIcon imagAbonar = new ImageIcon("src/images/alas_dinero.png");
        Icon icono_abonar = new ImageIcon(imagAbonar.getImage().getScaledInstance(jLabel_ImaAbonar.getWidth(), jLabel_ImaAbonar.getHeight(), Image.SCALE_DEFAULT));
        jLabel_ImaAbonar.setIcon(icono_abonar);
        this.repaint();
    }

 /**
 * Devuelve la imagen del icono que se mostrará en la ventana.
 * 
 * <p>Este método sobrescribe el método {@code getIconImage()} de la clase {@code JFrame}
 * para proporcionar una imagen personalizada como icono de la ventana.
 * La dirección del icono debe ser actualizada si hay un error en la ruta de los recursos.
 * 
 * @return La imagen del icono de la ventana.
 */
    @Override
    public Image getIconImage() {  //CAMBIAR DIRECCION DEL ICONO POR ERROR DE CARPETA DE RECURSOS
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo_protech.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Titulo = new javax.swing.JLabel();
        Derechos_Autor = new javax.swing.JLabel();
        jLabel_ImaAbonar = new javax.swing.JLabel();
        Aclaracion = new javax.swing.JLabel();
        jLabel_Logo = new javax.swing.JLabel();
        jButton_Volver = new javax.swing.JButton();
        jLabel_Subtitulo2 = new javax.swing.JLabel();
        jButton_ConvertirMon = new javax.swing.JButton();
        jTextField_MonedaConv = new javax.swing.JTextField();
        jLabel_SaldoActual = new javax.swing.JLabel();
        jLabel_MonedaActual = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel_Titulo.setText("CONVERTIR MONEDA");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        Derechos_Autor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Derechos_Autor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Derechos_Autor.setText("ProTech2024 © ");
        Derechos_Autor.setToolTipText("");
        getContentPane().add(Derechos_Autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, -1, -1));
        getContentPane().add(jLabel_ImaAbonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 50));

        Aclaracion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Aclaracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Aclaracion.setText("Opciones: Dolar/Euro/Sol/Real/Yen/Boliviano");
        Aclaracion.setToolTipText("");
        getContentPane().add(Aclaracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, 100));

        jButton_Volver.setBackground(new java.awt.Color(255, 51, 0));
        jButton_Volver.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton_Volver.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Volver.setText("Volver");
        jButton_Volver.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jButton_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 150, 40));

        jLabel_Subtitulo2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel_Subtitulo2.setText("Escribe la moneda");
        getContentPane().add(jLabel_Subtitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jButton_ConvertirMon.setBackground(new java.awt.Color(0, 0, 0));
        jButton_ConvertirMon.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton_ConvertirMon.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ConvertirMon.setText("Convertir");
        jButton_ConvertirMon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jButton_ConvertirMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConvertirMonActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ConvertirMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 150, 40));

        jTextField_MonedaConv.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTextField_MonedaConv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField_MonedaConv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 230, 50));

        jLabel_SaldoActual.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(jLabel_SaldoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 300, 20));

        jLabel_MonedaActual.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(jLabel_MonedaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 300, 20));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

 /**
 * Maneja el evento de acción del botón "Volver".
 * 
 * <p>Este método es llamado cuando el usuario hace clic en el botón "Volver".
 * Crea una nueva instancia de la clase {@code PagPrincipal} y la hace visible,
 * ocultando la ventana actual.
 * 
 * @param evt El evento de acción que contiene información sobre la acción del botón.
 */
    private void jButton_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VolverActionPerformed
        new PagPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_VolverActionPerformed

 /**
 * Maneja el evento de acción del botón "Convertir Moneda".
 * 
 * <p>Este método se ejecuta cuando el usuario hace clic en el botón "Convertir Moneda".
 * Obtiene la entrada de la moneda a convertir del campo de texto, 
 * valida la entrada y, si es válida, intenta realizar la conversión de moneda
 * para el cliente actual. Actualiza el saldo y la moneda en la interfaz de usuario
 * y muestra mensajes de éxito o error según corresponda.
 *
 * @param evt El evento de acción que contiene información sobre la acción del botón.
 */
    private void jButton_ConvertirMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConvertirMonActionPerformed
        String tipoMoneda = jTextField_MonedaConv.getText(); // Obtener la entrada de la moneda
        String tipoMonedaA = clienteActual.getMoneda(); // Moneda actual del cliente
        // Crear un objeto DecimalFormat con el formato deseado
        DecimalFormat df = new DecimalFormat("#.##"); // 2 decimales
        

        // Validar que el campo no esté vacío
        if (tipoMoneda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa una moneda válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Intentar convertir la moneda del cliente
        boolean exito = clienteActual.convertir(tipoMoneda, clienteActual.getSaldo(), tipoMonedaA);

        if (exito) {
            
            banco.guardarClientes(); // Guardar el estado de los clientes en el archivo
            String valorFormateado = df.format(clienteActual.getSaldo());
            jLabel_SaldoActual.setText("Su saldo actual es: " + valorFormateado);
            jLabel_MonedaActual.setText("Su moneda actual es: " + clienteActual.getMoneda());
            JOptionPane.showMessageDialog(null, "Conversión realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la conversión. Verifica la moneda ingresada.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        jTextField_MonedaConv.setText(""); // Limpiar el campo de texto       
    }//GEN-LAST:event_jButton_ConvertirMonActionPerformed

/**
 * Método principal que inicia la aplicación de conversión de monedas.
 *
 * <p>Este método configura el aspecto de la interfaz de usuario utilizando el look and feel 
 * Nimbus, si está disponible. Luego, crea y muestra una nueva instancia de 
 * {@link ConvMoneda}, que es la ventana principal para realizar conversiones de moneda.
 *
 * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación).
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
            java.util.logging.Logger.getLogger(ConvMoneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvMoneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvMoneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvMoneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvMoneda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Aclaracion;
    private javax.swing.JLabel Derechos_Autor;
    private javax.swing.JButton jButton_ConvertirMon;
    private javax.swing.JButton jButton_Volver;
    private javax.swing.JLabel jLabel_ImaAbonar;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_MonedaActual;
    private javax.swing.JLabel jLabel_SaldoActual;
    private javax.swing.JLabel jLabel_Subtitulo2;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField jTextField_MonedaConv;
    // End of variables declaration//GEN-END:variables
}
