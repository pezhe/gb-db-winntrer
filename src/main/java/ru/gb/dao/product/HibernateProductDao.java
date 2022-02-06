package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import java.util.List;

//@Repository
@RequiredArgsConstructor
public class HibernateProductDao implements ProductDao {

    private final SessionFactory sessionFactory;

    @Override
    public Product findById(Long id) {
        //return sessionFactory.getCurrentSession().createQuery("from Product p");
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product p").list();
    }
}
