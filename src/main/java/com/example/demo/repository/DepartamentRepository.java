package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Departament;



@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
 
