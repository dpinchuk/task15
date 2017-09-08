package repository;

import com.google.common.collect.Lists;
import entity.BidEntity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class BidRepository extends Repository {

    public void saveBid(BidEntity bidEntity) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO bids (bid_id, bid_step, bid_current, buyer_id, product_id) " +
                             "VALUES (null, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, bidEntity.getBidStep());
            preparedStatement.setInt(2, bidEntity.getBidCurrent());
            preparedStatement.setInt(3, bidEntity.getBuyerId());
            preparedStatement.setInt(4, bidEntity.getProductId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error add!");
            log.error("Save bid error!", e);
        }
    }

    public List<BidEntity> getBids() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bids")) {
            return processResultSet(preparedStatement.executeQuery());
        } catch (SQLException e) {
            log.error("Get bids error!", e);
        }
        return Collections.emptyList();
    }

    public void removeBid(String id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM bids WHERE bid_id = " + id)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error removing!");
            log.error("Remove bid error!", e);
        }
    }

    private List<BidEntity> processResultSet(ResultSet resultSet) throws SQLException {
        List<BidEntity> result = Lists.newArrayList();
        while (resultSet.next()) {
            result.add(BidEntity.builder()
                    .bidId(resultSet.getInt("bid_id"))
                    .bidStep(resultSet.getInt("bid_step"))
                    .bidCurrent(resultSet.getInt("bid_current"))
                    .buyerId(resultSet.getInt("buyer_id"))
                    .productId(resultSet.getInt("product_id"))
                    .build());
        }
        return result;
    }

}