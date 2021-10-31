package spacenews.gui;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;

import spacenews.domain.Auction;
import spacenews.domain.AuctionAdmin;
import spacenews.util.Observer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AuctionController implements Observer {



	@FXML
	private VBox root;

	@FXML
	private Label titleLabel;

	@FXML
	private Label statusLabel;

	@FXML
	private Label endTimeLabel;

	@FXML
	private Label remainingTimeLabel;

	@FXML
	private Label currentBidLabel;

	private Auction auction;

	public AuctionController(Auction auction) {
		this.auction = auction;
		AuctionAdmin.getInstance().addObserver(this);
	}

	@FXML
	public void initialize() {
		auction.start();
		titleLabel.setText(auction.getItem().getDescription());
		statusLabel.setText(auction.getStatus().name());
		endTimeLabel.setText(auction.getEndTime().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
		remainingTimeLabel.setText(String.valueOf(auction.getRemainingTime()));
	}

	@FXML
	public void addBidder() throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("loginView.fxml"));
		LoginController loginController = new LoginController(auction);
		loader.setController(loginController);
		Parent root = loader.load();
		Scene scene = new Scene(root, 350, 200);
		URL url = getClass().getClassLoader().getResource("application.css");
		scene.getStylesheets().add(url.toExternalForm());
		stage.setOnCloseRequest(e -> {
			Platform.exit();
		});
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void close() {
		((Stage) root.getScene().getWindow()).close();
		auction.end();
	}

	@Override
	public void update() {
		statusLabel.setText(auction.getStatus().name());
		remainingTimeLabel.setText(String.valueOf(auction.getRemainingTime()));
		if ((AuctionAdmin.getInstance().getLatestBid() != null)) {
			currentBidLabel.setText(AuctionAdmin.getInstance().getLatestBid().toString());
		}
	}
}
