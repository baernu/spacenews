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
import spacenews.domain.NewsType;
import spacenews.util.I18n;

import java.io.IOException;
import java.util.Locale;

public class NewsController {

    private final GetNews getNews = new GetNews();
    private NewsType newsType;


    @FXML
    private AnchorPane root;
    
    @FXML
    private Button articles;

    @FXML
    private Button blogs;

    @FXML
    private Button exitHome;



    @FXML
    private Button reports;


    @FXML
    void exit(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    void goToArticles(ActionEvent event) throws IOException {
        newsType = NewsType.Article;
        getNews.load(NewsType.Article);
        control();
    }

    @FXML
    void goToBlogs(ActionEvent event) throws IOException {
        newsType = NewsType.Blog;
        getNews.load(NewsType.Blog);
        control();
    }


    @FXML
    void goToReports(ActionEvent event) throws IOException {
        newsType = NewsType.Report;
        getNews.load(NewsType.Report);
        control();
    }


    public void control()  {

        try {
            NewsListController newsListController = new NewsListController(getNews, this);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("newsView.fxml"), I18n.getResourceBundle(Main.getLocale()));
            loader.setController(newsListController);
            Parent root = loader.load();
            Scene scene = new Scene(root, 500, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public NewsType getNewsType() {
        return this.newsType;
    }
}
