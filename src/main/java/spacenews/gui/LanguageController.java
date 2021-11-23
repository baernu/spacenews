package spacenews.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spacenews.util.I18n;

import java.io.IOException;
import java.util.Locale;

public class LanguageController {

    @FXML
    void setEnglish(ActionEvent event) {
        Main.setLocale(new Locale("en"));
        run();

    }

    @FXML
    void setGerman(ActionEvent event) {
        Main.setLocale(new Locale("de"));
        run();
    }

    public void run() {
        try {
            NewsController newsController = new NewsController();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("news.fxml"
            ), I18n.getResourceBundle(Main.getLocale()));
            loader.setController(newsController);
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 500);
            Main.getStage().setScene(scene);
            Main.getStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
