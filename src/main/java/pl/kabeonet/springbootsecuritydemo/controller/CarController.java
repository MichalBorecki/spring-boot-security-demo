package pl.kabeonet.springbootsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kabeonet.springbootsecuritydemo.entity.Car;
import pl.kabeonet.springbootsecuritydemo.service.CarService;

import javax.validation.Valid;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    /*
    Create car
     */
    @RequestMapping("/new")
    public String newCar(Model model){
        model.addAttribute("car", new Car());
        return "car/carForm";
    }

    /*
    Create car from form
     */
    @PostMapping("")
    public String saveCar(@Valid Car car, BindingResult result){
        System.out.println(car);
        if (result.hasErrors()) {
            return "car/carForm";
        }
        carService.saveCar(car);
        return "redirect:/car/" + car.getId();
    }

    /*
    Read car by id
     */
    @RequestMapping("/show/{id}")
    public String showCar(@PathVariable long id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "car/carShow";
    }

    /*
    Read all cars
     */
    @GetMapping("/cars")
    public String showCars(Model model){
        model.addAttribute("cars",carService.getAllCars());
        return "car/cars";
    }

    /*
    Edit car
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "car/carForm";
    }

    /*
    Delete car
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        carService.deleteCar(id);
        return "redirect:/car/cars";
    }


}
