package com.iesemilidarder.restaurants.web;

public class Restaurants {
    private String name;
    private String address;
    private String website;
    private String telephone;
    private String type;

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
