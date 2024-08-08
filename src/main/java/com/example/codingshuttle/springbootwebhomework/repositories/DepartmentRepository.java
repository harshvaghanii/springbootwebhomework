package com.example.codingshuttle.springbootwebhomework.repositories;

import com.example.codingshuttle.springbootwebhomework.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, String> {

}
