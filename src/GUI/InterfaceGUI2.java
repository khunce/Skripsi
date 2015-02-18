/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author robby
 */
public class InterfaceGUI2 extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceGUI2
     */
    public InterfaceGUI2() {
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        fc = new javax.swing.JFileChooser();
        jLabel2 = new javax.swing.JLabel();
        open = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        file_name = new javax.swing.JLabel();

        fc.setDialogTitle("Choose File");
        fc.setFileFilter(null);
        fc.setDragEnabled(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(748, 370));
        setPreferredSize(new java.awt.Dimension(748, 370));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SIMULASI ANTRIAN PASIEN  RS TNI AU DR.M.SALAMUN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 10, 568, 23);

        open.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        open.setText("Open File");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        getContentPane().add(open);
        open.setBounds(300, 130, 110, 25);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 50, 750, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nama File : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 210, 80, 30);

        start.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        start.setText("START SIMULATION");
        getContentPane().add(start);
        start.setBounds(370, 300, 200, 30);

        back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(153, 300, 190, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(150, 200, 430, 10);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(150, 250, 430, 10);

        file_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(file_name);
        file_name.setBounds(250, 204, 330, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==open){
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                System.out.println(file.getName());
                file_name.setText(file.getName());
               
            } else {
               
            }
        }
    }//GEN-LAST:event_openActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        InterfaceAwal awal=new InterfaceAwal();
        awal.pack();
        awal.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JFileChooser fc;
    private javax.swing.JLabel file_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton open;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
