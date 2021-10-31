package spacenews.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import spacenews.catalog.AuctionItem;
import spacenews.catalog.ItemStatus;
import spacenews.domain.Auction;
import spacenews.domain.AuctionAdmin;
import spacenews.util.I18n;
import spacenews.util.Observer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AuctionAdminController implements Observer {

	private Auction auction;
	private final int duration = 40;

	@FXML
	private ListView<String> auctionItems;

	@FXML
	private Button startAuctionButton;

	@FXML
	private Button showBiddingsButton;

	public void initialize() throws IOException {
		List<AuctionItem> items = AuctionAdmin.getInstance().getCatalog().getItems();
		AuctionAdmin.getInstance().addObserver(this);
		for (AuctionItem item : items) {
			auctionItems.getItems().add(item.getDescription());
		}
		auctionItems.getSelectionModel().select(0);
		// Disable the startAuctionButton, if selected auction item is SOLD.
		auctionItems.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
				int selectedItemIndex = auctionItems.getSelectionModel().getSelectedIndex();
				selectedItemIndex = selectedItemIndex < 0 ? 0 : selectedItemIndex;
				if (items.get(selectedItemIndex).getItemStatus() == ItemStatus.SOLD) {
					startAuctionButton.setDisable(true);
				} else {
					startAuctionButton.setDisable(false);
				}
			}
		});
	}

	@FXML
	private void startAuction() throws IOException {
		AuctionAdmin admin = AuctionAdmin.getInstance();
		int index = auctionItems.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			AuctionItem item = admin.getCatalog().getItems().get(index);
			if (item.getItemStatus() == ItemStatus.AVAILABLE) {
				auction = new Auction(item, duration);
				AuctionController auctionController = new AuctionController(auction);
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("auctionView.fxml"), I18n.getResourceBundle(new Locale("en")));
				loader.setController(auctionController);
				Parent root = loader.load();
				Scene scene = new Scene(root, 400, 300);
				URL url = getClass().getClassLoader().getResource("application.css");
				scene.getStylesheets().add(url.toExternalForm());
				startAuctionButton.setDisable(true);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("Auction for " + item.toString());
				stage.getScene().getStylesheets().add(url.toExternalForm());
				stage.show();

				auction.start();
				admin.addAuction(auction);
			}
		}
	}


	@FXML
	private void exit() throws IOException {
		Platform.exit();
	}

	@Override
	public void update() {
		auctionItems.getItems().clear();
		for (AuctionItem s: AuctionAdmin.getInstance().getCatalog().getItems()) {
			auctionItems.getItems().add(s.toString());
		}

	}
}
