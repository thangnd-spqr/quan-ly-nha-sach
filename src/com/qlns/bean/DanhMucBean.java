/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Thang
 */
public class DanhMucBean {
    
    private String kind;
    private JPanel jpn;
    private JLabel jlb;

    public DanhMucBean(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    
    
}
