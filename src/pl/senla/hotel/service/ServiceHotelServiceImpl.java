package pl.senla.hotel.service;

import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.repository.RepositoryHotelService;
import pl.senla.hotel.repository.RepositoryHotelServiceCollection;

import java.util.List;

import static pl.senla.hotel.constant.HotelServieConstant.*;

public class ServiceHotelServiceImpl implements ServiceHotelService{

    private static ServiceHotelService serviceHotelService;
    private final ServiceRoomReservation serviceRoomReservation;
    private final RepositoryHotelService repositoryHotelService;

    private ServiceHotelServiceImpl() {
        this.serviceRoomReservation = new ServiceRoomReservationImpl();
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
    public HotelService read(int id) {
        HotelService hs = readAll()
                .stream()
                .filter(o -> o.getIdService() == id)
                .findFirst()
                .orElse(null);
        if(hs != null) {
            int index = hs.getIdService();
            return repositoryHotelService.read(index);
        }
        System.out.println(ERROR_READ_SERVICE);
        return null;
    }

    @Override
    public boolean update(int id, String hotelServiceString) {
        String[] hotelServiceData = hotelServiceString.split(";");
        String typeOfService = hotelServiceData[10]; // EDIT and PUT correct index
        switch (typeOfService){
            case "RoomReservation" -> serviceRoomReservation.update(id, hotelServiceString);
            case "Restaurant" -> System.out.println("CREATE ACTION FOR RESTAURANT");
            case "Transfer" -> System.out.println("CREATE ACTION FOR TRANSFER");
            default -> System.out.println("Something went wrong ...");
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        HotelService hs = readAll()
                .stream()
                .filter(o -> o.getIdService() == id)
                .findFirst()
                .orElse(null);
        if(hs != null) {
            int index = hs.getIdService();
            return repositoryHotelService.delete(index);        }
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
