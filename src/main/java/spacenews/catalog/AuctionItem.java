package spacenews.catalog;

public class AuctionItem {
	private int id;
	private String description;
	private double minimumPrice;
	private double currentPrice;
	private ItemStatus itemStatus;

	public AuctionItem(int id, String description, double minimumPrice) {
		this.id = id;
		this.description = description;
		this.minimumPrice = minimumPrice;
		this.currentPrice = 0;
		itemStatus = ItemStatus.AVAILABLE;
	}

	public int getId() {
		return id;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double price) {
		this.currentPrice = price;
	}

	public ItemStatus getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}
	
	public double getMinimumPrice() {
		return minimumPrice;
	}

	@Override
	public String toString() {
		return id + ": " + description;
	}

	public String getDescription() {
		String text = id + ": " + description;
		text = text + ", start price: " + String.format("%1.2f", minimumPrice) + ", ";
		if (itemStatus == ItemStatus.SOLD) 
			text = text + "end price: " + String.format("%1.2f", currentPrice) + ", ";
		return text + itemStatus;
	}

}

