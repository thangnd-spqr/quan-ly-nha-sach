/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.utility;

import com.qlns.model.Sach;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thang
 */
public class ClassTableModel {
    
    public DefaultTableModel setTableSach(List<Sach> listItem,String [] listColumn) {
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
                Sach sach = listItem.get(i);
                obj = new Object[column];
                obj[0] = sach.getMa_sach();
                obj[1] = (i+1);
//                obj[2] = sach.getTen_sach();
//                obj[3] = sach.getTen_tg();
//                obj[4] = sach.getSo_luong();
                dtm.addRow(obj);
                
            }
        }
        return dtm;
    }
    
}
