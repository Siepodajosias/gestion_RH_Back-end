package com.rh.rh.facade;

import com.rh.rh.controllor.dto.RhDto;
import com.rh.rh.entity.Rh;
import com.rh.rh.repository.rh.RhRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service
public class RhFacade {
    private final RhRepository rhRepository;

    public RhFacade(RhRepository rhRepository) {
        this.rhRepository = rhRepository;
    }

    /**
     * Liste tous les rh.
     *
     * @return la liste {@link RhDto} des rh.
     */
    @Transactional
    public List<RhDto> recupererListeRh(){
        return rhRepository.findAll()
                .stream()
                .map(RhDto::new)
                .sorted(comparing(RhDto::getNom)
                        .thenComparing(RhDto::getPrenoms))
                .collect(toList());
    }

    /**
     * Crée ou modifie un rh.
     *
     * @param rhDto l'rh.
     */
    @Transactional
    public void creerOuModifierRh(RhDto rhDto) {
        Rh rh = this.rhRepository.findById(rhDto.getId()).orElse(new Rh());
        rh.creerOuMettreAJourRh(
                rhDto.getNomUtilisateur(),
                crypterPassword(rhDto.getMotDePasse()),
                rhDto.getNom(),
                rhDto.getPrenoms(),
                rhDto.getRole(),
                rhDto.getStatut()
        );
        rhRepository.save(rh);
    }


    /**
     * Modifie le mot de passe d'un utilisateur.
     *
     * @param rhDto l'utilisateur.
     */
    @Transactional
    public void modifierMotDePasse(RhDto rhDto) {
        Rh rh = this.rhRepository.findById(rhDto.getId())
                .orElseThrow(() -> rhInexistant(rhDto.getId()));
        rh.setMotDePasse(crypterPassword(rhDto.getMotDePasse()));
        rh.setStatut(rhDto.getStatut());
    }

    /**
     * Supprime un rh.
     *
     * @param id l'identifiant de l'rh.
     */
    @Transactional
    public void supprimerRh(Long id) {
        Rh rh = this.rhRepository.findById(id)
                .orElseThrow(() -> rhInexistant(id));
        rhRepository.delete(rh);
    }
}
