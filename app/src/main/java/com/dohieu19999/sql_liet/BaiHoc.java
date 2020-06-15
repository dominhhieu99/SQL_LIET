package com.dohieu19999.sql_liet;

public class BaiHoc {
private int id;
private String NameBaiHoc;

    public BaiHoc(int id, String nameBaiHoc) {
        this.id = id;
        NameBaiHoc = nameBaiHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBaiHoc() {
        return NameBaiHoc;
    }

    public void setNameBaiHoc(String nameBaiHoc) {
        NameBaiHoc = nameBaiHoc;
    }
}
