package HomeTask8.presenters;

import HomeTask8.model.Table;
import HomeTask8.model.User;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отображение списка столиков, забронированных клиентом в приложении
     * @param user клиент
     */
    void showUserReservations(User user);

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    void showReservationTableResult(int reservationNo);


    /**
     * Установить наблюдателя для представления
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Событие: Клиент нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name Имя клиента
     */
    void reservationTable(User user, Date orderDate, int tableNo, String name);

    void closeReservationTable(User user, int oldReservation);

    void changeReservationTable(User user, int oldReservation, Date date, int tableNo, String name);
}