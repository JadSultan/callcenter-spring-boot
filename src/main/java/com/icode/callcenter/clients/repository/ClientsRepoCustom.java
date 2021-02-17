package com.icode.callcenter.clients.repository;


import com.icode.callcenter.clients.entity.ClientEntity;

import java.util.List;

public interface ClientsRepoCustom {
    List<ClientEntity> get(String searchText);
}
