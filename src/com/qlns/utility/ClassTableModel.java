/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.utility;

import com.qlns.model.CTPhieuNhap;
import com.qlns.model.PhieuNhap;
import com.qlns.model.Sach;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thang
 */
public class ClassTableModel {
    
    public DefaultTableModel setTablePhieuNhap(List<PhieuNhap> listItem,String [] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
         
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int column = listColumn.length;
        Object[] obj = null;
        int rows =listItem.size();
        if (rows > 0) {
            for (int  i= 0 ; i<rows ; i++){
                PhieuNhap phieuNhap = listItem.get(i);
                obj = new Object[column];
                obj[0] = phieuNhap.getMaPhieuNhap();
                obj[1] = phieuNhap.getNgayNhap();
                dtm.addRow(obj);
                phieuNhap.toString();
                
            }
        }
        
        return dtm;
    }
    
    public DefaultTableModel setTableCTPhieuNhap(List<CTPhieuNhap> listItem,String [] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
         
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int column = listColumn.length;
        Object[] obj = null;
        int rows =listItem.size();
        if (rows > 0) {
            for (int  i= 0 ; i<rows ; i++){
                CTPhieuNhap cTPhieuNhap = listItem.get(i);
                obj = new Object[column];
                obj[0] = cTPhieuNhap.getMaPhieuNhap();
                obj[1] = cTPhieuNhap.getMaSach();
                obj[2] = cTPhieuNhap.getSoLuongNhap();
                obj[3] = cTPhieuNhap.getDonGiaNhap();
                dtm.addRow(obj);                
            }
        }
        
        return dtm;
    }
    
    public DefaultTableModel setTableSach (List<Sach> listItem,String [] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
         
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dtm.setColumnIdentifiers(listColumn);
        
        int column = listColumn.length;
        
        Object[] obj = null;
        
        int row = listItem.size();
        
        if (row > 0 ) {
            for (int i = 0; i < row; i++) {
                obj = new Object[column];
                obj[0] = listItem.get(i).getMa_sach();
                obj[1] = listItem.get(i).getMaDauSach();
                obj[2] = listItem.get(i).getNxb();
                obj[3] = listItem.get(i).getNamXb();
                obj[4] = listItem.get(i).getSoLuongTon();
                dtm.addRow(obj);
            }
        }
        
        return dtm;
    }
    
}
