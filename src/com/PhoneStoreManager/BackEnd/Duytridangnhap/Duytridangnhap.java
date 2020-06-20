
package com.PhoneStoreManager.BackEnd.Duytridangnhap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Duytridangnhap {
    private String username = "";

    public Duytridangnhap() {
        read();
    }
    
    public void read(){
        try {
            File inp = new File("temp");
            if(!inp.exists()) inp.createNewFile();
            Scanner fi = new Scanner(inp);
            while(fi.hasNextLine()){
                username = fi.nextLine();
            }
            fi.close();
        } catch (IOException ex) {
            Logger.getLogger(Duytridangnhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void write(String username){
        try {
            this.username = username;
            FileOutputStream out = new FileOutputStream("temp");
            PrintWriter fo = new PrintWriter(out);
            fo.println(username);
            System.out.println("Duy tri dang nhap: " + username);
            fo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Duytridangnhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
