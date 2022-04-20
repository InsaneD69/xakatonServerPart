package com.example.demo;

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int length = request.getContentLength();//узнаем размер переданных данных
        ServletInputStream sin = request.getInputStream();//читаем
        BufferedReader reader = new BufferedReader(new InputStreamReader(sin));
        String jsonobj = reader.readLine();//Получаем строку
        // connect2db();//попытка подключения к бд
        //Далее нужно создать из строки Джисон объект
        //После чего добавить в бд строку
        reader.close();
        sin.close();
        response.setStatus(HttpServletResponse.SC_OK);	//Как я понял эта строка говорит что всепрошло успешно


    }

}
