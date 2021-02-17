package com.icode.callcenter.clients.repository;

import com.icode.callcenter.clients.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepo extends CrudRepository<ClientEntity, Integer> {
    public List<ClientEntity> findAllByOrderByIdAsc();
}
