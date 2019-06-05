/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.PhieuNhap;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thang
 */
public class PhieuNhapDAO {
    
    public int createOrUpdate(PhieuNhap phieuNhap ) {
    
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO phieu_nhap(ma_phieu_nhap, ngay_nhap) "
                    + "VALUES(?,?) ON DUPLICATE KEY UPDATE ngay_nhap = VALUES(ngay_nhap);";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, phieuNhap.getMaPhieuNhap());
            ps.setDate(2, new Date(phieuNhap.getNgayNhap().getTime()) );
            
            int rowCount = ps.executeUpdate();

            
            ps.close();
            cons.close();
            
            return rowCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public List<PhieuNhap> getList() {
        List<PhieuNhap> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM book_store.phieu_nhap";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                PhieuNhap phieuNhap = new PhieuNhap();
                phieuNhap.setMaPhieuNhap(rs.getInt("ma_phieu_nhap"));
                phieuNhap.setNgayNhap(rs.getDate("ngay_nhap"));
                list.add(phieuNhap);
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
