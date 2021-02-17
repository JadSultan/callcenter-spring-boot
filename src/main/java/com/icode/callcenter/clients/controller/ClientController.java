package com.icode.callcenter.clients.controller;


import com.icode.callcenter.clients.entity.ClientEntity;
import com.icode.callcenter.clients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin("http://localhost:3000")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<ClientEntity> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/clients")
    public ResponseEntity addClient(@RequestBody ClientEntity clientEntityObj){
        try{
            return ResponseEntity.ok(clientService.addClient(clientEntityObj));

        } catch(ConstraintViolationException ex){
            return ResponseEntity.badRequest().body("Invalid Enity");
        }
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity getClient(@PathVariable int id){
        try{
            return ResponseEntity.ok(clientService.getClient(id));
        }catch(NoSuchElementException ex) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/clients/search/{searchText}")
    public List<ClientEntity> get(@PathVariable String searchText){
        return clientService.get(searchText);
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable int id){
        clientService.deleteClient(id);
        return "Client Deleted from DB id: " + id;
    }

    @PutMapping("/clients")
    public ResponseEntity updateClient(@RequestBody ClientEntity clientEntityObj){
        try{
            return ResponseEntity.ok(clientService.updateClient(clientEntityObj));
        } catch(ConstraintViolationException ex){
            return ResponseEntity.badRequest().body("Invalid Enity");
        }
    }
}
