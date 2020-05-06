package client;

import models.MeasuresClass;
import models.Response;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class client {

    public static void getList() {
        final String uri = "http://localhost:8080/values";
        RestTemplate restTemplate = new RestTemplate();
        MeasuresClass[] result = restTemplate.getForObject(uri, MeasuresClass[].class);
        System.out.println("\n");
        for (MeasuresClass i:result) {
            System.out.println("ID: " + i.getId() +", " +  "Temperature: " + i.getTemp() + ", " +
                    "Light: " + i.getLight() + "," + " Humidity: " + i.getHumidity() + ", Förbrukning: " + i.getConsumption() +", Date: " + i.getDate());

        }
    }
    public static void getLastValueTemp() {
        final String uri = "http://localhost:8080/lastTempValue";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("\n");
        System.out.println(result);

    }
    public static void getLastValueHum() {
        final String uri = "http://localhost:8080/lastHumValue";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("\n");
        System.out.println(result);

    }
    public static void getLastValuelight() {
        final String uri = "http://localhost:8080/lastLightValue";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("\n");
        System.out.println(result);

    }
    public static void getLastValueConsumption() {
        final String uri = "http://localhost:8080/lastConsumptionValue";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("\n");
        System.out.println(result);

    }
    public static void updateHum(int hum) {
        final String uri = "http://localhost:8080/Value/{hum}/updateHum";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("hum", hum);
        RestTemplate restTemplate = new RestTemplate();
        Response result = restTemplate.getForObject(uri, Response.class, params);
        System.out.println("\n" + result.getMessage());
    }
    public static void updateTemp(int temp) {
        final String uri = "http://localhost:8080/Value/{temp}/updateTemp";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("temp", temp);
        RestTemplate restTemplate = new RestTemplate();
        Response result = restTemplate.getForObject(uri, Response.class, params);
        System.out.println("\n" + result.getMessage());
    }
    public static void updateLight(int light) {
        final String uri = "http://localhost:8080/Value/{light}/updateLight";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("light", light);
        RestTemplate restTemplate = new RestTemplate();
        Response result = restTemplate.getForObject(uri, Response.class, params);
        System.out.println("\n" + result.getMessage());
    }
    public static void getReport() {
        final String uri = "http://localhost:8080/ReportValue";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("\n");
        System.out.println(result);
    }
    public static void getReportAVG() {
        final String uri = "http://localhost:8080/Report";
        RestTemplate restTemplate = new RestTemplate();
        String[] result = restTemplate.getForObject(uri, String[].class);
        System.out.println("\n");
        for (String i: result) {
            System.out.println(i);

        }

    }
    public static void getReportTemp() {
        final String uri = "http://localhost:8080/ReportTemp";
        RestTemplate restTemplate = new RestTemplate();
        String[] result = restTemplate.getForObject(uri, String[].class);
        System.out.println("\n");
        for (String i: result) {
            System.out.println(i);

        }
    }
    public static void getReportLight() {
        final String uri = "http://localhost:8080/ReportLight";
        RestTemplate restTemplate = new RestTemplate();
        String[] result = restTemplate.getForObject(uri, String[].class);
        System.out.println("\n");
        for (String i : result) {
            System.out.println(i);

        }
    }
    public static void getCost(int expense) {
        final String uri = "http://localhost:8080/GetCost";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        Double value = Double.parseDouble(result);
        System.out.println("\n");
        System.out.println("Elkostnaden: " + value / expense);

    }
    public static void greenhouseUpdate() {
        final String uri = "http://localhost:8080/UpdateFromGreenhouse";
        RestTemplate restTemplate = new RestTemplate();
        Response result = restTemplate.getForObject(uri, Response.class);
        System.out.println("\n" + result.getMessage());
    }





    public static void main(String []args) throws IOException {

        program p = new program();

    }
}
