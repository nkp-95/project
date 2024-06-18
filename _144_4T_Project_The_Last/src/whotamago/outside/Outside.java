package whotamago.outside;

import java.util.InputMismatchException;
import java.util.Scanner;

import whotamago.Egg;

public class Outside {
	static String str;
	Scanner scanner = new Scanner(System.in);

	FoodProduct foodProductHashMap = new FoodProduct();
	DecorateProduct decoProductHashMap = new DecorateProduct();
	TicketProduct ticProductHashMap = new TicketProduct();

	FoodProduct grass = new FoodProduct("풀", 100); // 5
	FoodProduct riceCake = new FoodProduct("떡볶이", 1500); // 10
	FoodProduct chiken = new FoodProduct("치킨", 3000); // 15

	DecorateProduct cap = new DecorateProduct("볼캡모자", 1000); // 5
	DecorateProduct glass = new DecorateProduct("패션안경", 1500); // 10
	DecorateProduct neck = new DecorateProduct("목걸이", 2500); // 15

	TicketProduct library = new TicketProduct("도서관", 1000); // 10
	TicketProduct singing = new TicketProduct("노래방", 2000); // 5
	TicketProduct gameMachine = new TicketProduct("게임기", 3500); // 15

	public void eatSnack() {
		foodProductHashMap.addProduct(grass);
		foodProductHashMap.addProduct(chiken);
		foodProductHashMap.addProduct(riceCake);
		do {
			System.out.println();
			System.out.print("\t▶ 구매할 간식을 입력해주세요.( 나가기 : 0 )\n");
			System.out.println("\t보유 잔액: " + Egg.money + "원\n");
			foodProductHashMap.showFoodProduct();
			System.out.print("\t▶ 상품명 입력: ");
			try {
				str = scanner.next();
				switch (str) {
				case "풀":
					if (Egg.money < grass.getPrice()) {
						System.out.println("\t구매 실패...금액이 부족합니다.\n");
						break;
					} else
					Egg.money -= grass.getPrice();
					Egg.change(0, 0, 1, -10, 0, 0, 2);
					System.out.println("\t구매 성공!" + grass.getpName() + "을(를) 먹고 맛없어서 실망합니다.\n");
					break;
				case "떡볶이":
					if (Egg.money < riceCake.getPrice()) {
						System.out.println("\t구매 실패...금액이 부족합니다.\n");
						break;
					} else
					Egg.money -= riceCake.getPrice();
					Egg.change(0, 0, 2, 5, -10, 0, 2);
					System.out.println("\t구매 성공! " + riceCake.getpName() + "을(를) 매워하면서도 맛있게 먹습니다.\n");
					break;
				case "치킨":
					if (Egg.money < chiken.getPrice()) {
						System.out.println("\t구매 실패...금액이 부족합니다.\n");
						break;
					} else {
						Egg.money -= chiken.getPrice();
						Egg.change(0, 0, 3, 10, -10, 0, 2);
						System.out.println("\t구매 성공! " + chiken.getpName() + "을(를) 신나게 뜯어먹습니다.\n");
					}
					break;
				case "0":
					System.out.println("\t상위 메뉴로 돌아갑니다.\n");
					break;
				default:
					System.out.println("\t다시 입력해 주세요.\n");
					break;
				}
			
		
			}catch (InputMismatchException e) {
				System.out.println(e);
				System.out.println("\t문자를 입력해야 합니다. 다시 입력해주세요.\n");
				scanner.next();
			}
		} while (!str.equals("0") && Egg.time < 21);
	}	

	public void deco()  {
		decoProductHashMap.addProduct(cap);
		decoProductHashMap.addProduct(glass);
		decoProductHashMap.addProduct(neck);
		do{
			System.out.println();
			System.out.print("\t▶ 구매할 용품을 선택해주세요.( 나가기 : 0 )\n");
			System.out.println("\t보유 잔액: " + Egg.money + "원\n");
			decoProductHashMap.showDecorateProduct();
			System.out.print("\t▶ 상품명 입력: ");
			try {
				str = scanner.next();
				switch (str) {
				case "모자","볼캡모자":
					if (Egg.money < cap.getPrice()) {
						System.out.println("\t구매 실패...금액이 부족합니다.\n");
						break;
					} else {
						Egg.money -= cap.getPrice();
						Egg.change(1, 0, 0, -5, 0, 0, 2);
						System.out.println("\t구매 성공! " + cap.getpName() + "을(를) 쓰며 얼굴을 가립니다.\n");
					}
					break;
				case "안경","패션안경":
					if (Egg.money < glass.getPrice()) {
						System.out.println("\t구매 실패...금액이 부족합니다.\n");
						break;
					} else {
						Egg.money -= glass.getPrice();
						Egg.change(2, 0, 0, -10, 0, 0, 2);
						System.out.println("\t구매 성공! " + glass.getpName() + "을(를) 쓰며 지적인 척을 합니다.\n");
					}
					break;
				case "목걸이":
					if (Egg.money < neck.getPrice()) {
						System.out.println("\t구매 실패...금액이 부족합니다.\n");
					} else {
						Egg.money -= neck.getPrice();
						Egg.change(3, 0, 0, -10, 0, 0, 2);
						System.out.println("\t구매 성공! " + neck.getpName() + "을(를) 하며 멋을 내봅니다.\n");
					}
					break;
				case "0":
					System.out.println("\t상위 메뉴로 돌아갑니다.");
					break;
				default:
					System.out.println("\t다시 입력해 주세요.\n");
					break;
				}
			}catch (InputMismatchException e) {
				System.out.println(e);
				System.out.println("\t문자를 입력해야 합니다. 다시 입력해주세요.\n");
				scanner.next();
			}
			
		}while(!str.equals("0") && Egg.time < 21);
		

	}

	public void solo() {

		ticProductHashMap.addProduct(singing);
		ticProductHashMap.addProduct(library);
		ticProductHashMap.addProduct(gameMachine);
		do {
		System.out.println();
		System.out.print("\t▶ 구매할 이용권 선택해주세요.( 나가기 : 0 )\n");
		System.out.println("\t보유 잔액: " + Egg.money + "원\n");
		ticProductHashMap.showTicketProduct();
		System.out.print("\t▶ 상품명 입력: ");
		try {
			str = scanner.next();
			switch (str) {
			case "도서관":
				if (Egg.money < library.getPrice()) {
					System.out.println("\t구매 실패...금액이 부족합니다.\n");
				} else {
					Egg.money -= library.getPrice();
					Egg.change(0, 2, 0, -10, 0, 0, 2);
					System.out.println("\t구매 성공! " + library.getpName() + "에서 조용히 책을 읽습니다.\n");
				}
				break;
			case "노래방":
				if (Egg.money < singing.getPrice()) {
					System.out.println("\t구매 실패...금액이 부족합니다.\n");
				} else {
					Egg.money -= singing.getPrice();
					Egg.change(0, 1, 0, -15, 0, 0, 2);
					System.out.println("\t구매 성공! " + singing.getpName() + "에서 신나게 노래를 불렀습니다.\n");
				}
				break;
			case "게임기":
				if (Egg.money < gameMachine.getPrice()) {
					System.out.println("\t구매 실패...금액이 부족합니다.\n");
				} else {
					Egg.money -= gameMachine.getPrice();
					Egg.change(0, 3, 0, -15, 0, 0, 2);
					System.out.println("\t구매 성공! " + gameMachine.getpName() + "을(를) 가지고 게임을 합니다.\n");
				}
				break;
			case "0":
				System.out.println("\t상위 메뉴로 돌아갑니다.\n");
				break;
			default:
				System.out.println("\t다시 입력해 주세요.\n");
				break;
			}
		}catch (InputMismatchException e) {
			System.out.println(e);
			System.out.println("\t문자를 입력해야 합니다. 다시 입력해주세요.\n");
			scanner.next();
		}
	}while(!str.equals("0") && Egg.time < 21);
		

	}

}
