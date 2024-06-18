package whotamago;

import java.util.Scanner;

//미니게임 클래스
public class MiniGame {

   static Scanner scanner = new Scanner(System.in);
   static int chance = 0;
   static int max;
   static int min;
   static int p = 0;
   static String str;

   static void playHJ() {

      Egg.time += 3;
      String sipping;
      int reward = 2000;
      System.out.println("\n\t[ 홀수 짝수 게임 ]\n");
      System.out.println("\t홀수 짝수를 맞혀보세요!\n");
      System.out.println("\t어떤 것을 고를까요?\n" + "\t1) 홀\t2) 짝\n");
      int i = (int) (Math.random() * 2);// 무작위난수
      if (i % 2 == 0) {
         sipping = "짝";
      } else {
         sipping = "홀";
      }

//      while (true) {
//         try {
//            System.out.print("\t▶ 번호 입력: ");
//            p = scanner.nextInt();
//         } catch (InputMismatchException e) {
//            System.out.println("\t숫자만 입력 가능합니다\n"); // scanner.nextLine()로 초기화 하지 않으면
//            scanner.nextLine();
//         } // InputMismatchException 이 오류 코드를 물고 무한반복함
//         if (p == 1 || p == 2 || p == 3) {
//            break;
//         } else {
//
//         }
//      }
      while (true) { // 정규표현식

         System.out.print("\t▶ 번호 입력: ");
         str = scanner.nextLine();
         if (str.matches("[0-9]+")) { // 숫자 문자 판별 (matches 정규표현식 선언)
            p = Integer.parseInt(str);
            if (p == 1 || p == 2) {
               break; // 해당하는 숫자일경우 탈출
            } else {
               System.out.println("\t없는 번호 입니다. 다시 입력해 주세요.\n");
            }
         } else {
            System.out.println("\t숫자로 입력해야 합니다.다시 확인 해주세요.\n");
         }
      }

      if (i % 2 == p || (i % 2 == 0 && p - 2 == 0)) {
         System.out.println("\t정답! " + reward + "원 획득!\n");
         Egg.money += reward;

      } else {
         System.out.println("\t정답: " + sipping + "\n" + "\n\t｡°(°´ᯅ`°)°｡ 보상 획득 실패\n");
         Egg.stress += 5;
      }

   }

   static void playRSP() {
      int reward = 3000;

      Egg.time += 3;

      System.out.println("\n\t[ 가위 바위 보 게임 ]\n");
      System.out.println("\t컴퓨터와 가위 바위 보를 해서 이겨보세요!\n");
      System.out.println("\t어떤 것을 낼까요?\n" + "\t1)가위\t2) 바위\t3) 보\n");

      String[] rspGame = new String[3];
      rspGame[0] = new String("가위");
      rspGame[1] = new String("바위");
      rspGame[2] = new String("보");

      while (true) {
         int i = (int) (Math.random() * 3);
         while (true) { // 정규표현식

            System.out.print("\t▶ 번호 입력: ");
            str = scanner.nextLine();
            if (str.matches("[0-9]+")) { // 숫자 문자 판별 (matches 정규표현식 선언)
               p = Integer.parseInt(str) - 1;
               if (p + 1 == 1 || p + 1 == 2 || p + 1 == 3) {
                  break; // 해당하는 숫자일경우 탈출
               } else {
                  System.out.println("\t없는 번호 입니다. 다시 입력해 주세요.\n");
               }
            } else {
               System.out.println("\t숫자로 입력해야 합니다.다시 확인 해주세요.\n");
            }
         }
         int x = p - i;
         if (x == 1 || x == -2) {
            System.out.println("\n\t컴퓨터: " + rspGame[i] + " 나: " + rspGame[p] + " 이겼습니다!");
            System.out.println("\t" + reward + "원 획득\n");
            Egg.money += reward;
            break;
         } else if (x == 2 || x == -1) {
            System.out.println("\n\t컴퓨터: " + rspGame[i] + "\t나: " + rspGame[p] + "\n\t｡°(°´ᯅ`°)°｡ 보상 획득 실패\n");
            System.out.println("\t스트레스 Up!!\n");
            Egg.stress += 5;
            break;
         } else {
            System.out.println("\n\t컴퓨터: " + rspGame[i] + "\t나: " + rspGame[p] + " 무승부!");
            System.out.println("\n\t처음부터 다시 진행합니다.");
         }
      }
   }

   static void playPic() {
      int reward = 8000;
      Egg.time += 3;
      System.out.println("\n\t[ 그림 맞추기 게임 ]\n");
      System.out.println("\t컴퓨터가 무작위로 내는 그림을 맞혀보세요!\n");
      System.out.println("\t어떤 그림을 고를까요?\n" + "\t1) ♥︎\t️2) ♠\t︎3) ♦\t4) ♣\n");

      String[] picture = new String[4];
      picture[0] = "하트";
      picture[1] = "스페이드";
      picture[2] = "다이아";
      picture[3] = "클로버";
      while (true) { // 정규표현식
         System.out.print("\t▶ 번호 입력: ");
         str = scanner.nextLine();
         if (str.matches("[0-9]+")) { // 숫자 문자 판별
            p = Integer.parseInt(str) - 1;
            if (p + 1 == 1 || p + 1 == 2 || p + 1 == 3 || p + 1 == 4) {
               break; // 해당하는 숫자일경우 탈출
            } else {
               System.out.println("\t유효하지 않은 번호 입니다. 다시 입력해 주세요.\t");
            }
         } else {
            System.out.println("\t숫자로 입력해야 합니다.다시 확인 해주세요.\t");
         }
      }
      int i = (int) (Math.random() * 4);
      if (i + 1 == (p + 1)) {
         System.out.println("\n\t컴퓨터: " + picture[i] + "\t나: " + picture[p] + " 정답! " + reward + "원 획득!\n");
         Egg.money += reward;
      } else {
         System.out.println("\n\t컴퓨터: " + picture[i] + "\t나: " + picture[p] + "\n\t｡°(°´ᯅ`°)°｡ 보상 획득 실패\n");
         System.out.println("\t스트레스 Up!!\n");
         Egg.stress += 5;
      }
   }

   static void playFraming() {

      int total = 0;
      int reward = 300;
      int trun = 0;
      int max = 0;
      if (max < 10) {
         System.out.println("\n\t[ 파밍하기 게임 ]\n");
         System.out.println("\t노가다로 보상을 획득하세요!\n");
         do {
            System.out.println("\t1) 파밍하기\t2) 그만두기");
            while (true) { // 정규표현식
               System.out.print("\t▶ 번호 입력: ");
               str = scanner.nextLine();
               if (str.matches("[0-9]+")) { // 숫자 문자 판별
                  p = Integer.parseInt(str);
                  if (p == 1 || p == 2) {
                     break; // 해당하는 숫자일경우 탈출
                  } else {
                     System.out.println("\t유효하지 않은 번호 입니다. 다시 입력해 주세요.\n");
                  }
               } else {
                  System.out.println("\t숫자로 입력해야 합니다.다시 확인 해주세요.\n");
               }
            }

            if (p == 1 && max < 10) {
               total = total + reward;
               Egg.money = Egg.money + reward;
               trun++;
               max++;
               DP.farming();
               System.out.printf("\t%d원 획득!\n", reward);
               System.out.printf("\t총 파밍 횟수: %d\n", trun);
            }
         } while (max < 10 && p == 1);
         if (p == 1 && max == 10) {
            System.out.println("\t더 이상 파밍 할수 없습니다.\n");
            System.out.printf("\t총 파밍 횟수: %d\n", trun);
         }
         if (p == 2) {
            System.out.printf("\t파밍을 끝냅니다.\n");
            System.out.printf("\t총 파밍 횟수: %d\n", trun);
         }
      } else {
         System.out.println("\t게임 기회 1회당 연속 파밍 10회까지 할 수 있습니다.\n");
      }
      if (trun <= 5) {
         Egg.time++;
      } else {
         Egg.time += 2;
      }
   }

   public static void numberGame() {
      System.out.println("숫자 맞추기");
      int reward = 2000;
      int min = 1;
      int max = 50;
      int i = (int) ((Math.random() * (max - min)) + min);

      for (int k = 0; k < 6; k++) {
         while (true) {
            System.out.println("숫자 선택: ");
            str = scanner.nextLine();
            if (str.matches("[0-9]+")) { // 정규표현식
               Menu.num = Integer.parseInt(str);
               if (Menu.num > 0 && Menu.num < 51) {
                  break;
               } else {
                  System.out.println("없는 번호 입니다. 다시 입력해 주세요.");
               }
            } else {
               System.out.println("숫자로 입력해야 합니다. 다시 확인 해주세요.");
            }
         }

         if (Menu.num == i) {
            Egg.money += reward;
            System.out.printf("%d 성공!!.\n", Menu.num);
            System.out.printf("보상 %d을 얻었습니다. 남은재산 %d.\n", reward, Egg.money);
            return; // 정답을 맞춘 경우 게임 종료
         } else if (Menu.num >= i) {
            System.out.printf("숫자는 %d 보다 작거나 같습니다.\n", Menu.num);
         } else if (Menu.num <= i) {
            System.out.printf("숫자는 %d 보다 크거나 같습니다.\n", Menu.num);
         }

         if (k < 5) { // 횟수를 다 채우기 전에만 도전 여부 확인
            while (true) {
               System.out.println("정답에 도전 하시겠습니까?");
               System.out.println("1번) YES  2번) NO");
               str = scanner.nextLine();

               if (str.matches("[0-9]+")) { // 정규표현식
                  Menu.num = Integer.parseInt(str);
                  if (Menu.num == 1) {
                     System.out.println("정답 입력: ");
                     str = scanner.nextLine();
                     if (str.matches("[0-9]+")) { // 정규표현식
                        int p = Integer.parseInt(str);
                        if (p > 0 && p < 51) {
                           if (p == i) {
                              Egg.money += reward;
                              System.out.printf("%d 성공!!.\n", p);
                              System.out.printf("보상 %d을 얻었습니다. 남은재산 %d.\n", reward, Egg.money);
                              return; // 정답을 맞춘 경우 게임 종료
                           } else {
                              System.out.printf("%d 틀렸습니다!!\n", p);
                              System.out.printf("보상 획득 실패. 남은재산 %d.\n", Egg.money);
                              return; // 정답을 틀린 경우 게임 종료
                            }

                        } else {
                           System.out.println("없는 번호 입니다. 다시 입력해 주세요.");
                        }
                     } else {
                        System.out.println("숫자로 입력해야 합니다. 다시 확인 해주세요.");
                     }
                  } else if (Menu.num == 2) {
                     break; // 도전하지 않을 경우 반복문 탈출후 재도전
                  } else {
                     System.out.println("없는 번호 입니다. 다시 입력해 주세요.");
                  }
               } else {
                  System.out.println("숫자로 입력해야 합니다. 다시 확인 해주세요.");
               }
            }
         }
      }
   }
}