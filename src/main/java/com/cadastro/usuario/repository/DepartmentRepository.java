package com.cadastro.usuario.repository;

import com.cadastro.usuario.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departament, Long> {
}
