/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.Sach;
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
public class SachDAOImpl implements SachDAO{

    @Override
    public List<Sach> getList() {
        List<Sach> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM book_store.sach";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Sach sach = new Sach();
                sach.setMa_sach(rs.getInt("ma_sach"));
                sach.setTen_sach(rs.getString("ten_sach"));
                sach.setTen_tg(rs.getString("ten_tg"));
                sach.setSo_luong(rs.getInt("so_luong"));
                list.add(sach);
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

    @Override
    public int createOrUpdate(Sach sach) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO sach(ma_sach, ten_sach, ten_tg, so_luong) "
                    + "VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE ten_sach = VALUES(ten_sach), ten_tg = VALUES(ten_tg), "
                    + "so_luong = VALUES(so_luong);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sach.getMa_sach());
            ps.setString(2, sach.getTen_sach());
            ps.setString(3, sach.getTen_tg());
            ps.setInt(4, sach.getSo_luong());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

//    @Override
//    public int createOrUpdate(CTPhieuNhap ctpn) {
//        
//        
//    }
    
}
