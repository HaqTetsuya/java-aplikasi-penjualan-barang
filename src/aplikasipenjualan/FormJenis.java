
package aplikasipenjualan; 

import javax.swing.*; //melakukan import libraly yg dibutuhkan
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author user
 */
public class FormJenis extends javax.swing.JFrame {
    Database dbsetting;
    String driver,database,user,pass;
    private Object tabel;

    public FormJenis() {
        initComponents();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height > screenSize.height){
            frameSize.height=screenSize.height;
        }
        if(frameSize.width > screenSize.width){
            frameSize.width=screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height = screenSize.height) / 4);
        dbsetting = new Database();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        Table.setModel(tableModel);
        Tabel(Table, new int[]{90,370});
        setDefaultTable();
        SetEditOff();
    }
    int row=0;
    public void Tampil(){
        row = Table.getSelectedRow();
        KodeJenis.setText(tableModel.getValueAt(row,0).toString());
        Jenis.setText(tableModel.getValueAt(row,1).toString());
        Save.setEnabled(false);
        Update.setEnabled(true);
        Delete.setEnabled(true);
        SetEditOn();
    }
    
    public void BersihData(){
        KodeJenis.setText("");
        Jenis.setText("");
        cover2.setVisible(true);
        cover1.setVisible(true);
    }
    public void SetEditOff(){
        KodeJenis.setEnabled(false);
        Jenis.setEnabled(false);
        cover2.setVisible(true);
        cover1.setVisible(true);
    }
    public void SetEditOn(){
        KodeJenis.setEnabled(true);
        Jenis.setEnabled(true);
        cover2.setVisible(false);
        cover1.setVisible(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        Jenis = new javax.swing.JTextField();
        cover1 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        KodeJenis = new javax.swing.JTextField();
        cover2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jenis Barang");
        setBackground(new java.awt.Color(204, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jenis Barang");
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        Table.setBackground(new java.awt.Color(255, 102, 0));
        Table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 3, true));
        Table.setModel(new javax.swing.table.DefaultTableModel(
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
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jLayeredPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 410, 160));

        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/add.png"))); // NOI18N
        Add.setToolTipText("Baru");
        Add.setBorder(null);
        Add.setBorderPainted(false);
        Add.setContentAreaFilled(false);
        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Add.setFocusPainted(false);
        Add.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/Add2.png"))); // NOI18N
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/save.png"))); // NOI18N
        Save.setToolTipText("Simpan");
        Save.setAutoscrolls(true);
        Save.setBorder(null);
        Save.setBorderPainted(false);
        Save.setContentAreaFilled(false);
        Save.setFocusPainted(false);
        Save.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/save2.png"))); // NOI18N
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/delete.png"))); // NOI18N
        Delete.setToolTipText("Hapus");
        Delete.setBorder(null);
        Delete.setBorderPainted(false);
        Delete.setContentAreaFilled(false);
        Delete.setFocusPainted(false);
        Delete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/delete2.png"))); // NOI18N
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/cancel.png"))); // NOI18N
        Cancel.setToolTipText("Batal");
        Cancel.setBorder(null);
        Cancel.setContentAreaFilled(false);
        Cancel.setFocusPainted(false);
        Cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/cancel2.png"))); // NOI18N
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        Jenis.setBackground(new java.awt.Color(19, 24, 38));
        Jenis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Jenis.setForeground(new java.awt.Color(255, 255, 255));
        Jenis.setBorder(null);
        Jenis.setDisabledTextColor(new java.awt.Color(255, 255, 51));
        Jenis.setOpaque(false);
        Jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 290, 30));

        cover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/Asset 70.png"))); // NOI18N
        jLayeredPane1.add(cover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 390, 90));

        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/update.png"))); // NOI18N
        Update.setToolTipText("Update");
        Update.setBorder(null);
        Update.setBorderPainted(false);
        Update.setContentAreaFilled(false);
        Update.setFocusPainted(false);
        Update.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/update2.png"))); // NOI18N
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/Asset 61.png"))); // NOI18N
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 390, 90));

        KodeJenis.setBackground(new java.awt.Color(19, 24, 38));
        KodeJenis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        KodeJenis.setForeground(new java.awt.Color(255, 255, 255));
        KodeJenis.setBorder(null);
        KodeJenis.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        KodeJenis.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        KodeJenis.setDoubleBuffered(true);
        KodeJenis.setOpaque(false);
        KodeJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeJenisActionPerformed(evt);
            }
        });
        jLayeredPane1.add(KodeJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 290, 40));

        cover2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/Asset 70.png"))); // NOI18N
        jLayeredPane1.add(cover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 390, 100));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Jenis");
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/Asset 61.png"))); // NOI18N
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 400, 120));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/bgJenis.png"))); // NOI18N
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, -30, 590, 910));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JenisActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        BersihData();
        KodeJenis.requestFocus();
        Save.setEnabled(true);
        Update.setEnabled(false);
        Delete.setEnabled(false);
        SetEditOn();
    }//GEN-LAST:event_AddActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        String KJ=KodeJenis.getText();
        String J=Jenis.getText();
        if((KJ.isEmpty())|(J.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            KodeJenis.requestFocus();
        }else{
            try {
                Class.forName(driver);
                Connection c = DriverManager.getConnection(database, user, pass);
                Statement s = c.createStatement();
                String SQL = "insert into tbljenis values('"+KodeJenis.getText()+"',"+"'"+Jenis.getText()+"')";
                s.executeUpdate(SQL);
                data[0]=KodeJenis.getText();
                data[1]=Jenis.getText();
                tableModel.insertRow(0, data);
                s.close();
                c.close();
                BersihData();
                Save.setEnabled(false);
                SetEditOff();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1) {
            Tampil();
        }
    }//GEN-LAST:event_TableMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        String kodeJenis = KodeJenis.getText();
        String jenis = Jenis.getText();

        if (kodeJenis.isEmpty() || jenis.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong, silahkan dilengkapi");
            KodeJenis.requestFocus();
        } else {
            try {
                Class.forName(driver);
                Connection c = DriverManager.getConnection(database, user, pass);
                Statement s = c.createStatement();

                // Create and execute an UPDATE SQL statement
                String sql = "UPDATE tbljenis SET jenis = '" + jenis + "'" +
                             "WHERE kodejenis = '" + kodeJenis + "'";
                s.executeUpdate(sql);

                // Update the table model with the new data
                data[0] = kodeJenis;
                data[1] = jenis;
                tableModel.removeRow(row);
                tableModel.insertRow(row, data);

                // Clean up
                s.close();
                c.close();
                BersihData();
                Save.setEnabled(false);
                SetEditOff();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        String KJ=KodeJenis.getText();
        String J=Jenis.getText();
        if ((KJ.isEmpty()) | (J.isEmpty())){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            KodeJenis.requestFocus();
        }else{
            try {
                Class.forName(driver);
                Connection c = DriverManager.getConnection(database, user, pass);
                Statement s = c.createStatement();
                String SQL = "Delete From tbljenis Where kodejenis='"+KodeJenis.getText().toString()+"'";
                s.executeUpdate(SQL);
                data[0]=KodeJenis.getText();
                data[1]=Jenis.getText();
                tableModel.removeRow(row);
                s.close();
                c.close();
                BersihData();
                Save.setEnabled(false);
                SetEditOff();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data Tidak Dapat Dihapus","Hapus Data",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        SetEditOff();
    }//GEN-LAST:event_CancelActionPerformed

    private void KodeJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeJenisActionPerformed

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
            java.util.logging.Logger.getLogger(FormJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJenis().setVisible(true);
            }
        });
    }
private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel();
    private void Tabel(javax.swing.JTable tb, int lebar[]){
        tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int kolom=tb.getColumnCount();
        for(int i=0;i<kolom;i++){
            javax.swing.table.TableColumn tbc=tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(17);
        }
    }
    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        return new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String [] {"Kode Jenis","Jenis Barang"}
        ){
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return canEdit[columnIndex];
    }
};
}
    
    String data[]=new String[2];
    private void setDefaultTable(){
        String stat="";
        try {
            Class.forName(driver);
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement();
            String SQL="SELECT * FROM tbljenis";
            ResultSet r=s.executeQuery(SQL);
            while(r.next()){
                data[0]=r.getString(1);
                data[1]=r.getString(2);
                tableModel.addRow(data);
            }
            r.close();
            s.close();
            c.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Jenis;
    private javax.swing.JTextField KodeJenis;
    private javax.swing.JButton Save;
    private javax.swing.JTable Table;
    private javax.swing.JButton Update;
    private javax.swing.JLabel cover1;
    private javax.swing.JLabel cover2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
