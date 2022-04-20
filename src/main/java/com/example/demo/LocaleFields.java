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
    purchasePrice("Стоимость, за которую готовы сделать закупку"),
    deliveryCost("Стоимость, за которую готовы сделать закупку"),
    comment("Комментарий") ;

   public String ruLocale;

    LocaleFields(String ruLocale){
        this.ruLocale=ruLocale;

    }


}
