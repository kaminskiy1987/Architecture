package HomeTask4.core;

import java.util.Collection;

/**
 * Покупатель
 */
public class Customer {
    private static int counter;
    private final int id;
    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public int getId() {
        return id;
    }
}