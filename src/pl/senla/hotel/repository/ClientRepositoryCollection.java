package pl.senla.hotel.repository;

import pl.senla.hotel.entity.Client;
import pl.senla.hotel.storage.DataStorage;
import pl.senla.hotel.storage.DataStorageClient;

import java.util.List;

public class ClientRepositoryCollection implements Repository<Client> {

    private final DataStorage<Client> dataStorage = new DataStorageClient();

    @Override
    public List<Client> readAll() {
        return dataStorage.getDataList();
    }

    @Override
    public boolean create(Client client) {
        readAll().add(client);
        return true;
    }

    @Override
    public Client read(int id) {
        Client clientRead = null;
        for(Client c : readAll()){
            if(id == c.getIdClient()){
                clientRead = c;
            }
        }
        return clientRead;
    }

    @Override
    public boolean update(Client client) {
        int clientId = client.getIdClient();
        readAll().set(clientId, client);
        return true;
    }

    @Override
    public boolean delete(int id) {
        readAll().remove(id);
        return true;
    }
}