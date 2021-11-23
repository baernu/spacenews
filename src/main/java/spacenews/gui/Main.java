package spacenews.gui;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;

import spacenews.util.I18n;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
	private static Locale locale = new Locale("en");
	private static Stage stage;


	public static void setLocale(Locale locale) {
		Main.locale = locale;
	}

	public static Locale getLocale() {
		return locale;
	}

	public static Stage getStage() {
		return Main.stage;
	}

	public void start(Stage stage) {
		FXMLLoader loader1 = null;

		Main.stage = stage;
		LanguageController languageController = new LanguageController();
		try {
			loader1 = new FXMLLoader(getClass().getClassLoader().getResource("languageView.fxml"
				), I18n.getResourceBundle(locale));
		} catch (MissingResourceException e) {
				e.printStackTrace();
		}
		try {
			loader1.setController(languageController);
			Parent root = loader1.load();
			Scene scene = new Scene(root, 200, 200);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
