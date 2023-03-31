import java.util.Scanner;

public class Validated {




    public static int height(Scanner sc) {
        while (true) {
            int num = integer(sc);
            if (num >= 0 && num < 1000) {
                return num;
            }
            System.out.println("Pra6ome įvesti teisiną aukštį ");
        }
    }


    public static int integer(Scanner sc) {
        int input = 0;
        boolean shouldGo = true;
        while (shouldGo) {
            try {
                input = sc.nextInt();
                shouldGo = false;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Pasirinkite teisingą skaičių");
            }
        }
        return input;
    }

    public static boolean boole(Scanner sc) {
        boolean input = false;
        boolean shouldGo = true;
        while (shouldGo) {
            try {
                input = sc.nextBoolean();
                shouldGo = false;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Pasirinkite teisinga reikšme (true/false)");
            }
        }
        return input;
    }
//    public static String string(Scanner sc) {
//        while (true) {
//               String input = sc.nextLine();
//               if (){
//                   return input;
//               }
//
//
//        }
//
//    }


}
