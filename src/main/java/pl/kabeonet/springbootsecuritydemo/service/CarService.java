package pl.kabeonet.springbootsecuritydemo.service;

import pl.kabeonet.springbootsecuritydemo.entity.Car;

import java.util.Optional;

public interface CarService {

    Car saveCar (Car car);

    Iterable<Car> getAllCars();

    Optional<Car> getCarById(Long id);

    Car deleteCar (Long id);
}
