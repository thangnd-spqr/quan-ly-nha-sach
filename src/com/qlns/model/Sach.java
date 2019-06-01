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
    private int maDauSach;
    private String nxb;
    private String namXb;
    private int soLuongTon;

    public Sach(){
        
    }
    
    public Sach(int maSach, int maDauSach, String nxb, String namXb, int soLuongTon) {
        this.maSach = maSach;
        this.maDauSach = maDauSach;
        this.nxb = nxb;
        this.namXb = namXb;
        this.soLuongTon = soLuongTon;
    }

    public int getMa_sach() {
        return maSach;
    }

    public void setMa_sach(int ma_sach) {
        this.maSach = ma_sach;
    }

    public int getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(int maDauSach) {
        this.maDauSach = maDauSach;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getNamXb() {
        return namXb;
    }

    public void setNamXb(String namXb) {
        this.namXb = namXb;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    
    

    
    
    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach  ;
    }

    
    
}
