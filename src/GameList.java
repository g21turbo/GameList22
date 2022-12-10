import java.util.ArrayList;

public class GameList {

    private String name;
    private ArrayList<String> gameArrayList;

    public GameList(String name) {
        this.name = name;
        this.gameArrayList = new ArrayList<String>();
    }


    public boolean addGame(Game game){
        if (findGame(game.getName()) >= 0){
            System.out.println("Game is already listed");
            return false;
        }
        gameArrayList.add(game);
        return true;
    }





}
