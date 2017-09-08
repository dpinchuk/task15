package controller;

import entity.BidEntity;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import repository.BidRepository;
import repository.BuyerRepository;
import repository.ProductRepository;
import service.BidService;

import java.util.stream.Collectors;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class BidAddController {

    final BidService bidService = new BidService();
    final BidRepository bidRepository = new BidRepository();
    final ProductRepository productRepository = new ProductRepository();
    final BuyerRepository buyerRepository = new BuyerRepository();

    @FXML
    TextField bidStep;
    @FXML
    TextField bidCurrent;
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
    Button buttonAddBid;
    @FXML
    ComboBox<String> comboBuyerIdList;
    @FXML
    ComboBox<String> comboProductIdList;

    @FXML
    private void initialize() {
        bidService.viewBidsTable(bidTable, bidIdColumn, bidStepColumn, bidCurrentColumn, buyerIdColumn, productIdColumn);
        this.addProductToCombo();
        this.addBuyerToCombo();
        buttonAddBid.disableProperty().bind(
                Bindings.isEmpty(bidStep.textProperty())
                        .or(Bindings.isEmpty(bidCurrent.textProperty()))
        );
    }

    @FXML
    private void addBid(ActionEvent event) {
        Integer bidStepList = Integer.parseInt(bidStep.getText());
        Integer bidCurrentList = Integer.parseInt(bidCurrent.getText());
        Integer buyerIdList = Integer.parseInt(comboBuyerIdList.getSelectionModel().getSelectedItem());
        Integer productIdList = Integer.parseInt(comboProductIdList.getSelectionModel().getSelectedItem());
        bidService.addBid(bidStepList, bidCurrentList, buyerIdList, productIdList);
        bidService.viewBidsTable(bidTable, bidIdColumn, bidStepColumn, bidCurrentColumn, buyerIdColumn, productIdColumn);
        bidStep.clear();
        bidCurrent.clear();
        comboProductIdList.getSelectionModel().clearSelection();
        comboBuyerIdList.getSelectionModel().clearSelection();
    }

    @FXML
    public void addProductToCombo() {
        comboProductIdList.setItems(
                FXCollections.observableArrayList(
                        productRepository.getProducts()
                                .stream()
                                .map(s -> String.valueOf(s.getProductId()))
                                .collect(Collectors.toList())
                )
        );
    }

    @FXML
    public void addBuyerToCombo() {
        comboBuyerIdList.setItems(
                FXCollections.observableArrayList(
                        buyerRepository.getBuyers()
                                .stream()
                                .map(s -> String.valueOf(s.getBuyerId()))
                                .collect(Collectors.toList())
                )
        );
    }

}