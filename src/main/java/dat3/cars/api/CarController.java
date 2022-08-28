package dat3.cars.api;

import dat3.cars.entity.Car;
import dat3.cars.repository.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    @GetMapping
    Iterable<Car> getCars(){return carRepository.findAll();}
}
