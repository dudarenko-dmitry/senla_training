package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.repository.RepositoryHotelService;
import pl.senla.hotel.repository.RepositoryHotelServiceCollection;

import java.util.Collections;
import java.util.List;

import static pl.senla.hotel.constant.HotelServieConstant.*;

public class ServiceHotelServiceImpl implements ServiceHotelService{

    private static ServiceHotelService serviceHotelService;
    private final ServiceRoomReservation serviceRoomReservation;
    private final RepositoryHotelService repositoryHotelService;

    private ServiceHotelServiceImpl() {
        this.serviceRoomReservation = ServiceRoomReservationImpl.getServiceRoomReservation();
        this.repositoryHotelService = RepositoryHotelServiceCollection.getRepositoryHotelService();
    }

    public static ServiceHotelService getServiceHotelService(){
        if(serviceHotelService == null){
            serviceHotelService = new ServiceHotelServiceImpl();
            System.out.println("Service layer for Hotel's Services was created.");
        }
        return serviceHotelService;
    }

    @Override
    public List<HotelService> readAll() {
        if(repositoryHotelService.readAll() == null || repositoryHotelService.readAll().isEmpty()){
            System.out.println(ERROR_READ_ALL_SERVICES);
            return Collections.emptyList();
        }
        return repositoryHotelService.readAll();
    }

    @Override
    public boolean create(String hotelServiceString) {
        String[] hotelServiceData = hotelServiceString.split(";");
        String typeOfService = hotelServiceData[10]; // EDIT and PUT correct index
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
                return repositoryHotelService.read(idHotelService);
            }
        }
        System.out.println(ERROR_READ_SERVICE);
        return null;
    }

    @Override
    public boolean update(int idHotelService, String hotelServiceString) {
        String[] hotelServiceData = hotelServiceString.split(";");
        String typeOfService = hotelServiceData[10]; // EDIT and PUT correct index
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
                return repositoryHotelService.delete(idHotelService);
            }
        }
        System.out.println(ERROR_READ_SERVICE);
        return false;
    }

//    private void setIdHotelServiceNew(HotelService hotelService) {
//        int lastId = readAll()
//                .stream()
//                .map(HotelService::getIdService)
//                .max(Comparator.comparingInt(o -> o))
//                .orElse(-1);
//        hotelService.setIdService(lastId + 1);
//    }
}
