/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.controller;

import com.qlns.model.CTPhieuNhap;
import com.qlns.utility.ClassTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thang
 */
public class CTPhieuNhapController {
    
    private JPanel jpnTable;
    private JButton btnDelete;
    
    private DefaultTableModel dtm = null;
    private ClassTableModel model = null;
    JTable table = null;

    public CTPhieuNhapController() {
    }

    public CTPhieuNhapController(JPanel jpnTable, JButton btnDelete) {
        this.jpnTable = jpnTable;
        this.btnDelete = btnDelete;
    }
    
    public void setDataToTable(List<CTPhieuNhap> listCTPN) {
        
        model = new ClassTableModel();
        String[] list = {"Mã Phiếu Nhập","Mã Sách","Số Lượng","Đơn giá Nhập"};
        Object[] obj = new Object[list.length];
        
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(list);
        table = new JTable( dtm );
        
        for (int i = 0; i < listCTPN.size(); i++) {
            obj[0] = listCTPN.get(i).getMaPhieuNhap();
            obj[1] = listCTPN.get(i).getMaSach();
            obj[2] = listCTPN.get(i).getSoLuongNhap();
            obj[3] = listCTPN.get(i).getDonGiaNhap();
            dtm.addRow(obj);
        }
        
        
        table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(200,50));
        table.setRowHeight(30);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1000, 400));
        
        jpnTable.removeAll();
        jpnTable.setLayout(new BorderLayout());
        jpnTable.add(scroll);
        jpnTable.validate();
        jpnTable.repaint();
    }
}
