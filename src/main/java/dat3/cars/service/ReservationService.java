package dat3.cars.service;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repository.CarRepository;
import dat3.cars.repository.MemberRepository;
import dat3.cars.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private ReservationRepository resRepo;
    private MemberRepository memberRepo;
    private CarRepository carRepo;

    public ReservationService(ReservationRepository resRepo, MemberRepository memberRepo, CarRepository carRepo) {
        this.resRepo = resRepo;
        this.memberRepo = memberRepo;
        this.carRepo = carRepo;
    }

    public void reserveCar(String username, int carId, LocalDate date) {

        Member member = memberRepo.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member not found"));
        Car car = carRepo.findById(carId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member not found"));

        if(resRepo.existsByCar_IdAndRentalDate(carId, date))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member not found");


        Reservation res = new Reservation(member, car, date);

        resRepo.save(res);

    }


}
