package whotamago;

import java.util.InputMismatchException;
import java.util.Scanner;

import whotamago.outside.Outside;

public class Menu {

	Scanner in = new Scanner(System.in);
	
	MiniGame mini = new MiniGame();
	Egg egg = new Egg();
	Outside out = new Outside();
	
	public static int num;

	public void start() {
		
		do {
			DP.startText();
			inPut(1,2);
			switch (num) {
			case 1:
				break;
			case 2:
				DP.exText();
				break;
			}
		} while (num != 1);
		
	}

	public void menu() {

		System.out.println("\t▶︎ 메인 메뉴 ◀︎\n");
		System.out.println("\t(1) 돌보기\t(2) 외출하기\t(3) 미니게임\t(10) 초기화\r");
		inPut(1, 10);
		if(num>3&&num<10) {
			System.out.println("\t유효하지 않은 번호입니다. 다시 입력하세요.\n");
			System.out.print("\t▶ 번호 입력: ");
			in.nextInt();
		}
		switch (num) {
		case 1:
			care();
			break;
		case 2:
			outSide();
			break;
		case 3:
			miniGame();
			break;
		case 10:
			break;
		}
		}
	

	private void care() {
		do {
			System.out.println();
			System.out.println("\t▶ 무엇을 해줄까요?︎\n");
			System.out.println("\t(1) 밥먹기\t(2) 목욕하기\t(3) 산책하기\t(4) 낮잠자기\t(0) 뒤로가기");
			inPut(0, 4);
				switch (num) {
				case 1:
					egg.meals();
					break;
				case 2:
					egg.bath();
					break;
				case 3:
					egg.walk();
					break;
				case 4:
					egg.sleep();
					break;
				case 0:
					System.out.println("\t메인 메뉴로 돌아갑니다.");
					break;
				}
		} while (num != 0 && Egg.time < 21&&Egg.stress!=100&&Egg.full!=0);
	}

	private void outSide() {
		do {
			System.out.println();
			System.out.println("\t▶ 뭐하고 놀까요?\t보유 잔액: " + Egg.money + "원");
			System.out.println("\t(1) 간식먹기\t(2) 쇼핑하기\t(3) 혼자놀기\t(0) 뒤로가기");
			inPut(0, 3);
			switch (num) {
			case 1:
				out.eatSnack();
				break;
			case 2:
				out.deco();
				break;
			case 3:
				out.solo();
				break;
			case 0:
				System.out.println("\t메인 메뉴로 돌아갑니다.");
				break;
			}
		} while (num != 0 && Egg.time < 21&&Egg.full!=0);
	}

	private void miniGame() {
		int max = 3;
		if (MiniGame.chance < max) {
			do {
				System.out.println();
				System.out.println("\t▶ 무슨 게임을 할까요?\t게임 기회: " + (max - MiniGame.chance) + "회\n");
				System.out.println("\t(1) 홀수짝수\t(2) 가위바위보\t(3) 그림맞추기\t(4) 파밍하기\t(5) 숫자업다운\t(0) 뒤로가기");
				inPut(0, 5);
				if (num >= 1 && 5 >= num) 
					MiniGame.chance++;
				in.nextLine();
				switch (num) {
				case 1:
					MiniGame.playHJ();
					break;
				case 2:
					MiniGame.playRSP();
					break;
				case 3:
					MiniGame.playPic();
					break;
				case 4:
					MiniGame.numberGame();
					break;
				case 5:
					MiniGame.playFraming();
					
					break;
				case 0:
					System.out.println("\t메인 메뉴로 돌아갑니다.");
					break;
				}
			} while (num != 0 && MiniGame.chance < max && Egg.time < 21&&Egg.stress!=100);
		} else {
			System.out.println("\t남은 기회가 없어요! 내일 다시오세요!\n");
		}
	}
	  public void closeScanner() {
	        if (in != null) {
	            in.close();
	        }
	  }
	public void inPut(int min, int max) {
		boolean inPut;
		do {
			inPut = true;
			System.out.print("\t▶ 번호 입력: ");
			try {
				num = in.nextInt();
				if (num < min || num > max) {
					System.out.println("\t유효하지 않은 번호입니다. 다시 입력하세요.\n");
					inPut = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("\t숫자를 입력해야 합니다. 다시 입력하세요.\n");
				in.next();
				inPut = false;
			}
		} while (!inPut);
		
		
	}
	
}
