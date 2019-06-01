/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.model;

import java.util.Date;

/**
 *
 * @author Thang
 */
public class PhieuNhap {
    
    private int maPhieuNhap;
    private Date ngayNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(int maPhieuNhap, Date ngayNhap) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    
}
