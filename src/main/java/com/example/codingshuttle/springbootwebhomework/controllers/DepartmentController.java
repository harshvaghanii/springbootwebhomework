package com.example.codingshuttle.springbootwebhomework.controllers;

import com.example.codingshuttle.springbootwebhomework.dto.DepartmentDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    //    Get All Departments
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        // TODO
        return null;
    }

    //    Get All Departments
    @GetMapping(path = "/{departmentID}")
    public ResponseEntity<DepartmentDTO> getDepartments(@PathVariable String departmentID) {
        // TODO
        return null;
    }

    //    Add a new Department
    @PostMapping
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody @Valid DepartmentDTO department) {
        // TODO
        return null;
    }

    //    Delete a department
    @DeleteMapping(path = "/{departmentID}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable String departmentID) {
        // TODO
        return null;
    }
}
