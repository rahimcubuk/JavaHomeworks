package Entities;

public class Campaign implements IEntity {
	private int id;
	private String description;
	private double discount;
	private boolean discountApplied;

	public Campaign(int id, String description, double discount, boolean discountApplied) {
		this.setId(id);
		this.setDescription(description);
		this.setDiscount(discount);
		this.setDiscountApplied(discountApplied);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isDiscountApplied() {
		return discountApplied;
	}

	public void setDiscountApplied(boolean discountApplied) {
		this.discountApplied = discountApplied;
	}
}
