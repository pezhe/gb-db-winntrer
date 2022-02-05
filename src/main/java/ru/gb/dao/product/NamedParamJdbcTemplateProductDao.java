package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//@Component
@RequiredArgsConstructor
public class NamedParamJdbcTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private Product productMapping(ResultSet rs) throws SQLException {
        return Product.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .cost(rs.getBigDecimal("cost"))
                .date(rs.getDate("manufacture_date").toLocalDate())
                .build();
    }

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, (rs, rn) -> productMapping(rs));
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM product WHERE id = :productId;";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.query(sql, namedParameters, (rs) -> {
            rs.next();
            return productMapping(rs);});
    }

    @Override
    public String findNameById(Long id) {
        String sql = "SELECT title FROM product where id = :productId";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

}
