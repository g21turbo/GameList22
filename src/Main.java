import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GameList gameList = new GameList("Favorite Games");


    public static void main(String[] args) {

        boolean quit = false;
        printActions();
        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    quit = true;
                    System.out.println("Closing program...");
                    break;
                case 1:
                    gameList.printGameList();
                    break;
                case 2:
                    addGame();
                    break;
                case 3:
                    updateGame();
                    break;
                case 4:
                    removeGame();
                    break;
                case 5:
                    queryGame();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }


    public static void addGame(){
        System.out.println("Enter the name of the game: ");
        String name = scanner.nextLine();
        System.out.println("Enter the game's genre: ");
        String genre = scanner.nextLine();
        System.out.println("What POV is the game played from: ");
        String pov = scanner.nextLine();
        Game newGame = Game.createNewGame(name, genre, pov);
        if (gameList.addGame(newGame)) {
            System.out.println("New game added = " + name +
                    "  Genre: " + genre + "  POV: " + pov);
        } else {
            System.out.println("Cannot add " + name + " already on file.");
        }
    }

    public static void updateGame(){
        System.out.println("Enter a game to update: ");
        String oldGame = scanner.nextLine();
        Game existingGameRecord = gameList.queryGame(oldGame);
        if (existingGameRecord == null) {
            System.out.println("Game was not found.");
            return;
        }
        System.out.println("Enter new game name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter the genre of the game: ");
        String newGenre = scanner.nextLine();
        System.out.println("Enter the POV of the new game: ");
        String newPov = scanner.nextLine();
        Game newGame = Game.createNewGame(newName, newGenre, newPov);
        if (gameList.updateGame(existingGameRecord, newGame)){
            System.out.println("Successfully updated.");
        } else {
            System.out.println("Error updating game.");
        }
    }

    public static void removeGame(){
        System.out.println("Enter a game to remove: ");
        String gameName = scanner.nextLine();
        Game existingGameRecord = gameList.queryGame(gameName);
        if (existingGameRecord == null){
            System.out.println("Game mot found.");
            return;
        }
        if (gameList.removeGame(existingGameRecord)){
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting game");
        }
    }

    public static void queryGame(){
        System.out.println("Enter game to search: ");
        String game = scanner.nextLine();
        Game existingGame = gameList.queryGame(game);
        if (gameList.queryGame(game) == null){
            System.out.println("Game not listed.");
            return;
        }
        System.out.println("Game name: " + existingGame.getName() + "Genre: " +
                existingGame.getGenre() + "POV: " + existingGame.getPov());

    }

    public static void printActions(){
        System.out.println("\tAvailable Actions:\n" +
                "Press: \n" +
                "\t 0 - To quit.\n" +
                "\t 1 - To print the game list.\n" +
                "\t 2 - To add a new game.\n" +
                "\t 3 - To update a listed game.\n" +
                "\t 4 - To remove a game from the list.\n" +
                "\t 5 - To see if a game is listed.\n" +
                "\t 6 - To print the available actions\n");
    }



}
