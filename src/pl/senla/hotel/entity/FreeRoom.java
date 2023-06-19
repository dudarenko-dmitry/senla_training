package pl.senla.hotel.entity;

import java.time.LocalDate;

public class FreeRoom {

    public static final LocalDate START_DATE_YEAR = LocalDate.of(2023, 1, 1);
    public static final LocalDate END_DATE_YEAR = LocalDate.of(2023, 12, 31);
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomId=" + room.getRoomId() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
