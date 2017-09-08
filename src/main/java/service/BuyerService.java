package service;

import entity.BuyerEntity;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import repository.BuyerRepository;

import java.util.List;

public class BuyerService {

    private final BuyerRepository buyerRepository = new BuyerRepository();

    public void addBuyer(String buyerName, String buyerLastname) {
        buyerRepository.saveBuyer(
                BuyerEntity.builder()
                        .buyerName(buyerName)
                        .buyerLastname(buyerLastname)
                        .build()
        );
    }

    public void viewBuyersTable(TableView<BuyerEntity> buyerTable,
                                TableColumn<BuyerEntity, Integer> buyerIdColumn,
                                TableColumn<BuyerEntity, String> buyerNameColumn,
                                TableColumn<BuyerEntity, String> buyerLastnameColumn) {

        List<BuyerEntity> buyers = buyerRepository.getBuyers();

        buyerIdColumn.setCellValueFactory(new PropertyValueFactory<BuyerEntity, Integer>("buyerId"));
        buyerNameColumn.setCellValueFactory(new PropertyValueFactory<BuyerEntity, String>("buyerName"));
        buyerLastnameColumn.setCellValueFactory(new PropertyValueFactory<BuyerEntity, String>("buyerLastname"));

        buyerTable.setItems(FXCollections.observableArrayList(buyers));
    }

}