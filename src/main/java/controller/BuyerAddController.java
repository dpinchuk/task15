package controller;

import entity.BuyerEntity;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import service.BuyerService;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class BuyerAddController {

    final BuyerService buyerService = new BuyerService();

    @FXML
    TextField buyerName;
    @FXML
    TextField buyerLastname;
    @FXML
    TableView<BuyerEntity> buyerTable;
    @FXML
    TableColumn<BuyerEntity, Integer> buyerIdColumn;
    @FXML
    TableColumn<BuyerEntity, String> buyerNameColumn;
    @FXML
    TableColumn<BuyerEntity, String> buyerLastnameColumn;
    @FXML
    Button buttonAddBuyer;

    @FXML
    private void initialize() {
        buyerService.viewBuyersTable(buyerTable, buyerIdColumn, buyerNameColumn, buyerLastnameColumn);
        buttonAddBuyer.disableProperty().bind(
                Bindings.isEmpty(buyerName.textProperty())
                        .or(Bindings.isEmpty(buyerLastname.textProperty()))
        );
    }

    @FXML
    private void addBuyer(ActionEvent event) {
        String buyerNameList = buyerName.getText();
        String buyerLastnameList = buyerLastname.getText();
        buyerService.addBuyer(buyerNameList, buyerLastnameList);
        buyerService.viewBuyersTable(buyerTable, buyerIdColumn, buyerNameColumn, buyerLastnameColumn);
        buyerName.clear();
        buyerLastname.clear();
    }

}