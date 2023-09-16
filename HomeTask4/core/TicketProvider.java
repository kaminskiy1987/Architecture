package HomeTask4.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {
    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date) {
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }

        return tickets;
    }

    public boolean buyTicket(int clientId, String cardNo) {
        // ПРЕДУСЛОВИЕ
        if (clientId < 1) {
            throw new RuntimeException("Ошибка! Передан неверный id клиента");
        }
        
        if (cardNo.length() != 16) {
            throw new RuntimeException("Ошибка! Передан неверный номер карты клиента");
        }

        //РАБОТА С ДАННЫМИ
        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        // ИНВАРИАНТ
        // validateAmount(amount);

        // ИНВАРИАНТ
        // текущий покупаемый билет нужно забронировать, чтобы его не купил кто-то другой, пока пользователь
        // оформляет покупку, и в то же время если пользователь начал процесс покупки, но потом передумал и ушел,
        // нужно освободить билет от брони
        // checkTicketFree();

        // ПОСТУСЛОВИЕ
        // проверяем, прошла ли транзакция
        if (!paymentProvider.buyTicket(orderId,  cardNo, amount)) {
            throw new RuntimeException("Ошибка обработки данных");
            // ИНВАРИАНТ
            // если оплата не прошла, откатываем назад транзацию и билет снова доступен к покупке
            // paymentProvider.rollback(orderId,  cardNo, amount);
        }

        Ticket ticket = new Ticket();
        database.addCustomer(database.getCustomerByID(clientId), ticket);
        System.out.println(database.getCustomerByID(clientId));
        database.getCustomerByID(clientId).addTicket(ticket);

        //TODO: Возвращаем результат выполнения задачи ...
        return true;
    }

    public boolean checkTicket(String qrcode) {
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }

        return false;
    }
}