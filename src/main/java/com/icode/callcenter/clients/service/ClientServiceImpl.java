package com.icode.callcenter.clients.service;


import com.icode.callcenter.clients.entity.ClientEntity;
import com.icode.callcenter.clients.repository.ClientRepo;
import com.icode.callcenter.clients.repository.ClientsRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ClientsRepoCustom clientsRepoCustom;

    @Override
    public List<ClientEntity> getAllClients() {
        List<ClientEntity> clients = new ArrayList<>();
        clientRepo.findAllByOrderByIdAsc().forEach(clients::add);
        return clients;
    }
    
    @Override
    public ClientEntity getClient(int id) {
        return clientRepo.findById(id).get();
    }
    
    @Override
    public List<ClientEntity> get(String searchText) {
        return clientsRepoCustom.get(searchText);
    }
    
    @Override
    public ClientEntity addClient(ClientEntity clientEntity) {
        try {
            return clientRepo.save(clientEntity);
        }catch(ConstraintViolationException ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
    }

    @Override
    public ClientEntity updateClient(ClientEntity clientEntity) {
        try {
            return clientRepo.save(clientEntity);
        }catch(ConstraintViolationException ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
    }

    @Override
    public void deleteClient(int id) {
        clientRepo.deleteById(id);
    }
    
}
