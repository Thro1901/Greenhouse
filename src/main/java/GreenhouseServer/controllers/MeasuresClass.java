package GreenhouseServer.controllers;

import java.io.Serializable;
import java.util.Date;

public class MeasuresClass implements Serializable {

    int id;
    int temperature = 10;
    int humidity = 10;
    int light = 10;



    Boolean input = Boolean.TRUE;
    int consumption;
    Date date;



    public MeasuresClass(int id, int temp, int light, int humidity,int consumption,Date date) {
        this.temperature = temp;
        this.light = light;
        this.humidity = humidity;
        this.id = id;
        this.consumption = consumption;
        this.date = date;

    }
    public MeasuresClass(){}
    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }
    public Boolean getInput() {
        return input;
    }

    public void setInput(Boolean input) {
        this.input = input;
    }


    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


