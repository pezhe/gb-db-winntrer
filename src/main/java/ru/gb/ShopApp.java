package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.ManufacturerDao;

public class ShopApp {

    public static void main(String[] args) {
//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//        for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        CartDao cartDao = context.getBean(CartDao.class);
//        System.out.println(manufacturerDao.findById(3L));
//        System.out.println(manufacturerDao.findNameById(5L));
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }
//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }
//        Manufacturer testManufacturer = Manufacturer.builder()
//                .name("Test")
//                .products(new HashSet<>(productDao.findAll().subList(1, 5)))
//                .build();
//        System.out.println(testManufacturer);
//        Manufacturer savedManufacturer = manufacturerDao.save(testManufacturer);
//        System.out.println(savedManufacturer);
//        Product product = productDao.findAll().get(5);
//        Cart cart = Cart.builder().products(Set.of(product)).build();
//        cartDao.save(cart);

    }
}
