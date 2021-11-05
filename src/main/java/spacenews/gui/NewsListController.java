package spacenews.gui;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import spacenews.catalog.AuctionItem;
import spacenews.catalog.ItemStatus;
import spacenews.domain.Articles;
import spacenews.domain.AuctionAdmin;
import spacenews.domain.NewsType;
import spacenews.domain.Providers;
import spacenews.util.I18n;
import spacenews.util.Observer;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;

public class NewsListController implements Observer {
    private  GetNews getNews;
    private Iterator<Articles> iterator = null;
    private NewsController newsController;
    private Articles actualIerator;
    private ListProperty<String> listProperty = new SimpleListProperty<>();
    private static int count = 1;
    private int countArticles;
    private int countItems ;
    private int countProvider = 0;

    @FXML
    private AnchorPane root1;

    @FXML
    private ListView<String> listView;



    @FXML
    private HBox hBox ;

    @FXML
    private VBox vBox;

    @FXML
    public void initialize() throws IOException {

        nextList((iterator));


    }


    public NewsListController(GetNews getNews, NewsController newsController)  {

        this.newsController = newsController;
        this.getNews = getNews;
        countArticles = getNews.getArticles().size();
        iterator = getNews.getArticles().iterator();
        AuctionAdmin.getInstance().addObserver(this);
        listView = new ListView<>();
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


    }



    private void nextList(Iterator<Articles> iterator) throws IOException {
            String launchesId = null;
            String launchesP = null;
            String eventsId = null;
            String eventsP = null;
            Providers launches = null;
            Providers events = null;
            actualIerator = iterator.next();
            String id = "id: " + actualIerator.getId();
            String title = "title: " + actualIerator.getTitle();
            String url = "url: " + actualIerator.getUrl();
            String imageUrl = "imageUrl: " + actualIerator.getImageUrl();
            String newsSite = "newsSite: " + actualIerator.getNewsSite();
            String summary = "summary: " + actualIerator.getSummary();
            String publishedAt = "publishedAt: " + actualIerator.getPublishedAt();
            String updatedAt = "updatedAT: " + actualIerator.getUpdatedAt();
            String featured = "featured: " +actualIerator.getFeatured();
            if (actualIerator.getLaunches() != null) {
                launches = actualIerator.getLaunches();
            }
            if (launches != null) {
                if (launches.getId() != null) {
                    launchesId = "laungches id: " + launches.getId();
                    launchesP = "launches provider: " + launches.getProvider();
                    countProvider++;
                }
            }

            if (actualIerator.getEvents() != null) {
                events = actualIerator.getEvents();
            }
            if (events != null) {
                if (events.getId() != null) {
                    eventsId = "events id: " + events.getId();
                    eventsP = "events provider: " + events.getProvider();
                    countProvider++;
                }
            }


        ObservableList<String> items =FXCollections.observableArrayList (
                id, title, url, imageUrl, newsSite, summary, publishedAt, updatedAt, featured,
                launchesId, launchesP, eventsId, eventsP);

            listProperty.set(items);
            listView.itemsProperty().bind(listProperty);

        countItems = items.size();


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
        NewsListController.count = 1;
        getNews.load(newsController.getNewsType());
        iterator = getNews.getArticles().iterator();

    }

    public int getCountArticles() {
        return countArticles;
    }

    public int getCountItems() {
        return countItems;
    }

    public int getCountProvider() {
        return countProvider;
    }

    @FXML
    void doStatistics(ActionEvent event) throws IOException {
        StatisticsController statisticsController = new StatisticsController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("statisticsView.fxml"), I18n.getResourceBundle(new Locale("en")));
        loader.setController(statisticsController);
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 500);
        URL url = getClass().getClassLoader().getResource("application.css");
        scene.getStylesheets().add(url.toExternalForm());
        Stage stage = new Stage();
//        stage.setTitle("Statistics");
        stage.setScene(scene);
        stage.getScene().getStylesheets().add(url.toExternalForm());
        stage.show();
    }

    @Override
    public void update() {

    }
}
