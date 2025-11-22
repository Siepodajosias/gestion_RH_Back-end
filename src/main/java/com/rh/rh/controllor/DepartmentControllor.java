package com.rh.rh.controllor;

import com.rh.rh.controllor.dto.DepartmentDto;
import com.rh.rh.controllor.dto.EmployeeDto;
import com.rh.rh.facade.DepartmentFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentControllor {
    private final DepartmentFacade departmentFacade;

    public DepartmentControllor(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    /**
     * Liste tous les employées.
     *
     * @return la liste {@link EmployeeDto} des employées.
     */
    @GetMapping("/lister")
    public List<DepartmentDto> listerDepartment() {
        return departmentFacade.recupererListeDepartment();
    }

    /**
     * Crée ou modifie un department.
     *
     * @param departmentDto du department.
     */
    @PostMapping("/enregistrer")
    public void creerOuModifierDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentFacade.enregistrerDepartment(departmentDto);
    }


    /**
     * Supprime un department.
     *
     * @param id l'identifiant du department.
     */
    @DeleteMapping("/supprimer/{id}")
    public void supprimerDepartment(@PathVariable("id") Long id) throws Exception {
        departmentFacade.supprimerDepartment(id);
    }
}
