import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PriceCalculator{

    private static boolean isWednesday = false;

    public static String calculate(List<Ticket> selectedTickets){
        System.out.println("CALCULATING...");
        isWednesday = "Wed".equalsIgnoreCase(new SimpleDateFormat("EEE").format(new Date()));
        int totalCost = 0;
        for (Ticket ticket : selectedTickets){
            int cost = ticket.getCost();
            if (isWednesday){
                System.out.println("WEDNESDAY DISCOUNT");
                cost -= 2;
            }
            totalCost += cost;
        }
        return String.valueOf(totalCost);
    }



}
