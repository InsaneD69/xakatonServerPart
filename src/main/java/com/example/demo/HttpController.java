package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class HttpController {



    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(path="URL")
    public void greeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//В ковычках передается запрашиваемое поле
        PrintWriter out = response.getWriter();//С помощью этого мы будем писать информацию в ответ
        JSONObject js=null;
        //connect2db();//Попытка подключения к бд
        /*if (connection != null) {
            out.println("Connect to DB established!<br/>");
            out.flush();
        }*/
        //Далее нужно сделать запрос в базу данных по этому полю
        //Сформировать Джисон объект
        //и в текстовом виде отправить его
        out.println(js);
        out.flush();

    }


    @RequestMapping(path="/post")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpringServerParthApplication.creatConnect();
        if (request.getParameter("nameCompany") != null || request.getParameter("isSeller") != null ||
                request.getParameter("isCustomer") != null || request.getParameter("FCsGenDirector") != null ||
                request.getParameter("email") != null || request.getParameter("phoneNumber") != null ||
                request.getParameter("legalAddress") != null || request.getParameter("INN") != null ||
                request.getParameter("OGRN") != null || request.getParameter("KPP") != null || request.getParameter("password") != null) {
            if (!request.getParameter("nameCompany").equals("") && !request.getParameter("isSeller").equals("") &&
                    !request.getParameter("isCustomer").equals("") && !request.getParameter("FCsGenDirector").equals("") &&
                    !request.getParameter("email").equals("") && !request.getParameter("phoneNumber").equals("") &&
                    !request.getParameter("legalAddress").equals("") && !request.getParameter("INN").equals("") &&
                    !request.getParameter("OGRN").equals("") && !request.getParameter("password").equals("") && !request.getParameter("KPP").equals("")) {
                JSONObject jsonobject = new JSONObject() {
                };

                try {
                    jsonobject.put(LocaleFields.nameCompany.name(), request.getParameter("nameCompany"));
                    jsonobject.put(LocaleFields.isCustomer.name(), Integer.parseInt(request.getParameter("isCustomer")));
                    jsonobject.put(LocaleFields.isSeller.name(), Integer.parseInt(request.getParameter("isSeller")));
                    jsonobject.put(LocaleFields.INN.name(), request.getParameter("INN"));
                    jsonobject.put(LocaleFields.OGRN.name(), request.getParameter("OGRN"));
                    jsonobject.put(LocaleFields.FCsGenDirector.name(), request.getParameter("FCsGenDirector"));
                    jsonobject.put(LocaleFields.email.name(), request.getParameter("email"));
                    jsonobject.put(LocaleFields.legalAddress.name(), request.getParameter("legalAddress"));
                    jsonobject.put(LocaleFields.KPP.name(), request.getParameter("KPP"));
                    jsonobject.put(LocaleFields.phoneNumber.name(), request.getParameter("phoneNumber"));
                    jsonobject.put(LocaleFields.password.name(), request.getParameter("password"));
                    UserRegistration userRegistration = new UserRegistration(jsonobject);


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        }
    }
}
