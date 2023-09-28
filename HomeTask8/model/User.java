package HomeTask8.model;

import java.util.ArrayList;
import java.util.Collection;

public class User {
    private String name;

    private int phone;
    private static int counter;
    private final int userId;

    {
        userId = ++counter;
    }

    private final Collection<Reservation> reservations = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }
}