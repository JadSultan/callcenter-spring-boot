package com.icode.callcenter.clients.service;


import com.icode.callcenter.clients.entity.ClientEntity;

import java.util.List;

public interface ClientService {
    List<ClientEntity> getAllClients();
    
    List<ClientEntity> get(String searchText);
    
    ClientEntity getClient(int id);
    
    ClientEntity addClient(ClientEntity clientEntity);

    ClientEntity updateClient(ClientEntity clientEntity);

    void deleteClient(int id);
}
