package spacenews.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StatisticsController {

    private final NewsListController newsListController;

    StringProperty totalArticles = new SimpleStringProperty("0");
    StringProperty totalItems = new SimpleStringProperty("0");
    StringProperty totalProviders = new SimpleStringProperty("0");

    public StatisticsController(NewsListController newsListController) {
        this.newsListController = newsListController;

    }

    @FXML
    private TextField items;

    @FXML
    private TextField providers;

    @FXML
    private TextField total;



    @FXML
    public void initialize() {
        totalArticles.setValue(String.valueOf(newsListController.getCountArticles()));
        totalItems.setValue(String.valueOf(newsListController.getCountItems()));

        total.textProperty().bindBidirectional(totalArticles);
        items.textProperty().bind(totalItems);
        totalProviders.setValue(String.valueOf(newsListController.getCountProvider()));
        providers.textProperty().bind(totalProviders);

    }

}

