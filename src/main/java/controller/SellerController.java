package controller;

import entity.SellerEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import repository.SellerRepository;
import service.SellerService;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class SellerController {

    final SellerService sellerService = new SellerService();
    final SellerRepository sellerRepository = new SellerRepository();

    @FXML
    TableView<SellerEntity> sellerTable;
    @FXML
    TableColumn<SellerEntity, Integer> sellerIdColumn;
    @FXML
    TableColumn<SellerEntity, String> sellerNameColumn;
    @FXML
    TableColumn<SellerEntity, String> sellerLastnameColumn;
    @FXML
    Button buttonSellerDelete = new Button();

    @FXML
    private void initialize() {
        sellerService.viewSellersTable(sellerTable, sellerIdColumn, sellerNameColumn, sellerLastnameColumn);
        buttonSellerDelete.disableProperty().bind(sellerTable
                .getSelectionModel()
                .selectedItemProperty()
                .isNull());
    }

    @FXML
    public void removeSeller(ActionEvent actionEvent) {
        int row = sellerTable.getSelectionModel().getSelectedIndex();
        sellerTable.getItems().remove(row);
        sellerRepository.removeSeller(String.valueOf(sellerRepository.getSellers().get(row).getSellerId()));
    }

}