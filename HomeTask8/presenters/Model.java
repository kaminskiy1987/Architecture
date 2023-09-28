package HomeTask8.presenters;

import HomeTask8.model.Table;
import HomeTask8.model.User;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(User user, Date reservationDate, int tableNo, String name);

    int closeReservationTable(User user, int oldReservation);
}