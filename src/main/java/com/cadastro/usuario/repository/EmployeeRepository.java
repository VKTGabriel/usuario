package com.cadastro.usuario.repository;

import com.cadastro.usuario.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
