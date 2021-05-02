package Entities;

public class Order implements IEntity {

	/*
	 * Normal þartlar altýnda bir sipariþ tablosunda kullanýcýnýn ve ürünün "Id" si yeterli olur.
	 * * Id'i kullanarak kullanýcý ve ürün hakkýnda tüm verilere ulaþmak mümkündür. 
	 * Bu proje özelinde kullanýcý ürün ve kampanya detaylarýna ulaþabilmek için böyle bir yöntem kullandým.
	 * 
	 * Kampanya ve toplam fiyat bilgisini haricen ekledim. Ýleriki zamanlarda ürünün fiyatý ve kampanyasý deðiþebilir.
	 * Bu durumda satýþ anýndaki verilerin korunmasý gerekmektedir.
	 * */
	private int id;
	private User user;
	private Game game;
	private Campaign campaign;
	private double totalPrice;
	private boolean status;

	public Order(int id, User user, Game game, Entities.Campaign campaign, double totalPrice, boolean status) {
		this.setId(id);
		this.setUser(user);
		this.setGame(game);
		this.setCampaign(campaign);
		this.setTotalPrice(totalPrice);
		this.setStatus(status);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
