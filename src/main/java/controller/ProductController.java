package controller;

import entity.ProductEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import repository.ProductRepository;
import repository.SellerRepository;
import service.ProductService;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ProductController {

    final ProductService productService = new ProductService();
    final SellerRepository sellerRepository = new SellerRepository();
    final ProductRepository productRepository = new ProductRepository();

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
    Button buttonProductDelete = new Button();

    @FXML
    private void initialize() {
        productService.viewProductsTable(productTable, productIdColumn, productNameColumn, productStartPriceColumn, productSalePriceColumn, sellerIdColumn);
        buttonProductDelete.disableProperty().bind(productTable
                .getSelectionModel()
                .selectedItemProperty()
                .isNull());
    }

    @FXML
    private void removeProduct(ActionEvent actionEvent) {
        int row = productTable.getSelectionModel().getSelectedIndex();
        productTable.getItems().remove(row);
        productRepository.removeProduct(String.valueOf(productRepository.getProducts().get(row).getProductId()));
    }

}