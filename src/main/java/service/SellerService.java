package service;

import entity.SellerEntity;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import repository.SellerRepository;

import java.util.List;

public class SellerService {

    private final SellerRepository sellerRepository = new SellerRepository();

    public void addSeller(String sellerName, String sellerLastname) {
        sellerRepository.saveSeller(
                SellerEntity.builder()
                        .sellerName(sellerName)
                        .sellerLastname(sellerLastname)
                        .build()
        );
    }

    public void viewSellersTable(TableView<SellerEntity> sellerTable,
                                 TableColumn<SellerEntity, Integer> sellerIdColumn,
                                 TableColumn<SellerEntity, String> sellerNameColumn,
                                 TableColumn<SellerEntity, String> sellerLastnameColumn) {

        List<SellerEntity> sellers = sellerRepository.getSellers();

        sellerIdColumn.setCellValueFactory(new PropertyValueFactory<SellerEntity, Integer>("sellerId"));
        sellerNameColumn.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("sellerName"));
        sellerLastnameColumn.setCellValueFactory(new PropertyValueFactory<SellerEntity, String>("sellerLastname"));

        sellerTable.setItems(FXCollections.observableArrayList(sellers));
    }

}