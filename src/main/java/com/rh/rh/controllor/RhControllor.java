package com.rh.rh.controllor;

import com.rh.rh.controllor.dto.RhDto;
import com.rh.rh.facade.RhFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rh")
public class RhControllor {

    private final RhFacade rhFacade;

    public RhControllor(RhFacade rhFacade) {
        this.rhFacade = rhFacade;
    }


    /**
     * Liste tous les rh.
     *
     * @return la liste {@link uhDto} des rh.
     */
    @GetMapping("/lister")
    public List<RhDto> recupererListeRH(){
        return rhFacade.recupererListeRh();
    }

    /**
     * Crée ou modifie un employée.
     *
     * @param rhDto l'employée.
     */
    @PostMapping("/enregistrer")
    public void creerOuModifierUtilisateur(@RequestBody RhDto rhDto) {
        rhFacade.creerOuModifierRh(rhDto);
    }

}
