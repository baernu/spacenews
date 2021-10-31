package spacenews.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import spacenews.domain.Auction;
import spacenews.domain.AuctionAdmin;
import spacenews.util.Observer;

import java.time.format.DateTimeFormatter;

public class NewsController implements Observer {

    @FXML
    private AnchorPane root;
    
    @FXML
    private Button articles;

    @FXML
    private Button blogs;

    @FXML
    private Button exitHome;

    @FXML
    private Button language;

    @FXML
    private Button links;

    @FXML
    private Button reports;

    @FXML
    public void initialize() {
        AuctionAdmin.getInstance().addObserver(this);
    }

    @FXML
    void exit(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    void goToArticles(ActionEvent event) {

    }

    @FXML
    void goToBlogs(ActionEvent event) {

    }

    @FXML
    void goToLinks(ActionEvent event) {

    }

    @FXML
    void goToReports(ActionEvent event) {

    }

    @FXML
    void setLanguage(ActionEvent event) {

    }

    @Override
    public void update() {

    }
}
