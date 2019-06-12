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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class CTPhieuNhapDAO {
    
    public int createOrUpdate(List<CTPhieuNhap> dsCtpn ) throws SQLException {
        
        int rowCount = 0; // khởi tạo biến đếm số dòng trong database đã update, create
        Connection cons = DBConnect.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO ct_pn(ma_ctpn,ma_phieu_nhap, ma_sach,so_luong_nhap,don_gia_nhap) "
                    + "VALUES(?,?, ?, ?, ?) ON DUPLICATE KEY UPDATE so_luong_nhap = VALUES(so_luong_nhap), "
                    + "don_gia_nhap = VALUES(don_gia_nhap);";

        for (int i = 0; i < dsCtpn.size(); i++) {
            try {
                ps = cons.prepareStatement(sql);
                ps.setInt(1, dsCtpn.get(i).getMaCTPhieuNhap());
                ps.setInt(2, dsCtpn.get(i).getMaPhieuNhap());
                ps.setInt(3,dsCtpn.get(i).getMaSach());
                ps.setInt(4, dsCtpn.get(i).getSoLuongNhap());
                ps.setLong(5, dsCtpn.get(i).getDonGiaNhap());
                rowCount += ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }

        ps.close();
        cons.close();
            

        return rowCount;
    }
    
    public List<CTPhieuNhap> getList (int id) {
        
        List<CTPhieuNhap> listCTPN = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM book_store.ct_pn where ma_phieu_nhap = ' " + Integer.toString(id) +  "';";
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                CTPhieuNhap ctpn = new CTPhieuNhap(rs.getInt("ma_ctpn"), rs.getInt("ma_phieu_nhap"), 
                        rs.getInt("ma_sach"), rs.getInt("so_luong_nhap"), rs.getLong("don_gia_nhap"));
                listCTPN.add(ctpn);
            }

            ps.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listCTPN;
    }
    
    public int deleteData( int id) {
        int rowCount = 0; // khởi tạo biến đếm số dòng trong database đã update, create
        Connection cons = DBConnect.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM book_store.ct_pn WHERE ma_ctpn = '"+ id +"';";
        try {
            ps = cons.prepareStatement(sql);
            rowCount = ps.executeUpdate();
            ps.close();
            cons.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
