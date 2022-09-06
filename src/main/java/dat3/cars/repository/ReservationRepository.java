package dat3.cars.repository;

import dat3.cars.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    boolean existsByCar_IdAndRentalDate(int carId, LocalDate date);

}
