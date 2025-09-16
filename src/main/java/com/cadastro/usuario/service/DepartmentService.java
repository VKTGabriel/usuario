package com.cadastro.usuario.service;

import com.cadastro.usuario.model.Departament;
import com.cadastro.usuario.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Departament> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Departament> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public Departament save(Departament departament) {
        return departmentRepository.save(departament);
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
