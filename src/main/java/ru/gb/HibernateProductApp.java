package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Product;

public class HibernateProductApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        for(Product product : productDao.findAll()) {
            System.out.println(product);
        }
        System.out.println(productDao.findById(6L));
        System.out.println(productDao.findNameById(7L));
    }

}
