package GreenhouseServer.controllers;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@RestController
public class MeasureControllers {
    MeasuresDBDAO database = new MeasuresDBDAO();

    MeasureControllers() throws IOException {}

    @RequestMapping("/values")
    public List<MeasuresClass> ShowAllvalues() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.GetallValues();
    }
    @RequestMapping("/lastTempValue")
    public String ShowLastTempValue() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.GetTempValue();
    }
    @RequestMapping("/lastHumValue")
    public String ShowlastHumValue() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.GetHumidityValue();
    }
    @RequestMapping("/lastLightValue")
    public String ShowlastLightValue() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.GetLightValue();
    }
    @RequestMapping("/lastConsumptionValue")
    public String ShowlastconsumptionValue() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.GetConsumptionValue();
    }
    @RequestMapping("/Value/{hum}/updateHum")
    public Response updateHum(@PathVariable("hum") int hum) throws SQLException, ClassNotFoundException {
        return database.updateHum(hum);
    }
    @RequestMapping("/Value/{temp}/updateTemp")
    public Response updateTemp(@PathVariable("temp") int temp) throws SQLException, ClassNotFoundException {
        return database.updateTemp(temp);
    }
    @RequestMapping("/Value/{light}/updateLight")
    public Response updatelight(@PathVariable("light") int light) throws SQLException, ClassNotFoundException {
        return database.updateLight(light);
    }
    @RequestMapping("/ReportValue")
    public String reportHumTempLight() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.reportHumTempLight();
    }
    @RequestMapping("/Report")
    public List<String> report() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.report();
    }
    @RequestMapping("/ReportTemp")
    public List<String> reportTemp() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.reporttemp();
    }
    @RequestMapping("/ReportLight")
    public List<String> reportLight() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.reportlight();
    }
    @RequestMapping("/GetCost")
    public String getConsumtionCost() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.getConsumptionCost();
    }
    @RequestMapping("/UpdateFromGreenhouse")
    public Response UpdateFromGreenhouse() throws InterruptedException, SQLException, ClassNotFoundException {
        return database.updateFromGreenhouse();
    }
}
