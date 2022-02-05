package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.DbConfig;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Product;

public class NamedParamJdbcTemplateProductApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        for(Product product : productDao.findAll()) {
            System.out.println(product);
        }
        System.out.println(productDao.findById(4L));
        System.out.println(productDao.findNameById(5L));
    }

}
