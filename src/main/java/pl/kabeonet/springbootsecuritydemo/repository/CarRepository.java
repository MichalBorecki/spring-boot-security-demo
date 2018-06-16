package pl.kabeonet.springbootsecuritydemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kabeonet.springbootsecuritydemo.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
}
