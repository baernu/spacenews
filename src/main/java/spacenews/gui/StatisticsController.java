package spacenews.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import spacenews.api.GetNews;
import spacenews.domain.Articles;
import spacenews.domain.AuctionAdmin;
import spacenews.util.Observer;

import java.io.IOException;
import java.util.Iterator;

public class StatisticsController implements Observer {

    private NewsListController newsListController;
    private Articles article;
    private GetNews getNews;
    StringProperty totalArticles = new SimpleStringProperty("0");
    StringProperty totalItems = new SimpleStringProperty("0");
    StringProperty totalProviders = new SimpleStringProperty("0");

    public StatisticsController(NewsListController newsListController) {
        AuctionAdmin.getInstance().addObserver(this);
        this.newsListController = newsListController;
//        labelTotal = new Label();
//        labelItems = new Label();
//        labelProviders = new Label();
//        total.set(String.valueOf(newsListController.getCountArticles()));
//        items.set(String.valueOf(newsListController.getCountItems()));
//        providers.set(String.valueOf(newsListController.getCountProvider()));
//        labelTotal.textProperty().bind(total);
//        labelItems.textProperty().bind(items);
//        labelProviders.textProperty().bind(providers);
    }

    @FXML
    private TextField items;

    @FXML
    private TextField providers;

    @FXML
    private TextField total;

//    @FXML
//    private AnchorPane root;
//
//    @FXML
//    private Label labelItems;
//
//    @FXML
//    private Label labelProviders;
//
//    @FXML
//    private Label labelTotal;
//
//    @FXML
//    private HBox h1;
//
//    @FXML
//    private HBox h2;
//
//    @FXML
//    private HBox h3;

    @Override
    public void update() {

    }

    @FXML
    public void initialize() throws IOException {
        totalArticles.setValue(String.valueOf(newsListController.getCountArticles()));
        totalItems.setValue(String.valueOf(newsListController.getCountItems()));

        total.textProperty().bindBidirectional(totalArticles);
        items.textProperty().bind(totalItems);
        totalProviders.setValue(String.valueOf(newsListController.getCountProvider()));
        providers.textProperty().bind(totalProviders);

    }

}

