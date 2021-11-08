package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static int CAR_COUNT;
    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(++CAR_COUNT, "Mercedes-Benz", 500, "Red"));
        cars.add(new Car(++CAR_COUNT, "Volkswagen", 600, "White"));
        cars.add(new Car(++CAR_COUNT, "Ducati", 800, "Black"));
        cars.add(new Car(++CAR_COUNT, "BMW 2 Series Gran Tourer", 300, "Grey"));
        cars.add(new Car(++CAR_COUNT, "BMW i4", 900, "Blue"));
    }

    @Override
    public List<Car> getCountCar(Integer count) {
        if (count == null || count > 5) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
