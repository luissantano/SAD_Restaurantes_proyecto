package com.iesemilidarder.restaurants.web;

import java.util.ArrayList;
import java.util.Iterator;

public class ShowRestaurants {
    public static void main(String[] args) {
        ReadDB readDB = new ReadDB();

        ArrayList al = readDB.readRestaurants();
        Iterator itr = al.iterator();

        while (itr.hasNext()) {
            Restaurants rst = (Restaurants) itr.next();
            System.out.println(" " + rst.getName() + " " + rst.getAddress() + " " + rst.getWebsite() + " " + rst.getTelephone() + " " + rst.getType());


        }


    }
}