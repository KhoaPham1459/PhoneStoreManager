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
public class RefreshButton extends JButton {

    public RefreshButton() {
        this.setText("Làm mới");
//        System.out.println(this.getClass().getResource("/com/PhoneStoreManager/images/internet.png"));
        this.setIcon(new ImageIcon(this.getClass().getResource("/com/PhoneStoreManager/image/internet.png")));
    }
}
