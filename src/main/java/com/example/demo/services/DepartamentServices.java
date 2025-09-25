package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Departament;
import com.example.demo.repository.DepartamentRepository;


@Service
public class DepartamentServices {

    @Autowired
    private DepartamentRepository departmentRepository;

    public List<Departament> findAll() {
        return departmentRepository.findAll();
}


    public Optional<Departament> findById(Long id) {
        return departmentRepository.findById(id);
}
    public Departament save(Departament department) {
        return departmentRepository.save(department);
}

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
    
}
