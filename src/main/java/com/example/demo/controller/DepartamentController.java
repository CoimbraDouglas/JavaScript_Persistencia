package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Departament;
import com.example.demo.services.DepartamentServices;

@RestController
@RequestMapping("departments")
public class DepartamentController {
    @Autowired
    private DepartamentServices departmentService;
@GetMapping
    public List<Departament> getAllDepartments() {
        // Chama o serviço para buscar todos os departamentos
        return departmentService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Departament> getDepartmentById(@PathVariable Long id) {
        Optional<Departament> department = departmentService.findById(id);
        // Retorna o departamento se encontrado, caso contrário retorna 404 Not Found
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Departament createDepartment(@RequestBody Departament department) {
        // Chama o serviço para salvar o novo departamento
        return departmentService.save(department);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Departament> updateDepartment(@PathVariable Long id, @RequestBody Departament departmentDetails) {
        Optional<Departament> department = departmentService.findById(id);
        if (department.isPresent()) {
            Departament updatedDepartment = department.get();
            updatedDepartment.setName(departmentDetails.getName());
            return ResponseEntity.ok(departmentService.save(updatedDepartment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

