//package pl.senla.hotel.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import pl.senla.hotel.dao.DaoHotelServiceSpring;
//import pl.senla.hotel.dto.HotelServiceDto;
//import pl.senla.hotel.entity.services.HotelService;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.List;
//import java.util.Optional;
//
//import static pl.senla.hotel.constant.HotelServiceConstant.READ_ALL_SERVICES_IS_EMPTY;
//import static pl.senla.hotel.constant.HotelServiceConstant.SERVICE_NOT_EXISTS;
//
//@Service
//@Slf4j
//public class ServiceHotelServiceSpring implements ServiceHotelService{
//
//    @Autowired
//    private ServiceRoomReservation serviceRoomReservation;
//    @Autowired
//    private DaoHotelServiceSpring daoHotelService;
//
//    @Override
//    public List<HotelService> readAll() {
//        log.debug("START: HotelService ReadAll");
//        List<HotelService> hotelServiceList = daoHotelService.findAll();
//        if(hotelServiceList.isEmpty()){
//            log.debug(READ_ALL_SERVICES_IS_EMPTY);
//        }
//        return hotelServiceList;
//    }
//
//    @Override
//    public HotelService create(HotelServiceDto hotelServiceDto) throws IllegalAccessException,
//            InvocationTargetException, NoSuchMethodException, InstantiationException {
//        log.debug("START: HotelService Create");
//        return daoHotelService.save(hotelServiceDto);
//    }
//
//    @Override
//    public HotelService read(int idHotelService) throws InvocationTargetException, NoSuchMethodException,
//            InstantiationException, IllegalAccessException {
//        Optional<HotelService> hotelService = daoHotelService.findById(idHotelService);
//        log.debug("START: HotelService Read");
//        if(hotelService.isPresent()){
//            return daoHotelService.findById(idHotelService);
//        }
//        log.debug(SERVICE_NOT_EXISTS);
//        return null;
//    }
//
//    @Override
//    public HotelService update(int idHotelService, HotelServiceDto hotelServiceDtoNew) throws InvocationTargetException,
//            NoSuchMethodException, InstantiationException, IllegalAccessException {
//        log.debug("START: HotelService Update");
//        if (daoHotelService.existsById(idHotelService)) {
//            return serviceRoomReservation.update(idHotelService, hotelServiceDtoNew);
//            }
//        log.debug(SERVICE_NOT_EXISTS);
//        return null;
//    }
//
//    @Override
//    public void delete(int idHotelService) throws InvocationTargetException, NoSuchMethodException,
//            InstantiationException, IllegalAccessException {
//        log.debug("START: HotelService Delete");
//        if(daoHotelService.existsById(idHotelService)){
//            daoHotelService.deleteById(idHotelService);
//        }
//        log.debug(SERVICE_NOT_EXISTS);
//    }
//
//}
