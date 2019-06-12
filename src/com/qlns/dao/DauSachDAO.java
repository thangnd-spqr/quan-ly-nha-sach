/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.DauSach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thang
 */
public class DauSachDAO {
    
    public List<DauSach> getList() {
        List<DauSach> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM book_store.dau_sach";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DauSach dauSach = new DauSach();
                dauSach.setMaDauSach(rs.getInt("ma_dau_sach"));
                dauSach.setTenDauSach(rs.getString("ten_dau_sach"));
                dauSach.setTheLoai(rs.getString("ten_the_loai"));
                list.add(dauSach);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }    
    
}
