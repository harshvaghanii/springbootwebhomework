package com.example.codingshuttle.springbootwebhomework.services;

import com.example.codingshuttle.springbootwebhomework.dto.DepartmentDTO;
import com.example.codingshuttle.springbootwebhomework.entities.DepartmentEntity;
import com.example.codingshuttle.springbootwebhomework.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;
    private final ModelMapper mapper;

    public DepartmentService(DepartmentRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(departmentEntity -> mapper.map(departmentEntity, DepartmentDTO.class))
                .toList();
    }

    public DepartmentDTO getDepartmentByID(String departmentID) {
        DepartmentEntity entity = repository.findById(departmentID).orElse(null);
        return entity == null ? null : mapper.map(entity, DepartmentDTO.class);
    }

    public DepartmentDTO addDepartment(DepartmentDTO department) {
        DepartmentEntity entityToSave = mapper.map(department, DepartmentEntity.class);
        DepartmentEntity savedEntity = repository.save(entityToSave);
        return mapper.map(savedEntity, DepartmentDTO.class);
    }

    public boolean deleteDepartment(String departmentID) {
        if (!departmentExists(departmentID)) return false;
        repository.deleteById(departmentID);
        return true;
    }

    public boolean departmentExists(String departmentID) {
        return repository.existsById(departmentID);
    }

}
