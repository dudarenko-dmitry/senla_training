package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import static pl.senla.hotel.constant.HotelServiceConstant.READ_ALL_SERVICES_IS_EMPTY;
import static pl.senla.hotel.constant.HotelServiceConstant.SERVICE_NOT_EXISTS;

@AppComponent
public class ServiceHotelServiceDB implements ServiceHotelService{

    @GetInstance(beanName = "ServiceRoomReservationDB")
    private ServiceRoomReservation serviceRoomReservation;
    @GetInstance(beanName = "DaoHotelServiceDB")
    private GenericDao<HotelService> daoHotelService;

    public ServiceHotelServiceDB() {}

    @Override
    public List<HotelService> readAll() {
        if(daoHotelService.readAll() != null || !daoHotelService.readAll().isEmpty()){
            return daoHotelService.readAll();
        }
        System.out.println(READ_ALL_SERVICES_IS_EMPTY);
        return Collections.emptyList();
    }

    @Override
    public boolean create(String hotelServiceString) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        String[] hotelServiceData = hotelServiceString.split(";");
        String typeOfService = hotelServiceData[0]; // EDIT and PUT correct index
        switch (typeOfService){
//            case "RoomReservation" -> serviceRoomReservation.create(hotelServiceString);
            case "RoomReservation" -> serviceRoomReservation.create(hotelServiceString);
            case "Restaurant" -> System.out.println("CREATE ACTION FOR RESTAURANT");
            case "Transfer" -> System.out.println("CREATE ACTION FOR TRANSFER");
            default -> System.out.println("Something went wrong ...");
        }
        return true;
    }

    @Override
    public HotelService read(int idHotelService) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if(daoHotelService.read(idHotelService) != null){
            return daoHotelService.read(idHotelService);
        }
        System.out.println(READ_ALL_SERVICES_IS_EMPTY);
        return null;
    }

    @Override
    public boolean update(int idHotelService, String hotelServiceString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (read(idHotelService) != null) {
            String[] hotelServiceData = hotelServiceString.split(";");
            String typeOfService = hotelServiceData[0]; // EDIT and PUT correct index
            switch (typeOfService){
                case "RoomReservation" -> serviceRoomReservation.update(idHotelService, hotelServiceString);
                case "Restaurant" -> System.out.println("CREATE ACTION FOR RESTAURANT");
                case "Transfer" -> System.out.println("CREATE ACTION FOR TRANSFER");
                default -> System.out.println("Something went wrong ...");
            }
        }
        System.out.println(READ_ALL_SERVICES_IS_EMPTY);
        return false;
    }

    @Override
    public boolean delete(int idHotelService) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        if(daoHotelService.read(idHotelService) != null){
            return daoHotelService.delete(idHotelService);
        }
        System.out.println(SERVICE_NOT_EXISTS);
        return false;
    }

}
