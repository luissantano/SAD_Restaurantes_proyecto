package com.iesemilidarder.restaurants.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*Cream una classe publica */
public class ReadDB {


    public ArrayList readRestaurants() {

        ArrayList ar = new ArrayList();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");



            Statement stmt = con.createStatement();


/*Feim una consulta , que ens mostri el nom, la web , la adreça , el telefon etc*/
            ResultSet rs = stmt.executeQuery("SELECT E.RES_NOM, E.RES_WEB, E.RES_ADRECA, E.RES_TELEFON, R.TRS_DESCRIPCIO FROM RESTAURANTS E , TRESTAURANTS R WHERE E.RES_TRS_CODI = R.TRS_CODI");

            while (rs.next()) {


                String name = rs.getString("RES_NOM");
                String website = rs.getString("RES_WEB");
                String address = rs.getString("RES_ADRECA");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");

                Restaurants rst = new Restaurants();
                rst.setName(name);
                rst.setAddress(address);
                rst.setWebsite(website);
                rst.setTelephone(telephone);
                rst.setType(type);



                ar.add(rst);


            }
            stmt.close();
            con.close();


        }

        catch (Exception e) {
            System.out.println(e.toString());
        }
        return ar;

    }
}