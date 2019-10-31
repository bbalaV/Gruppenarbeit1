package com.company;
import java.util.*;
public class Main {
    /*
    Team Salman	Ugras, Marcel Stauffiger, Varshan Balasunderam
     */
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String choice;
        int num_Throws;
        do {
            System.out.println("Sie dürfen Spielen");
            System.out.println("Wählen Sie ein Spiel durch Eingabe des jeweiligen Buchstabens aus: \nWürfeln [w] \nMünzwurf [m] \nBeenden [q]");
            choice = input.nextLine();
            switch (choice) {
                case "w":
                    System.out.println("Würfeln. Wie oft soll gewürfelt werden? Eingabe einer Zahl oder 'Enter' für einmal.");
                    num_Throws = get_int_input();
                    roll_dice(num_Throws);
                    break;
                case "m":
                    System.out.println("Münzwurf. Wie oft soll geworfen werden? Eingabe einer Zahl oder 'Enter' für einmal.");
                    num_Throws = get_int_input();
                    flip_coin(num_Throws);

                    break;
                case "q":
                    break;
                default:
                    System.out.println("Diese Option existiert nicht");
            }
            System.out.println("-------------------------------------------------------------------------");
        } while (!choice.equals("q"));
        System.out.println("Programmende. Vielen Dank fürs Mitspielen.");
    }

    public static void roll_dice(int num_Throws) {
        double total_dice = 0;
        for (int i = 0; i < num_Throws; i++) {
            int die_num = (int) (Math.random() * 6) + 1;
            System.out.println("Ergebnis: " + die_num);
            total_dice += die_num;
        }
        System.out.println("Zusammenfassung: Anzahl der Würfe = " + num_Throws +
                "   Summe = " + (int) total_dice + "  Durschnitt = " +  (total_dice / num_Throws));
    }

    public static void flip_coin(int num_Throws) {
        int total_head = 0;
        int total_tails = 0;
        for (int i = 0; i < num_Throws; i++) {
            double coin_result = Math.random();
            System.out.println("Ergebnis " + (coin_result > 0.5 ? "W" : "Z"));
            if (coin_result > 0.5) {
                total_head++;
            } else {
                total_tails++;
            }
        }
        System.out.println("Zusammenfassung: Anzahl der Münzwürfe = " + num_Throws + "   Wappen:Zahl = " + total_head + ":" + total_tails);
    }

    public static int get_int_input() {
        int num_Throws;
        String input_value;
        while (true) {
            input_value = input.nextLine();
            if (input_value.isEmpty()) {
                num_Throws = 1;
                break;
            } else if (isInt(input_value)) {
                num_Throws = Integer.parseInt(input_value);
                break;
            }
            System.out.println("Bitte eine ganze Zahl eingeben oder 'Enter' drücken");
        }

        return num_Throws;
    }

    public static boolean isInt(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

