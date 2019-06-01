/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.CTPhieuNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Thang
 */
public class CTPhieuNhapDAO {
    
    public int createOrUpdate(CTPhieuNhap ctpn ) {
    
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO ct_pn(ma_ctpn,ma_phieu_nhap, ma_sach,so_luong_nhap,don_gia_nhap) "
                    + "VALUES(?,?, ?, ?, ?) ON DUPLICATE KEY UPDATE so_luong_nhap = VALUES(so_luong_nhap), don_gia_nhap = VALUES(don_gia_nhap);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ctpn.getMaCTPhieuNhap());
            ps.setInt(2, ctpn.getMaPhieuNhap());
            ps.setInt(3,ctpn.getMaSach());
            ps.setInt(4, ctpn.getSoLuongNhap());
            ps.setLong(5, ctpn.getDonGiaNhap());
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
