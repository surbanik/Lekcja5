import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        MovieLibrary movies = mapper.readValue(new URL("file:src/test/resources/movies.json"), MovieLibrary.class);

        while(true){
            Scanner scanner= new Scanner(System.in);
            Menu.displayMenu();
            int userChoise = scanner.nextInt();
            switch(userChoise){
                case 1:
                    System.out.println("Podaj rok produkcji pierwszego filmu");
                    int firstDate = scanner.nextInt();
                    System.out.println("Podaj rok produkcji drugieg filmu");
                    int secondDate = scanner.nextInt();
                    Movie.displayMoviesShotBetween(movies, firstDate, secondDate);
                    break;
                case 2:
                    Movie.displayRandomMovieInfo(movies);
                    break;
                case 3:
                    System.out.println("Podaj imie aktora");
                    String firstName = scanner.next();
                    System.out.println("Podaj nazwisko aktora");
                    String lastName = scanner.next();
                    Movie.displayMoviesWhereActorPlay(movies, firstName, lastName);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Something went wrong");;
            }
        }
    }
}

