package spacenews.gui;

import java.util.Locale;
import spacenews.util.I18n;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

	public void start(Stage stage) {



		try {
			NewsController newsController = new NewsController();
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("news.fxml"
			), I18n.getResourceBundle(new Locale("labels","de")));
			loader.setController(newsController);
			Parent root = loader.load();
			Scene scene = new Scene(root, 600, 500);



			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
