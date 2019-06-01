/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.controller;

import com.qlns.model.Sach;
import com.qlns.service.SachService;
import com.qlns.service.SachServiceImpl;
import com.qlns.utility.ClassTableModel;
import com.qlns.view.NhapSachJFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
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
    private JPanel jpnView;
    private JButton add;
    private JTextField jtfSearch;
    
    private SachService sachService = null;
    
    private TableRowSorter<TableModel> rowSorter = null;
    
    private String[] listColumn = {"Mã sách","STT", "Tên Sách", "Tên Tác Giả","Số Lượng","Đơn giá nhập"};

    public QuanLySachController(JPanel jpnView, JButton add, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.add = add;
        this.jtfSearch = jtfSearch;
        
        this.sachService = new SachServiceImpl();
    }
    
    public void setDateToTable(){
        List<Sach> listItem = sachService.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableSach(listItem, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(1).setMinWidth(20);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        
        table.addMouseListener(new MouseAdapter() {
            
            public  void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    
//                    Sach sach = new Sach();
//                    sach.setMa_sach((int) model.getValueAt(selectedRowIndex, 0));
//                    sach.setTen_sach(model.getValueAt(selectedRowIndex, 2).toString());
//                    sach.setTen_tg(model.getValueAt(selectedRowIndex, 3).toString());
//                    sach.setSo_luong((int)model.getValueAt(selectedRowIndex, 4));
                                       
//                    NhapSachJFrame frame = new NhapSachJFrame(sach);
//                    frame.setTitle("Thông tin học viên");
//                    frame.setResizable(false);
//                    frame.setLocationRelativeTo(null);
//                    frame.setVisible(true);
                    
                    System.out.println("Button clicked");
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
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
        
    }
    
    public void setEvent() {
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NhapSachJFrame frame = new NhapSachJFrame(new Sach());
                frame.setTitle("Thông tin phiếu nhập");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
                System.out.println("Button clicked");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                add.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                add.setBackground(new Color(100, 221, 23));
            }
        });
    }
}
