/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author robby
 */
public class InterfaceGUI3 extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceGUI3
     */
    public InterfaceGUI3() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        arr_rate = new javax.swing.JTextField();
        ser_rate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        play = new javax.swing.JToggleButton();
        pause = new javax.swing.JToggleButton();
        stop = new javax.swing.JToggleButton();
        panelanimasi = new javax.swing.JPanel();
        ratio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        server_poli = new javax.swing.JSpinner();
        server_awal = new javax.swing.JSpinner();
        customer = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        servicerate_poli = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        servicerate_BPJSL = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        output2 = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        queue_capacity = new javax.swing.JSpinner();
        jLabel35 = new javax.swing.JLabel();
        server_poli2 = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        server_poli3 = new javax.swing.JSpinner();
        jLabel38 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        slider = new javax.swing.JSlider();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Jumlah Server  Pendaftaran Awal : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 50, 159, 13);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SIMULASI ANTRIAN PASIEN  RS TNI AU DR.M.SALAMUN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 0, 568, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Jumlah Server Poilklinik :  ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 110, 120, 13);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Arrival Rate : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(760, 60, 62, 13);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Service Rate Pend.Awal (BPJS Baru) : ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(310, 110, 173, 13);

        arr_rate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        arr_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arr_rateActionPerformed(evt);
            }
        });
        getContentPane().add(arr_rate);
        arr_rate.setBounds(880, 60, 40, 19);

        ser_rate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(ser_rate);
        ser_rate.setBounds(490, 110, 44, 19);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("Proporsi Pasien Emergency : ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 140, 133, 13);

        play.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        play.setText("Play");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play);
        play.setBounds(440, 620, 51, 21);

        pause.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        pause.setText("Pause");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        getContentPane().add(pause);
        pause.setBounds(500, 620, 59, 21);

        stop.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        getContentPane().add(stop);
        stop.setBounds(570, 620, 53, 21);

        panelanimasi.setLayout(null);
        getContentPane().add(panelanimasi);
        panelanimasi.setBounds(8, 176, 660, 430);

        ratio.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ratio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratioActionPerformed(evt);
            }
        });
        getContentPane().add(ratio);
        ratio.setBounds(490, 140, 40, 19);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("pasien / menit");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(540, 50, 62, 13);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("pasien / menit");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(540, 110, 62, 13);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("Loket");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(230, 50, 25, 13);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("Dokter");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(230, 110, 31, 13);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("Jumlah Customer : ");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(760, 100, 87, 13);

        server_poli.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        server_poli.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));
        getContentPane().add(server_poli);
        server_poli.setBounds(180, 110, 39, 20);

        server_awal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        server_awal.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        getContentPane().add(server_awal);
        server_awal.setBounds(180, 50, 39, 20);

        customer.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerActionPerformed(evt);
            }
        });
        getContentPane().add(customer);
        customer.setBounds(880, 100, 40, 19);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("pasien");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(930, 100, 28, 13);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("Service Rate Poliklnik :");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(310, 50, 103, 13);

        servicerate_poli.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(servicerate_poli);
        servicerate_poli.setBounds(490, 50, 43, 19);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("pasien / menit");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(930, 60, 62, 13);

        servicerate_BPJSL.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        servicerate_BPJSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicerate_BPJSLActionPerformed(evt);
            }
        });
        getContentPane().add(servicerate_BPJSL);
        servicerate_BPJSL.setBounds(490, 80, 40, 19);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setText("Service Rate Pend.Awal (BPJS Lama) :");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(310, 80, 172, 13);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setText("pasien / menit");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(540, 80, 62, 13);

        output2.setColumns(20);
        output2.setRows(5);
        output2.setText("Output Statistik Kedatangan: ");
        jScrollPane2.setViewportView(output2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(730, 180, 279, 70);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel20.setText("jLabel20");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(690, 290, 380, 13);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setText("jLabel21");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(690, 320, 380, 13);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("jLabel22");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(690, 350, 380, 13);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel23.setText("jLabel23");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(690, 380, 380, 13);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel24.setText("jLabel24");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(690, 410, 380, 13);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel25.setText("jLabel25");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(690, 440, 380, 13);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel26.setText("jLabel26");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(690, 470, 380, 13);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel27.setText("jLabel27");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(690, 500, 380, 13);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel28.setText("jLabel28");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(690, 530, 380, 13);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel29.setText("jLabel29");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(690, 560, 380, 13);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel30.setText("jLabel30");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(730, 250, 90, 13);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel31.setText("jLabel31");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(820, 250, 100, 13);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel32.setText("jLabel32");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(940, 250, 120, 13);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel33.setText("Kapasitas Antrian Awal :");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(760, 140, 108, 13);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel34.setText("pasien");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(930, 140, 28, 13);

        queue_capacity.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        queue_capacity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        getContentPane().add(queue_capacity);
        queue_capacity.setBounds(880, 140, 39, 20);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel35.setText("Jumlah Server Poliklinik :");
        getContentPane().add(jLabel35);
        jLabel35.setBounds(60, 80, 114, 13);

        server_poli2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        server_poli2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));
        getContentPane().add(server_poli2);
        server_poli2.setBounds(180, 80, 40, 20);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel36.setText("Perawat");
        getContentPane().add(jLabel36);
        jLabel36.setBounds(230, 80, 36, 13);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel37.setText("Jumlah Server Poliklinik :");
        getContentPane().add(jLabel37);
        jLabel37.setBounds(60, 140, 114, 13);

        server_poli3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        server_poli3.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));
        getContentPane().add(server_poli3);
        server_poli3.setBounds(180, 140, 40, 20);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel38.setText("Petugas");
        getContentPane().add(jLabel38);
        jLabel38.setBounds(230, 140, 35, 13);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(790, 590, 155, 23);

        slider.setMaximum(900);
        slider.setMinimum(100);
        slider.setValue(500);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });
        getContentPane().add(slider);
        slider.setBounds(10, 620, 390, 26);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(280, 30, 20, 140);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(0, 170, 280, 20);
        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(270, 170, 400, 10);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(670, 30, 10, 140);
        getContentPane().add(jSeparator9);
        jSeparator9.setBounds(670, 170, 380, 20);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator10);
        jSeparator10.setBounds(410, 610, 20, 60);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator11);
        jSeparator11.setBounds(640, 600, 10, 70);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator12);
        jSeparator12.setBounds(1050, 0, 10, 690);
        getContentPane().add(jSeparator13);
        jSeparator13.setBounds(0, 30, 1050, 10);

        jLabel8.setText("Real Time");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(180, 650, 60, 14);

        jLabel9.setText("Slower");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 650, 60, 14);

        jLabel10.setText("Faster");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(370, 650, 40, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arr_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arr_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arr_rateActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        

    }//GEN-LAST:event_playActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed

        // TODO add your handling code here:
        
    }//GEN-LAST:event_pauseActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:

       

    }//GEN-LAST:event_stopActionPerformed

    private void ratioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ratioActionPerformed

    private void customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerActionPerformed

    private void servicerate_BPJSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicerate_BPJSLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicerate_BPJSLActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.server_awal.setValue(1);
        this.server_poli.setValue(1);
        this.server_poli2.setValue(1);
        this.server_poli3.setValue(1);
        this.servicerate_BPJSL.setText("");
        this.servicerate_poli.setText("");
        this.ser_rate.setText("");
        this.arr_rate.setText("");
        this.customer.setText("");
        this.ratio.setText("");
        this.queue_capacity.setValue(1);
        jLabel20.setVisible(false);
        jLabel21.setVisible(false);
        jLabel22.setVisible(false);
        jLabel23.setVisible(false);
        jLabel24.setVisible(false);
        jLabel25.setVisible(false);
        jLabel26.setVisible(false);
        jLabel27.setVisible(false);
        jLabel28.setVisible(false);
        jLabel29.setVisible(false);
        jLabel30.setVisible(false);
        jLabel31.setVisible(false);
        jLabel32.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        
    }//GEN-LAST:event_sliderStateChanged

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
            java.util.logging.Logger.getLogger(InterfaceGUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGUI3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGUI3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arr_rate;
    private javax.swing.JTextField customer;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea output2;
    private javax.swing.JPanel panelanimasi;
    private javax.swing.JToggleButton pause;
    private javax.swing.JToggleButton play;
    private javax.swing.JSpinner queue_capacity;
    private javax.swing.JTextField ratio;
    private javax.swing.JTextField ser_rate;
    private javax.swing.JSpinner server_awal;
    private javax.swing.JSpinner server_poli;
    private javax.swing.JSpinner server_poli2;
    private javax.swing.JSpinner server_poli3;
    private javax.swing.JTextField servicerate_BPJSL;
    private javax.swing.JTextField servicerate_poli;
    private javax.swing.JSlider slider;
    private javax.swing.JToggleButton stop;
    // End of variables declaration//GEN-END:variables
}