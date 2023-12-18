package org.example;

import java.util.*;
import java.lang.*;

public class Controller {

/* ��������� ����� �������*/
    public static int getNum(Scanner sc) {
        String choose = "";
        int d =0;
        while (!(choose.equalsIgnoreCase("q"))) {
            try {
                d = Integer.parseInt(choose);
                if ((d > 0 && d < 11)) {
                    break;
                } else {
                    System.out.println("������ �� 1 �� 10\n");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("������ ����������� �����");
            }
            System.out.print("������� ����� ������� ��� ���������, �� ����� 10 :");
            sc = new Scanner(System.in);
            choose = sc.nextLine();
        }

        if (choose.equalsIgnoreCase("q")) System.exit(1);
        return d;
    }

    /* ����� ������������� �������� � �������*/
    public static boolean checkRepeatArray(ArrayList<Integer> ids, int inputId) {
        for (int id : ids) {
            if (inputId == id) {
                return false;
            }
        }
        return true;
    }

    /* ����� ����� �������� � ������� �� ����� 10*/
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

        /* ����������� ��������*/
        Collections.shuffle(toysList);

        /* ��������� ��������� � PriorityQueue*/

        PriorityQueue toyPQ = new PriorityQueue<Toy>(toysList);

            return toyPQ;
}

        }



