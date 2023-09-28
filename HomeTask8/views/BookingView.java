package HomeTask8.views;

import HomeTask8.model.Reservation;
import HomeTask8.model.Table;
import HomeTask8.model.User;
import HomeTask8.presenters.View;
import HomeTask8.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    public void showUserReservations(User user) {
        for (Reservation reservation : user.getReservations()) {
            System.out.println(reservation);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        } else if (reservationNo < -1) {
            System.out.printf("Бронирование #%d успешно отменено.\n", -1*reservationNo);
        } else {
            System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(User user, Date orderDate, int tableNo, String name) {
        if (observer != null)
            observer.onReservationTable(user, orderDate, tableNo, name);
    }

    /**
     * TODO: Доработать самостоятельнов рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменения резерва)
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void changeReservationTable(User user, int oldReservation, Date reservationDate, int tableNo, String name) {
        if (observer != null) {
            observer.onChangeReservationTable(user, oldReservation, reservationDate, tableNo, name);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку удаления бронирования столика)
     * @param oldReservation
     */
    public void closeReservationTable(User user, int oldReservation) {
        if (observer != null) {
            observer.onCloseReservationTable(user, oldReservation);
        }
    }
}