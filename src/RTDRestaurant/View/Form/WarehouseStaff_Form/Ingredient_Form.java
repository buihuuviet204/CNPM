
package RTDRestaurant.View.Form.WarehouseStaff_Form;

import RTDRestaurant.Controller.Service.ServiceStaff;
import RTDRestaurant.Model.ModelNguyenLieu;
import RTDRestaurant.Model.ModelNguoiDung;
import RTDRestaurant.View.Form.MainForm;
import RTDRestaurant.View.Swing.CustomScrollBar.ScrollBarCustom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ingredient_Form extends javax.swing.JPanel {

    private ServiceStaff service;
    private ArrayList<ModelNguyenLieu> list;
    private final MainForm main;
    DecimalFormat df;

    public Ingredient_Form(MainForm main) {
        this.main=main;
        service=new ServiceStaff();
        initComponents();
        init();
    }

    public void init(){
        txtSearch.setHint("Tìm kiếm Nguyên Liệu . . .");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        df = new DecimalFormat("##,###,###");
        //Thêm data cho Menu
        initTable();
        getUserSales();
        //Them event cho Button ThemNL
        cmdAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                main.showForm(new InsertAndUpdate_Ingredient_Form(main,null));
            }
        });
        
        cmdUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ModelNguyenLieu data=service.getNLbyID(tableNL.getFirstCol_RowSelected(tableNL.getSelectedRow()));
                    main.showForm(new InsertAndUpdate_Ingredient_Form(main,data));
                } catch (SQLException ex) {
                    Logger.getLogger(Ingredient_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    public void getUserSales(){
             txtTong.setText(list.size()+"");
    }
    public void initTable(){
        try {
            list = service.MenuNL();
            for(ModelNguyenLieu data:list){  
                tableNL.addRow(new Object[]{data.getId(),data.getTenNL(),df.format(data.getDonGia())+"đ",data.getDvt()});
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void searchTable(String txt){
        tableNL.removeAllRow();
        for(ModelNguyenLieu data:list){
            if((data.getTenNL()).toLowerCase().contains(txt.toLowerCase())){
                tableNL.addRow(new Object[]{data.getId(),data.getTenNL(),df.format(data.getDonGia())+"đ",data.getDvt()});
            }
        }
        tableNL.repaint();
        tableNL.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        txtSearch = new RTDRestaurant.View.Swing.MyTextField();
        lbTong = new javax.swing.JLabel();
        txtTong = new RTDRestaurant.View.Swing.MyTextField();
        lbNL = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNL = new RTDRestaurant.View.Swing.Table();
        cmdAdd = new RTDRestaurant.View.Swing.Button();
        cmdUpdate = new RTDRestaurant.View.Swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/food.png"))); // NOI18N
        lbTitle.setText("Quản lý nguyên liệu");
        lbTitle.setIconTextGap(10);

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe (1).png"))); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSearchMouseEntered(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lbTong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTong.setForeground(new java.awt.Color(89, 89, 89));
        lbTong.setText("Tổng số nguyên liệu");

        txtTong.setEditable(false);
        txtTong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTong.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lbNL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNL.setForeground(new java.awt.Color(89, 89, 89));
        lbNL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNL.setText("Danh sách nguyên liệu");

        jSeparator2.setBackground(new java.awt.Color(76, 76, 76));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableNL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NL", "Tên nguyên liệu", "Đơn giá", "Đơn vị tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableNL);
        if (tableNL.getColumnModel().getColumnCount() > 0) {
            tableNL.getColumnModel().getColumn(0).setMinWidth(120);
            tableNL.getColumnModel().getColumn(0).setMaxWidth(120);
            tableNL.getColumnModel().getColumn(1).setMinWidth(250);
            tableNL.getColumnModel().getColumn(1).setPreferredWidth(30);
            tableNL.getColumnModel().getColumn(1).setMaxWidth(250);
            tableNL.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        cmdAdd.setBackground(new java.awt.Color(108, 91, 123));
        cmdAdd.setForeground(new java.awt.Color(255, 255, 255));
        cmdAdd.setText("THÊM NLIỆU");
        cmdAdd.setFocusable(false);
        cmdAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cmdUpdate.setBackground(new java.awt.Color(108, 91, 123));
        cmdUpdate.setForeground(new java.awt.Color(255, 255, 255));
        cmdUpdate.setText("SỬA NLIỆU");
        cmdUpdate.setFocusable(false);
        cmdUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTong, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbTitle)
                            .addComponent(lbNL))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cmdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
       
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered
        
        searchTable(txtSearch.getText().trim());
    }//GEN-LAST:event_txtSearchMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RTDRestaurant.View.Swing.Button cmdAdd;
    private RTDRestaurant.View.Swing.Button cmdUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbNL;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTong;
    private RTDRestaurant.View.Swing.Table tableNL;
    private RTDRestaurant.View.Swing.MyTextField txtSearch;
    private RTDRestaurant.View.Swing.MyTextField txtTong;
    // End of variables declaration//GEN-END:variables
}