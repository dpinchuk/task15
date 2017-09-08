package service;

import entity.ProductEntity;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import repository.ProductRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();

    public void addProduct(String productName, int productStartPrice, int productSalePrice, int sellerId) {
        productRepository.saveProduct(
                ProductEntity.builder()
                        .productName(productName)
                        .productStartPrice(productStartPrice)
                        .productSalePrice(productSalePrice)
                        .sellerId(sellerId)
                        .build()
        );
    }

    public void viewProductsTable(TableView<ProductEntity> productTable,
                                  TableColumn<ProductEntity, Integer> productIdColumn,
                                  TableColumn<ProductEntity, String> productNameColumn,
                                  TableColumn<ProductEntity, Integer> productStartPriceColumn,
                                  TableColumn<ProductEntity, Integer> productSalePriceColumn,
                                  TableColumn<ProductEntity, Integer> sellerIdColumn) {

        List<ProductEntity> products = productRepository.getProducts();

        productIdColumn.setCellValueFactory(new PropertyValueFactory<ProductEntity, Integer>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<ProductEntity, String>("productName"));
        productStartPriceColumn.setCellValueFactory(new PropertyValueFactory<ProductEntity, Integer>("productStartPrice"));
        productSalePriceColumn.setCellValueFactory(new PropertyValueFactory<ProductEntity, Integer>("productSalePrice"));
        sellerIdColumn.setCellValueFactory(new PropertyValueFactory<ProductEntity, Integer>("sellerId"));

        productTable.setItems(FXCollections.observableArrayList(products));
    }

}