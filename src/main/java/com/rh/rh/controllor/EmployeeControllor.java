package com.rh.rh.controllor;

import com.rh.rh.controllor.dto.EmployeeDto;
import com.rh.rh.facade.EmployeeFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeControllor {

    private final EmployeeFacade employeeFacade;

    public EmployeeControllor(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    /**
     * Liste tous les employées.
     *
     * @return la liste {@link EmployeeDto} des employées.
     */
    @GetMapping("/lister")
    public List<EmployeeDto> listerEmployee() {
        return employeeFacade.recupererListeEmployee();
    }

    /**
     * Crée ou modifie un employée.
     *
     * @param employeeDto l'employée.
     */
    @PostMapping("/enregistrer")
    public void creerOuModifierUtilisateur(@RequestBody EmployeeDto employeeDto) {
        employeeFacade.enregistrerEmployee(employeeDto);
    }

    /**
     * Supprime un emplyoée.
     *
     * @param id l'identifiant de l'emplyoée.
     */
    @DeleteMapping("/supprimer/{id}")
    public void supprimerEmployee(@PathVariable("id") Long id) throws Exception {
        employeeFacade.supprimerEmployee(id);
    }
}
