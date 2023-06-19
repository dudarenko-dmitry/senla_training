package pl.senla.hotel.entity;

public class Guest {

    private int idGuest;
    private String name;
    private int phoneNumber;

    public Guest() {
    }

    public Guest(int idGuest) {
        this.idGuest = idGuest;
    }

    public Guest(int idGuest, String name, int phoneNumber) {
        this.idGuest = idGuest;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\nGuest{" +
                "idGuest=" + idGuest +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}