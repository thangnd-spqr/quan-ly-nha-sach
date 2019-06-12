/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.model;

/**
 *
 * @author Thang
 */
public class DauSach {
    
    private int MaDauSach;
    private String TenDauSach;
    private String TheLoai;

    public DauSach() {
    }

    public DauSach(int MaDauSach, String TenDauSach, String TheLoai) {
        this.MaDauSach = MaDauSach;
        this.TenDauSach = TenDauSach;
        this.TheLoai = TheLoai;
    }

    public int getMaDauSach() {
        return MaDauSach;
    }

    public void setMaDauSach(int MaDauSach) {
        this.MaDauSach = MaDauSach;
    }

    public String getTenDauSach() {
        return TenDauSach;
    }

    public void setTenDauSach(String TenDauSach) {
        this.TenDauSach = TenDauSach;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    @Override
    public String toString() {
        return  TenDauSach ;
    }
    
    
}
