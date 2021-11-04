package spacenews.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import spacenews.api.GetNews;
import spacenews.domain.Articles;
import spacenews.domain.AuctionAdmin;
import spacenews.util.Observer;

import java.util.Iterator;

public class StatisticsController implements Observer {

    private NewsListController newsListController;
    private Articles article;
    private GetNews getNews;

    public StatisticsController(NewsListController newsListController) {
        AuctionAdmin.getInstance().addObserver(this);
        this.newsListController = newsListController;
        labelTotal = new Label();
        labelItems = new Label();
        labelProviders = new Label();
        labelTotal.setText(String.valueOf(newsListController.getCountArticles()));
        labelItems.setText(String.valueOf(newsListController.getCountItems()));
        labelProviders.setText(String.valueOf(newsListController.getCountProvider()));
    }

    @FXML
    private Label labelItems;

    @FXML
    private Label labelProviders;

    @FXML
    private Label labelTotal;

    @Override
    public void update() {

    }

}

