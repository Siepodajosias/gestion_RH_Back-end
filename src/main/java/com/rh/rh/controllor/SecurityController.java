package com.rh.rh.controllor;

import com.rh.rh.controllor.dto.AuthDto;
import com.rh.rh.controllor.dto.TokenDto;
import com.rh.rh.services.SecurityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/securite")
public class SecurityController {

	private final SecurityService securityService;

	public SecurityController(SecurityService securityService) {
		this.securityService = securityService;
	}

	/**
	 * Permet d'authentifier le rh.
	 *
	 * @param authDto les informations de connexion.
	 * @return le token d'authentification
	 */
	@PostMapping("/auth")
	public TokenDto auth(@RequestBody AuthDto authDto) {
		return securityService.autentifierRh(authDto);
	}
}
