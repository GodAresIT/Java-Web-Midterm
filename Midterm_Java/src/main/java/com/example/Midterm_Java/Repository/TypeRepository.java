package com.example.Midterm_Java.Repository;

import com.example.Midterm_Java.Models.Typeofbrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Typeofbrand, Integer> {
}
