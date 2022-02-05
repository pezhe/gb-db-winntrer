package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.DbConfig;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Product;

public class SpringJdbcProductApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        for (Product product : productDao.findAll()) {
            System.out.println(product);
        }

    }

}
