package pl.senla.hotel.repository;

import pl.senla.hotel.entity.Guest;

public interface RepositoryGuest extends RepositoryCRUDALL<Guest>{

    int countNumberOfGuestsTotal();

}
