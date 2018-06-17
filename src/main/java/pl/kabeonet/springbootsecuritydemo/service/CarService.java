package pl.kabeonet.springbootsecuritydemo.service;

import pl.kabeonet.springbootsecuritydemo.entity.Car;

public interface CarService {

    Car saveCar (Car car);

    Iterable<Car> getAllCars();

    Car getCarById(Long id);

    void deleteCar (Long id);
}
