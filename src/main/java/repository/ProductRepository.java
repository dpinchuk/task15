package repository;

import com.google.common.collect.Lists;
import entity.ProductEntity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ProductRepository extends Repository {

    public void saveProduct(ProductEntity productEntity) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO products (product_id, product_name, product_start_price, product_sale_price, seller_id) " +
                             "VALUES (null, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, productEntity.getProductName());
            preparedStatement.setInt(2, productEntity.getProductStartPrice());
            preparedStatement.setInt(3, productEntity.getProductSalePrice());
            preparedStatement.setInt(4, productEntity.getSellerId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error adding!");
            log.error("Save product error!", e);
        }
    }

    public List<ProductEntity> getProducts() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products")) {
            return processResultSet(preparedStatement.executeQuery());
        } catch (SQLException e) {
            log.error("Get products error!", e);
        }
        return Collections.emptyList();
    }

    public void removeProduct(String id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE product_id = " + id)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error removing!");
            log.error("Remove product error!", e);
        }
    }

    private List<ProductEntity> processResultSet(ResultSet resultSet) throws SQLException {
        List<ProductEntity> result = Lists.newArrayList();
        while (resultSet.next()) {
            result.add(ProductEntity.builder()
                    .productId(resultSet.getInt("product_id"))
                    .productName(resultSet.getString("product_name"))
                    .productStartPrice(resultSet.getInt("product_start_price"))
                    .productSalePrice(resultSet.getInt("product_sale_price"))
                    .sellerId(resultSet.getInt("seller_id"))
                    .build());
        }
        return result;
    }

}