package GreenhouseServer.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MeasuresDBDAO {
    Properties p =new Properties();

    MeasuresDBDAO() throws IOException {
        p.load(new FileInputStream("src/config.properties"));

    }
    public List<MeasuresClass> GetallValues() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        List<MeasuresClass> List;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,temperature,humidity,light,consumption,created FROM measurement");

            List = new ArrayList<>();
            while (rs.next()) {

                MeasuresClass k = new MeasuresClass(rs.getInt("id"), rs.getInt("temperature"),rs.getInt("humidity"),rs.getInt("light"),rs.getInt("consumption"),rs.getDate("created"));
                List.add(k);
            }
        }
        return List;
    }
    public String GetTempValue() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String text = "";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,temperature,created FROM measurement ORDER BY id DESC LIMIT 1");

            while (rs.next()) {

                text = "ID: " + rs.getInt("id") + ", Temperatur: " + rs.getInt("temperature") + ", Datum: " + rs.getDate("created");
            }
        }
        return text;
    }
    public String GetHumidityValue() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String text = "";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,humidity,created FROM measurement ORDER BY id DESC LIMIT 1");

            while (rs.next()) {

                text = "ID: " + rs.getInt("id") + ", Fuktighet: " + rs.getInt("humidity") + ", Datum: " + rs.getDate("created");
            }
        }
        return text;
    }
    public String GetLightValue() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String text = "";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,light,created FROM measurement ORDER BY id DESC LIMIT 1");

            while (rs.next()) {

                text = "ID: " + rs.getInt("id") + ", Belysning: " + rs.getInt("light") + ", Datum: " + rs.getDate("created");
            }
        }
        return text;
    }
    public String GetConsumptionValue() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String text = "";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,consumption,created FROM measurement ORDER BY id DESC LIMIT 1");

            while (rs.next()) {

                text = "ID: " + rs.getInt("id") + ", Förbrukning: " + rs.getInt("consumption") + ", Datum: " + rs.getDate("created");
            }
        }
        return text;
    }
    public Response updateHum(int hum) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Response res = new Response("Fuktigheten uppdaterat", Boolean.FALSE);

        String query = "UPDATE measurement" + " SET humidity = " + hum +" ORDER BY id DESC" + " LIMIT 1";
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            res.setSuccess(Boolean.TRUE);

        }
        return res;
    }
    public Response updateTemp(int temp) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Response res = new Response("Temperaturen uppdaterat", Boolean.FALSE);

        String query = "UPDATE measurement" + " SET temperature = " + temp +" ORDER BY id DESC" + " LIMIT 1";
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            res.setSuccess(Boolean.TRUE);

        }
        return res;
    }
    public Response updateLight(int light) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Response res = new Response("Belysningen uppdaterat", Boolean.FALSE);

        String query = "UPDATE measurement" + " SET light = " + light +" ORDER BY id DESC" + " LIMIT 1";
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            res.setSuccess(Boolean.TRUE);

        }
        return res;
    }

    public String reportHumTempLight() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String text = "";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT temperature,humidity,light,created FROM measurement ORDER BY id DESC LIMIT 1");

            while (rs.next()) {

                text = "Temperatur : " + rs.getInt("temperature")+ ", Fuktighet: " + rs.getInt("humidity") + ", Belysning: " + rs.getInt("light")+ ", Datum: " + rs.getDate("created");
            }
        }
        return text;
    }

    public List<String> report() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String text;

        List<String> list = new ArrayList<>();



        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT humidity,created FROM measurement ORDER BY created DESC LIMIT 7");

            while (rs.next()) {

                list.add("Fuktighet: " + rs.getInt("humidity") + ", Datum: " + rs.getDate("created"));
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT AVG(humidity) \n" +
                    "FROM measurement\n" +
                    "WHERE DATE(created) \n" +
                    "BETWEEN '2020-05-05' AND '2020-05-11'");

            while (rs.next()) {

                double avg = rs.getDouble("AVG(humidity)");
                text ="Medelvärdet för veckan: " + avg + "";
                list.add(text);
            }
        }
        return list;
    }
    public List<String> reporttemp() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String text;

        List<String> list = new ArrayList<>();



        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT temperature,created FROM measurement ORDER BY created DESC LIMIT 7");

            while (rs.next()) {

                list.add("Temperatur: " + rs.getInt("temperature") + ", Datum: " + rs.getDate("created"));
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT AVG(temperature) \n" +
                    "FROM measurement\n" +
                    "WHERE DATE(created) \n" +
                    "BETWEEN '2020-05-05' AND '2020-05-11'");

            while (rs.next()) {

                double avg = rs.getDouble("AVG(temperature)");
                text ="Medelvärdet för veckan: " + avg + "";
                list.add(text);
            }
        }
        return list;
    }
    public List<String> reportlight() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String text;

        List<String> list = new ArrayList<>();



        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT light,created FROM measurement ORDER BY created DESC LIMIT 7");

            while (rs.next()) {

                list.add("Belysning: " + rs.getInt("light") + ", Datum: " + rs.getDate("created"));
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT AVG(light) \n" +
                    "FROM measurement\n" +
                    "WHERE DATE(created) \n" +
                    "BETWEEN '2020-05-05' AND '2020-05-11'");

            while (rs.next()) {

                double avg = rs.getDouble("AVG(light)");
                text ="Medelvärdet för veckan: " + avg + "";
                list.add(text);
            }
        }
        return list;
    }

    public String getConsumptionCost() throws SQLException, InterruptedException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        double value=0.0;
        String text;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password")))
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(consumption) \n" +
                    "FROM measurement\n" +
                    "WHERE DATE(created) \n" +
                    "BETWEEN '2020-05-05' AND '2020-05-11'");

            while (rs.next()) {

                value = rs.getDouble("SUM(consumption)");
            }
            text = value + "";
        }
        return text;
    }
    public Response updateFromGreenhouse() throws ClassNotFoundException, SQLException {

        MeasuresClass greenHouse = new MeasuresClass();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Response res = new Response("Databasen uppdaterat", Boolean.FALSE);

        String query = "UPDATE measurement\n" +
                "SET humidity =" + greenHouse.getHumidity() + ", temperature =" + greenHouse.getTemp() + ", light = " + greenHouse.getLight()+ ", manualInput = " + greenHouse.getInput() + "\n" +
                "ORDER BY id DESC\n" +
                "LIMIT 1;";
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            res.setSuccess(Boolean.TRUE);

        }
        return res;
    }

}


