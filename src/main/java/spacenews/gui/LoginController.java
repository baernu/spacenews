package spacenews.gui;

import java.io.IOException;
import java.net.URL;

import spacenews.bidder.Bidder;
import spacenews.domain.Auction;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {

	private Auction auction;
	
	
	@FXML
	private VBox root;
	
	@FXML
	private TextField usernameText;

	@FXML
	private PasswordField passwordText;

	@FXML
	private Label errorLabel;

	public LoginController(Auction auction) {
		this.auction = auction;
	}

	@FXML
	public void login() throws IOException {
		if (usernameText.getText().isBlank() || !passwordText.getText().contentEquals("17")) {
			errorLabel.setText("LoginFailed");
		} else {
			errorLabel.setText("Login successful");
			
			((Stage)root.getScene().getWindow()).close();
			
			Bidder bidder = new Bidder(usernameText.getText(), passwordText.getText());			
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("bidView.fxml"));
			BidController bidController = new BidController(auction, bidder);
			loader.setController(bidController);
			Parent root = loader.load();
			Scene scene = new Scene(root, 350, 250);
			URL url = getClass().getClassLoader().getResource("application.css");
			scene.getStylesheets().add(url.toExternalForm());
			stage.setOnCloseRequest(e -> {
				Platform.exit();
			});
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	public void cancel() {
		((Stage)root.getScene().getWindow()).close();
	}
	
	@FXML
	public void cleanUp() {
		errorLabel.setText("");
	}
}
