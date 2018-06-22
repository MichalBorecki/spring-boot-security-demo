package pl.kabeonet.springbootsecuritydemo.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @Min(1)
    private int carNumber;

    @NotNull
    @Min(0)
    private double mileage;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @Column(columnDefinition = "TEXT")
    private String description;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", carNumber=" + carNumber +
                ", mileage=" + mileage +
                ", description='" + description + '\'' +
                '}';
    }
}

