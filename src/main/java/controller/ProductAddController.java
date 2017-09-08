package controller;

import entity.ProductEntity;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import repository.SellerRepository;
import service.ProductService;

import java.util.stream.Collectors;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ProductAddController {

    final ProductService productService = new ProductService();
    final SellerRepository sellerRepository = new SellerRepository();

    @FXML
    TextField productName;
    @FXML
    TextField productStartPrice;
    @FXML
    TextField productSalePrice;
    @FXML
    TableView<ProductEntity> productTable;
    @FXML
    TableColumn<ProductEntity, Integer> productIdColumn;
    @FXML
    TableColumn<ProductEntity, String> productNameColumn;
    @FXML
    TableColumn<ProductEntity, Integer> productStartPriceColumn;
    @FXML
    TableColumn<ProductEntity, Integer> productSalePriceColumn;
    @FXML
    TableColumn<ProductEntity, Integer> sellerIdColumn;
    @FXML
    Button buttonAddProduct;

    @FXML
    private void initialize() {
        productService.viewProductsTable(productTable, productIdColumn, productNameColumn, productStartPriceColumn, productSalePriceColumn, sellerIdColumn);
        addToCombo();
        buttonAddProduct.disableProperty().bind(
                Bindings.isEmpty(productName.textProperty())
                        .or(Bindings.isEmpty(productStartPrice.textProperty()))
                        .or(Bindings.isEmpty(productSalePrice.textProperty()))
        );
    }

    @FXML
    private void addProduct(ActionEvent event) {
        String productNameList = productName.getText();
        Integer productStartPriceList = Integer.parseInt(productStartPrice.getText());
        Integer productSalePriceList = Integer.parseInt(productSalePrice.getText());
        Integer sellerIdList = Integer.parseInt(comboSellerIdList.getSelectionModel().getSelectedItem());
        productService.addProduct(productNameList, productStartPriceList, productSalePriceList, sellerIdList);
        productService.viewProductsTable(productTable, productIdColumn, productNameColumn, productStartPriceColumn, productSalePriceColumn, sellerIdColumn);
        productName.clear();
        productStartPrice.clear();
        productSalePrice.clear();
        comboSellerIdList.getSelectionModel().clearSelection();
    }

    @FXML
    ComboBox<String> comboSellerIdList;

    @FXML
    private void addToCombo() {
        comboSellerIdList.setItems(
                FXCollections.observableArrayList(
                        sellerRepository.getSellers()
                                .stream()
                                .map(s -> String.valueOf(s.getSellerId()))
                                .collect(Collectors.toList())
                )
        );
    }

}