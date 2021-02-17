package com.icode.callcenter.clients.repository;

import com.icode.callcenter.clients.entity.ClientEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientsRepoCustomImpl implements ClientsRepoCustom {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<ClientEntity> get(String searchText) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ClientEntity> query = currentSession.createQuery("from ClientEntity WHERE "
                        + "lower(name) LIKE lower('" + searchText +"%') OR"
                        + " lower(Phone_nbr) LIKE lower('" + searchText +"%') OR"
                        + " lower(address) LIKE lower('" + searchText +"%')"

                , ClientEntity.class);
        List<ClientEntity> list = query.getResultList();
        return list;
    }
}
