package com.backcasino;

import com.backcasino.DAO.BetDAO;
import com.backcasino.models.Game;
import com.backcasino.models.Player;
import com.backcasino.models.Bet;
import com.backcasino.services.GameService;
import com.backcasino.services.PlayerService;
import com.backcasino.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

@SpringBootApplication
public class BackCasinoApplication {

    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private BetService betService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BackCasinoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BetDAO betDAO) {
        return args -> {
            // Créer un joueur de test si nécessaire
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le nom d'utilisateur du joueur : ");
            String username = scanner.nextLine();
            Player player = playerService.findByUsername(username);
            if (player == null) {
                System.out.print("Entrez le mot de passe du joueur : ");
                String password = scanner.nextLine();
                playerService.createPlayer(username, passwordEncoder.encode(password), username);
                player = playerService.findByUsername(username);
            }
            System.out.println("Joueur : " + player.getUsername());

            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Entrez le montant du pari : ");
            int betAmount = scanner2.nextInt();

            Game game = gameService.createGame(player.getId(), betAmount);

            System.out.println("Jeu démarré pour le joueur " + game.getPlayer().getUsername());
            afficherEtatJeu(game);

            boolean finDuJeu = false;

            // Boucle de jeu pour que le joueur prenne des décisions
            while (!finDuJeu) {
                System.out.println("Que voulez-vous faire ? (1 = Tirer, 2 = Rester, 3 = Doubler, 4 = Abandonner)");
                int choix = scanner.nextInt();

                switch (choix) {
                    case 1:
                        // Tirer
                        gameService.playerHit(game);
                        System.out.println("Vous avez tiré une carte.");
                        afficherEtatJeu(game);
                        break;
                    case 2:
                        // Rester
                        gameService.playerStand(game);
                        System.out.println("Vous avez choisi de rester.");
                        afficherEtatJeu(game);
                        finDuJeu = true;
                        break;
                    case 3:
                        // Doubler
                        gameService.playerDouble(game);
                        System.out.println("Vous avez doublé.");
                        afficherEtatJeu(game);
                        finDuJeu = true;
                        break;
                    case 4:
                        // Abandonner
                        gameService.playerSurrender(game);
                        System.out.println("Vous avez abandonné.");
                        finDuJeu = true;
                        break;
                    default:
                        System.out.println("Choix non valide. Veuillez entrer un numéro entre 1 et 4.");
                }

                if (game.getIsGameOver() != Game.GameStatus.PROGRESS) {
                    System.out.println("La partie est terminée.");
                    finDuJeu = true;
                }
            }

            System.out.println("Partie terminée pour le joueur " + game.getPlayer().getUsername());
        };
    }

    private void afficherEtatJeu(Game game) {
        System.out.println("Main du joueur : " + game.getPlayerHand());
        System.out.println("Score du joueur : " + game.getPlayerScore());
        System.out.println("Main du croupier : " + game.getDealerHand());
        System.out.println("Score du croupier : " + game.getDealerScore());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
