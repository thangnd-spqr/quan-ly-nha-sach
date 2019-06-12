
package com.qlns.controller;

import com.qlns.bean.DanhMucBean;
import com.qlns.view.NhapSachPanel;
import com.qlns.view.QuanLySachPanel;
import com.qlns.view.TrangChuPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Thang
 */
public class ChuyenManHinhController {
    
    private JPanel jpnRoot;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.jpnRoot = jpnRoot;
    }
    
    public void setView (JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(229, 229, 204));
        jlbItem.setBackground(new Color(229, 229, 204));
        
        jpnRoot.removeAll();
        jpnRoot.setLayout(new BorderLayout());
        jpnRoot.add(new TrangChuPanel());
        jpnRoot.validate();
        jpnRoot.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem) {
        
        this.listItem = listItem;
        for(DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener {
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
             switch (kind) {
                case "TrangChu" :
                    node = new QuanLySachPanel();
                    break;
                case "NhapSach" :
                    node = new NhapSachPanel();
                    break;
                default:
                    node = new QuanLySachPanel();
                    break;
             }
             jpnRoot.removeAll();
             jpnRoot.setLayout(new BorderLayout());
             jpnRoot.add(node);
             jpnRoot.validate();
             jpnRoot.repaint();
             //setChangeBackgound(kind);
             
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
             if(!kindSelected.equalsIgnoreCase(kind)){
                 jpnItem.setBackground(new Color(102,255,255));
                 jlbItem.setBackground(new Color(102,255,255));
             }
        }
        
    }
    
    public void setChangeBackgound(String kind) {
        for(DanhMucBean item: listItem) {
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            }
        }
    }
    
}
