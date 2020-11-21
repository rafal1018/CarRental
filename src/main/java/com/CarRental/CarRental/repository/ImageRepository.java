package com.CarRental.CarRental.repository;

import com.CarRental.CarRental.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ImageRepository extends JpaRepository<Image, Long> {
}
