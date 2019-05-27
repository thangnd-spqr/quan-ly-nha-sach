/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.service;

import com.qlns.model.Sach;
import java.util.List;

/**
 *
 * @author Thang
 */
public interface SachService {
    
    public List<Sach> getList();
    public int createOrUpdate(Sach sach);
}
