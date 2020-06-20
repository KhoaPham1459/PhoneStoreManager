
package com.PhoneStoreManager.BackEnd.Quanlyquyen;

import java.util.ArrayList;


public class QuanlyquyenBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã quyền", "Tên quyền", "Chi tiết quyền"};
    public static String[] getHeaders = {"STT", "Mã quyền", "Tên quyền", "Chi tiết quyền"};
    private static ArrayList<Quyen> a;
    private QuanlyquyenDAO qlquyenDAO = new QuanlyquyenDAO();

    public QuanlyquyenBUS() {
        if(a == null){
            a = qlquyenDAO.SelectQuyen();
        }
        else{
            if(a.size() <= 0){
                a = qlquyenDAO.SelectQuyen();
            }
        }
    }
    
    public static Quyen getQuyen(String MaQuyen){
        for(Quyen q: a){
            if(q.getMaQuyen().equals(MaQuyen)){
                return q;
            }
        }
        return null;
    }

    public static ArrayList<Quyen> getDSQuyen() {
        return a;
    }
    
    public static String MaQuyennotHave(){
        String s = "";
        int max = 0;
        int temp = 0;
        for(Quyen q: a){
            s = q.getMaQuyen();
            s = s.trim();
            s = s.replace("Q", "");
            temp = Integer.parseInt(s);
            if(max < temp){
                max = temp;
            }
        }
        ++max;
        return "Q" + max;
    }
    
    public boolean repaireQuyen(String MaQuyen, String TenQuyen, String ChiTietQuyen){
        if(qlquyenDAO.repairQuyen(MaQuyen, TenQuyen, ChiTietQuyen)){
            for(Quyen q: a){
                if(q.getMaQuyen().equals(MaQuyen)){
                    q.setTenQuyen(TenQuyen);
                    q.setChiTietQuyen(ChiTietQuyen);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deleteQuyen(String MaQuyen){
        if(qlquyenDAO.deleteQuyen(MaQuyen)){
            int i = 0;
            for(Quyen q: a){
                if(q.getMaQuyen().equals(MaQuyen)){
                    a.remove(i);
                    return true;
                }
                ++i;
            }
        }
        return false;
    }
    
    public boolean addQuyen(Quyen q){
        if(qlquyenDAO.addQuyen(q)){
            a.add(q);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Quyen> SearchQuyen(String s, String type){
        ArrayList<Quyen> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(Quyen q: a){
                    if(q.getMaQuyen().toLowerCase().contains(s) || q.getTenQuyen().toLowerCase().contains(s) || q.getChiTietQuyen().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã quyền":{
                for(Quyen q: a){
                    if(q.getMaQuyen().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Tên quyền":{
                for(Quyen q: a){
                    if(q.getTenQuyen().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Chi tiết quyền":{
                for(Quyen q: a){
                    if(q.getChiTietQuyen().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            default:break;
        }
        if(list.size() > 0) return list;
        return null;
    }
}
