package HomeTask4.core;

import java.util.ArrayList;
import java.util.Collection;

/**
 * База данных
 */
public class Database {
    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    private double amount = 45;

    public Database() {
        tickets.add(new Ticket());
        tickets.add(new Ticket());
        tickets.add(new Ticket());
        customers.add(new Customer());
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer, Ticket ticket) {
        customers.add(customer);
        ticket.setCustomerId(customer.getId());
    }

    public Customer getCustomerByID (int clientId) {
        for (Customer customer : customers) {
            if (customer.getId() == clientId) {
                return customer;
            }
        }
        
        return null;
    }

    /**
     * Получить актуальную стоимость билета
     * @return
     */
    public double getTicketAmount() {
        return amount;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }
}