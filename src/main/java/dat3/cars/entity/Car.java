package dat3.cars.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 50, nullable = false)
    private String brand;

    @Column(length = 50, nullable = false)
    private String model;

    double pricePrDay;

    // In percentages
    double bestDiscount;

    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;
}
