package whotamago.outside;

import java.util.HashMap;
import java.util.Iterator;

class FoodProduct extends Product{
	
	// 멤버변수 선언
		private HashMap<String, Product> hashMap;
		public FoodProduct() {
			hashMap = new HashMap<String, Product>();
		}
		public FoodProduct(String pName, int price) {
			 super(pName, price);
		 }
		// 상품 추가
		public void addProduct(Product product) {
			hashMap.put(product.getpName(), product);
		}
		// 상품 삭제
		public boolean removeMember(String pName) {
			if(hashMap.containsKey(pName)) {
				hashMap.remove(pName);
				return true;
			}
			System.out.println(pName + "이(가) 존재하지 않습니다.");
			return false;
		}
		// 상품 목록 보여주는 메서드
		public void showFoodProduct() {
			Iterator<String> ir = hashMap.keySet().iterator();
			while(ir.hasNext()) {
				String key = ir.next();
				Product product = hashMap.get(key);
				System.out.println(product);
			}
			System.out.println();
		}
	
	
	       
}
