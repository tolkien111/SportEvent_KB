package pl.sportevent.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class EntityTest {

    @Autowired
    protected EntityManager entityManager;

    protected void persist(Object entity){
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.clear();
    }


}
