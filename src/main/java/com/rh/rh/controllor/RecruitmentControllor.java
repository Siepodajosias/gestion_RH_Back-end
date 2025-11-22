package com.rh.rh.controllor;

import com.rh.rh.controllor.dto.EmployeeDto;
import com.rh.rh.controllor.dto.RecruitmentDto;
import com.rh.rh.facade.RecruitmentFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment")
public class RecruitmentControllor {
    private final RecruitmentFacade recruitmentFacade;

    public RecruitmentControllor(RecruitmentFacade recruitmentFacade) {
        this.recruitmentFacade = recruitmentFacade;
    }

    /**
     * Liste tous les employées.
     *
     * @return la liste {@link EmployeeDto} des employées.
     */
    @GetMapping("/lister")
    public List<RecruitmentDto> listerRecruitment() {
        return recruitmentFacade.recupererListeRecruitment();
    }

    /**
     * Crée ou modifie un recruitment.
     *
     * @param recruitmentDto du recruitment.
     */
    @PostMapping("/enregistrer")
    public void creerOuModifierRecruitment(@RequestBody RecruitmentDto recruitmentDto) {
        recruitmentFacade.enregistrerRecruitment(recruitmentDto);
    }

    /**
     * Supprime un recruitment.
     *
     * @param id l'identifiant du recruitment.
     */
    @DeleteMapping("/supprimer/{id}")
    public void supprimerDepartment(@PathVariable("id") Long id) throws Exception {
        recruitmentFacade.supprimerRecruitment(id);
    }
}
