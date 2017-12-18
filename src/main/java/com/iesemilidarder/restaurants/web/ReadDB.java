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

            if (cercar == null || cercar.equals("")){

                System.out.println("select * from  ( select RE.RES_NOM, RE.RES_WEB, RE.RES_ADRECA, RE.RES_TELEFON, RR.TRS_DESCRIPCIO , RE.RES_MITJANA FROM RESTAURANTS RE , TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI ORDER BY RE.RES_MITJANA desc ) where ROWNUM <= 5");
                rs = stmt.executeQuery("select * from  ( select RE.RES_NOM, RE.RES_WEB, RE.RES_ADRECA, RE.RES_TELEFON, RR.TRS_DESCRIPCIO , RE.RES_MITJANA FROM RESTAURANTS RE , TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI ORDER BY RE.RES_MITJANA desc ) where ROWNUM <= 5");


            } else {

                System.out.println("select * from  ( select RE.RES_NOM, RE.RES_WEB, RE.RES_ADRECA, RE.RES_TELEFON, RR.TRS_DESCRIPCIO , RE.RES_MITJANA FROM RESTAURANTS RE , TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI AND LOWER( RE.RES_NOM) LIKE '%"+cercar.toLowerCase()+"%' ORDER BY RE.RES_MITJANA desc ) where ROWNUM <= 5");
                rs = stmt.executeQuery("select * from  ( select RE.RES_NOM, RE.RES_WEB, RE.RES_ADRECA, RE.RES_TELEFON, RR.TRS_DESCRIPCIO , RE.RES_MITJANA FROM RESTAURANTS RE , TRESTAURANTS RR WHERE RE.RES_TRS_CODI = RR.TRS_CODI AND LOWER( RE.RES_NOM) LIKE '%"+cercar.toLowerCase()+"%' ORDER BY RE.RES_MITJANA desc ) where ROWNUM <= 5");

            }



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