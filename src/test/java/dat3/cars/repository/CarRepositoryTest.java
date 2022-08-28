package dat3.cars.repository;

import dat3.cars.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @BeforeEach
    void setupBeforeEach(){
        Car toyota = Car.builder().brand("Toyota").model("Aygo").pricePrDay(300).bestDiscount(15).build();
        Car mercedes = Car.builder().brand("Mercedes").model("AMG").pricePrDay(500).bestDiscount(10).build();
        carRepository.save(toyota);
        carRepository.save(mercedes);
    }


    @Test
    void findCarByBrand() {
        List<Car> cars = carRepository.findCarByBrand("Toyota");
        assertEquals(1,cars.size());
    }
}