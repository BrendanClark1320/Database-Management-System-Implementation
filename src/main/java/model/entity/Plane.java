package model.entity;

public class Plane extends AbstractEntity {
    private Integer ID = null;
    private Integer seats_available;
    private Integer total_seats;
    private String model;
    public Plane() {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSeats_available() {
        return seats_available;
    }

    public void setSeats_available(Integer seats_available) {
        this.seats_available = seats_available;
    }

    public Integer getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(Integer total_seats) {
        this.total_seats = total_seats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}