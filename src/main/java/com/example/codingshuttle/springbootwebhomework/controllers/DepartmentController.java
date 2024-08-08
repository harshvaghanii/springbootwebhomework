package com.example.codingshuttle.springbootwebhomework.controllers;

import com.example.codingshuttle.springbootwebhomework.dto.DepartmentDTO;
import com.example.codingshuttle.springbootwebhomework.exceptions.ResourceNotFoundException;
import com.example.codingshuttle.springbootwebhomework.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    //    Get All Departments
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        return ResponseEntity.ok(service.getAllDepartments());
    }

    //    Get All Departments
    @GetMapping(path = "/{departmentID}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable String departmentID) {
        DepartmentDTO departmentDTO = service.getDepartmentByID(departmentID);
        if (departmentDTO == null) throw new ResourceNotFoundException("Department Not Found!");
        return ResponseEntity.ok(departmentDTO);
    }

    //    Add a new Department
    @PostMapping
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody @Valid DepartmentDTO department) {
        DepartmentDTO savedDepartment = service.addDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    //    Delete a department
    @DeleteMapping(path = "/{departmentID}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable String departmentID) {
        boolean deleted = service.deleteDepartment(departmentID);
        if (!deleted) throw new ResourceNotFoundException("Department Not Found!");
        return ResponseEntity.ok(true);
    }
}
