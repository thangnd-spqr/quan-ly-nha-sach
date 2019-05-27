/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.main;

import com.qlns.view.MainJFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Thang
 */
public class Main {
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainJFrame frame = new MainJFrame();

                frame.setVisible(true);
                frame.setDefaultCloseOperation(MainJFrame.EXIT_ON_CLOSE);
            }
        });
        
        
    }
}
