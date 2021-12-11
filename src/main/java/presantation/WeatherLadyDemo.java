package presantation;

import bussinessLogic.AvgDatas;
import data.CountryEntity;
import data.CurrentMeasurementEntity;
import data.LocationEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.ServiceCall;
import services.Weather2;
import services.Weather3;
import javax.persistence.EntityManager;
import java.util.Scanner;


public class WeatherLadyDemo {

    private static final String DATABASE = "weatherLady.cfg.xml";

    public static void main(String[] args) throws Exception {

            SessionFactory sessionFactory = new Configuration()
                    .configure(DATABASE)
                    .buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();

        boolean check=true;
        Scanner scanner=new Scanner(System.in);

        while (check){
            AvgDatas avgDatas=new AvgDatas(entityManager);
            System.out.println("Press 1 to add specific location");
            System.out.println("Press 2 to display added locations");
            System.out.println("Press 0 to exit");
            System.out.println("Choose");
            int numberOfChoice=scanner.nextInt();
            switch (numberOfChoice){
                case 1:
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Set location");
                    String location=sc.nextLine();
                    Weather3 weather3 =new Weather3(location);
                    Weather2 weather2 =new Weather2(location);
                    LocationEntity locationEntity=new LocationEntity();
                    locationEntity.setLocationName(weather3.getLocationName());
                    locationEntity.setLongitude(weather2.getLogitude());
                    locationEntity.setLatitude(weather2.getLatitude());
                    System.out.println("did we get here");
                    CountryEntity countryEntity=new CountryEntity();
                    CurrentMeasurementEntity currentEntity=new CurrentMeasurementEntity();
                    countryEntity.setCountryName(weather3.getCountryName());
                    countryEntity.setRegion(weather3.getRegionName());
                    locationEntity.setCountry(countryEntity);
                    currentEntity.setObservationTime(weather3.getObservationTime());
                    currentEntity.setTemperature( avgDatas.getAvgTemp(location));
                    currentEntity.setPressure(avgDatas.getAvgPressure(location));
                    currentEntity.setWindSpeed(weather2.getWindSpeed());
                    locationEntity.setCurrent(currentEntity);
                    avgDatas.addLocation(locationEntity);

                    break;
                case 2:
                    try {
                        avgDatas.findAll();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    check=false;
                    System.out.println("Exiting now pip pip pip pip pauuu");
                    break;
                default:
                    System.out.println("None of the answers is correct");
            }

        }


        scanner.close();


    }
}
