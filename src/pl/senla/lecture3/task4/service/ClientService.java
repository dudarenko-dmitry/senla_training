package pl.senla.lecture3.task4.service;

import pl.senla.lecture3.task4.entity.Client;
import pl.senla.lecture3.task4.repository.ClientRepositoryCollection;
import pl.senla.lecture3.task4.repository.Repository;

import java.util.List;

import static pl.senla.lecture3.task4.constant.ClientConstant.*;

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
        if(clientRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(clientRepository.read(client) != null){
            System.out.println(ERROR_CREATE_CLIENT);
            return false;
        }
        return clientRepository.create(client);
    }

    @Override
    public Client read(Client client) {
        if(clientRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
        } else if(clientRepository.read(client) == null){
            System.out.println(ERROR_READ_CLIENT);
        }
        return clientRepository.read(client);
    }

    @Override
    public boolean update(Client client) {
        if(clientRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(clientRepository.read(client) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return clientRepository.update(client);
    }

    @Override
    public boolean delete(Client client) {
        if(clientRepository.readAll() == null){
            System.out.println(ERROR_READ_ALL_CLIENT);
            return false;
        } else if(clientRepository.read(client) == null){
            System.out.println(ERROR_READ_CLIENT);
            return false;
        }
        return clientRepository.delete(client);
    }
}
