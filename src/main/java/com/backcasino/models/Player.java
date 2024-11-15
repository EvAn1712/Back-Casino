package com.backcasino.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "players")
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username; // Nom d'utilisateur unique

    @Column(name = "password_hash", nullable = false)
    private String passwordHash; // Hash du mot de passe pour la sécurité

    @Column(unique = true, nullable = false)
    private String email; // Email du joueur, également unique

    @Column(name = "token_balance")
    private int tokenBalance; // Solde des jetons virtuels du joueur

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Game> games;

   // @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    //private List<Bet> bets;

    public Player() {}

    public Player(int id, String username, String passwordHash, String email, int tokenBalance) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.tokenBalance = tokenBalance;
    }

    public void adjustTokenBalance(int amount) {
        this.tokenBalance += amount;
    }
}
