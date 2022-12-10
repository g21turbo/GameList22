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

    public boolean removeGame(){

    }

    public boolean updateGame(){


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

    public String queryGame(){

    }

    public Game queryGame(){

    }





}
