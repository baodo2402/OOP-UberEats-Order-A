package model;

import java.util.*;

public class In {
    private static Scanner in = new Scanner(System.in);

    public static String nextLine() {
        return in.nextLine();
    }

    public static char nextChar() {
        while (true) {
            try {
                return in.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter a single character.");
            }
        }
    }

    public static char nextUpperChar() {
        while (true) {
            try {
                return in.nextLine().toUpperCase().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter a single character.");
            }
        }
    }

    public static int nextInt() {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    public static double nextDouble() {
        while (true) {
            try {
                return Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a double.");
            }
        }
    }

    public static int readInt(String message) {
        System.out.print("Please enter " + message);
        return In.nextInt();
    }

    public static double readDouble(String message) {
        System.out.print("Please enter " + message + ": ");
        return In.nextDouble();
    }

    public static String readName(String message) {
        System.out.print("Please enter " + message + " name: ");
        return In.nextLine();
    }

    public static int readNameInt(String message) {
        System.out.print("Please enter " + message + " name: ");
        return In.nextInt();
    }

    public static String formatted(double amount) {
        return String.format("%.2f", amount);
    }
}
