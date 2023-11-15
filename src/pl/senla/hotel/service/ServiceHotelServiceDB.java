package pl.senla.hotel.service;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.dao.GenericDao;
import pl.senla.hotel.entity.services.HotelService;

import java.lang.reflect.InvocationTargetException;
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
        List<HotelService> hotelServiceList = daoHotelService.readAll();
        if(hotelServiceList.isEmpty()){
            System.out.println(READ_ALL_SERVICES_IS_EMPTY);
        }
        return hotelServiceList;
    }

    @Override
    public boolean create(String hotelServiceString) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        return serviceRoomReservation.create(hotelServiceString);
    }

    @Override
    public HotelService read(int idHotelService) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        HotelService hotelService = daoHotelService.read(idHotelService);
        if(hotelService == null){
            System.out.println(SERVICE_NOT_EXISTS);
        }
        return hotelService;
    }

    @Override
    public boolean update(int idHotelService, String hotelServiceString) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (read(idHotelService) == null) {
            System.out.println(READ_ALL_SERVICES_IS_EMPTY);
            }
        return serviceRoomReservation.update(idHotelService, hotelServiceString);
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
