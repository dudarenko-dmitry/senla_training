package pl.senla.lecture3.task4.controller;

import pl.senla.lecture3.task4.entity.Client;
import pl.senla.lecture3.task4.service.ClientService;
import pl.senla.lecture3.task4.service.Service;

import java.util.List;

public class ClientController implements Controller<Client>{

    private final Service<Client> clientService = new ClientService();

    @Override
    public List<Client> readAll() {
        return clientService.readAll();
    }

    @Override
    public boolean create(Client client) {
        return clientService.create(client);
    }

    @Override
    public Client read(int id) {
        Client clientRead = new Client(id);
        return clientService.read(clientRead);
    }

    @Override
    public boolean update(Client client) {
        return clientService.update(client);
    }

    @Override
    public boolean delete(int id) {
        Client clientDeleted = new Client(id);
        return clientService.delete(clientDeleted);
    }
}
