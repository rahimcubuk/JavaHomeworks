package Entities;

public class Game implements IEntity {
	private int id;
	private String name;
	private double price;
	private double finalPrice;
	private Campaign campaign;
	private boolean status;
	
	public Game(int id, String name, double price, Campaign campaign, boolean status) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setCampaign(campaign);
		this.setFinalPrice(price, campaign);
		this.setStatus(status);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	private void setFinalPrice(double price, Campaign campaign) {
		if(campaign != null && campaign.isDiscountApplied()){
			this.finalPrice = price - (price * campaign.getDiscount() / 100);
		}else {
			this.finalPrice = this.price;
		}
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
