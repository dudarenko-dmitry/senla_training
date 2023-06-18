package pl.senla.hotel.controller;

import pl.senla.hotel.service.ClientService;
import pl.senla.hotel.entity.Client;
import pl.senla.hotel.service.Service;

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
        return clientService.read(id);
    }

    @Override
    public boolean update(Client client) {
        return clientService.update(client);
    }

    @Override
    public boolean delete(int id) {
        return clientService.delete(id);
    }
}
