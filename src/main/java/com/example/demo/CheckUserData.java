package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.*;

public class CheckUserData {

     JSONObject jsonObject;

     public ArrayList<String> requestLogs =new ArrayList<>();

    boolean errors=false;


     public  CheckUserData(JSONObject jsonObject) throws SQLException {



         this.jsonObject=jsonObject;

         EnumSet.allOf(LocaleFields.class).forEach(field->{  //проверка заполненности всех полей после передачи

             checkNotNullField(String.valueOf(field));

         });
         if( CheckValueInDB.checkUniquenessValue(LocaleFields.email.name(),jsonObject.getString("email"))){

             requestLogs.add("Почта "+jsonObject.getString("INN")+" уже занята");

         }

            //проверка уникального названия компаниии
        if( CheckValueInDB.checkUniquenessValue(LocaleFields.nameCompany.name(),jsonObject.getString("nameCompany"))){

            requestLogs.add("Компания с названием "+jsonObject.getString("nameCompany")+" уже существует");
         }

         //проверка уникального инн компаниии
        if( CheckValueInDB.checkUniquenessValue(LocaleFields.INN.name(),jsonObject.getString("INN"))){

            requestLogs.add("ИНН "+jsonObject.getString("INN")+" уже был зарегестрированн");

        }
         //проверка уникального огрн компаниии
         if( CheckValueInDB.checkUniquenessValue(LocaleFields.OGRN.name(),jsonObject.getString("OGRN"))){

             requestLogs.add("ОГРН "+jsonObject.getString("OGRN")+" уже был зарегестрированн");

         }

        if(!errors){

            requestLogs.add("200");

        }



     }



     public void checkNotNullField(String key){

        try{
            jsonObject.get(key);

        } catch (JSONException e){

            requestLogs.add(  "Ошибка в поле: "+LocaleFields.valueOf(key).ruLocale+ " - поле пустое");


        }


    }









}
