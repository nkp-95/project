package whotamago.end;

import java.util.InputMismatchException;
import java.util.Scanner;

import whotamago.Egg;
import whotamago.Menu;

public class End {
	EndingType fail = new Fail();
	EndingType dog = new Dog();
	EndingType ham = new Ham();
	EndingType cat = new Cat();
	Menu menu = new Menu();
	Scanner in = new Scanner(System.in);
	public static int eNum;
	
	
	public void result() {
		if(Menu.num!=10) {
		if(Egg.stress<100&&Egg.full!=0) {
		String persnal="느긋함";
		if(Egg.lazy<Egg.shy) {
			persnal="수줍음";
		}if(Egg.shy<Egg.active) {
			persnal="활발함";
		}
		switch(persnal) {
		case "수줍음": dog.run();break;
		case "활발함": cat.run();break;
		case "느긋함": ham.run();break;
		}
		}else {
			fail.run();
		}
	}end();
	}
	
	
	public void end() {					// 게임이 끝날을 때 재시작 할건지 말건지를 선택.
		System.out.println();
		System.out.println("\t˚✧₊⁎⁺˳✧초기화 됐어요˚✧₊⁎⁺˳✧\n");		
		System.out.println("\t1) 다시하기\t2) 끝내기");		// 메뉴 출력.
		boolean inPut;
		do {
			inPut = true;
			System.out.print("\t▶ 번호 입력: ");
			try {
				eNum=in.nextInt();
				if (eNum < 1 || eNum > 2) {
					System.out.println("\t유효하지 않은 번호입니다. 다시 입력하세요.\r");
					inPut = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("\t숫자를 입력해야 합니다. 다시 입력하세요.\r");
				in.next();
				inPut = false;
			}
		} while (!inPut);
	}

//
//	public void result() {
//		if (Menu.num != 4) {
//			if (Egg.stress < 100) {
//				String persnal = "먹보";
//				if (Egg.lazy < Egg.shy) {
//					persnal = "조용";
//				}
//				if (Egg.shy < Egg.active) {
//					persnal = "활발";
//				}
//				if (persnal.equals("조용"))
//					dog.run();
//				if (persnal.equals("활발"))
//					cat.run();
//				if (persnal.equals("먹보"))
//					ham.run();
//			} else if (Egg.stress > 100) {
//				fail.run();
//			} else if (Menu.num == 4) {
//				reset.run();
//			}else {
//				return;
//			}
//		}
//	}
//	public void text() {
//		System.out.println();
//		System.out.println("\t▶ 초기화 되었습니다. 다시 해볼까요?\r");
//		System.out.println("\t1) 다시하기\t2) 끝내기\r");
//		System.out.print("\t▶ 번호 입력: ");
//		Menu.num = in.nextInt();
//	}
}
