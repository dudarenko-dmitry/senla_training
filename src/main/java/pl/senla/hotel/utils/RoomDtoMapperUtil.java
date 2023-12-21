package pl.senla.hotel.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.dto.RoomDto;
import pl.senla.hotel.entity.facilities.CategoryFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.service.ServiceFacility;

@Component
@Slf4j
public class RoomDtoMapperUtil {

    private RoomDtoMapperUtil() {}

    @Autowired
    private static ServiceFacility serviceFacility;

    public static Room convertRoomDtoToRoom(RoomDto roomDto) {
        log.debug("Start: convert RoomDto to Room");
        return Room.builder()
                .idRoom(serviceFacility.getRoomByNameFacility(roomDto.getNameFacility()).getIdRoom())
                .category(CategoryFacility.ROOM)
                .nameFacility(roomDto.getNameFacility())
                .price(roomDto.getPrice())
                .capacity(roomDto.getCapacity())
                .roomLevel(roomDto.getRoomLevel())
                .roomStatus(serviceFacility.getRoomByNameFacility(roomDto.getNameFacility()).getRoomStatus())
                .build();
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
