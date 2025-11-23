package com.rh.rh.services;

import com.rh.rh.controllor.dto.AuthDto;
import com.rh.rh.controllor.dto.TokenDto;
import com.rh.rh.entity.Rh;
import com.rh.rh.repository.rh.RhRepository;
import com.rh.rh.security.JwtTokenUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;
import static java.util.List.of;

@Service
public class SecurityService implements UserDetailsService {

    private final JwtTokenUtils jwtTokenUtils;
    private final RhRepository rhRepository;

    public SecurityService(JwtTokenUtils jwtTokenUtils, RhRepository rhRepository){
        this.jwtTokenUtils = jwtTokenUtils;
        this.rhRepository = rhRepository;
    }

    /**
     * Génère le Token JWT de l'utilisateur.
     *
     * @param rh l'utilisateur.
     * @return le Token JWT de l'utilisateur.
     */
    private String genererTokenJwt(Rh rh) {
        return jwtTokenUtils.generateToken(rh);
    }

    /**
     * Récupère un utilisateur à partir de son username.
     *
     * @param nomUtilisateur le username de l'utilisateur.
     * @return L'utilisateur.
     * @throws UsernameNotFoundException Exception levé lorsqu'aucun utilisateur ne correspond à ce username.
     */
    @Override
    public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {
        Optional<Rh> utilisateurOptional = rhRepository.findByUsername(nomUtilisateur);
        if (utilisateurOptional.isPresent()) {
            return utilisateurOptional.get().buildUser();
        } else {
            throw new UsernameNotFoundException("Aucun utilisateur trouvé pour le username: " + nomUtilisateur);
        }
    }

    /**
     * Récupère un utilisateur à partir de son username et de son password.
     *
     * @param nomUtilisateur le username de l'utilisateur.
     * @param password le password de l'utilisateur.
     * @return L'utilisateur.
     * @throws UsernameNotFoundException Exception levé lorsqu'aucun utilisateur ne correspond à ce username.
     */
    private Rh rechercherUtilisateurParUsernameEtPassword(String nomUtilisateur, String password) throws UsernameNotFoundException {
        Optional<Rh> utilisateurOptional = rhRepository.findByUsername(nomUtilisateur);
        if (utilisateurOptional.isPresent()) {
            Rh rh = utilisateurOptional.get();
            if (SecurityService.comparerPassword(password, rh.getPassword())) {
                return rh;
            }
        }

        throw new UsernameNotFoundException("Aucun utilisateur trouvé pour le username: " + nomUtilisateur);
    }

    /**
     * Authentifie l'utilisateur.
     *
     * @param authDto l'utilisateur.
     * @return le Tokent JWT de l'utilisateur authentifié.
     */
    public TokenDto autentifierRh(AuthDto authDto) {
        Rh rh = rechercherUtilisateurParUsernameEtPassword(authDto.getnomUtilisateur(), authDto.getPassword());
        SecurityContextHolder.clearContext();
        String token = genererTokenJwt(rh);

        return new TokenDto(StringUtils.join(of("Bearer", token), " "));
    }

    /**
     * Compare les mots de passe.
     *
     * @param password       le mot de passe.
     * @param encodePassword le mot de passe crypté.
     * @return le mot de passe crypté.
     */
    private static boolean comparerPassword(String password, String encodePassword) {
        int strength = 10;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.matches(password, encodePassword);
    }

    /**
     * Crypte le mot de passe de l'utilisateur.
     *
     * @param password le mot de passe.
     * @return le mot de passe crypté.
     */
    public static String crypterPassword(String password) {
        int strength = 10;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.encode(password);
    }
}
