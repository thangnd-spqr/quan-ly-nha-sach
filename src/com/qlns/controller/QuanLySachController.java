/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.controller;

import com.qlns.dao.DauSachDAO;
import com.qlns.dao.SachDAO;
import com.qlns.model.DauSach;
import com.qlns.model.Sach;
import com.qlns.utility.ClassTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Thang
 */
public class QuanLySachController {
    private JFormattedTextField tfMaSach;
    private JComboBox cbNhaXuatBan;
    private JSpinner spinNamXB;
    private JComboBox cbDauSach;
    private JFormattedTextField tfSoLuong;
    private JButton btnThem;
    private JButton btnThemDauSach;
    private JButton btnThemNXB;
    private JButton btnCapNhap;
    private JLabel lbLoi;
    private JTextField tfSearch;
    private JPanel pnTable;
    
    private JTable table;
    
    private int indexForMaDauSach;
    private List<DauSach> listDauSach = null;
    List<Sach> listSach = new ArrayList<>();
    private String[] listColumn = {"Mã sách","Mã Đầu Sách","Nhà Xuất Bản","Năm Xuất Bản","Số Lượng Tồn"}; 


    public QuanLySachController(JFormattedTextField tfMaSach, JComboBox cbNhaXuatBan, JSpinner spinNamXB,JFormattedTextField tfSoLuong,
            JComboBox cbDauSach, JButton btnThem, JButton btnThemDauSach, 
            JButton btnThemNXB, JButton btnCapNhap,JLabel lbLoi,JPanel pnTable,JTextField tfSearch) {
        this.tfMaSach = tfMaSach;
        this.cbNhaXuatBan = cbNhaXuatBan;
        this.spinNamXB = spinNamXB;
        this.cbDauSach = cbDauSach;
        this.tfSoLuong = tfSoLuong;
        this.btnThem = btnThem;
        this.btnThemDauSach = btnThemDauSach;
        this.btnThemNXB = btnThemNXB;
        this.btnCapNhap = btnCapNhap;
        this.tfSearch = tfSearch;
        this.lbLoi = lbLoi;
        
        this.pnTable = pnTable;
    }
    
    public void setEvent() {
                
        setCbDauSach();
        setCBNhaXuatBan();
        setSpinNamXB();
        btnThem.addMouseListener(new MouseAdapter() {
        
            public void mouseClicked(MouseEvent e) {
                
                SachDAO sachDAO = new SachDAO();
                Sach sach = new Sach();
                int saveCheck = 0;
                
                if(tfMaSach.getText().trim().length() == 0 ||tfSoLuong.getText().trim().length() == 0) {
                    lbLoi.setText("Nhập đủ các thông tin cần thiết");
                } else if (tfMaSach.getText().trim().length() < 5) {
                    lbLoi.setText("Mã sách có độ dài 5 ký tự VD: 10000");
                } else {
                    sach.setMa_sach(Integer.parseInt(tfMaSach.getText().trim()));
                    sach.setMaDauSach(listDauSach.get(indexForMaDauSach).getMaDauSach());
                    sach.setNxb((String)cbNhaXuatBan.getSelectedItem());
                    sach.setNamXb(String.valueOf(spinNamXB.getValue()));
                    sach.setSoLuongTon(Integer.parseInt(tfSoLuong.getText().trim()));
                    saveCheck = sachDAO.createOrUpdate(sach);
                    if(saveCheck == 0) {
                        lbLoi.setText("Lưu dữ liệu vào database không thành công");
                    } else {
                        lbLoi.setText("Đã lưu entry vào database");
                    }
                   
                }
            }
        });
        
    }
    
    public void setDataToTable() {
        
        DefaultTableModel dtm;
        
        SachDAO sachDAO = new SachDAO();
        
        listSach = sachDAO.getList();
        
        
        dtm = new ClassTableModel().setTableSach(listSach, listColumn);
        table = new JTable(dtm);
        
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(tableRowSorter);
        
        tfSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                
                String text = tfSearch.getText();
                if(text.trim().length() == 0) {
                    tableRowSorter.setRowFilter(null);
                } else {
                    tableRowSorter.setRowFilter(RowFilter.regexFilter(text,0));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
                String text = tfSearch.getText();
                if(text.trim().length() == 0) {
                    tableRowSorter.setRowFilter(null);
                } else {
                    tableRowSorter.setRowFilter(RowFilter.regexFilter(text,0));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        btnCapNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                ClassTableModel classTableModel = new ClassTableModel();
                DefaultTableModel model = new DefaultTableModel();
                listSach = sachDAO.getList();
                model = classTableModel.setTableSach(listSach, listColumn);
                table.setModel(model);
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
        
        pnTable.removeAll();
        pnTable.setLayout(new BorderLayout());
        pnTable.add(scroll);
        pnTable.validate();
        pnTable.repaint();


    }
    public void setCbDauSach(){
        
        DauSachDAO dauSachDAO = new DauSachDAO();
        listDauSach = new ArrayList<>();
        listDauSach = dauSachDAO.getList();
        
        
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (int i = 0; i < listDauSach.size(); i++) {
            dcbm.addElement(listDauSach.get(i).toString());
        }
        
        cbDauSach.setModel(dcbm);
        cbDauSach.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                JComboBox cb = (JComboBox) e.getSource();
                indexForMaDauSach = cb.getSelectedIndex();
            }
        });
    }
    
    public void setCBNhaXuatBan () {
    
        String[] nxb = {"Kim Đồng","Trẻ","Giáo Dục", "Đại Học Quốc Gia"};
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        
        for (int i = 0; i < nxb.length; i++) {
            dcbm.addElement(nxb[i]);
        }
        
        cbNhaXuatBan.setModel(dcbm);
    }
    
    public void setSpinNamXB() {
        
        int year = 2000;
        SpinnerNumberModel snm = new SpinnerNumberModel(year, year-20, year + 50, 1);
        spinNamXB.setModel(snm);
    }
}

