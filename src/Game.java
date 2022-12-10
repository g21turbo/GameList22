public class Game {

    private String name;
    private String genre;
    private String pov;

    public Game(String name, String genre, String pov) {
        this.name = name;
        this.genre = genre;
        this.pov = pov;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getPov() {
        return pov;
    }

    public static Game createNewGame(String name, String genre, String pov){
        return new Game(name, genre, pov);
    }

}
