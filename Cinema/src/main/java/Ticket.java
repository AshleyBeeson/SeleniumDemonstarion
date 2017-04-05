import lombok.Data;

@Data
public class Ticket {

    private int cost;
    private TicketType ticketType;

    public Ticket(TicketType type){
        ticketType = type;
        cost = TicketType.ticketCost(type);
    }


}
