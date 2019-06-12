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
public class SachDAO {

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
                sach.setMaDauSach(rs.getInt("ma_dau_sach"));
                sach.setNxb(rs.getString("nxb"));
                sach.setNamXb(rs.getString("nam_xb"));
                sach.setSoLuongTon(rs.getInt("so_luong_ton"));
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

    public int createOrUpdate(Sach sach) {
        try {
            int rowCount = 0;
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO sach(ma_sach, ma_dau_sach, nxb, nam_xb ,so_luong_ton) "
                    + "VALUES(?, ?, ?, ?,?) ON DUPLICATE KEY UPDATE ma_dau_sach = VALUES(ma_dau_sach), nxb = VALUES(nxb), "
                    + "nam_xb = VALUES(nam_xb),so_luong_ton = VALUES(so_luong_ton) ;";
            PreparedStatement ps = cons.prepareStatement(sql);
            
            ps.setInt(1, sach.getMa_sach());
            ps.setInt(2,sach.getMaDauSach());
            ps.setString(3, sach.getNxb());
            ps.setString(4, sach.getNamXb());
            ps.setInt(5, sach.getSoLuongTon());
            
            rowCount += ps.executeUpdate();

            ps.close();
            cons.close();
            return rowCount;
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
