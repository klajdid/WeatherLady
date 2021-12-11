package services;

import com.google.gson.Gson;

import services.models.Root;

public class Weather2 extends ServiceCall {
    Root root;
    String response;

    public Weather2(String location) throws Exception {
        super("http://api.openweathermap.org/data/2.5/weather?q=" + location
                + "&appid=643400db357a220ba5c22ae43791aac0");
        response = super.getResponse();

        Gson gson = new Gson();
        root = gson.fromJson(response, Root.class);
    }

    public double getLatitude(){
        return root.coord.lat;
    }

    public double getLogitude(){
        return root.coord.lon;
    }

    public double getWindSpeed(){return root.wind.speed;}

    @Override
    public double getTemp() {
        return root.main.temp- 273.15;
    }

    @Override
    public double getPressure() {
        return root.main.pressure;
    }


}
