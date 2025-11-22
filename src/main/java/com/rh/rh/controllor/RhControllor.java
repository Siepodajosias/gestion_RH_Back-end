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

    public recupererRHParId(){}

    /**
     * Crée ou modifie un utilisateur.
     *
     * @param utilisateurDto l'utilisateur.
     */
    @PostMapping("/creer")
    public void creerRH(){}

    /**
     * Désactive un utilisateur.
     *
     * @param utilisateurDto l'utilisateur.
     */
    @PostMapping("/activer-ou-desactiver")
    public mettreAJourRH(){}

    /**
     * Supprime un utilisateur.
     *
     * @param id l'identifiant de l'utilisateur.
     */
    @DeleteMapping("/supprimer/{id}")
    public supprimerRH(){}

    /**
     * Modifie le mot de passe d'un utilisateur.
     *
     * @param utilisateurDto l'utilisateur.
     */
    @PostMapping("/modifier-mot-de-passe")
    public void modifierMotDePasseUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        utilisateurFacade.modifierMotDePasse(utilisateurDto);
    }
}
