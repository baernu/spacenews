package spacenews.gui;

import java.net.URL;
import java.util.Locale;

import spacenews.util.I18n;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage stage) {
		try {
			AuctionAdminController auctionAdminController = new AuctionAdminController();
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("auctionAdminView.fxml"
			), I18n.getResourceBundle(new Locale("labels","de")));
			loader.setController(auctionAdminController);
			Parent root = loader.load();
			Scene scene = new Scene(root, 500, 350);
			URL url = getClass().getClassLoader().getResource("application.css");
			scene.getStylesheets().add(url.toExternalForm());
			stage.setOnCloseRequest(e -> {
				Platform.exit();
			});
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
