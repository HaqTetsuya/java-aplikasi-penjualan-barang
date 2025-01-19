
package aplikasipenjualan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author user
 */
public class FormPenjualan extends javax.swing.JFrame {
    Database dbsetting;
    String driver,database,user,pass,userLogin;
    private Object tabel;

    /**
     * Creates new form FormPenjualan
     */
    public FormPenjualan() {
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
        //setting untuk memanggil koneksi Database.ini
        dbsetting = new Database();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        Table.setModel(tableModel);
        Tabel(Table, new int[]{90,300,90,60,60,90});
        setDefaultTable();
        TanggalOtomatis();
        SetEditOff();
        TampilComboBarang();
        TampilComboPetugas();
    }
    
    private void TampilGridDetail(){
        String stat="";
        try {
            Class.forName(driver);
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement();
            String SQL = "SELECT tblbarang.kodebarang,tblbarang.namabarang,tblbarang.hargajual," +"tblbarang.stok,tbldetailpenjualan.jumlah,tbldetailpenjualan.subtotal,tblpenjualan.nofaktur " +
                "FROM tblbarang, tbldetailpenjualan, tblpenjualan " +
                "WHERE tblbarang.kodebarang=tbldetailpenjualan.kodebarang " +
                "AND tblpenjualan.nofaktur=tbldetailpenjualan.nofaktur " +
                "AND tbldetailpenjualan.nofaktur='" + NoFaktur.getText().toString() + "'";
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
        NoFaktur.setText("");
        NamaPetugas.setText("");
        IDPetugas.setSelectedIndex(0);
        KodeBarang.setSelectedIndex(0);
        NamaBarang.setText("");
        HargaJual.setText("");
        Jumlah.setText("");
        Stock.setText("");
        Bayar.setText("0");
        Sisa.setText("0");
        Total.setText("0");
        SubTotal.setText("0");
    }
    public void BersihDetail(){
        KodeBarang.setSelectedIndex(0);
        NamaBarang.setText("");
        HargaJual.setText("");
        Jumlah.setText("");
        Stock.setText("");
        SubTotal.setText("0");
    }
    public void SetEditOff(){
        NoFaktur.setEnabled(false);
        TglMasuk.setEnabled(false);
        IDPetugas.setEnabled(false);
        KodeBarang.setEnabled(false);
        Jumlah.setEnabled(false);
        Hitung.setEnabled(false);
        CariData.setEnabled(false);
        AddItem.setEnabled(false);
    }
    public void SetEditOn(){
        NoFaktur.setEnabled(true);
        TglMasuk.setEnabled(true);
        IDPetugas.setEnabled(true);
        KodeBarang.setEnabled(true);
        Jumlah.setEnabled(true);
        SaveTransaction.setEnabled(true);
        CariData.setEnabled(true);
        Hitung.setEnabled(true);
        AddItem.setEnabled(true);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        TglMasuk = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NoFaktur = new javax.swing.JTextField();
        CariData = new javax.swing.JButton();
        IDPetugas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NamaPetugas = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        KodeBarang = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        AddItem = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        NamaBarang = new javax.swing.JTextField();
        HargaJual = new javax.swing.JTextField();
        Stock = new javax.swing.JTextField();
        Jumlah = new javax.swing.JTextField();
        Hitung = new javax.swing.JButton();
        SubTotal = new javax.swing.JTextField();
        SaveTransaction = new javax.swing.JButton();
        AddNew = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Bayar = new javax.swing.JTextField();
        Sisa = new javax.swing.JTextField();
        Total = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Penjualan");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLayeredPane1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 180, 370, 170));

        TglMasuk.setBackground(new java.awt.Color(48, 19, 74));
        TglMasuk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TglMasuk.setForeground(new java.awt.Color(255, 255, 255));
        TglMasuk.setBorder(null);
        TglMasuk.setCaretColor(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(TglMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 80, 200, 30));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No. Faktur");
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tanggal Penjualan");
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        NoFaktur.setBackground(new java.awt.Color(48, 19, 74));
        NoFaktur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NoFaktur.setForeground(new java.awt.Color(255, 255, 255));
        NoFaktur.setBorder(null);
        NoFaktur.setCaretColor(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(NoFaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 80, 160, 30));

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
        jLayeredPane1.add(CariData, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 88, 60));

        IDPetugas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Petugas" }));
        IDPetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IDPetugasItemStateChanged(evt);
            }
        });
        jLayeredPane1.add(IDPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 230, 30));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Petugas");
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Petugas");
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        NamaPetugas.setEditable(false);
        NamaPetugas.setBackground(new java.awt.Color(48, 19, 74));
        NamaPetugas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NamaPetugas.setForeground(new java.awt.Color(255, 255, 255));
        NamaPetugas.setBorder(null);
        NamaPetugas.setCaretColor(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(NamaPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 150, 280, 30));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Kode Barang");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        KodeBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Data Barang" }));
        KodeBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                KodeBarangItemStateChanged(evt);
            }
        });
        jPanel1.add(KodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, 30));

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nama Barang");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jLabel15.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Harga Jual");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 77, -1, 30));

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
        jPanel1.add(AddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 180, 40));

        jLabel18.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sub Total");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLabel16.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Stock");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        jLabel17.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jumlah");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, 40));

        NamaBarang.setEditable(false);
        NamaBarang.setBackground(new java.awt.Color(22, 5, 40));
        NamaBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NamaBarang.setForeground(new java.awt.Color(255, 255, 255));
        NamaBarang.setBorder(null);
        NamaBarang.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(NamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 57, 260, 20));

        HargaJual.setEditable(false);
        HargaJual.setBackground(new java.awt.Color(22, 5, 40));
        HargaJual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        HargaJual.setForeground(new java.awt.Color(255, 255, 255));
        HargaJual.setBorder(null);
        HargaJual.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(HargaJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 260, 20));

        Stock.setEditable(false);
        Stock.setBackground(new java.awt.Color(22, 5, 40));
        Stock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Stock.setForeground(new java.awt.Color(255, 255, 255));
        Stock.setBorder(null);
        Stock.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(Stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 167, 160, 20));

        Jumlah.setBackground(new java.awt.Color(22, 5, 40));
        Jumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jumlah.setForeground(new java.awt.Color(255, 255, 255));
        Jumlah.setBorder(null);
        Jumlah.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(Jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 217, 160, 20));

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
        jPanel1.add(Hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

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
        jPanel1.add(SubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 277, 160, 20));

        jLayeredPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 251, -1, 380));

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
        jLayeredPane1.add(SaveTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, 220, -1));

        AddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/add.png"))); // NOI18N
        AddNew.setToolTipText("Tambah");
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
        jLayeredPane1.add(AddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 96, -1));

        Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/cancel.png"))); // NOI18N
        Cancel.setToolTipText("Batal");
        Cancel.setBorder(null);
        Cancel.setBorderPainted(false);
        Cancel.setContentAreaFilled(false);
        Cancel.setFocusPainted(false);
        Cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/cancel2.png"))); // NOI18N
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bayar");
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 50, 30));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sisa");
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, -1, 20));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total");
        jLayeredPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 40, 20));

        Bayar.setBackground(new java.awt.Color(255, 102, 0));
        Bayar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Bayar.setForeground(new java.awt.Color(255, 255, 255));
        Bayar.setBorder(null);
        Bayar.setCaretColor(new java.awt.Color(255, 255, 255));
        Bayar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                BayarCaretUpdate(evt);
            }
        });
        Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BayarActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 200, 20));

        Sisa.setEditable(false);
        Sisa.setBackground(new java.awt.Color(255, 102, 0));
        Sisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Sisa.setForeground(new java.awt.Color(255, 255, 255));
        Sisa.setBorder(null);
        Sisa.setCaretColor(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(Sisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 455, 200, 20));

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(255, 102, 0));
        Total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Total.setForeground(new java.awt.Color(255, 255, 255));
        Total.setBorder(null);
        Total.setCaretColor(new java.awt.Color(255, 255, 255));
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });
        jLayeredPane1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, 200, 20));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasipenjualan/img/APENJUALAN.png"))); // NOI18N
        jLayeredPane1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1090, 690));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariDataActionPerformed
        // TODO add your handling code here:
        try {
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String SQL = "SELECT * FROM tblpenjualan where nofaktur='"+NoFaktur.getText().toString()+"'";
            ResultSet r = s.executeQuery(SQL);
            r.absolute(1);
            TampilGridDetail();
            TglMasuk.setText(r.getString("tglpenjualan"));
            IDPetugas.setSelectedItem(r.getString("idpetugas"));
            Bayar.setText(r.getString("bayar"));
            Sisa.setText(r.getString("sisa"));
            Total.setText(r.getString("total"));
            SaveTransaction.setEnabled(false);
            NoFaktur.setEnabled(false);
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
        double c;
        a = Integer.parseInt(HargaJual.getText());
        b = Integer.parseInt(Jumlah.getText());
        c = a*b;
        SubTotal.setText(String.valueOf(c));
    }//GEN-LAST:event_HitungActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        // TODO add your handling code here:
        String NF=NoFaktur.getText();
        String KB=KodeBarang.getSelectedItem().toString();
        String J=Jumlah.getText();
        if((NF.isEmpty())|(KB.isEmpty())|(J.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            KodeBarang.requestFocus();
        }else{
            try {
                Class.forName(driver);
                Connection c = DriverManager.getConnection(database, user, pass);
                Statement s = c.createStatement();
                String SQL = "insert into tbldetailpenjualan values('"+NoFaktur.getText()+"',"+
                    "'"+KodeBarang.getSelectedItem()+"',"+
                    "'"+Jumlah.getText()+"',"+
                    "'"+SubTotal.getText()+"')";
                s.executeUpdate(SQL);
                Class.forName(driver);
                Connection c1 = DriverManager.getConnection(database, user, pass);
                Statement s1 = c1.createStatement();
                String SQL1 = "Update tblbarang Set stok=stok - '"+Jumlah.getText()+"'" +
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
                KodeBarang.requestFocus();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_AddItemActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        SetEditOff();
    }//GEN-LAST:event_CancelActionPerformed

    private void SubTotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SubTotalCaretUpdate
        // TODO add your handling code here:
        try {
            double d = Double.parseDouble(SubTotal.getText());
            double e = Double.parseDouble(Total.getText());
            e = e + d;
            Total.setText(String.valueOf(e));
          } catch (NumberFormatException e) {
          }
    }//GEN-LAST:event_SubTotalCaretUpdate

    private void BayarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_BayarCaretUpdate
        try {
            double a = Double.parseDouble(Bayar.getText());
            double b = Double.parseDouble(Total.getText());
            double c = a - b;
            Sisa.setText(String.valueOf(c));
          } catch (NumberFormatException e) {
          }
    }//GEN-LAST:event_BayarCaretUpdate

    private void AddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewActionPerformed

        SetEditOn();
        NoFaktur.requestFocus();
        BersihData();
    }//GEN-LAST:event_AddNewActionPerformed

    private void SaveTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveTransactionActionPerformed
        String NF= NoFaktur.getText();
        if (NF.isEmpty()){
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            NoFaktur.requestFocus();
        }else{
            try {
                Class.forName(driver);
                Connection c = DriverManager.getConnection(database, user, pass);
                Statement s = c.createStatement();
                String SQL = "insert into tblpenjualan values('"+NoFaktur.getText()+"',"+
                    "'"+TglMasuk.getText()+"',"+
                    "'"+IDPetugas.getSelectedItem()+"',"+
                    "'"+Bayar.getText()+"',"+
                    "'"+Sisa.getText()+"',"+
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

    private void BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BayarActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed

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
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenjualan().setVisible(true);
            }
        });
    }

    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel();
    private void Tabel(javax.swing.JTable tb, int lebar[]){
        tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int kolom=tb.getColumnCount();
        for (int i = 0; i < kolom; i++) {
            javax.swing.table.TableColumn tbc=tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(17);
        }
    }
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
        return new  javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String [] {"Kode Barang","Nama Barang","Harga Jual","Stok","Jumlah","Sub Total"}
        ){
            boolean[]canEdit= new boolean[]{
                false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int coloumnIndex){
                return canEdit[coloumnIndex];
            }
        };
    }
    
    String data[]=new String[6];
    private void setDefaultTable(){
        String stat="";
        try {
            Class.forName(driver);
            Connection c = DriverManager.getConnection(database, user, pass);
            Statement s = c.createStatement();
            String SQL = "SELECT tblbarang.kodebarang,tblbarang.namabarang,tblbarang.hargajual," +
                "tblbarang.stok,tbldetailpenjualan.jumlah,tbldetailpenjualan.subtotal,tblpenjualan.nofaktur " +
                "FROM tblbarang,tbldetailpenjualan,tblpenjualan WHERE tblbarang.kodebarang=tbldetailpenjualan.kodebarang " +
                "AND tblpenjualan.nofaktur=tbldetailpenjualan.nofaktur AND tbldetailpenjualan.nofaktur='"+NoFaktur.getText()+"'";

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItem;
    private javax.swing.JButton AddNew;
    private javax.swing.JTextField Bayar;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton CariData;
    private javax.swing.JTextField HargaJual;
    private javax.swing.JButton Hitung;
    private javax.swing.JComboBox IDPetugas;
    private javax.swing.JTextField Jumlah;
    private javax.swing.JComboBox KodeBarang;
    private javax.swing.JTextField NamaBarang;
    private javax.swing.JTextField NamaPetugas;
    private javax.swing.JTextField NoFaktur;
    private javax.swing.JButton SaveTransaction;
    private javax.swing.JTextField Sisa;
    private javax.swing.JTextField Stock;
    private javax.swing.JTextField SubTotal;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TglMasuk;
    private javax.swing.JTextField Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
