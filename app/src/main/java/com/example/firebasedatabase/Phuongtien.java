package com.example.firebasedatabase;

public class Phuongtien {

    public String ten;
    public Integer sobanh;

    public Phuongtien() {
    }

    public Phuongtien(String ten, Integer sobanh) {
        this.ten = ten;
        this.sobanh = sobanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getSobanh() {
        return sobanh;
    }

    public void setSobanh(Integer sobanh) {
        this.sobanh = sobanh;
    }
}
