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
public class CTPhieuNhap {
    
    private int maPhieuNhap;
    private int maSach;
    private int soLuongNhap;
    private long donGiaNhap;

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public long getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(long donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    @Override
    public String toString() {
        return "CTPhieuNhap{" + "maPhieuNhap=" + maPhieuNhap + ", maSach=" + maSach + '}';
    }
    
    
}
