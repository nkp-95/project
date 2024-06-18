package whotamago;

import whotamago.end.End;

public class WhoTamagoTest {
	public static void main(String[] args) {
		// 실행 클래스
//		      Login.yourLogin();
		Egg egg = new Egg();
		End end = new End();
		Menu menu = new Menu();
		try {
			do {
				menu.start();
				egg.naming();
				egg.setting();
				do {
					egg.showState();
					menu.menu();
					egg.dayCount();
				} while (Egg.day != 8 && Menu.num != 10 && Egg.stress != 100&&Egg.full!=0);
				end.result();
			} while (End.eNum != 2);
			System.out.println("\t게임이 종료되었습니다. 안녕히 가세요.");
		} finally {
			menu.closeScanner();
		}
	}
}