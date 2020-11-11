package com.CarRental.CarRental.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private int id;

    @Column(name = "brand")
    @Length(min = 2, message = "*Brand name must have at least 2 characters")
    @NotEmpty(message = "*Please provide a brand name")
    private String brandName;

    @Column(name = "model_name")
    @Length(min = 2, message = "*Model name must have at least 2 characters")
    @NotEmpty(message = "*Please provide a model name")
    private String modelName;

    @Column(name = "type")
    @Length(min = 2, message = "*Type must have at least 2 characters")
    @NotEmpty(message = "*Please provide type")
    private String type;

    @Column(name = "engine_tyoe")
    @Length(min = 2, message = "*Engine type name must have at least 2 characters")
    @NotEmpty(message = "*Please provide engine type")
    private String engineType;

    @Column(name = "body_color")
    @Length(min = 2, message = "*Body color must have at least 2 characters")
    @NotEmpty(message = "*Please provide body color")
    private String bodyColor;

    @Column(name = "engine_power")
    @NotEmpty(message = "*Please provide engine power")
    private Long enginePower;

    @Column(name = "engine_capacity")
    @NotEmpty(message = "*Please provide engine capacity")
    private Long engineCapacity;

    @Column(name = "year_of_production")
    private String yearOfProduction;

    @Column(name = "bail")
    @NotEmpty(message = "*Please provide bail value")
    private Long bail;

    @Column(name = "rental_price")
    @NotEmpty(message = "*Please provide rental price")
    private Long rentalPrice;

    @Column(name = "status")
    private Boolean status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "users_cars", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "car",
            fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] carPicture;

    @Column(name = "date_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;

    @Column(name = "date_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;

}
