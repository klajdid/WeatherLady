package services;

import com.google.gson.Gson;
import services.models.Root;
import services.models.Root1;

public class Weather3 extends ServiceCall{
    Root1 root;
    String response;

    public Weather3(String location) throws Exception {
        super("http://api.weatherstack.com/current?access_key=4cbe1f21ff321a14deea39bfb5ab5a2b&query="+location);
        response = super.getResponse();

        Gson gson = new Gson();
        root = gson.fromJson(response, Root1.class);
    }

    public String getLocationName(){
        return root.location.name;
    }


    public String getRegionName(){
        return root.location.region;
    }

    public String getCountryName(){
        return root.location.country;
    }

    public String getObservationTime(){
        return root.current.observation_time;
    }

    @Override
    public double getTemp() {
        return root.current.temperature;
    }

    @Override
    public double getPressure() {
        return root.current.pressure;
    }


}
