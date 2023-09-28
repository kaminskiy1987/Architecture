package HomeTask8.model;

import HomeTask8.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables() {

        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя клиента
     */
    @Override
    public int reservationTable(User user, Date reservationDate, int tableNo, String name) {
        for (Table table: tables) {
            if (table.getTableNo() == tableNo){
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                user.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }

    /**
     * Отмена бронирования столика
     *
     * @param user
     * @param oldReservation id бронирования, которое нужно отменить
     */
    @Override
    public int closeReservationTable(User user, int oldReservation) {
        for (Reservation reservation : user.getReservations()) {
            if (reservation.getId() == oldReservation) {
                user.getReservations().remove(reservation);
                return -1*oldReservation;
            }
        }

        throw new RuntimeException("Ошибка отмены бронирования столика. Повторите попытку позже.");
    }

    /**
     * TODO: Доработать самостоятельнов рамках домашней работы
     * @param oldReservation id бронирования
     * @param reservationDate новая дата бронирования
     * @param tableNo новый номер столика
     * @param name новое имя посетителя
     * @return код успешного выполнения операции, либо код ошибки
     */
    public int changeReservationTable(User user, int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Reservation reservation : user.getReservations()) {
            if (reservation.getId() == oldReservation) {
                reservation.setReservationDate(reservationDate);
                reservation.setName(name);
                return oldReservation;
            }
        }
        throw new RuntimeException("Ошибка изменения бронирования столика. Повторите попытку позже.");
    }
}