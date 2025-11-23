package com.rh.rh.facade;

import com.rh.rh.controllor.dto.RhDto;
import com.rh.rh.entity.Rh;
import com.rh.rh.repository.rh.RhRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.rh.rh.services.SecurityService.crypterPassword;
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
                .collect(toList());
    }

    /**
     * Crée ou modifie un rh.
     *
     * @param rhDto l'rh.
     */
    @Transactional
    public void creerOuModifierRh(RhDto rhDto) {
        Rh rh = new Rh();
        rh.setNom(rhDto.getNom());
        rh.setPrenoms(rhDto.getPrenoms());
        rh.setUsername(rhDto.getNomUtilisateur());
        rh.setPassword(crypterPassword(rhDto.getMotDePasse()));
        rh.setEmail(rhDto.getEmail());
        rh.setStatut(rhDto.getStatut());
        rh.setRole(rhDto.getRole());

        rhRepository.save(rh);
    }

    /**
     * Supprime un rh.
     *
     * @param id l'identifiant de l'rh.
     */
    @Transactional
    public void supprimerRh(Long id) throws Exception {
        Optional<Rh> rhOptional = this.rhRepository.findById(id);
        if (rhOptional.isPresent()) {
            rhRepository.deleteById(id);
        }
        else {
            throw new Exception("Ce recruitment n'existe pas !");
        }
    }
}
