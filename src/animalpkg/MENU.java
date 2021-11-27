package animalpkg;

import java.util.ArrayList;
import java.util.Scanner;

public class MENU extends ArrayList<String> {
    String msg;
    public static Scanner sc = new Scanner(System.in);

    public MENU(String msg) {
        super();
        this.msg = msg;
    }

    public int getUserChoice() {
        while (true) {
            try {
                System.out.println(msg);
                for (int i = 0; i < this.size(); i++)
                    System.out.println((i + 1) + "-" + this.get(i));
                System.out.println("Other: Quit-Choose: ");
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Wrong input, input again");
            }
        }
    }
    public int getUserChoice2() {
        while (true) {
            try {
                System.out.println(msg);
                for (int i = 0; i < this.size(); i++)
                    System.out.println((i + 1) + "-" + this.get(i));
                System.out.println("Other: Quit ");
                return MyScanner.getInt("Choose:",4);
            } catch (Exception e) {
                System.out.println("Wrong input, input again");
            }
        }
    }
}
