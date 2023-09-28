package HomeTask8.presenters;

import HomeTask8.model.Table;
import HomeTask8.model.User;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables(){
        return model.loadTables();
    }

    /**
     * Отобразить список столиков (на представлении)
     */
    public void updateUIShowTables(){
        view.showTables(loadTables());
    }

    public void updateUIShowReservationTableResult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(User user, Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(user, orderDate, tableNo, name);
            updateUIShowReservationTableResult(reservationNo);

        }
        catch (RuntimeException e){
            updateUIShowReservationTableResult(-1);
        }
    }

    /**
     * Произошло событие, пользователь передумал бронировать столик
     * @param oldReservation старый id бронирования
     * @param reservationDate новая дата резерва
     * @param tableNo новый номер столика
     * @param name новое имя имя клиента
     */
    @Override
    public void onChangeReservationTable(User user, int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(user, reservationDate, tableNo, name);
            updateUIShowReservationTableResult(reservationNo);
            onCloseReservationTable(user, oldReservation);
        }
        catch (RuntimeException e) {
            updateUIShowReservationTableResult(-1);
        }
    }

    /**
     * Произошло событие, пользователь решил отменить бронирование столика
     * @param oldReservation id бронирования, который нужно отменить
     */
    @Override
    public void onCloseReservationTable(User user, int oldReservation) {
        try {
            int closeResult = model.closeReservationTable(user, oldReservation);
            updateUIShowReservationTableResult(closeResult);
        }
        catch (RuntimeException e) {
            updateUIShowReservationTableResult(-1);
        }
    }
}