package HomeTask4;

import HomeTask4.core.*;
import HomeTask4.mobileapp.*;
import HomeTask4.busstation.*;

import java.util.Collection;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());

        if (mobileApp.buyTicket("000022220004444")) {
            System.out.println("Клиент успешно купил билет.");
            mobileApp.searchTicket(new Date());

            Collection<Ticket> tickets = mobileApp.getTickets();
            System.out.println(tickets);

            if (busStation.checkTicket(tickets.stream().findFirst().get().getQrcode())) {
                System.out.println("Клиент успешно прошел в автобус.");
            }
        }
    }
}