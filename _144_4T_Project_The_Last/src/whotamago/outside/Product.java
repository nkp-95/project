package whotamago.outside;

public class Product {
	private String pName;
	private int price;
	public Product() {}
	
	public Product(String pName, int price) {
		this.pName = pName;
		this.price = price;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\t상품명: "+ pName + ",\t금액: " + price + "원";
	}
}
