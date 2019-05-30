/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.controller;

import com.qlns.dao.DBConnect;
import com.qlns.model.CTPhieuNhap;
import com.qlns.service.SachService;
import com.qlns.service.SachServiceImpl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thang
 */
public class NhapSachController {
    
    private JButton btnAdd;
    private JButton btnSubmit;
    private JPanel jpnView;
    private javax.swing.JTextField jtfDonGiaNhap;
    private javax.swing.JTextField jtfMaSach;
    private JTextField jtfMaPhieuNhap;
    private javax.swing.JTextField jtfSoLuong;
    private JLabel jlbMsg;
    private JComboBox jcbTenDauSach;
    
    private CTPhieuNhap ctpn = null;
    
    private SachService sachService = null;
    
    private List<CTPhieuNhap> listCTPN ;
    
    public void setMaPhieuNhap(){
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT ma_phieu_nhap FROM book_store.ct_pn";
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            int id = 0;
            if (rs.next()) {
                while(rs.next()) {
                    id = rs.getInt("ma_phieu_nhap");
                }
            }           
            jtfMaPhieuNhap.setText(Integer.toString(id));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public int checkIfMaSachExist(JTable table, int maSach) {
        
        int index = -1;
        for(int i = 0; i < table.getRowCount(); i++) {
            System.out.println("gia tri ma sach: " + (int)table.getValueAt(i, 1));
            if ((int)table.getValueAt(i, 1) == maSach) {
                index = i; 
                break;
            }
        }
        return index;
    }

    public NhapSachController(JButton btnAdd,JButton btnSubmit,JPanel jpnView, JTextField jtfMaSach,JTextField jtfMaPhieuNhap,
             JTextField jtfSoLuong,JTextField jtfDonGiaNhap,JLabel jlbMsg) {
        this.btnAdd = btnAdd;
        this.btnSubmit = btnSubmit;
        this.jpnView = jpnView;
        this.jtfMaSach = jtfMaSach;
        this.jtfMaPhieuNhap = jtfMaPhieuNhap;
        this.jtfSoLuong = jtfSoLuong;
        this.jtfDonGiaNhap = jtfDonGiaNhap;
        this.jlbMsg = jlbMsg;
        
        this.sachService = new SachServiceImpl();
    }
    public void setView(CTPhieuNhap ctpn) {
        this.ctpn = ctpn;
        //jtfMaSach.setText("" + sach.getMa_sach());
        //jtfTenSach.setText(sach.getTen_sach());
        //jtfTenTacGia.setText(sach.getTen_tg());
        //jtfSoLuong.setText("" + sach.getSo_luong());
    }
    
    public void setEvent() {
        
        DefaultTableModel dtm = new DefaultTableModel();
        String[] list = {"Mã Phiếu Nhập","Mã Sách","Số Lượng","Đơn giá Nhập"};
        dtm.setColumnIdentifiers(list);
        JTable table = new JTable(dtm);
        Object[] objs = new Object[list.length];
        listCTPN = new ArrayList<>(); 
        setMaPhieuNhap();
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                               
                if (jtfMaSach.getText().length() == 0) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                } else {
                    ctpn = new CTPhieuNhap();
                    System.out.println("Button clicked");
                    int n = (Integer.parseInt(jtfMaSach.getText()));
                    System.out.println(n);
                    ctpn.setMaSach(n);                   
                    ctpn.setMaPhieuNhap(Integer.parseInt(jtfMaPhieuNhap.getText()));
                    ctpn.setSoLuongNhap(Integer.parseInt(jtfSoLuong.getText()));
                    ctpn.setDonGiaNhap(Long.parseLong(jtfDonGiaNhap.getText()));  
                    if( checkIfMaSachExist(table, n) == -1) {
                        objs[0] = ctpn.getMaPhieuNhap();
                        objs[1] = ctpn.getMaSach();
                        objs[2] = ctpn.getSoLuongNhap();
                        objs[3] = ctpn.getDonGiaNhap();
                        dtm.addRow(objs);
                        listCTPN.add(ctpn);
                    } else {
//                        int index = checkIfMaSachExist(table, n);
//                        
//                        System.out.println("Last index: "+ index);
//                        
//                        int previousValue = Integer.valueOf((String)table.getValueAt(n, 2)) ; //Lấy số lượng tại vị trí mã mách tồn tại
//                        
//                        int userValue = Integer.valueOf(jtfSoLuong.getText());
//                        
//                        int updateValue = previousValue + userValue;
//                        
//                        table.setValueAt(updateValue, n, 2 );
                        
                        jlbMsg.setText("Dữ liệu bị trùng");
                    }
                    
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
        
        
        
        
        table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(200,50));
        table.setRowHeight(30);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1000, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
        
        btnSubmit.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){
                for(int i = 0; i< listCTPN.size(); i++) {
                    System.out.println(listCTPN.get(i).toString());
                }
            }
        });
    }
    
    public void setComboBox(){
        ArrayList<Integer> maDauSach = new ArrayList<Integer>();
        ArrayList<String> tenDauSach = new ArrayList<String>();
        ArrayList<String> theLoai = new ArrayList<String>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM book_store.dau_sach";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                maDauSach.add(rs.getInt("ma_dau_sach"));
                tenDauSach.add(rs.getString("ten_dau_sach"));
                theLoai.add(rs.getString("the_loai"));  
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
    
    
    
    
    
    
    

