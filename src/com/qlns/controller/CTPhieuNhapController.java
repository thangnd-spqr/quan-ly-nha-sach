/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.controller;

import com.qlns.dao.CTPhieuNhapDAO;
import com.qlns.model.CTPhieuNhap;
import com.qlns.utility.ClassTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thang
 */
public class CTPhieuNhapController {
    
    private JPanel jpnTable;
    private JButton btnDelete;
    private JOptionPane jopThongBao;
    
    private DefaultTableModel dtm = null;
    private ClassTableModel model = null;
    JTable table = null;

    public CTPhieuNhapController() {
    }

    public CTPhieuNhapController(JPanel jpnTable, JButton btnDelete, JOptionPane jopThongBao) {
        this.jpnTable = jpnTable;
        this.btnDelete = btnDelete;
        this.jopThongBao = jopThongBao;
    }
    
    public void setDataToTable(List<CTPhieuNhap> listCTPN) {
        
        model = new ClassTableModel();
        String[] list = {"Mã CT Phiếu Nhập","Mã Phiếu Nhập","Mã Sách","Số Lượng","Đơn giá Nhập"};
        Object[] obj = new Object[list.length];
        
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(list);
        table = new JTable( dtm );
        
        for (int i = 0; i < listCTPN.size(); i++) {
            obj[0] = listCTPN.get(i).getMaCTPhieuNhap();
            obj[1] = listCTPN.get(i).getMaPhieuNhap();
            obj[2] = listCTPN.get(i).getMaSach();
            obj[3] = listCTPN.get(i).getSoLuongNhap();
            obj[4] = listCTPN.get(i).getDonGiaNhap();
            dtm.addRow(obj);
        }
        
        
        
        
        btnDelete.setToolTipText("Hủy chi tiết phiếu nhập đã chọn bên dưới");
        btnDelete.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = table.getSelectedRow();
                int maCTPN;
                
                System.out.println(n);
                CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
                if (n == -1){
                    jopThongBao.showMessageDialog(null,"Không có dữ liệu được chọn");
                } else {
                    maCTPN = (int)table.getValueAt(n, 0);
                    int f = ctpnDAO.deleteData(maCTPN);
                    if (f == 1) {
                        jopThongBao.showMessageDialog(null,"Xóa dữ liệu thành công");
                        dtm.removeRow(n);
                    } else {
                        jopThongBao.showMessageDialog(null,"Xóa dữ liệu thất bại");
                    }
                }
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
        
        jpnTable.removeAll();
        jpnTable.setLayout(new BorderLayout());
        jpnTable.add(scroll);
        jpnTable.validate();
        jpnTable.repaint();
    }
}
