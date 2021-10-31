package spacenews.domain;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import spacenews.catalog.AuctionItem;
import spacenews.catalog.ItemStatus;

public class Auction {
	private AuctionItem item;
	private LocalTime endTime;
	private AuctionStatus status;

	public Auction(AuctionItem item, long duration) {
		this.item = item;
		endTime = LocalTime.now().plus(duration, ChronoUnit.SECONDS);
		this.status = AuctionStatus.CREATED;
	}

	public AuctionItem getItem() {
		return item;
	}

	public AuctionStatus getStatus() {
		return status;
	}

	public void setStatus(AuctionStatus status) {
		this.status = status;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public long getRemainingTime() {
		long result = 0;
		if (endTime != null) {
			result = LocalTime.now().until(endTime, ChronoUnit.SECONDS);
		}
		return result > 0 ? result : 0;
	}

	public void start() {
		status = AuctionStatus.RUNNING;
	}

	public void end() {
		if (status != AuctionStatus.ENDED) {
			status = AuctionStatus.ENDED;
			if (item.getCurrentPrice() != 0)
				item.setItemStatus(ItemStatus.SOLD);
		}
	}

	public void addBid(Bid bid)  {
		bid.getItem().setCurrentPrice(bid.getAmount());
		AuctionAdmin.getInstance().addBid(bid);
	}

}
