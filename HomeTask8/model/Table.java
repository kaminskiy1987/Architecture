package HomeTask8.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {
    private final Collection<Reservation> reservations = new ArrayList<>();

    private static int counter;
    private final int tableNo;

    {
        tableNo = ++counter;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public int getTableNo() {
        return tableNo;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", tableNo);
    }
}