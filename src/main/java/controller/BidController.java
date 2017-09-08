package controller;

import entity.BidEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import repository.BidRepository;
import service.BidService;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class BidController {

    final BidService bidService = new BidService();
    final BidRepository bidRepository = new BidRepository();

    @FXML
    TableView<BidEntity> bidTable;
    @FXML
    TableColumn<BidEntity, Integer> bidIdColumn;
    @FXML
    TableColumn<BidEntity, Integer> bidStepColumn;
    @FXML
    TableColumn<BidEntity, Integer> bidCurrentColumn;
    @FXML
    TableColumn<BidEntity, Integer> buyerIdColumn;
    @FXML
    TableColumn<BidEntity, Integer> productIdColumn;
    @FXML
    Button buttonBidDelete = new Button();

    @FXML
    private void initialize() {
        bidService.viewBidsTable(bidTable, bidIdColumn, bidStepColumn, bidCurrentColumn, buyerIdColumn, productIdColumn);
        buttonBidDelete.disableProperty().bind(bidTable
                .getSelectionModel()
                .selectedItemProperty()
                .isNull());
    }

    @FXML
    public void removeBid(ActionEvent actionEvent) {
        int row = bidTable.getSelectionModel().getSelectedIndex();
        bidTable.getItems().remove(row);
        bidRepository.removeBid(String.valueOf(bidRepository.getBids().get(row).getBidId()));
    }

}