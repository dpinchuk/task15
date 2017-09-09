package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import repository.BidRepository;

import java.io.IOException;

@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class MainController {

    final BidRepository bidRepository = new BidRepository();
    private FXMLLoader fxmlLoader;

    @FXML
    Button buttonClose;

    @FXML
    private void handleProductItemAdd(ActionEvent actionEvent) throws IOException {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/productAdd.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add new Product");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[PRODUCTS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleSellerItemAdd(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/sellerAdd.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add new Seller");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[SELLERS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleBuyerItemAdd(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/buyerAdd.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add new Buyer");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[BUYERS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleBidItemAdd(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/bidAdd.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add new Bid");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[BIDS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleProductItemView(ActionEvent event) throws IOException {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/productView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("View Products");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("[PRODUCTS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleSellerItemView(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/sellerView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("View Sellers");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[SELLERS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleBuyerItemView(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/buyerView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("View Buyers");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[BUYERS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleBidItemView(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/bidView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("View Bids");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[BIDS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleProductItemDelete(ActionEvent actionEvent) throws IOException {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/productDelete.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete a Product");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[PRODUCTS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleSellerItemDelete(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/sellerDelete.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete a Seller");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[SELLERS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleBuyerItemDelete(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/buyerDelete.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete a Buyer");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[BUYERS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleBidItemDelete(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/bidDelete.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete a Bid");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[BIDS] Can't to open new Window!");
        }
    }

    @FXML
    private void handleLeaveMenuItemAction(ActionEvent actionEvent) {
        if (bidRepository.getBids().size() > 0) {
            try {
                fxmlLoader = new FXMLLoader(getClass().getResource("/noExit.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("No leave");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                System.out.println("[BIDS] Can't to open new Window!");
            }
        } else {
            System.exit(0);
        }
    }

    @FXML
    private void handleHelpAction(ActionEvent actionEvent) {
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/about.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("About");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("[HELP] Can't to open new Window!");
        }
    }

    @FXML
    private void handleCloseWindowAction(ActionEvent actionEvent) {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleCloseMenuItemAction(ActionEvent actionEvent) {
        System.exit(0);
    }

}