package controller;

import entity.SellerEntity;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import service.SellerService;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class SellerAddController {

    final SellerService sellerService = new SellerService();

    @FXML
    TextField sellerName;
    @FXML
    TextField sellerLastname;
    @FXML
    TableView<SellerEntity> sellerTable;
    @FXML
    TableColumn<SellerEntity, Integer> sellerIdColumn;
    @FXML
    TableColumn<SellerEntity, String> sellerNameColumn;
    @FXML
    TableColumn<SellerEntity, String> sellerLastnameColumn;
    @FXML
    Button buttonAddSeller;

    @FXML
    private void initialize() {
        sellerService.viewSellersTable(sellerTable, sellerIdColumn, sellerNameColumn, sellerLastnameColumn);
        buttonAddSeller.disableProperty().bind(
                Bindings.isEmpty(sellerName.textProperty())
                        .or(Bindings.isEmpty(sellerLastname.textProperty()))
        );
    }

    @FXML
    private void addSeller(ActionEvent event) {
        String sellerNameList = sellerName.getText();
        String sellerLastnameList = sellerLastname.getText();
        sellerService.addSeller(sellerNameList, sellerLastnameList);
        sellerService.viewSellersTable(sellerTable, sellerIdColumn, sellerNameColumn, sellerLastnameColumn);
        sellerName.clear();
        sellerLastname.clear();
    }

}