package spacenews.gui;

import java.util.Locale;
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



		try {
			Main.stage = stage;
			LanguageController languageController = new LanguageController();
			FXMLLoader loader1 = new FXMLLoader(getClass().getClassLoader().getResource("languageView.fxml"
			), I18n.getResourceBundle(locale));
			loader1.setController(languageController);
			Parent root = loader1.load();
			Scene scene = new Scene(root, 200, 200);
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
