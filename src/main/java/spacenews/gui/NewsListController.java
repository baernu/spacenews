package spacenews.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import spacenews.api.GetNews;
import spacenews.domain.Articles;
import spacenews.domain.AuctionAdmin;
import spacenews.domain.Providers;
import spacenews.util.Observer;

import java.io.IOException;
import java.util.Iterator;

public class NewsListController implements Observer {
    private  GetNews getNews;
    //private ListView list = new ListView();
    private Iterator<Articles> iterator = null;
    private NewsController newsController;
    private static int count = 1;

    @FXML
    private AnchorPane root1;

    @FXML
    private ListView<String> listView;




    /*   StringProperty header = new SimpleStringProperty();
    header


    title = "Articles";*/

    @FXML
    private HBox hBox ;

    @FXML
    public void initialize()  {


        listView = new ListView<>();
        listView.getItems().add("halllo");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


    }


    public NewsListController(GetNews getNews, NewsController newsController) throws IOException {
        this.newsController = newsController;
        this.getNews = getNews;
        iterator = getNews.getArticles().iterator();
        AuctionAdmin.getInstance().addObserver(this);
//        nextList();

    }

    private void nextList(Iterator<Articles> iterator) throws IOException {
//        title.setText(getNews.getDescription());
//        while (iterator.hasNext()) {
            String launchesId = null;
            String launchesP = null;
            String eventsId = null;
            String eventsP = null;
            Articles actualIerator = iterator.next();
            String id = "id: " + actualIerator.getId();
            String title = "title: " + actualIerator.getTitle();
            String url = "url: " + actualIerator.getUrl();
            String imageUrl = "imageUrl: " + actualIerator.getImageUrl();
            String newsSite = "newsSite: " + actualIerator.getNewsSite();
            String summary = "summary: " + actualIerator.getSummary();
            String publishedAt = "publishedAt: " + actualIerator.getPublishedAt();
            String updatedAt = "updatedAT: " + actualIerator.getUpdatedAt();
            String featured = "featured: " +actualIerator.getFeatured();
            Providers launches = actualIerator.getLaunches();
            if (launches.getId() != null) {
                launchesId = "laungches id: " + launches.getId();
                launchesP = "launches provider: " + launches.getProvider();
            }
            Providers events = actualIerator.getEvents();
            if (events.getId() != null) {
                eventsId = "events id: " + events.getId();
                eventsP = "events provider: " + events.getProvider();
            }


            listView = new ListView<>();
            listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listView.getItems().addAll(id, title, url, imageUrl, newsSite, summary, publishedAt, updatedAt, featured,
                    launchesId, launchesP, eventsId, eventsP);



            hBox = new HBox(listView);


            newsController.load(hBox);






//        }
    }

    @FXML
    void doExit(ActionEvent event) {
        ((Stage) root1.getScene().getWindow()).close();
    }

    @FXML
    void doHome(ActionEvent event) {

    }



    @FXML
    void doNext(ActionEvent event) throws IOException {
        if (iterator.hasNext()) {
            nextList(iterator);
        }

    }

    @FXML
    void doRefresh(ActionEvent event) {

    }

    @FXML
    void doStatistics(ActionEvent event) {

    }

    @Override
    public void update() {

    }
}
