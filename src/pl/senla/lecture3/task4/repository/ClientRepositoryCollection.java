package pl.senla.lecture3.task4.repository;

import pl.senla.lecture3.task4.entity.Client;
import pl.senla.lecture3.task4.storage.DataStorage;
import pl.senla.lecture3.task4.storage.DataStorageClient;

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
    public Client read(Client client) {
        Client clientRead = null;
        int clientId = client.getIdClient();
        for(Client c : readAll()){
            if(clientId == c.getIdClient()){
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
    public boolean delete(Client client) {
        int clientId = client.getIdClient();
        readAll().remove(clientId);
        return true;
    }
}
