package hellocucumber;

public class FridayChecker {
    public static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}
