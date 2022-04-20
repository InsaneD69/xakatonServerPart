package com.example.demo;


import org.json.JSONObject;
import org.springframework.data.jpa.repository.Modifying;

//import javax.persistence.Id

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.demo.DatabaseConnection.connectionDB;

public class SQLQueries {


    static public void createNewUser(JSONObject jsonObject) throws SQLException {


        String signDataQuery ="insert into \"UserSignDataTable\" "+" (" +
                "\"FCsGenDirector\"," +
                "\"INN\"," +
                "\"KPP\"," +
                "\"OGRN\"," +
                "\"dateOfRegistration\"," +
                "\"email\"," +
                "\"isCustomer\"," +
                "\"isSeller\"," +
                "\"legalAddress\"," +
                "\"nameCompany\"," +
                "\"phoneNumber\")"+
                " values (?,?,?,?,?,?,?,?,?,?,?)";


        PreparedStatement preparedStatementSign=connectionDB.prepareStatement(signDataQuery);

        preparedStatementSign.setString(1,jsonObject.getString("FCsGenDirector"));
        preparedStatementSign.setString(2,jsonObject.getString("INN"));
        preparedStatementSign.setString(3,jsonObject.getString("KPP"));
        preparedStatementSign.setString(4,jsonObject.getString("OGRN"));
        preparedStatementSign.setString(5,jsonObject.getString("dateOfRegistration"));
        preparedStatementSign.setString(6,jsonObject.getString("email"));
        preparedStatementSign.setBoolean(7,jsonObject.getBoolean("isCustomer"));
        preparedStatementSign.setBoolean(8,jsonObject.getBoolean("isSeller"));
        preparedStatementSign.setString(9,jsonObject.getString("legalAddress"));
        preparedStatementSign.setString(10,jsonObject.getString("nameCompany"));
        preparedStatementSign.setString(11,jsonObject.getString("phoneNumber"));
        preparedStatementSign.executeUpdate();

        String authDataQuery ="insert into \"UserAuthData\" "+" (" +
                "\"email\"," +
                "\"password\")" +
                " values (?,?)";


        PreparedStatement preparedStatementAuth=connectionDB.prepareStatement(authDataQuery);

        preparedStatementAuth.setString(1,jsonObject.getString("email"));
        preparedStatementAuth.setString(2,jsonObject.getString("password"));
        preparedStatementAuth.executeUpdate();




    }


    //@Modifying(clearAutomatically = true)
    public static void deleteUser(String nameTable,String column,String parameter) throws SQLException {//пример аргументов: (nameAuthDataTable, "email","= \'Qqwerty@crirretesnge.pzdc\'")

        String query="DELETE FROM \""+nameTable +"\" WHERE \""+column+"\" "+parameter;

        Statement preparedStatement= connectionDB.createStatement();
        int resultSet = preparedStatement.executeUpdate(query);


    }



    public void changeUserStatus(){}


    public void updateData(){}



    public void createRequestCustomer(JSONObject jsonObject){







    }
    public void createRequestSeller(JSONObject jsonObject){




    }



}
