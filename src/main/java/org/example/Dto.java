package org.example;

import java.io.*;
import java.util.PriorityQueue;

public class Dto {

    public static void fileWiter(PriorityQueue toyPQ) throws IOException {


        File output = new File("output.txt");
        FileWriter writer = new FileWriter(output);

        while (!toyPQ.isEmpty()) {
            writer.write("Выигрывает игрушка : " + toyPQ.poll().toString() + "\n");

        }
        writer.flush();
        writer.close();

       }

}

