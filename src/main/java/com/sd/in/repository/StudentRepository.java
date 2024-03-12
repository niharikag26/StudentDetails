package com.sd.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sd.in.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}