package bussinessLogic;

import data.LocationEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import services.Iservice;
import services.Weather2;
import services.Weather3;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter

public class AvgDatas {

    private final EntityManager entityManager;

    public AvgDatas(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    List<Iservice> list = new ArrayList<>();

    public List<Iservice> getList() {
        return list;
    }

    public double getAvgTemp(String location) throws Exception {
        list.add(new Weather2(location));
        list.add(new Weather3(location));
        System.out.println(list.stream().mapToDouble(Iservice::getTemp).average().getAsDouble());
        return list.stream().mapToDouble(Iservice::getTemp).average().getAsDouble();
    }

    public double getAvgPressure(String location) throws Exception {
        list.add(new Weather2(location));
        list.add(new Weather3(location));
        System.out.println(list.stream().mapToDouble(Iservice::getPressure).average().getAsDouble());
        return list.stream().mapToDouble(Iservice::getPressure).average().getAsDouble();
    }


    public LocationEntity addLocation(final LocationEntity location) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.persist(location);
            transaction.commit();
            return location;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    public void findAll() {

        List<LocationEntity> locationEntities = entityManager.createQuery("select b from LocationEntity b", LocationEntity.class).getResultList();
            locationEntities.forEach(el -> {
                System.out.println(el.getCountry().getCountryName()+" "+ el.getLocationName()+" "
                        +el.getCurrent().getTemperature());
            });

    }


}
