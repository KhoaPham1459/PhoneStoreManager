/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneStoreManager.FrontEnd.MyButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author DELL
 */
public class SuaButton extends JButton {
    public SuaButton() {
        this.setText("Sửa");
        this.setIcon(new ImageIcon(this.getClass().getResource("/com/PhoneStoreManager/image/icons8_support_30px.png")));
    }
}
