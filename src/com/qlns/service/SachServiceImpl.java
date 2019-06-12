/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.service;

import com.qlns.dao.SachDAO;
import com.qlns.dao.SachDAO;
import com.qlns.model.Sach;
import java.util.List;

/**
 *
 * @author Thang
 */
public class SachServiceImpl implements SachService{
    
    private SachDAO sachDAO = null;
    
    public SachServiceImpl() {
        sachDAO = new SachDAO();
    }
    
    @Override
    public List<Sach> getList() {
        return sachDAO.getList();
    }

    @Override
    public int createOrUpdate(Sach sach) {
        return sachDAO.createOrUpdate(sach);
    }
    
}
