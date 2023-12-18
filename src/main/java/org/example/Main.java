package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue toyPQ = new PriorityQueue<Toy>();

/* ввода игрушек*/

        int toysnum; /* переменна€ дл€ хранени€ числа различных игрушек*/
        List<Integer> Id = new ArrayList<Integer>(); /* временный массив дл€ хранени€ ID игрушек*/
        List<Integer> Odds = new ArrayList<Integer>(); /* временный массив дл€ хранени€ веро€тностей игрушек*/
        List<String> Names = new ArrayList<String>(); /* временный массив дл€ хранени€ имен игрушек*/

        /* введем число игрушек*/

        Scanner sc = new Scanner(System.in);
        System.out.println("¬ведите число игрушек дл€ розыгрыша, не более 10 или q :");

        /* проверим валидность ввода*/
        toysnum = Controller.getNum(sc);

        /* введем данные игрушек с проверкой валидности ввода*/
        System.out.println("¬едите построчно через пробел: id, веро€тность выигрыша и назавние игрушки. ¬сего "
                + toysnum + " строк(и). —уммарна€ веро€тность должа быть = 10.");

        while (toysnum>0)
        {
            int id =0; /* временна€ переменна€*/
            int odds =0; /* временна€ переменна€*/
            System.out.println("ќсталось записать # " + toysnum + " игрушек");
            String toyInfo = sc.nextLine();
            String[] toyArray = toyInfo.split(" ");

            try {
                id = Integer.parseInt(toyArray[0]);
                odds = Integer.parseInt(toyArray[1]);
                /* проврека на уникальность Id дл€ игрушки*/
                    if (!Controller.checkRepeatArray((ArrayList<Integer>) Id, id)){
                        throw new UniqueId ("UniqueId");
                    }

                /* проврека на сумму веро€тностей, суммарно не более 10*/
                    if (!Controller.checkSumArray((ArrayList<Integer>) Odds, odds)){
                        throw new OutOfOddsSum("OutOfOddsSum");
                    }

                Id.add(id);
                Odds.add(odds);
                Names.add(toyArray[2]);
                toysnum--;

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("” веро€тности и номера игрушки могут быть только натуральные числа через пробел");
                } catch (UniqueId e) {
                System.out.println("Ётот Id не уникальный. “акой уже есть");
                } catch (OutOfOddsSum e) {
                System.out.println("—уммарна€ веро€тность не может быть более 10");
                }

        }

        /* создаем toysnum объектов игрушек и записываем их в PriorityQueue*/
        toyPQ = Controller.CreateToys((ArrayList<Integer>) Id, (ArrayList<Integer>) Odds, (ArrayList<String>) Names);

        Dto.fileWiter(toyPQ);
    }
}