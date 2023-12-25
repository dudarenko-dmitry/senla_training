package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.HotelServiceDto;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.service.*;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Slf4j
public class HotelServiceDtoMapperUtil {

    private HotelServiceDtoMapperUtil() {}

    @Autowired
    private static ServiceGuest serviceGuest;
    @Autowired
    private static ServiceFacility serviceFacility;
    @Autowired
    private static ServiceOrder serviceOrder;
    @Autowired
    private static ServiceRoomReservation serviceRoomReservation;

    public static HotelService convertHotelServiceDtoToHotelService(HotelServiceDto hotelServiceDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("Start: convert HotelServiceDto to HotelService");
        int idService = 0;
        int idOrder = hotelServiceDto.getIdOrder();
        int idRoom = hotelServiceDto.getIdHotelFacility();
        Optional<HotelService> hotelService = serviceRoomReservation.findServicesForOrder(idOrder).stream()
                .filter(hs -> hs.getRoom().getIdRoom() == idRoom)
                .findFirst();
        if(hotelService.isPresent()) {
            idService = hotelService.get().getIdService();
        }
        return HotelService.builder()
                .idService(idService)
                .order(serviceOrder.read(idOrder))
                .typeOfService(TypeOfService.valueOf("ROOM_RESERVATION"))
                .guest(serviceGuest.read(hotelServiceDto.getIdGuest()))
                .room(serviceFacility.read(idRoom))
                .numberOfDays(hotelServiceDto.getNumberOfDays())
                .checkInTime(convertStringToTime(hotelServiceDto.getCheckInTimeString()))
                .checkOutTime(convertStringToTime(hotelServiceDto.getCheckOutTimeString()))
                .cost(hotelServiceDto.getCost())
                .build();
    }

    public static HotelServiceDto convertHotelServiceToHotelServiceDto(HotelService hotelService) {
        log.debug("Start: convert HotelService to HotelServiceDto");
        return HotelServiceDto.builder()
                .idOrder(hotelService.getOrder().getIdOrder())
                .idGuest(hotelService.getGuest().getIdGuest())
                .idHotelFacility(hotelService.getRoom().getIdRoom())
                .numberOfDays(hotelService.getNumberOfDays())
                .checkInTimeString(convertTimeToString(hotelService.getCheckInTime()))
                .checkOutTimeString(convertTimeToString(hotelService.getCheckOutTime()))
                .cost(hotelService.getCost())
                .build();
    }

    public static LocalDateTime convertStringToTime(String checkedDateString) {
        log.debug("START: HotelServiceMapper getDateTime");
        String[] timeData = checkedDateString.split("-");
        int year = Integer.parseInt(timeData[0]);
        int month = Integer.parseInt(timeData[1]);
        int day = Integer.parseInt(timeData[2]);
        int hour = 12;
        int minute = 0;
        int second = 0;
        return LocalDateTime.of(year,month,day, hour, minute, second);
    }

    public static String convertTimeToString(LocalDateTime time) {
        log.debug("START: HotelServiceMapper getDateTime");
        return time.getYear() + "-" +
                time.getMonthValue() + "-" +
                time.getDayOfMonth() + "-" +
                time.getHour() + "-" +
                time.getMinute() + "-" +
                time.getSecond();
    }
}
