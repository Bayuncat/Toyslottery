package org.example;

import java.util.*;
import java.lang.*;

public class Controller {

/* принимаем число игрушек*/
    public static int getNum(Scanner sc) {
        String choose = "";
        int d =0;
        while (!(choose.equalsIgnoreCase("q"))) {
            try {
                d = Integer.parseInt(choose);
                if ((d > 0 && d < 11)) {
                    break;
                } else {
                    System.out.println("только от 1 до 10\n");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Только натуральное можно");
            }
            System.out.print("Введите число игрушек для розыгрыша, не более 10 :");
            sc = new Scanner(System.in);
            choose = sc.nextLine();
        }

        if (choose.equalsIgnoreCase("q")) System.exit(1);
        return d;
    }

    /* поиск повторяющихся значений в массиве*/
    public static boolean checkRepeatArray(ArrayList<Integer> ids, int inputId) {
        for (int id : ids) {
            if (inputId == id) {
                return false;
            }
        }
        return true;
    }

    /* поиск суммы значений в массиве не более 10*/
    public static boolean checkSumArray(ArrayList<Integer> odds, int odd){
        int sum = 0;
        for (int oddi : odds) {
            sum = sum + oddi;
        }

        if (sum + odd > 10){
            return false;}
        else {
            return true;
        }
    }

    public static PriorityQueue CreateToys(ArrayList<Integer> Id, ArrayList<Integer> Odds, ArrayList<String> Names){

        ArrayList<Toy> toysList = new ArrayList<Toy>();

        for (int i = 0; i < Id.size(); i++) {
            for (int j = 0; j < Odds.get(i); j++){
                Toy newToy = new Toy(Id.get(i), Names.get(i));
                toysList.add(newToy);
            }
        }

        /* Перемешиваю коллецию*/
        Collections.shuffle(toysList);

        /* Записываю коллекцию в PriorityQueue*/

        PriorityQueue toyPQ = new PriorityQueue<Toy>(toysList);

            return toyPQ;
}

        }



