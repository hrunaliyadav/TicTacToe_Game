import controller.GameController;
import enums.*;
import models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);
        int id = 1;

        List<Player> playerList = new ArrayList<>();

        System.out.println("Welcome to Tic Tac Toe Game");

        System.out.println("Enter the size of Board: ");
        int dimension = sc.nextInt();

        System.out.println("Do you want a Bot player? Y or N?");
        String botans = sc.next();
        if (botans.equalsIgnoreCase("Y")) {
            Player bot = new Bot(id++, "Chitti", '$', BotLevel.EASY); // Bot initialized
            playerList.add(bot);
        }

        while (id < dimension) {  // Adjusting the condition to allow enough human players
            System.out.println("Enter Player Name: ");
            String name = sc.next();
            System.out.println("Enter player symbol: ");
            char symbol = sc.next().charAt(0);

            Player newPlayer = new Player(id++, name, symbol, PlayerType.HUMAN);
            playerList.add(newPlayer);
        }

        // Shuffle the player list to randomize turns
        Collections.shuffle(playerList);

        // Create a new game with the specified dimension and players
        Game game = gameController.createGame(dimension, playerList, WinningStrategyNames.ORDERONEWINNINGSTRATEGY);
        int playerIndex = -1;
        while (game.getGameStatus().equals(GameStatus.INPROGRESS)) {
            System.out.println("Current Board:");
            gameController.displayBoard(game);

            playerIndex++;
            playerIndex = playerIndex % playerList.size();
            Player currentPlayer = playerList.get(playerIndex);

            Move movePlayed = gameController.executeMove(game,playerList.get(playerIndex));
            game.getMoves().add(movePlayed);


            // If Game is Draw
            if (game.getMoves().size() == game.getCurrentboard().getDimension() * game.getCurrentboard().getDimension()) {
                System.out.println("GAME IS A DRAW");
                break;
            }

            // Check if there is a winner
            Player winner = gameController.checkWinner(game, movePlayed);
            if (winner != null) {
                System.out.println("WINNER is " + winner.getName());
                break;
            }
        }

        System.out.println("Final Board:");
        gameController.displayBoard(game);

        System.out.println("Thank You for playing!");

    }
}
