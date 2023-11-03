package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.dao.GenericDao;

import java.util.Collections;
import java.util.List;

import static pl.senla.hotel.constant.HotelServiceConstant.*;

@AppComponent
public class ServiceHotelServiceImpl implements ServiceHotelService{

    @GetInstance(beanName = "ServiceRoomReservationImpl")
    private ServiceRoomReservation serviceRoomReservation;
    @GetInstance(beanName = "DaoHotelServiceCollection")
    private GenericDao<HotelService> daoHotelService;

    public ServiceHotelServiceImpl() {}

    @Override
    public List<HotelService> readAll() {
        if(daoHotelService.readAll() == null || daoHotelService.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_SERVICES);
            return Collections.emptyList();
        }
        return daoHotelService.readAll();
    }

    @Override
    public boolean create(String hotelServiceString) throws IllegalAccessException {
        String[] hotelServiceData = hotelServiceString.split(";");
        String typeOfService = hotelServiceData[0]; // EDIT and PUT correct index
        switch (typeOfService){
            case "RoomReservation" -> serviceRoomReservation.create(hotelServiceString);
            case "Restaurant" -> System.out.println("CREATE ACTION FOR RESTAURANT");
            case "Transfer" -> System.out.println("CREATE ACTION FOR TRANSFER");
            default -> System.out.println("Something went wrong ...");
        }
        return true;
    }

    @Override
    public HotelService read(int idHotelService) {
        if(readAll() == null || readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_SERVICES);
            return null;
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdService() == idHotelService){
                return daoHotelService.read(idHotelService);
            }
        }
        System.out.println(ERROR_READ_SERVICE);
        return null;
    }

    @Override
    public boolean update(int idHotelService, String hotelServiceString) {
        String[] hotelServiceData = hotelServiceString.split(";");
        String typeOfService = hotelServiceData[0]; // EDIT and PUT correct index
        switch (typeOfService){
            case "RoomReservation" -> serviceRoomReservation.update(idHotelService, hotelServiceString);
            case "Restaurant" -> System.out.println("CREATE ACTION FOR RESTAURANT");
            case "Transfer" -> System.out.println("CREATE ACTION FOR TRANSFER");
            default -> System.out.println("Something went wrong ...");
        }
        return true;
    }

    @Override
    public boolean delete(int idHotelService) {
        if(readAll() == null || readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_SERVICES);
            return false;
        }
        for(int i = 0; i <= readAll().size(); i++){
            if(readAll().get(i).getIdService() == idHotelService){
                return daoHotelService.delete(idHotelService);
            }
        }
        System.out.println(ERROR_READ_SERVICE);
        return false;
    }
}
