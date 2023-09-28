package HomeTask8.presenters;

import HomeTask8.model.User;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(User user, Date orderDate, int tableNo, String name);

    void onChangeReservationTable(User user, int oldReservation, Date reservationDate, int tableNo, String name);

    void onCloseReservationTable(User user, int oldReservation);

}