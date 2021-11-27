package animalpkg;

import java.util.Scanner;

public class MyScanner {
    public static boolean getBoolean(String msg) {
        String s = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
//            try {
                s=getNonBlankStr(msg);
                if (s.charAt(0) == 'y' || s.charAt(0) == 'Y' || s.charAt(0) == 'T' || s.charAt(0) == '1' || s.charAt(0) == 't')
                    return true;
                else if (s.charAt(0) == 'N' || s.charAt(0) == 'n' || s.charAt(0) == 'F' || s.charAt(0) == '0' || s.charAt(0) == 'f')
                    return false;
//            } catch (Exception e) {
                System.out.println("Please input y/Y/t/T/1 or n/N/f/F/0");
                System.out.println("Enter again");
//            }
        }
    }

    public static double getDouble(String msg, double min, double max) {
        double x = 0;
        Scanner sc = new Scanner(System.in);
        if (min > max) {
            x = min;
            min = max;
            max = x;
        }
        while (true) {
            System.out.println(msg + "(" + min + "..." + max + ")");
            try {
                x = Double.parseDouble(sc.nextLine().trim());
                if (x < min || x > max) {
                    throw new NumberFormatException();
                } else return x;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input.Input again");
            }
        }
        //do while(x<min||x>max)
    }

    public static double getDouble(String msg, double max) {
        double x = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(msg + "(" + "0" + "..." + max + ")");
            try {
                x = Double.parseDouble(sc.nextLine().trim());
                if (x < 0 || x > max) {
                    throw new NumberFormatException();
                } else return x;
            } catch (NumberFormatException e) {
                System.out.println("You should input number in range "+0+","+max);
            }
        }

    }

    public static int getInt(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        if (min > max) {
            x = min;
            min = max;
            max = x;
        }
        while (true) {
            System.out.println(message+"(" + "0" + "..." + max + ")");
            try {
                x = Integer.parseInt(sc.nextLine().trim());
                if (x < min || x > max) {
                    throw new NumberFormatException();
                }
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input input again");
            }
        }
    }

    public static int getInt(String message, int max) {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            try {
                x = Integer.parseInt(sc.nextLine().trim());
                if (x < 0 || x > max) {
                    throw new NumberFormatException();
                } else {
                    return x;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should input number in 0"+","+max);
            }
        }
    }

    public static String getNonBlankStr(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(msg);
            msg = sc.nextLine().trim();
            if (msg.isEmpty()) {
                System.out.println("String can't be empty. Please Input again");
            } else return msg;
        }
    }

}

