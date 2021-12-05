package services;

public class Weather3 extends ServiceCall{
    public Weather3(String location) {
        super("http://api.weatherstack.com/current?access_key=4cbe1f21ff321a14deea39bfb5ab5a2b&query="+location);
    }

    @Override
    public double getTemp() {
        return 0;
    }

    @Override
    public double getPressure() {
        return 0;
    }
}
