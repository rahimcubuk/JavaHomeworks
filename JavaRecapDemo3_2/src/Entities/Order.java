package Entities;

public class Order implements IEntity {

	/*
	 * Normal �artlar alt�nda bir sipari� tablosunda kullan�c�n�n ve �r�n�n "Id" si yeterli olur.
	 * * Id'i kullanarak kullan�c� ve �r�n hakk�nda t�m verilere ula�mak m�mk�nd�r. 
	 * Bu proje �zelinde kullan�c� �r�n ve kampanya detaylar�na ula�abilmek i�in b�yle bir y�ntem kulland�m.
	 * 
	 * Kampanya ve toplam fiyat bilgisini haricen ekledim. �leriki zamanlarda �r�n�n fiyat� ve kampanyas� de�i�ebilir.
	 * Bu durumda sat�� an�ndaki verilerin korunmas� gerekmektedir.
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
