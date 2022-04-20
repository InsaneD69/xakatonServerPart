package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@Controller
public class DatabaseConnection {
	static public String hostName="ec2-52-54-212-232.compute-1.amazonaws.com";
	static public String DBName="d3juig38qlpane";
	static public String port="5432";
	static public String user = "ispfozezsllypp";
	static public String url ="jdbc:postgresql://ec2-52-54-212-232.compute-1.amazonaws.com:5432/d3juig38qlpane";
	static private String password ="d726cabb37d69cafb3156b57eb2ea3ac90c6c1057506f7317a1d0c7959215a45";
	static public String nameInfoTable="public.\"UserSignDataTable\"";


	static Connection connectionDB;

	public static void createConnect() throws SQLException {

		openConnectionDB();

		// openConnectionClient();

		// waitingForRequests();
		//тест для нахождения ошибки пустого поля (пока только этой ошибки
		/*JSONObject jsonobject =new JSONObject()  {};

		jsonobject.put(LocaleFields.nameCompany.name(),"rdrgdfggfden");
		jsonobject.put(LocaleFields.isCustomer.name(),true);
		jsonobject.put(LocaleFields.isSeller.name(), true);
		jsonobject.put(LocaleFields.INN.name(), "5333dgvxcv42");
		jsonobject.put(LocaleFields.OGRN.name(), "3152ht34");
		jsonobject.put(LocaleFields.FCsGenDirector.name(), "qa4dsgfzx");
		jsonobject.put(LocaleFields.email.name(), "Qqwefgsdrty@crirretesnge.pzdc");
		jsonobject.put(LocaleFields.legalAddress.name(), "qwqwecbvfertser t io");
		jsonobject.put(LocaleFields.KPP.name(), "236er8t5432");
		jsonobject.put(LocaleFields.phoneNumber.name(), "324324e8rt342");
		jsonobject.put(LocaleFields.dateOfRegistration.name(),"22:22 12.12.2000");
		jsonobject.put(LocaleFields.password.name(), "qwr3fvewr");

		//отсутствует заполнение поля с датой  регистрации
		UserRegistration userRegistration = new UserRegistration(jsonobject);
		//


		//небольшой тест доступа к таблице со взятием значений из поля "Id" "NameCompany"
		Statement statement = connectionDB.createStatement();



		ResultSet resultSet=statement.executeQuery("select * from "+nameInfoTable);


		while (resultSet.next()){
			System.out.println(resultSet.getString("UserId")+" "+resultSet.getString("nameCompany"));
		}

		//
		statement.close();*/

		closeConnectionDB();

		//SpringApplication.run(DatabaseConnection.class, args);
	}



	public static void openConnectionDB()  {


		try{
			Class.forName("org.postgresql.Driver");
			connectionDB= DriverManager
					.getConnection("jdbc:postgresql://"+hostName+":"+port+"/"+DBName+"?user="+user+"&password="+password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}



	}







	public static void closeConnectionDB() throws SQLException {


		//connectionDB.close();



	}





}
