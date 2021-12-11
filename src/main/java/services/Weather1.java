package services;

import com.google.gson.Gson;
import services.models.Root;
import services.models.Root1;

public class Weather1 extends ServiceCall{
 Root1 root1;
 String response;
    public Weather1(String location) throws Exception {
        super("http://api.weatherstack.com/current?access_key=4cbe1f21ff321a14deea39bfb5ab5a2b&query=Tirana");
        response = super.getResponse();
        Gson gson = new Gson();
        root1 = gson.fromJson(response, Root1.class);}

    public Weather1() {
        super("");
    }

    @Override
    public double getTemp() {
        return root1.current.temperature;
    }

    @Override
    public double getPressure() {
        return root1.current.pressure;

    }
}
