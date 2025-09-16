package com.cadastro.usuario.controller;

import com.cadastro.usuario.model.Departament;
import com.cadastro.usuario.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("departaments")
public class DepartamentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Departament> getAllDepartament() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departament> getDepartamentById(@PathVariable Long id) {
        Optional<Departament> departamentOptional = departmentService.findById(id);

        return departamentOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Departament createDepartament(@RequestBody Departament departament) {
        return departmentService.save(departament);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departament> updateDepartament(
            @PathVariable Long id,
            @RequestBody Departament departament) {

        Optional<Departament> departamentOptional = departmentService.findById(id);

        if (departamentOptional.isPresent()) {
            Departament updateDepartament = departamentOptional.get();
            updateDepartament.setTitle(departament.getTitle());
            return ResponseEntity.ok(departmentService.save(updateDepartament));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartament(@PathVariable Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
