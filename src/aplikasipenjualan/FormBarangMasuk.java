/*
Masalah : You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'tbldetailbrgmasuk.nonota=''' at line 1
          Cannot add or update a child row: a foreign key constraint fails (`database_retail`.`tbldetailbrgmasuk`, CONSTRAINT `dry` FOREIGN KEY (`nonota`) REFERENCES `tblbrgmasuk` (`nonota`))
 */
package aplikasipenjualan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author user
 */
public class FormBarangMasuk extends javax.swing.JFrame {
    Database dbsetting;
    String driver,database,user,pass,userlogin;
    private Object tabel;

    /**
     * Creates new form FormBarangMasuk
     */
    public FormBarangMasuk() {
        initComponents();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height > screenSize.height){
        frameSize.height=screenSize.height;
        }
        if(frameSize.width > screenSize.width){
        frameSize.width=screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height = screenSize.height) / 10);
        
        dbsetting = new Database();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        Table.setModel(tableModel);
        Tabel(Table, new int[]{90,300,90,60,60,90});
        setDefaultTable();
        SetEditOff();
        TanggalOtomatis();
        TampilComboBarang();
        TampilComboPetugas();
        TampilComboDistributor();
    }
    
    private void TampilGridDetail(){
        String stat="";
        try {
            Class.forName(driver);
            Connection c =DriverManager.getConnection(database, user, pass);
            Statement s =c.createStatement();
            String SQL = "SELECT tblbarang.kodebarang, tblbarang.namabarang, tblbarang.hargajual, " +
              "tblbarang.stok, tbldetailbrgmasuk.jumlah, tbldetailbrgmasuk.subtotal, tblbrgmasuk.nonota " +
              "FROM tblbarang, tbldetailbrgmasuk, tblbrgmasuk WHERE tblbarang.kodebarang = tbldetailbrgmasuk.kodebarang " +
              "AND tblbrgmasuk.nonota = tbldetailbrgmasuk.nonota " +  // <-- missing AND clause
              "AND tbldetailbrgmasuk.nonota = '"+NoNota.getText().toString()+"'";
            ResultSet r = s.executeQuery(SQL);
            while(r.next()){
                data[0]=r.getString(1);
                data[1]=r.getString(2);
                data[2]=r.getString(3);
                data[3]=r.getString(4);
                data[4]=r.getString(5);
                data[5]=r.getString(6);
                tableModel.addRow(data);
            }
            r.close();
            s.close();
            c.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void BersihData(){
        tableModel.setRowCount(0);
        NoNota.setText("");
        IDDistributor.setSelectedIndex(0);
        NamaPetugas.setText("");
        IDPetugas.setSelectedIndex(0);
        NamaDistributor.setText("");
        KotaAsal.setText("");
        KodeBarang.setSelectedIndex(0);
        NamaBarang.setText("");
        HargaJual.setText("");
        Jumlah.setText("");
        Stock.setText("");
        SubTotal.setText("0");
        Total.setText("0");
    }
    public void BersihDetail(){
        KodeBarang.setSelectedIndex(0);
        NamaBarang.setText("");
        HargaJual.setText("");
        Stock.setText("");
        Jumlah.setText("");
        SubTotal.setText("0");
    }
    public void SetEditOff(){
        NoNota.setEnabled(false);
        TglMasuk.setEnabled(false);
        IDDistributor.setEnabled(false);
        IDPetugas.setEnabled(false);
        KodeBarang.setEnabled(false);
        Jumlah.setEnabled(false);
        Hitung.setEnabled(false);
        CariData.setEnabled(false);
        AddItem.setEnabled(false);
    }
    public void SetEditOn(){
        NoNota.setEnabled(true);
        TglMasuk.setEnabled(true);
        IDDistributor.setEnabled(true);
        IDPetugas.setEnabled(true);
        KodeBarang.setEnabled(true);
        Jumlah.setEnabled(true);
        Hitung.setEnabled(true);
        CariData.setEnabled(true);
        AddItem.setEnabled(true);
        SaveTransaction.setEnabled(true);
    }
    public void TampilComboDistributor(){
        try {
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM tbldistributor";
            ResultSet r =  s.executeQuery(SQL);
            while(r.next()){
                IDDistributor.addItem(r.getString("iddistributor"));
            }
        } catch (Exception ex) {
        }
    }
    public void TampilComboPetugas(){
        try {
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM tblpetugas";
            ResultSet r =  s.executeQuery(SQL);
            while(r.next()){
                IDPetugas.addItem(r.getString("idpetugas"));
            }
        } catch (Exception ex) {
        }
    }
    public void TampilComboBarang(){
        try {
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM tblbarang";
            ResultSet r =  s.executeQuery(SQL);
            while(r.next()){
                KodeBarang.addItem(r.getString("kodebarang"));
            }
        } catch (Exception ex) {
        }
    }
    public void TanggalOtomatis(){
        long time = System.currentTimeMillis();
        Date tanggal = new Date(time);
        TglMasuk.setText(""+ (String.format("%1$td:%1$tb:%1$tY",tanggal)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        TglMasuk = new javax.swing.JTextField();
        NoNota = new javax.swing.JTextField();
        CariData = new javax.swing.JButton();
        IDPetugas = new javax.swing.JComboBox();
        IDDistributor = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        KodeBarang = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Jumlah = new javax.swing.JTextField();
        Hitung = new javax.swing.JButton();
        AddItem = new javax.swing.JButton();
        SubTotal = new javax.swing.JTextField();
        NamaBarang = new javax.swing.JTextField();
        HargaJual = new javax.swing.JTextField();
        Stock = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        AddNew = new javax.swing.JButton();
        SaveTransaction = new javax.swing.JButton();
        Total = new javax.swing.JTextField();
        NamaDistributor = new javax.swing.JTextField();
        NamaPetugas = new javax.swing.JTextField();
        KotaAsal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        jScrollPane1.setViewportView(jTextPane1);

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Barang Masuk");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TglMasuk.setBackground(new java.awt.Color(48, 19, 74));
        TglMasuk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TglMasuk.setForeground(new java.awt.Color(255, 255, 255));
        TglMasuk.setBorder(null);
        TglMasuk.setCaretColor(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(TglMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 200, 30));

        NoNota.setBackground(new java.awt.Color(48, 19, 74));
        NoNota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NoNota.setForeground(new java.awt.Color(255, 255, 255));
        NoNota.setBorder(null);
        NoNota.setCaretColor(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(NoNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 160, 30));

        CariData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/search.png"))); // NOI18N
        CariData.setToolTipText("Cari");
        CariData.setBorder(null);
        CariData.setBorderPainted(false);
        CariData.setContentAreaFilled(false);
        CariData.setFocusPainted(false);
        CariData.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/search2.png"))); // NOI18N
        CariData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariDataActionPerformed(evt);
            }
        });
        jLayeredPane1.add(CariData, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 88, -1));

        IDPetugas.setBackground(new java.awt.Color(255, 153, 0));
        IDPetugas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Petugas" }));
        IDPetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IDPetugasItemStateChanged(evt);
            }
        });
        jLayeredPane1.add(IDPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 230, 30));

        IDDistributor.setBackground(new java.awt.Color(255, 153, 0));
        IDDistributor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Distributor" }));
        IDDistributor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IDDistributorItemStateChanged(evt);
            }
        });
        jLayeredPane1.add(IDDistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 230, 30));

        jPanel1.setToolTipText("");
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Kode Barang");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        KodeBarang.setBackground(new java.awt.Color(255, 153, 0));
        KodeBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Data Barang" }));
        KodeBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                KodeBarangItemStateChanged(evt);
            }
        });
        jPanel1.add(KodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 30));

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nama Barang");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel15.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Harga Jual");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel16.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Stock");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        jLabel17.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jumlah");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jLabel18.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sub Total");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        Jumlah.setBackground(new java.awt.Color(22, 5, 40));
        Jumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jumlah.setForeground(new java.awt.Color(255, 255, 255));
        Jumlah.setBorder(null);
        Jumlah.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(Jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 170, 20));
        Jumlah.getAccessibleContext().setAccessibleName("");

        Hitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/hitung.png"))); // NOI18N
        Hitung.setToolTipText("Hitung");
        Hitung.setBorder(null);
        Hitung.setBorderPainted(false);
        Hitung.setContentAreaFilled(false);
        Hitung.setFocusPainted(false);
        Hitung.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/hitung2.png"))); // NOI18N
        Hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HitungActionPerformed(evt);
            }
        });
        jPanel1.add(Hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        AddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/addd2.png"))); // NOI18N
        AddItem.setToolTipText("Add Item");
        AddItem.setBorder(null);
        AddItem.setBorderPainted(false);
        AddItem.setContentAreaFilled(false);
        AddItem.setFocusPainted(false);
        AddItem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/addd3.png"))); // NOI18N
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });
        jPanel1.add(AddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 245, 50));

        SubTotal.setEditable(false);
        SubTotal.setBackground(new java.awt.Color(22, 5, 40));
        SubTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubTotal.setForeground(new java.awt.Color(255, 255, 255));
        SubTotal.setBorder(null);
        SubTotal.setCaretColor(new java.awt.Color(255, 255, 255));
        SubTotal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                SubTotalCaretUpdate(evt);
            }
        });
        jPanel1.add(SubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 160, 20));

        NamaBarang.setEditable(false);
        NamaBarang.setBackground(new java.awt.Color(22, 5, 40));
        NamaBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NamaBarang.setForeground(new java.awt.Color(255, 255, 255));
        NamaBarang.setBorder(null);
        NamaBarang.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(NamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 260, 20));

        HargaJual.setEditable(false);
        HargaJual.setBackground(new java.awt.Color(22, 5, 40));
        HargaJual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        HargaJual.setForeground(new java.awt.Color(255, 255, 255));
        HargaJual.setBorder(null);
        HargaJual.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(HargaJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 260, 20));

        Stock.setEditable(false);
        Stock.setBackground(new java.awt.Color(22, 5, 40));
        Stock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Stock.setForeground(new java.awt.Color(255, 255, 255));
        Stock.setBorder(null);
        Stock.setCaretColor(new java.awt.Color(255, 255, 255));
        Stock.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                StockCaretUpdate(evt);
            }
        });
        jPanel1.add(Stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 20, 160, 20));

        jLayeredPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 600, 220));

        Table.setBackground(new java.awt.Color(255, 153, 51));
        Table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
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
        jScrollPane3.setViewportView(Table);

        jLayeredPane1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 360, 180));

        AddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/add.png"))); // NOI18N
        AddNew.setBorder(null);
        AddNew.setBorderPainted(false);
        AddNew.setContentAreaFilled(false);
        AddNew.setFocusPainted(false);
        AddNew.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/Add2.png"))); // NOI18N
        AddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewActionPerformed(evt);
            }
        });
        jLayeredPane1.add(AddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        SaveTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/saveee.png"))); // NOI18N
        SaveTransaction.setToolTipText("Simpan Transaksi");
        SaveTransaction.setBorder(null);
        SaveTransaction.setBorderPainted(false);
        SaveTransaction.setContentAreaFilled(false);
        SaveTransaction.setFocusPainted(false);
        SaveTransaction.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/saveeeee.png"))); // NOI18N
        SaveTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveTransactionActionPerformed(evt);
            }
        });
        jLayeredPane1.add(SaveTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 250, 50));

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(255, 102, 0));
        Total.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Total.setForeground(new java.awt.Color(255, 255, 255));
        Total.setBorder(null);
        jLayeredPane1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 197, 20));

        NamaDistributor.setEditable(false);
        NamaDistributor.setBackground(new java.awt.Color(48, 19, 74));
        NamaDistributor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NamaDistributor.setForeground(new java.awt.Color(255, 255, 255));
        NamaDistributor.setBorder(null);
        NamaDistributor.setCaretColor(new java.awt.Color(255, 255, 255));
        NamaDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaDistributorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(NamaDistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 280, 30));

        NamaPetugas.setEditable(false);
        NamaPetugas.setBackground(new java.awt.Color(48, 19, 74));
        NamaPetugas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NamaPetugas.setForeground(new java.awt.Color(255, 255, 255));
        NamaPetugas.setBorder(null);
        NamaPetugas.setCaretColor(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(NamaPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 280, 30));

        KotaAsal.setEditable(false);
        KotaAsal.setBackground(new java.awt.Color(48, 19, 74));
        KotaAsal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        KotaAsal.setForeground(new java.awt.Color(255, 255, 255));
        KotaAsal.setBorder(null);
        KotaAsal.setCaretColor(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(KotaAsal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 200, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/cancel.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/cancel2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tanggal Barang Masuk");
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No. Nota");
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Petugas");
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Petugas");
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Distributor");
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Distributor");
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kota Asal");
        jLayeredPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        jLabel21.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Total Rp");
        jLayeredPane1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/brrrg.png"))); // NOI18N
        jLayeredPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1100, 690));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariDataActionPerformed
        // TODO add your handling code here:
        try {
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL= "SELECT * FROM tblbrgmasuk where nonota='"+NoNota.getText().toString()+"'";
            ResultSet r = s.executeQuery(SQL);
            r.absolute(1);
            TglMasuk.setText(r.getString("tglmasuk"));
            IDPetugas.setSelectedItem(r.getString("idpetugas"));
            IDDistributor.setSelectedItem(r.getString("iddistributor"));
            Total.setText(r.getString("total"));
            TampilGridDetail();
            SaveTransaction.setEnabled(false);
            NoNota.setEnabled(false);
            CariData.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersedia","Cari data",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CariDataActionPerformed

    private void IDPetugasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IDPetugasItemStateChanged
        // TODO add your handling code here:
        try {
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL= "SELECT * FROM tblpetugas where idpetugas='"+ IDPetugas.getSelectedItem().toString()+"'";
            ResultSet r = s.executeQuery(SQL);
            r.absolute(1);
            NamaPetugas.setText(r.getString("namapetugas"));
        } catch (Exception ex) {
        }
            
    }//GEN-LAST:event_IDPetugasItemStateChanged

    private void IDDistributorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IDDistributorItemStateChanged
        // TODO add your handling code here:
        try {
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM tbldistributor where iddistributor='"+ IDDistributor.getSelectedItem().toString()+"'";
            ResultSet r = s.executeQuery(SQL);
            r.absolute(1);
            NamaDistributor.setText(r.getString("namadistributor"));
            KotaAsal.setText(r.getString("kotaasal"));
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_IDDistributorItemStateChanged

    private void KodeBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_KodeBarangItemStateChanged
        // TODO add your handling code here:
        try {
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM tblbarang where kodebarang='"+ KodeBarang.getSelectedItem().toString()+"'";
            ResultSet r = s.executeQuery(SQL);
            r.absolute(1);
            NamaBarang.setText(r.getString("namabarang"));
            HargaJual.setText(r.getString("hargajual"));
            Stock.setText(r.getString("stok"));
        } catch (Exception ex) {
        }
        Jumlah.requestFocus();
        AddItem.setEnabled(true);
    }//GEN-LAST:event_KodeBarangItemStateChanged

    private void HitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HitungActionPerformed
        // TODO add your handling code here:
        int a;
        int b;
        double c, e, d;
        a = Integer.parseInt(HargaJual.getText());
        b = Integer.parseInt(Jumlah.getText());
        c = a*b;
        SubTotal.setText(String.valueOf(c));
    }//GEN-LAST:event_HitungActionPerformed

    private void SubTotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SubTotalCaretUpdate
        try {
            double d = Double.parseDouble(SubTotal.getText());
            double e = Double.parseDouble(Total.getText());
            e = e + d;
            Total.setText(String.valueOf(e));
          } catch (NumberFormatException e) {

          }
    }//GEN-LAST:event_SubTotalCaretUpdate

    private void AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewActionPerformed
        // TODO add your handling code here:
        SetEditOn();
        NoNota.requestFocus();
        BersihData();
    }//GEN-LAST:event_AddNewActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        // TODO add your handling code here:
        String NN=NoNota.getText();
        String KB=KodeBarang.getSelectedItem().toString();
        String J=Jumlah.getText();
        if((NN.isEmpty())|(KB.isEmpty())|(J.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            KodeBarang.requestFocus();
        }else{
            try {
                Class.forName(driver);
                Connection c = DriverManager.getConnection(database, user, pass);
                Statement s = c.createStatement();
                String SQL = "insert into tbldetailbrgmasuk values('"+NoNota.getText()+"',"+
                    "'"+KodeBarang.getSelectedItem()+"',"+
                    "'"+Jumlah.getText()+"',"+
                    "'"+SubTotal.getText()+"')";
                s.executeUpdate(SQL);
                Class.forName(driver);
                Connection c1 = DriverManager.getConnection(database, user, pass);
                Statement s1 = c1.createStatement();
                String SQL1 = "Update tblbarang Set stok=stok + '"+Jumlah.getText()+"'" +
                    "Where kodebarang='"+KodeBarang.getSelectedItem().toString()+"'";
                s1.executeUpdate(SQL1);
                data[0] = KodeBarang.getSelectedItem().toString();
                data[1] = NamaBarang.getText();
                data[2] = HargaJual.getText();
                data[3] = Stock.getText();
                data[4] = Jumlah.getText();
                data[5] = SubTotal.getText();
                tableModel.insertRow(0, data);
                s.close();
                c.close();
                KodeBarang.requestFocus();
                AddItem.setEnabled(false);
                BersihDetail();
                KodeBarang.requestFocus();;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_AddItemActionPerformed

    private void SaveTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveTransactionActionPerformed
        // TODO add your handling code here:
        String NN= NoNota.getText();
        if (NN.isEmpty()){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            NoNota.requestFocus();
        }else{
            try {
                Class.forName(driver);
                Connection c = DriverManager.getConnection(database, user, pass);
                Statement s = c.createStatement();
                String SQL = "insert into tblbrgmasuk values('"+NoNota.getText()+"',"+
                    "'"+TglMasuk.getText()+"',"+
                    "'"+IDDistributor.getSelectedItem()+"',"+
                    "'"+IDPetugas.getSelectedItem()+"',"+
                    "'"+Total.getText()+"')";
                s.executeUpdate(SQL);
                s.close();
                c.close();
                BersihData();
                SetEditOff();
                SaveTransaction.setEnabled(false);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_SaveTransactionActionPerformed

    private void StockCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_StockCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_StockCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BersihData();
        SetEditOff();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NamaDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaDistributorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaDistributorActionPerformed

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
            java.util.logging.Logger.getLogger(FormBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarangMasuk().setVisible(true);
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
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
        return new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String [] {"Kode Barang","Nama Barang","Harga Jual","Stok","Jumlah","Sub Total"}     
        ){
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };
            public  boolean isCellEditable(int rowIndex, int coloumnIndex){
                return canEdit[coloumnIndex];
            }
        };
    }
    String data[]=new String[6];
    
    private void setDefaultTable() {
        String stat ="";
        try {
            Class.forName(driver);
            Connection c = DriverManager.getConnection(database,user,pass);
            Statement s = c.createStatement();
            String SQL = "SELECT tblbarang.kodebarang,tblbarang.namabarang,tblbarang.hargajual," +
                    "tblbarang.stok,tbldetailbrgmasuk.jumlah,tbldetailbrgmasuk.subtotal,tblbrgmasuk.nonota " +
                    "FROM tblbarang,tbldetailbrgmasuk,tblbrgmasuk WHERE tblbarang.kodebarang=tbldetailbrgmasuk.kodebarang " +
                    "AND tblbrgmasuk.nonota=tbldetailbrgmasuk.nonota AND tbldetailbrgmasuk.nonota='"+NoNota.getText()+"'";
            ResultSet r = s.executeQuery(SQL);
            while(r.next()){
            data[0] = r.getString(1);
            data[1] = r.getString(2);
            data[2] = r.getString(3);
            data[3] = r.getString(4);
            data[4] = r.getString(5);
            data[5] = r.getString(6);
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
    private javax.swing.JButton AddItem;
    private javax.swing.JButton AddNew;
    private javax.swing.JButton CariData;
    private javax.swing.JTextField HargaJual;
    private javax.swing.JButton Hitung;
    private javax.swing.JComboBox IDDistributor;
    private javax.swing.JComboBox IDPetugas;
    private javax.swing.JTextField Jumlah;
    private javax.swing.JComboBox KodeBarang;
    private javax.swing.JTextField KotaAsal;
    private javax.swing.JTextField NamaBarang;
    private javax.swing.JTextField NamaDistributor;
    private javax.swing.JTextField NamaPetugas;
    private javax.swing.JTextField NoNota;
    private javax.swing.JButton SaveTransaction;
    private javax.swing.JTextField Stock;
    private javax.swing.JTextField SubTotal;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TglMasuk;
    private javax.swing.JTextField Total;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
