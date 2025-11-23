package com.rh.rh.facade;

import com.rh.rh.controllor.dto.DepartmentDto;
import com.rh.rh.entity.Department;
import com.rh.rh.repository.department.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

@Service
public class DepartmentFacade {
    private final DepartmentRepository departmentRepository;

    public DepartmentFacade (DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> recupererListeDepartment(){
        return  departmentRepository.findAll()
                .stream()
                .map(DepartmentDto::new)
                .sorted(Comparator.comparing(DepartmentDto::getDesignation,
                        Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(toList());
    }

    public void enregistrerDepartment(DepartmentDto departmentDto){
        Department department = new Department();
        department.setDesignation(departmentDto.getDesignation());
        departmentRepository.save(department);
    }

    public void supprimerDepartment(Long id) throws Exception {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isPresent()) {
            departmentRepository.deleteById(id);
        }
        else {
            throw new Exception("Ce department n'existe pas !");
        }
    }
}
