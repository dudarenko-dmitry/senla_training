package pl.senla.hotel.service;

import pl.senla.hotel.entity.Client;
import pl.senla.hotel.repository.ClientRepositoryCollection;
import pl.senla.hotel.repository.Repository;

import java.util.List;

import static pl.senla.hotel.constant.ClientConstant.*;

public class ClientService implements Service<Client> {

    private final Repository<Client> clientRepository = new ClientRepositoryCollection();


    @Override
    public List<Client> readAll() {
        if(clientRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
        }
        return clientRepository.readAll();
    }

    @Override
    public boolean create(Client client) {
        if(clientRepository.read(client.getIdClient()) != null){
            System.out.println(ERROR_CREATE_CLIENT);
            return false;
        }
        return clientRepository.create(client);
    }

    @Override
    public Client read(int id) {
        if(clientRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return null;
        } else if(clientRepository.read(id) == null){
            System.out.println(ERROR_READ_CLIENT);
            return null;
        }
        return clientRepository.read(id);
    }

    @Override
    public boolean update(Client client) {
        if(clientRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(clientRepository.read(client.getIdClient()) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return clientRepository.update(client);
    }

    @Override
    public boolean delete(int id) {
        if(clientRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(clientRepository.read(id) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return clientRepository.delete(id);
    }
}
