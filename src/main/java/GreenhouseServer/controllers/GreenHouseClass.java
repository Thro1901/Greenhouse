package GreenhouseServer.controllers;

public class GreenHouseClass {

    int temperature = 30;
    int humidity = 30;
    int light = 30;
    Boolean input = Boolean.TRUE;

    public GreenHouseClass() {
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }
    public Boolean getInput() {
        return input;
    }

    public void setInput(Boolean input) {
        this.input = input;
    }
}
