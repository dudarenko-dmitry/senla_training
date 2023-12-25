package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.RoomDto;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.facilities.RoomStatus;
import pl.senla.hotel.service.ServiceFacility;

@Component
@Slf4j
public class RoomDtoMapperUtil {

    private RoomDtoMapperUtil() {}

    @Autowired
    private static ServiceFacility serviceFacility;

    public static Room convertRoomDtoToRoom(RoomDto roomDto) {
        log.debug("Start: convert RoomDto to Room");
        Room room = new Room();
        room.setIdRoom(serviceFacility.getRoomByNameFacility(roomDto.getNameFacility()).getIdRoom());
        room.setCategory(roomDto.getCategory());
        room.setNameFacility(roomDto.getNameFacility());
        room.setPrice(roomDto.getPrice());
        room.setCapacity(roomDto.getCapacity());
        room.setRoomLevel(roomDto.getRoomLevel());
        room.setRoomStatus(RoomStatus.AVAILABLE);
        return room;
    }

    public static RoomDto convertRoomToRoomDto(Room room) {
        log.debug("Start: convert Room to RoomDto");
        return RoomDto.builder()
                .category(room.getCategory())
                .nameFacility(room.getNameFacility())
                .price(room.getPrice())
                .capacity(room.getCapacity())
                .roomLevel(room.getRoomLevel())
                .build();
    }

}
