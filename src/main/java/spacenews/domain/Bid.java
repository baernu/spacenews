package spacenews.domain;

import spacenews.bidder.Bidder;
import spacenews.catalog.AuctionItem;

public class Bid {
	private AuctionItem item;
	private Bidder bidder;
	private double amount;
	private long timestamp;

	public Bid(AuctionItem item, Bidder bidder, double amount, long timestamp) {
		this.item = item;
		this.bidder = bidder;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public AuctionItem getItem() {
		return item;
	}

	public Bidder getBidder() {
		return bidder;
	}

	public double getAmount() {
		return amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String toString() {
		return amount + " from " + bidder.getUsername();
	}

}
