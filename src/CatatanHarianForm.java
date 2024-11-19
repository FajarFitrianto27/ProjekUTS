/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class CatatanHarianForm extends JFrame {
    private JTextField txtJudul;
    private JTextArea txtIsi;
    private JButton btnSimpan, btnEdit, btnHapus;
    private JTable tableCatatan;
    private DefaultTableModel tableModel;
    private ArrayList<String> catatanIsi;
    
    
public CatatanHarianForm() {
    initComponents();
        // Inisialisasi komponen
    // Inisialisasi tambahan
    catatanIsi = new ArrayList<>();
     tableModel = new DefaultTableModel(new String[]{"Judul", "Isi"}, 0);
     jTable1.setModel(tableModel);
    
    

    // Event handling untuk tombol
    jButton1.addActionListener(e -> simpanCatatan());
    jButton2.addActionListener(e -> editCatatan());
    jButton3.addActionListener(e -> hapusCatatan());
    btnSimpanKeFile.addActionListener(e -> simpanKeFile());
    btnCetak.addActionListener(e -> cetakCatatan());

    // Pengaturan JFrame
    setTitle("Catatan Harian");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
    }
 private void simpanCatatan() {
    String judul = jTextField1.getText();
    String isi = jTextArea1.getText();
    if (!judul.isEmpty() && !isi.isEmpty()) {
        // Tambahkan data ke kedua kolom
        tableModel.addRow(new Object[]{judul, isi});
        jTextField1.setText("");
        jTextArea1.setText("");
        JOptionPane.showMessageDialog(this, "Catatan berhasil disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Judul dan isi tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
}
 private void editCatatan() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        jTextField1.setText((String) tableModel.getValueAt(selectedRow, 0)); // Kolom Judul
        jTextArea1.setText((String) tableModel.getValueAt(selectedRow, 1)); // Kolom Isi
        tableModel.removeRow(selectedRow);
        JOptionPane.showMessageDialog(this, "Catatan siap untuk diedit. Silakan simpan setelah mengedit.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Pilih catatan untuk diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
}
private void hapusCatatan() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        ((DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);

        // Tambahkan pengecekan ukuran ArrayList sebelum menghapus
        if (selectedRow < catatanIsi.size()) {
            catatanIsi.remove(selectedRow);
        }
        
        JOptionPane.showMessageDialog(this, "Catatan berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Pilih catatan untuk dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
}
private void simpanKeFile() {
    try {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String judul = (String) tableModel.getValueAt(i, 0);
                String isi = (String) tableModel.getValueAt(i, 1);
                writer.write("Judul: " + judul + "\n");
                writer.write("Isi: " + isi + "\n\n");
            }
            
            writer.close();
            JOptionPane.showMessageDialog(this, "Catatan berhasil disimpan ke file!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan catatan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
private void cetakCatatan() {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable((graphics, pageFormat, pageIndex) -> {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        int y = 20;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String judul = (String) tableModel.getValueAt(i, 0);
            String isi = (String) tableModel.getValueAt(i, 1);
            g2d.drawString("Judul: " + judul, 10, y);
            y += 15;
            g2d.drawString("Isi: " + isi, 10, y);
            y += 30; // Jarak antar catatan
        }

        return Printable.PAGE_EXISTS;
    });

    boolean doPrint = job.printDialog();
    if (doPrint) {
        try {
            job.print();
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencetak: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSimpanKeFile = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("SIMPAN");

        jButton2.setText("EDIT");

        jButton3.setText("HAPUS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setText("Judul :");

        jLabel2.setText("Isi     :");

        btnSimpanKeFile.setText("BUAT FILE");
        btnSimpanKeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanKeFileActionPerformed(evt);
            }
        });

        btnCetak.setText("CETAK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSimpanKeFile)
                        .addGap(87, 87, 87)
                        .addComponent(btnCetak)
                        .addGap(176, 176, 176))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2)
                                .addComponent(jButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpanKeFile)
                            .addComponent(btnCetak))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanKeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanKeFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanKeFileActionPerformed

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
            java.util.logging.Logger.getLogger(CatatanHarianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatatanHarianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatatanHarianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatatanHarianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatatanHarianForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnSimpanKeFile;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
