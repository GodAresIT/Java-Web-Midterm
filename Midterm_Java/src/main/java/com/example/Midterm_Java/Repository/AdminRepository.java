package com.example.Midterm_Java.Repository;

import com.example.Midterm_Java.Models.Productdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Productdetails, Integer> {
}
