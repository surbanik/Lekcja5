import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Movie {

    @Override
    public String toString(){
        return  "title: " + title + "\n" +
                "director: " + director.firstName + " " + director.lastName +"\n" +
                "genre: " + type + "\n" +
                "date: " + publicationYear +"\n" +
                "actors: " + Actor.getActorsName(actors)+"\n";

    }

    String name;
    String title;
    int publicationYear;
    String type;
    Director director;
    List<Actor> actors;


    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getType() {
        return type;
    }

    public Director getDirector() {
        return director;
    }

    public List<Actor> getActors() {
        return actors;
    }
    public static Movie getRandomMovieInfo(MovieLibrary movies){
        Random rn = new Random();
        int random = rn.nextInt(movies.getMovieList().size());
        return movies.getMovieList().get(random);
    }

    public static void displayRandomMovieInfo(MovieLibrary movies){
        Movie movie = Movie.getRandomMovieInfo(movies);
        System.out.println(movie.toString());


    }

    public static void displayMoviesWhereActorPlay(MovieLibrary movies, String wantedFirstName, String wantedLastName) {
        List<String> matchedTitles = new ArrayList<>();
        movies.getMovieList().stream()
                .filter(m -> m.actors.stream().anyMatch(a -> (a.firstName.equals(wantedFirstName) && a.lastName.equals(wantedLastName))))
                .map(m -> m.title)
                .forEach(matchedTitles::add);
        if (matchedTitles.isEmpty()) {
            System.out.println("No results");
        } else {
            for (String title : matchedTitles) {
                System.out.println(title);
            }
        }
    }

    public static void displayMoviesShotBetween(MovieLibrary movies, int firstDate, int secondDate){
        List<String> matchedTitles = new ArrayList<>();
        movies.getMovieList().stream()
                .filter (m -> m.publicationYear >= firstDate)
                .filter (m -> m.publicationYear <= secondDate)
                .map(m -> m.title)
                .forEach(matchedTitles::add);
        if (matchedTitles.isEmpty()) {
            System.out.println("No results");
        } else {
            for (String title : matchedTitles) {
                System.out.println(title);
            }
        }
    }
}
