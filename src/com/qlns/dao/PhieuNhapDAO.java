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
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, phieuNhap.getMaPhieuNhap());
            ps.setDate(2, new Date(phieuNhap.getNgayNhap().getTime()) );
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            
            int generatedKey = 0 ;
            if (rs.next()){
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            
            return generatedKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
