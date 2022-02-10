package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import ru.gb.config.JpaConfig;
import ru.gb.service.ProductService;

public class ShopApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        ProductService productService = context.getBean(ProductService.class);
        System.out.println(productService.findAllActiveSortedById(0, 5, Sort.Direction.DESC));
//        productService.disableById(104L);
//        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
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
//        Product product = Product.builder()
//                .title("Shrimp")
//                .cost(new BigDecimal(500))
//                .date(LocalDate.now())
//                .manufacturer(manufacturerDao.findById(2L).get())
//                .build();
    }
}
