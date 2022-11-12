package com.tutorial;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private int sId;
    private String name;


    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Student() {
        super();
    }


    public int getId() {
        return sId;
    }

    public Student(int sId, String name, String city) {
        this.sId = sId;
        this.name = name;
        this.city = city;
    }

    public void setId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    private Certificate certificate;

}
