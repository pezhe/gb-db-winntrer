package ru.gb;

import ru.gb.dao.product.OldJdbcProductDao;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Product;

public class OldJdbcProductApp {

    public static void main(String[] args) {

        ProductDao productDao = new OldJdbcProductDao();

        for(Product product : productDao.findAll()) {
            System.out.println(product);
        }

    }

}
