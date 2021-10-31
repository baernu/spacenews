package spacenews.bidder;

public  class Bidder {
	private String username;
	private String password;

	public Bidder(String name, String password) {
		this.username = name;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return username;
	}
}
