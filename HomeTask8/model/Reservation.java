package HomeTask8.model;

import java.util.Date;
import java.util.Locale;

public class Reservation {
    private static int counter = 1000;
    private final int id;

    private Table table;
    private Date date;
    private String name;

    {
        id = ++counter;
    }

    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setReservationDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Бронирование #%d", id);
    }
}