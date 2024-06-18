package whotamago;

import java.util.Scanner;

public class Egg {
	
	public static int money = 2000;
	public static int time= 10;
	public static int day = 1;
	public static int full = 50;            // 배부름
	public static int cleanliness = 50;     // 청결도
	public static int stress = 50;          // 스트레스 지수
	private static String name;
	public static int shy;                  // 수줍음
	public static int active;               // 활발함
	public static int lazy;                 // 느긋함
	
	public void setting() {   // 초기화 세팅값 메서드
		money = 2000;
		time = 10;
		day = 1;
		full = 50;
		cleanliness = 50;
		stress = 50;
		shy = 0;
		active = 0;
		lazy = 0;
		MiniGame.chance=0;
	}
	
	Scanner in = new Scanner(System.in);

	public void naming() { // 이름 설정 메서드
		try { // try - catch 예외처리 추가
			while (true) {
				System.out.print("\t알의 이름을 입력해주세요! ▶ \n\t이름 : ");
				name = in.nextLine();
	//			name = "^([a-zA-Z가-힣ㄱ-ㅎ]).(2,10)$";
				if(!((name.length() > 1 && name.length() < 11) && name.matches("[a-zA-Z가-힣ㄱ-ㅎ]+"))) {
						System.out.println("\t이름은 2자 이상 10자 이하로 입력해주세요!\n\t (숫자, 특수문자 입력 불가)\n");
				}else {
					
					break;
				}
			}
			System.out.println("\t"+name + "(이)와 7일간 잘 지내보아요!\n");
		}catch (Exception e){
			System.out.println("오류가 발생했습니다.");
			System.out.println(e);
		}
	}
	
	public void showState() {  // 상태 변화 메서드
		System.out.println();
		System.out.println("\t╔════*.·:·.☽✧ ✦ ✧☾.·:·.*════╗");
		System.out.println();
		System.out.println("\t     D - " + (8-day) + "\t   " + time + ":00\n"
				+ "\t     --------------------" 
				+ "\n\t     현재 [ " + name + " ] 의 상태" 
				+ "\n\t     배부름 지수 : " + full
				+ "\n\t     쳥결도 지수 : " + cleanliness
				+ "\n\t     스트레스 지수 : " + stress
				+ "\n\t     잔액 : " + money);
		System.out.println();
		System.out.println("\t╚════*.·:·.☽✧ ✦ ✧☾.·:·.*════╝\n");
	}
	public void dayCount() {  // 날짜 카운트 메서드
		if(time >= 21 && day < 8 && stress != 100 && full !=0) {
			System.out.println();
			System.out.println("\t╭ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝╮\n"
					+ "\t    21시가 되어 "+name+"(이)가 잠들었습니다.\n"
					+ "\t╰ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ╯\n");
			System.out.println();
			time=10;
			MiniGame.chance=0;  // 미니게임 횟수 초기화
			day++;}
	}
	
	// 기질 3가지, 상태 3가지, 시간 변화 메서드
	public static void change(int shyC, int activeC, int lazyC, int fullC, int cleanC, int stressC, int timeC) {
		shy += shyC;
		active += activeC;
		lazy += lazyC;
		full += fullC;
		cleanliness += cleanC;
		stress += stressC;
		time += timeC;
		
		if(full < 0) {
			full = 0;
		}else if(full > 100) {
			full = 100;
		}
		
		if(cleanliness < 0) {
			cleanliness = 0;
		}else if(cleanliness > 100) {
			cleanliness = 100;
		}
		
		if(stress < 0) {
			stress = 0;
		}else if(stress > 100) {
			stress = 100;
		}
		
	}
	
	// 돌보기 메서드
	public void meals() {   // 배부름 up
		
		if(full > 0 && full < 100) {
			change(0, 0, 0, 10, 0, 0, 2);
			System.out.println("\n\t배부름 Up!!\n");
			if(full < 20) {
				System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			}
		}
		else if(full == 100) {  
			change(0, 0, 0, 10, 0, 0, 2);
			System.out.println("\n\t배부름 Up!!\n");
			System.out.println("\t" + name + "은(는) 배가 너무 불러요!\n");
		}
		else if(full == 0 ) {
			change(0, 0, 0, 10, 0, 0, 2);
			System.out.println("\n\t배부름 Up!!\n");
			System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
		}
	}
	
	// 목욕하기 메서드
	public void bath() {    // 청결도 up / 스트레스 up
		
		if((cleanliness > 0 && cleanliness < 100) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, 0, 10, 5, 2);
			System.out.println("\n\t청결도  Up!!\n"
							+ "\t스트레스 Up!!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if((cleanliness == 0) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, 0, 10, 5, 2);
			System.out.println("\n\t청결도  Up!!\n"
							+ "\t스트레스 Up!!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if((cleanliness == 100) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, 0, 10, 5, 2);
			System.out.println("\n\t청결도  Up!!\n"
							+ "\t스트레스 Up!!\n");
			System.out.println("\t" + name + "은(는) 이미 깨끗해요!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if(stress == 0) {
			change(0, 0, 0, 0, 10, 5, 2);
			System.out.println("\n\t청결도  Up!!\n"
							+ "\t스트레스 Up!!\n");
			System.out.println("\t" + name + "은(는) 스트레스가 없어요!\n");
			if(full < 20) {
				System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			}
		}
	}
	
	// 산책하기 메서드
	public void walk() {    // 청결도 down / 스트레스 down 
		
		if((cleanliness > 0 && cleanliness < 100) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, 0, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t스트레스 Down!!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}	
		else if((cleanliness == 0) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, 0, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t스트레스 Down!!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if((cleanliness == 100) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, 0, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t스트레스 Down!!\n");	
			System.out.println("\t" + name + "은(는) 이미 깨끗해요!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if(stress == 0) {
			change(0, 0, 0, 0, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t스트레스 Down!!\n");
			System.out.println("\t" + name + "은(는) 스트레스가 없어요!\n");
			if(full < 20) {
				System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			}
		}
	}
	
	// 낮잠 자기 메서드
	public void sleep() {   // 청결도 down / 배부름 down / 스트레스 down

		if((cleanliness > 0 && cleanliness < 100) && (full > 0 && full < 100) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, -10, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t배부름  Down!!\n"
							+ "\t스트레스 Down!!\n");
			if(full < 20) {
				System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			}
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}	
		else if((cleanliness == 0) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, -10, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t배부름  Down!!\n"
							+ "\t스트레스 Down!!\n");
			if(full < 20) {
				System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			}
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if((cleanliness == 100) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, -10, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t배부름  Down!!\n"
							+ "\t스트레스 Down!!\n");
			System.out.println("\t" + name + "은(는) 이미 깨끗해요!\n");
			if(full < 20) {
				System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			}
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if(full == 100) {  
			change(0, 0, 0, -10, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t배부름  Down!!\n"
							+ "\t스트레스 Down!!\n");
			System.out.println("\t" + name + "은(는) 배가 너무 불러요!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if(full == 0 ) {
			change(0, 0, 0, -10, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t배부름  Down!!\n"
							+ "\t스트레스 Down!!\n");
			System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if((cleanliness == 0) && (full == 0) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, -10, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t배부름  Down!!\n"
							+ "\t스트레스 Down!!\n");
			System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}
		else if((cleanliness == 100) && (full == 100) && (stress > 0 && stress < 100)) {
			change(0, 0, 0, -10, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t배부름  Down!!\n"
							+ "\t스트레스 Down!!\n");
			System.out.println("\t" + name + "은(는) 이미 깨끗해요!\n");
			System.out.println("\t" + name + "은(는) 배가 너무 불러요!\n");
			if(stress > 80) {
				System.out.println("\t[경고]" + name + "은(는) 스트레스 수치가 너무 높아요! 알이 깨질 수 있으니 조심하세요!\n");
			}
		}	
		else if(stress == 0) {
			change(0, 0, 0, -10, -10, -5, 2);
			System.out.println("\n\t청결도  Down!!\n"
							+ "\t배부름  Down!!\n"
							+ "\t스트레스 Down!!\n");			
			System.out.println("\t" + name + "은(는) 스트레스가 없어요!\n");
			if(full < 20) {
				System.out.println("\t[경고]" + name + "은(는) 너무 배고파요! 얼른 밥을 주세요!\n");
			}
		}
	}
	
	// 게터
	public static int getMoney() {
		return money;
	}
	public static int getTime() {
		return time;
	}
}