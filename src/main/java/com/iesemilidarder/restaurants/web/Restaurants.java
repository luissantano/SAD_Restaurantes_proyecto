package com.iesemilidarder.restaurants.web;

//He afegit un private string anomenat imatge per poder mostrar una imatge.

public class Restaurants {
    private String name;
    private String address;
    private String website;
    private String telephone;
    private String type;
    private String image;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setType(String type) {
        this.type = type;
    }
}
