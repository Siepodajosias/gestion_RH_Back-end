package com.rh.rh.utils;

import com.rh.rh.controllor.dto.RhDto;
import com.rh.rh.entity.enums.ERole;
import com.rh.rh.entity.enums.StatutUtilisateur;
import com.rh.rh.facade.RhFacade;
import com.rh.rh.repository.rh.RhRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitialize {

    @Bean
    CommandLineRunner initDatabase(
            RhFacade rhFacade,
            RhRepository rhRepository) {

        return args -> { // Cet enregistrement est faite pour l'authentification par défaut
            // Vérifie si les données existent déjà
            if (rhRepository.count() == 0) {
                // Créer un admin par défaut
                RhDto rhDto = new RhDto();
                rhDto.setNom("SIE");
                rhDto.setPrenoms("Poda");
                rhDto.setNomUtilisateur("Josias");
                rhDto.setEmail("josias.sie@gmail.com");
                rhDto.setMotDePasse("azerty77");
                rhDto.setStatut(StatutUtilisateur.ACTIF);
                rhDto.setRole(ERole.ROLE_ADMIN);
                rhFacade.creerOuModifierRh(rhDto);

                System.out.println("Données initiales insérées avec succès!");
            } else {
                System.out.println("Données déjà existantes, insertion ignorée.");
            }
        };
    }
}