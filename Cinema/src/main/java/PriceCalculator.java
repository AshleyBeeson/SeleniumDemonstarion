import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PriceCalculator{

    private static boolean isWednesday = false;

    public static String calculate(List<Ticket> selectedTickets){
        System.out.println("CALCULATING...");
        isWednesday = "Wed".equalsIgnoreCase(new SimpleDateFormat("ddd").format(new Date()));
        int totalCost = 0;
        for (Ticket ticket : selectedTickets){
            int cost = ticket.getCost();
            if (isWednesday){
                cost -= 2;
            }
            totalCost += cost;
        }
        return String.valueOf(totalCost);
    }



}
