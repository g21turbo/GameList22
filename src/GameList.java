import java.util.ArrayList;

public class GameList {

    private String name;
    private ArrayList<Game> gameArrayList;

    public GameList(String name) {
        this.name = name;
        this.gameArrayList = new ArrayList<Game>();
    }


    public boolean addGame(Game game){
        if (findGame(game.getName()) >= 0){
            System.out.println("Game is already listed");
            return false;
        }
        gameArrayList.add(game);
        return true;
    }

    public boolean updateGame(Game oldGame, Game newGame){
        int foundPosition =  findGame(oldGame);
        if (foundPosition < 0){
            System.out.println("Game is nt listed");
        } else {
            if (findGame(newGame.getName()) != -1){
                System.out.println("The game " + newGame.getName() +
                        " is already listed. Update not successful.");
            }
        }
        this.gameArrayList.set(foundPosition, newGame);
        System.out.println(oldGame.getName() + ", was replaced with " + newGame.getName());
        return true;

    }

    public boolean removeGame(Game game){
        int foundPosition = findGame(game);
        if (foundPosition < 0) {
            System.out.println(game.getName() + ", was not found.");
            return false;
        }
        this.gameArrayList.remove(foundPosition);
        System.out.println(game.getName() + " has been removed.");
        return true;
    }

    private int findGame(Game game){
        return this.gameArrayList.indexOf(game);

    }

    private int findGame(String gameName){
        for (int i = 0; i < this.gameArrayList.size(); i++){
            Game game = this.gameArrayList.get(i);
            if (game.getName().equals(gameName)){
                return i;
            }
        }
        return -1;
    }

    public String queryGame(Game game){
        if (findGame(game) >= 0) {
            return game.getName();
        }
        return null;
    }

    public Game queryGame(String name){
        int position = findGame(name);
        if (position >= 0){
            return this.gameArrayList.get(position);
        }
        return  null;
    }

    public void printGameList(){
        System.out.println("You have " + gameArrayList.size() + " game/s on the list");
        for (int i = 0; i < this.gameArrayList.size(); i++){
            System.out.println((i + 1) + ". " +
                    this.gameArrayList.get(i).getName() +  " -> " +
                    this.gameArrayList.get(i).getGenre() + " -> " +
                    this.gameArrayList.get(i).getPov());
        }
    }
}
