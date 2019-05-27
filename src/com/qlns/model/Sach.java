/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Thang
 */
public class Sach implements Serializable{
    
    private int maSach;
    private String tenSach;
    private String tenTG;
    private int soLuong;

    public int getMa_sach() {
        return maSach;
    }

    public void setMa_sach(int ma_sach) {
        this.maSach = ma_sach;
    }

    
    public String getTen_sach() {
        return tenSach;
    }

    public void setTen_sach(String ten_sach) {
        this.tenSach = ten_sach;
    }

    public String getTen_tg() {
        return tenTG;
    }

    public void setTen_tg(String ten_tg) {
        this.tenTG = ten_tg;
    }

    public int getSo_luong() {
        return soLuong;
    }

    public void setSo_luong(int so_luong) {
        this.soLuong = so_luong;
    }

    
    
    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + '}';
    }

    
    
}
