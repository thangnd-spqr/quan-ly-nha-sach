/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.CTPhieuNhap;
import com.qlns.model.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thang
 */
public interface SachDAO {
    public List<Sach> getList();
    
    public int createOrUpdate(Sach sach);
    
    //public int createOrUpdate(CTPhieuNhap ctpn); 
}
