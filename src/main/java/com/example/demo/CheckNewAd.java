package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.EnumSet;

public class CheckNewAd {

    JSONObject jsonObject;

    public ArrayList<String> requestLogs =new ArrayList<>();

    boolean errors=false;



    public CheckNewAd(JSONObject jsonObject) {

        this.jsonObject=jsonObject;

        EnumSet.allOf(SaleOffersFiels.class).forEach(field->{  //проверка заполненности всех   полей после передачи, кроме комментария


            checkNotNullField(String.valueOf(field));

        });





    }

    public ArrayList<String> getRequestLogs() {
        return requestLogs;
    }


    public void checkNotNullField(String key){

        if (key.equals(SaleOffersFiels.comment.name())){
            return;
        }

        try{
            jsonObject.get(key);

        } catch (JSONException e){

            requestLogs.add(  "Ошибка в поле: "+ UserRegistrationFields.valueOf(key).ruLocale+ " - поле пустое");


        }
    }
}
