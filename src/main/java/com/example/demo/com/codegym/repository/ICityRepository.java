package com.example.demo.com.codegym.repository;

import com.example.demo.com.codegym.model.City;
import com.example.demo.com.codegym.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City,Long> {
}
