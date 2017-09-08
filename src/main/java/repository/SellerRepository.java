package repository;

import com.google.common.collect.Lists;
import entity.SellerEntity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class SellerRepository extends Repository {

    public void saveSeller(SellerEntity sellerEntity) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO sellers (seller_id, seller_name, seller_lastname) " +
                             "VALUES (null, ?, ?)")) {
            preparedStatement.setString(1, sellerEntity.getSellerName());
            preparedStatement.setString(2, sellerEntity.getSellerLastname());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error add!");
            log.error("Save seller error!", e);
        }
    }

    public List<SellerEntity> getSellers() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM sellers")) {
            return processResultSet(preparedStatement.executeQuery());
        } catch (SQLException e) {
            log.error("Get sellers error!", e);
        }
        return Collections.emptyList();
    }

    public void removeSeller(String id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM sellers WHERE seller_id = " + id)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error removing!");
            log.error("Remove seller error!", e);
        }
    }

    private List<SellerEntity> processResultSet(ResultSet resultSet) throws SQLException {
        List<SellerEntity> result = Lists.newArrayList();
        while (resultSet.next()) {
            result.add(SellerEntity.builder()
                    .sellerId(resultSet.getInt("seller_id"))
                    .sellerName(resultSet.getString("seller_name"))
                    .sellerLastname(resultSet.getString("seller_lastname"))
                    .build());
        }
        return result;
    }

}