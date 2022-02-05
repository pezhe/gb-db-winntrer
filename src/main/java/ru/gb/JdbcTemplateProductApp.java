package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.DbConfig;
import ru.gb.dao.product.ProductDao;

public class JdbcTemplateProductApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        System.out.println(productDao.findNameById(3L));
    }

}
