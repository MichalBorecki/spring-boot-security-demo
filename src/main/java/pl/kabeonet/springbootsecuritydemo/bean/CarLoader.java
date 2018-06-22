package pl.kabeonet.springbootsecuritydemo.bean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.kabeonet.springbootsecuritydemo.entity.Car;
import pl.kabeonet.springbootsecuritydemo.repository.CarRepository;

@Component
public class CarLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CarRepository carRepository;

    private final Logger LOGGER = LogManager.getLogger(CarLoader.class);

    @Autowired
    public void setCarRepository(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        Car audi = new Car();
        audi.setCarNumber(1);
        audi.setModel("Audi A3");
        audi.setMileage(12000);
        audi.setDescription("Samochód powypadkowy");
        carRepository.save(audi);

        LOGGER.info("Saved audi - id: " + audi.getId());

        Car peugeot = new Car();
        peugeot.setCarNumber(2);
        peugeot.setModel("Peugeot 800");
        peugeot.setMileage(13000);
        peugeot.setDescription("Samochód nowy");
        carRepository.save(peugeot);

        LOGGER.info("Saved peugeot - id: " + peugeot.getId());
    }

}
