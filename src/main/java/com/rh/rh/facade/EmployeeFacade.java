package com.rh.rh.facade;

import com.rh.rh.controllor.dto.EmployeeDto;
import com.rh.rh.controllor.dto.RhDto;
import com.rh.rh.entity.Employee;
import com.rh.rh.entity.Rh;
import com.rh.rh.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service
public class EmployeeFacade {
    private final EmployeeRepository employeeRepository;

    public EmployeeFacade(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto>recupererListeEmployee(){
        return  employeeRepository.findAll()
                .stream()
                .map(EmployeeDto::new)
                .sorted()
                .collect(toList());
    }

    public void enregistrerEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setNom(employeeDto.getNom());
        employee.setPrenoms(employeeDto.getPrenoms());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartment(employeeDto.getDepartment());

        employeeRepository.save(employee);
    }

    public void supprimerEmployee(Long id) throws Exception{
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            employeeRepository.deleteById(id);
        }
        else {
            throw new Exception("Ce utilisateur n'existe pas");
        }
    }
}

