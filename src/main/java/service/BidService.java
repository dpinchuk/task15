package service;

import entity.BidEntity;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import repository.BidRepository;

import java.util.List;

public class BidService {

    private final BidRepository bidRepository = new BidRepository();

    public void addBid(int bidStep, int bidCurrent, int buyerId, int productId) {
        bidRepository.saveBid(
                BidEntity.builder()
                        .bidStep(bidStep)
                        .bidCurrent(bidCurrent)
                        .buyerId(buyerId)
                        .productId(productId)
                        .build()
        );
    }

    public void viewBidsTable(TableView<BidEntity> bidTable,
                              TableColumn<BidEntity, Integer> bidIdColumn,
                              TableColumn<BidEntity, Integer> bidStepColumn,
                              TableColumn<BidEntity, Integer> bidCurrentColumn,
                              TableColumn<BidEntity, Integer> buyerIdColumn,
                              TableColumn<BidEntity, Integer> productIdColumn) {
        List<BidEntity> bids = bidRepository.getBids();

        bidIdColumn.setCellValueFactory(new PropertyValueFactory<BidEntity, Integer>("bidId"));
        bidStepColumn.setCellValueFactory(new PropertyValueFactory<BidEntity, Integer>("bidStep"));
        bidCurrentColumn.setCellValueFactory(new PropertyValueFactory<BidEntity, Integer>("bidCurrent"));
        buyerIdColumn.setCellValueFactory(new PropertyValueFactory<BidEntity, Integer>("buyerId"));
        productIdColumn.setCellValueFactory(new PropertyValueFactory<BidEntity, Integer>("productId"));

        bidTable.setItems(FXCollections.observableArrayList(bids));
    }

}