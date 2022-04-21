package com.example.demo;

public enum SaleOffersFiels {

    productName("Наименование продукции или услуги"),
    quantity("Количество"),
    purchasePrice("Стоимость, за которую готовы сделать закупку"),
    deliveryCost("Стоимость, за которую готовы сделать закупку"),
    comment("Комментарий");

    public String ruLocale;

    SaleOffersFiels(String ruLocale){
        this.ruLocale=ruLocale;

    }
}
