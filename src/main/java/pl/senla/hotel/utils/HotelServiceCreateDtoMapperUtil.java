package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.HotelServiceCreateDto;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.TypeOfService;
import pl.senla.hotel.service.ServiceFacility;
import pl.senla.hotel.service.ServiceGuest;
import pl.senla.hotel.service.ServiceOrder;
import pl.senla.hotel.service.ServiceRoomReservation;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Slf4j
public class HotelServiceCreateDtoMapperUtil {

    private HotelServiceCreateDtoMapperUtil() {}

    @Autowired
    private static ServiceGuest serviceGuest;
    @Autowired
    private static ServiceFacility serviceFacility;
    @Autowired
    private static ServiceOrder serviceOrder;
    @Autowired
    private static ServiceRoomReservation serviceRoomReservation;

    public static HotelService convertHotelServiceDtoToHotelService(HotelServiceCreateDto hotelServiceDto) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        log.debug("Start: convert HotelServiceDto to HotelService");
        HotelService hotelService = new HotelService();
        Integer idService = null;
        Integer idOrder = hotelServiceDto.getIdOrder();
        Integer idRoom = hotelServiceDto.getIdHotelFacility();
        Optional<HotelService> hotelServiceDB = serviceRoomReservation.findServicesForOrder(idOrder).stream()
                .filter(hs -> hs.getRoom().getIdRoom().equals(idRoom))
                .findFirst();
        if(hotelServiceDB.isPresent()) {
            idService = hotelServiceDB.get().getIdService();
        }
        hotelService.setIdService(idService);
        hotelService.setOrder(serviceOrder.read(idOrder));
        hotelService.setTypeOfService(TypeOfService.valueOf("ROOM_RESERVATION"));
        hotelService.setGuest(serviceGuest.read(hotelServiceDto.getIdGuest()));
        hotelService.setRoom(serviceFacility.read(idRoom));
        hotelService.setNumberOfDays(hotelServiceDto.getNumberOfDays());
        hotelService.setCheckInTime(convertStringToTime(hotelServiceDto.getCheckInTimeString()));
        hotelService.setCheckOutTime(convertStringToTime(hotelServiceDto.getCheckInTimeString())
                .plusDays(hotelServiceDto.getNumberOfDays()).minusMinutes(1));
        hotelService.setCost(serviceFacility.read(hotelService.getIdService()).getPrice()
                * hotelServiceDto.getNumberOfDays());
        return hotelService;
//        return HotelService.builder()
//                .idService(idService)
//                .order(serviceOrder.read(idOrder))
//                .typeOfService(TypeOfService.valueOf("ROOM_RESERVATION"))
//                .guest(serviceGuest.read(hotelServiceDto.getIdGuest()))
//                .room(serviceFacility.read(idRoom))
//                .numberOfDays(hotelServiceDto.getNumberOfDays())
//                .checkInTime(convertStringToTime(hotelServiceDto.getCheckInTimeString()))
//                .checkOutTime(convertStringToTime(hotelServiceDto.getCheckInTimeString())
//                        .plusDays(hotelServiceDto.getNumberOfDays()).minusMinutes(1))
//                .cost(serviceFacility.read(idRoom).getPrice() * hotelServiceDto.getNumberOfDays())
//                .build();
    }

    // not used
//    public static HotelServiceCreateDto convertHotelServiceToHotelServiceDto(HotelService hotelService) {
//        log.debug("Start: convert HotelService to HotelServiceDto");
//        return HotelServiceCreateDto.builder()
//                .idOrder(hotelService.getOrder().getIdOrder())
//                .idGuest(hotelService.getGuest().getIdGuest())
//                .idHotelFacility(hotelService.getRoom().getIdRoom())
//                .numberOfDays(hotelService.getNumberOfDays())
//                .checkInTimeString(convertTimeToString(hotelService.getCheckInTime()))
//                .build();
//    }

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
