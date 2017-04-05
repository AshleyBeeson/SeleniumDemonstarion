public enum TicketType {

    STANDARD,OAP,STUDENT,CHILD;

    public static int ticketCost(TicketType type){
        switch (type){
            default:
                return 9999;
            case CHILD:
                return 4;
            case OAP:
                return 6;
            case STANDARD:
                return 8;
            case STUDENT:
                return 6;
        }
    }

}
