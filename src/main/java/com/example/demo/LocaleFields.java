package com.example.demo;

public enum LocaleFields {

    nameCompany("Имя компании"),
    isSeller("Продавец"),
    isCustomer("Закупщик"),
    FCsGenDirector("ФИО"),
    email("Почта"),
    phoneNumber("Номер телефона"),
    legalAddress("Юридический адресс"),
    dateOfRegistration("Дата регистрации"),
    INN("ИНН"),
    OGRN("ОГРН"),
    KPP("КПП"),
    password("Пароль"),
    productName("Наименование продукции или услуги"),
    quantity("Количество"),
    purchasePricet("Стоимость"),//hf
    deliveryCost("Стоимость, за которую готовы сделать закупку")


    ;

   public String ruLocale;

    LocaleFields(String ruLocale){
        this.ruLocale=ruLocale;

    }


}
