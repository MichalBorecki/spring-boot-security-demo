package pl.kabeonet.springbootsecuritydemo.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String model;

    @NotNull
    private int carNumber;

    @NotNull
    private double mileage;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @Column(columnDefinition = "TEXT")
    private String description;

}

