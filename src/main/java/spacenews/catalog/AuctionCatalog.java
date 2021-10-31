package spacenews.catalog;

import java.util.ArrayList;
import java.util.List;

public class AuctionCatalog {
	private List<AuctionItem> items = new ArrayList<>();

	public AuctionCatalog() {
		items.add(new AuctionItem(1, "Snowboard", 30 ));
		items.add(new AuctionItem(2, "Torch Light", 8));
		items.add(new AuctionItem(3, "Bicycle", 100 ));
		items.add(new AuctionItem(4, "Umbrella", 12 ));
	}
	
	public List<AuctionItem> getItems() {
		return items;
	}

	public void setItems(List<AuctionItem> items) {
		this.items = items;
	}
	
	public AuctionItem selectItem(int number) {
		return items.get(number);
	}
}