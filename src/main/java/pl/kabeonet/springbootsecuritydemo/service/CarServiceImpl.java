package pl.kabeonet.springbootsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kabeonet.springbootsecuritydemo.entity.Car;
import pl.kabeonet.springbootsecuritydemo.repository.CarRepository;


@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findOne(id);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.delete(id);
    }
}
