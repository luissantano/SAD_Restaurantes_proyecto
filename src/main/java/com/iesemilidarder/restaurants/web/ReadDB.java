package com.iesemilidarder.restaurants.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*Cream una classe publica */
public class ReadDB {


    public ArrayList readRestaurants(String cercar) {

        ArrayList ar = new ArrayList();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");


            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");



            Statement stmt = con.createStatement();

            ResultSet rs;

            System.out.println(cercar);

            //Aquest if serveix per al cercador . Diu que si el valor que introduim es null o no posam res , farà un select amb el nom , telèfon , imatge etc...

            if (cercar == null || cercar.equals("")){

                rs = stmt.executeQuery("select * from  ( select RE.RES_NOM, RE.RES_WEB, RE.RES_ADRECA, RE.RES_TELEFON, RR.TRS_DESCRIPCIO , RE.RES_MITJANA , RES_URL_IMG FROM RESTAURANTS RE , TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI ORDER BY RE.RES_MITJANA desc ) where ROWNUM <= 5");

            //Aquesta part del else fa un select amb el valor que l'hi hem introduit
            } else {

                rs = stmt.executeQuery("select * from  ( select RE.RES_NOM, RE.RES_WEB, RE.RES_ADRECA, RE.RES_TELEFON, RR.TRS_DESCRIPCIO, RE.RES_MITJANA, RES_URL_IMG FROM RESTAURANTS RE , TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI AND LOWER( RE.RES_NOM) LIKE '%"+cercar.toLowerCase()+"%' ORDER BY RE.RES_MITJANA desc ) where ROWNUM <= 5");

            }



            while (rs.next()) {


                String name = rs.getString("RES_NOM");
                String website = rs.getString("RES_WEB");
                String address = rs.getString("RES_ADRECA");
                String telephone = rs.getString("RES_TELEFON");
                String type = rs.getString("TRS_DESCRIPCIO");
                String image = rs.getString("RES_URL_IMG");

                Restaurants rst = new Restaurants();
                rst.setName(name);
                rst.setAddress(address);
                rst.setWebsite(website);
                rst.setTelephone(telephone);
                rst.setType(type);
                rst.setImage(image);



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