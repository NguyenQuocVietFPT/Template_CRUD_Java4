package com.iamviet.template_crud_java4.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dongvat")
public class DongVat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String ten;

    @Column
    private Double can_nang;

    @Column
    private Boolean gioi_tinh;

    @Column
    private Integer nam_sinh;

    public DongVat() {
    }

    public DongVat(Integer id, String ten, Double can_nang, Boolean gioi_tinh, Integer nam_sinh) {
        this.id = id;
        this.ten = ten;
        this.can_nang = can_nang;
        this.gioi_tinh = gioi_tinh;
        this.nam_sinh = nam_sinh;
    }

    public DongVat(String ten, Double can_nang, Boolean gioi_tinh, Integer nam_sinh) {
        this.ten = ten;
        this.can_nang = can_nang;
        this.gioi_tinh = gioi_tinh;
        this.nam_sinh = nam_sinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getCan_nang() {
        return can_nang;
    }

    public void setCan_nang(Double can_nang) {
        this.can_nang = can_nang;
    }

    public Boolean getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(Boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public Integer getNam_sinh() {
        return nam_sinh;
    }

    public void setNam_sinh(Integer nam_sinh) {
        this.nam_sinh = nam_sinh;
    }
}
