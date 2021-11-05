package spacenews.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import spacenews.util.I18n;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.HttpEntity;


public class Main extends Application {

	public void start(Stage stage) {
		String input = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpResponse response;
		try {

//			HttpGet request = new HttpGet("https://api.spaceflightnewsapi.net/v3/articles");
//			HttpGet request = new HttpGet("https://api.spaceflightnewsapi.net/v3/blogs");
			HttpGet request = new HttpGet("https://api.spaceflightnewsapi.net/v3/reports");

			response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
				if (entity != null) {
					// return it as a String
					input = EntityUtils.toString(entity);
				}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();

		}


		try {
			NewsController newsController = new NewsController(input);
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("news.fxml"
			), I18n.getResourceBundle(new Locale("labels","de")));
			loader.setController(newsController);
			Parent root = loader.load();
			Scene scene = new Scene(root, 600, 500);
			URL url = getClass().getClassLoader().getResource("application.css");
			scene.getStylesheets().add(url.toExternalForm());
//			stage.setOnCloseRequest(e -> {
//				Platform.exit();
			stage.setOnCloseRequest(e -> Platform.exit());



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
