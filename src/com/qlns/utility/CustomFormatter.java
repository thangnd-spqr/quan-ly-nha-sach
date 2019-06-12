/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.utility;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Thang
 */
public class CustomFormatter {
    public static MaskFormatter createFormatter(String s) {
        
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
            formatter.setPlaceholder("");
        } catch (ParseException e) {
            System.err.println("formatter is bad: " + e.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
}
