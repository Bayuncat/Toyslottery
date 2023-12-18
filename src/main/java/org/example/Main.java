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

/* ����� �������*/

        int toysnum; /* ���������� ��� �������� ����� ��������� �������*/
        List<Integer> Id = new ArrayList<Integer>(); /* ��������� ������ ��� �������� ID �������*/
        List<Integer> Odds = new ArrayList<Integer>(); /* ��������� ������ ��� �������� ������������ �������*/
        List<String> Names = new ArrayList<String>(); /* ��������� ������ ��� �������� ���� �������*/

        /* ������ ����� �������*/

        Scanner sc = new Scanner(System.in);
        System.out.println("������� ����� ������� ��� ���������, �� ����� 10 ��� q :");

        /* �������� ���������� �����*/
        toysnum = Controller.getNum(sc);

        /* ������ ������ ������� � ��������� ���������� �����*/
        System.out.println("������ ��������� ����� ������: id, ����������� �������� � �������� �������. ����� "
                + toysnum + " �����(�). ��������� ����������� ����� ���� = 10.");

        while (toysnum>0)
        {
            int id =0; /* ��������� ����������*/
            int odds =0; /* ��������� ����������*/
            System.out.println("�������� �������� # " + toysnum + " �������");
            String toyInfo = sc.nextLine();
            String[] toyArray = toyInfo.split(" ");

            try {
                id = Integer.parseInt(toyArray[0]);
                odds = Integer.parseInt(toyArray[1]);
                /* �������� �� ������������ Id ��� �������*/
                    if (!Controller.checkRepeatArray((ArrayList<Integer>) Id, id)){
                        throw new UniqueId ("UniqueId");
                    }

                /* �������� �� ����� ������������, �������� �� ����� 10*/
                    if (!Controller.checkSumArray((ArrayList<Integer>) Odds, odds)){
                        throw new OutOfOddsSum("OutOfOddsSum");
                    }

                Id.add(id);
                Odds.add(odds);
                Names.add(toyArray[2]);
                toysnum--;

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("� ����������� � ������ ������� ����� ���� ������ ����������� ����� ����� ������");
                } catch (UniqueId e) {
                System.out.println("���� Id �� ����������. ����� ��� ����");
                } catch (OutOfOddsSum e) {
                System.out.println("��������� ����������� �� ����� ���� ����� 10");
                }

        }

        /* ������� toysnum �������� ������� � ���������� �� � PriorityQueue*/
        toyPQ = Controller.CreateToys((ArrayList<Integer>) Id, (ArrayList<Integer>) Odds, (ArrayList<String>) Names);

        Dto.fileWiter(toyPQ);
    }
}