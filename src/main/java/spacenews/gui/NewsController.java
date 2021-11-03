package spacenews.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import spacenews.api.GetNews;
import spacenews.domain.Auction;
import spacenews.domain.AuctionAdmin;
import spacenews.util.I18n;
import spacenews.util.Observer;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NewsController implements Observer {

    private GetNews getNews = new GetNews();

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
    void goToArticles(ActionEvent event) throws IOException {
        getNews.load();
        NewsListController newsListController = new NewsListController(getNews, this);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("newsView.fxml"), I18n.getResourceBundle(new Locale("en")));
        loader.setController(newsListController);
        Parent root = loader.load();
        Scene scene = new Scene(root, 500, 500);
        URL url = getClass().getClassLoader().getResource("application.css");
        scene.getStylesheets().add(url.toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Articles");
        stage.setScene(scene);
        stage.getScene().getStylesheets().add(url.toExternalForm());
        stage.show();
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
