package HomeTask4.core;

import java.util.Date;
/**
 * Билет
 */
public class Ticket {
    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return this.id;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int clientId) {
        this.customerId = clientId;
    }
    public Date getDate() {
        return this.date;
    }

    public String getQrcode() {
        return this.qrcode;
    }

    public boolean isEnable() {
        return this.enable;
    }
}