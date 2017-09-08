package repository;

import com.google.common.collect.Lists;
import entity.BuyerEntity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class BuyerRepository extends Repository {

    public void saveBuyer(BuyerEntity buyerEntity) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO buyers (buyer_id, buyer_name, buyer_lastname) " +
                             "VALUES (null, ?, ?)")) {
            preparedStatement.setString(1, buyerEntity.getBuyerName());
            preparedStatement.setString(2, buyerEntity.getBuyerLastname());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error add!");
            log.error("Save buyer error!", e);
        }
    }

    public List<BuyerEntity> getBuyers() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM buyers")) {
            return processResultSet(preparedStatement.executeQuery());
        } catch (SQLException e) {
            log.error("Get buyers error!", e);
        }
        return Collections.emptyList();
    }

    public void removeBuyer(String id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM buyers WHERE buyer_id = " + id)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error removing!");
            log.error("Remove buyer error!", e);
        }
    }

    private List<BuyerEntity> processResultSet(ResultSet resultSet) throws SQLException {
        List<BuyerEntity> result = Lists.newArrayList();
        while (resultSet.next()) {
            result.add(BuyerEntity.builder()
                    .buyerId(resultSet.getInt("buyer_id"))
                    .buyerName(resultSet.getString("buyer_name"))
                    .buyerLastname(resultSet.getString("buyer_lastname"))
                    .build());
        }
        return result;
    }

}
