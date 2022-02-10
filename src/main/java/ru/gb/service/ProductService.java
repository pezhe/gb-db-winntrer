package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;
import ru.gb.entity.enums.Status;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductDao productDao;

    public Product save(Product product) {
        return productDao.save(product);
    }

    @Transactional
    public Product findById(Long id) {
        return productDao.findById(id).get();
    }

    public List<Product> findAllActive() {
        return productDao.findAllByStatus(Status.ACTIVE);
    }

    public void disableById(Long id) {
        productDao.findById(id).ifPresent(
                p -> {
                    p.setStatus(Status.DISABLE);
                    productDao.save(p);
                }
        );
    }

    public List<Product> findAllActive(int page, int size) {
        return productDao.findAllByStatus(Status.ACTIVE, PageRequest.of(page, size));
    }

    public List<Product> findAllActiveSortedById(Sort.Direction direction) {
        return productDao.findAllByStatus(Status.ACTIVE, Sort.by(direction, "id"));
    }

    public List<Product> findAllActiveSortedById(int page, int size, Sort.Direction direction) {
        return productDao.findAllByStatus(Status.ACTIVE, PageRequest.of(page, size, Sort.by(direction, "id")));
    }

}
