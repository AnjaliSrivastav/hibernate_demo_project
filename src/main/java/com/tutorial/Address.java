package com.tutorial;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

   @Column(length = 50, name="STREET")
   private String street;

   @Column(length = 50, name="CITY")
   private String city;

   @Column(name="is_open")
   private boolean isOpen;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", isOpen=" + isOpen +
                ", x=" + x +
                ", addedDate=" + addedDate +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public int getId() {
        return addressId;
    }

    public void setId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public Address() {
        super();
    }


    @Transient        //this field's column will not be created in the table bcz it has @Transient annotation. And thus, the data of
    //this value will not be saved in DB.
    private double x;

    @Column(name="added_date")
    @Temporal(TemporalType.DATE) //format the date. Now only date will be saved in a table only not the time.
    private Date addedDate;

    @Column(name="IMAGE")
    @Lob
    private byte[] image;

}
