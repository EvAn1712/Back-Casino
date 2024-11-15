package com.backcasino.controller;

import com.backcasino.DTO.PlayerDTO;
import com.backcasino.DTO.PlayerLoginDTO;
import com.backcasino.DTO.PlayerRegistrationDTO;
import com.backcasino.models.Player;
import com.backcasino.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@CrossOrigin
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerPlayer(@RequestBody @Valid PlayerRegistrationDTO registrationData) {
        try {
            String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
            playerService.createPlayer(registrationData.getUsername(), encodedPassword, registrationData.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body("{msg : Utilisateur enregistré avec succès}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{msg : Erreur lors de l'enregistrement}");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginPlayer(@RequestBody PlayerLoginDTO loginData) {
        Player player = playerService.findByUsername(loginData.getUsername());

        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{msg : Utilisateur non trouvé}");
        }

        boolean passwordMatch = passwordEncoder.matches(loginData.getPassword(), player.getPasswordHash());
        if (!passwordMatch) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{msg : Mot de passe incorrect}");
        }

        PlayerDTO playerDTO = new PlayerDTO(player);
        return ResponseEntity.ok(playerDTO);
    }

}
