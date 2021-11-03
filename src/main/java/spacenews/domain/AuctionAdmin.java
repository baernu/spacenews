package spacenews.domain;

import java.util.ArrayList;
import java.util.List;

import spacenews.bidder.Bidder;
import spacenews.catalog.AuctionCatalog;
import spacenews.catalog.AuctionItem;
import spacenews.util.Observable;

public class AuctionAdmin extends Observable {





	private static AuctionAdmin instance;
	private List<Auction> auctions;
	private List<Bidder> bidders;
	private List<Bid> bids;
	private AuctionCatalog catalog;

	private AuctionAdmin() {
		catalog = new AuctionCatalog();
		auctions = new ArrayList<>();
		bidders = new ArrayList<>();
		bids = new ArrayList<>();
	}

	public static AuctionAdmin getInstance() {
		if (instance == null) {
			instance = new AuctionAdmin();
		}
		return instance;
	}

	public List<Auction> getAuctions() {
		return auctions;
	}

	public void addAuction(Auction auction) {
		auctions.add(auction);
		super.notifyObservers();
	}

	public List<Bidder> getBidders() {
		return bidders;
	}

	public void addBidder(Bidder bidder) {
		bidders.add(bidder);
		super.notifyObservers();
	}

	public List<Bid> getBids() {
		return bids;
	}

	public Bid getLatestBid() {
		return bids.size() > 0 ? bids.get(bids.size() - 1) : null;
	}

	public void addBid(Bid bid) {
		bids.add(bid);
		super.notifyObservers();
	}

	public AuctionCatalog getCatalog() {
		return catalog;
	}

	public void addAuctionItem(AuctionItem item) {
		catalog.getItems().add(item);
		super.notifyObservers();
	}

}