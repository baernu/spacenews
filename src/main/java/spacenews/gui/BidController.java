
package spacenews.gui;

import spacenews.bidder.Bidder;
import spacenews.domain.Auction;
import spacenews.domain.Bid;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BidController {

	private Bidder bidder;
	private Auction auction;

	@FXML
	private VBox root;

	@FXML
	private Label titleLabel;

	@FXML
	private TextField bidField;

	@FXML
	private Button placeBidButton;

	@FXML
	private Label messageLabel;

	private StringProperty messageString = new SimpleStringProperty(" ");

	public BidController(Auction auction, Bidder bidder) {
		this.auction = auction;
		this.bidder = bidder;
	}

	public void initialize() {
		messageLabel.textProperty().bind(messageString);
		titleLabel.setText(bidder.getUsername() + " bidding for " + auction.getItem().toString());
	}

	@FXML
	private void placeBid() {
		if (auction.getRemainingTime() > 0) {
			try {
				double amount = Double.parseDouble(bidField.getText());
				Bid bid = new Bid(auction.getItem(), bidder, amount, auction.getRemainingTime());
				auction.addBid(bid);
				messageString.set(bid.toString());
			} catch (NumberFormatException | NullPointerException e) {
				messageString.set("Input value must be a double number");
			}
		} else {
			messageString.set("Auction is not running");
			auction.end();
		}
		bidField.setText("");
	}

	@FXML
	private void logout() {
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
	}
}
