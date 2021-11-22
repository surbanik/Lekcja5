import java.util.List;

public class Actor {

    String firstName;
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static String getActorsName(List<Actor> actors){
        String actorsData="";
        for (Actor actor: actors){
            actorsData += actor.firstName + " " + actor.lastName + " ";
        }
        return actorsData;
    }
}
