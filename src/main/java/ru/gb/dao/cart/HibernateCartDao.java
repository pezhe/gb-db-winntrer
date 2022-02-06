package ru.gb.dao.cart;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Cart;

//@Repository
@RequiredArgsConstructor
public class HibernateCartDao implements CartDao {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional
    public Cart save(Cart cart) {
        sessionFactory.getCurrentSession().saveOrUpdate(cart);
        return cart;
    }
}
