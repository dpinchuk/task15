package controller;

import entity.BuyerEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import repository.BuyerRepository;
import service.BuyerService;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class BuyerController {

    final BuyerService buyerService = new BuyerService();
    final BuyerRepository buyerRepository = new BuyerRepository();

    @FXML
    TableView<BuyerEntity> buyerTable;
    @FXML
    TableColumn<BuyerEntity, Integer> buyerIdColumn;
    @FXML
    TableColumn<BuyerEntity, String> buyerNameColumn;
    @FXML
    TableColumn<BuyerEntity, String> buyerLastnameColumn;
    @FXML
    Button buttonBuyerDelete = new Button();

    @FXML
    private void initialize() {
        buyerService.viewBuyersTable(buyerTable, buyerIdColumn, buyerNameColumn, buyerLastnameColumn);
        buttonBuyerDelete.disableProperty().bind(buyerTable
                .getSelectionModel()
                .selectedItemProperty()
                .isNull());
    }

    @FXML
    public void removeBuyer(ActionEvent actionEvent) {
        int row = buyerTable.getSelectionModel().getSelectedIndex();
        buyerTable.getItems().remove(row);
        buyerRepository.removeBuyer(String.valueOf(buyerRepository.getBuyers().get(row).getBuyerId()));
    }

}