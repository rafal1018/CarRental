package com.CarRental.CarRental.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date date;

    @Column(name = "creator")
    private String creator;

    @Lob
    @Column(name = "image")
    @Basic(fetch = FetchType.LAZY)
    private byte[] carPicture;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private Car car;
}
