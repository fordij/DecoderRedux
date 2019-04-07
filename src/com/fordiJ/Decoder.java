package com.fordiJ;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import org.ejml.simple.SimpleMatrix;
import com.fordiJ.Translator;

public class Decoder {

    private SimpleMatrix key;
    private boolean size2;
    private ArrayList<Integer> decdata;

    public Decoder(boolean sz2) {
        Scanner read = new Scanner(System.in);
        size2 = sz2;
        System.out.println("Chose decoding.");
        if (size2) {
            System.out.println("Chose 2x2.");
            System.out.println("Please type out your key matrix. Go from left to right and then the next column, pressing enter after every number.");
            double[] tempkey = new double[4];
            // read off every number then turn it into actual matrix
            for (int i = 0;i <=3; i++) {
                int size = read.nextInt();
                tempkey[i] = size;
            }
            SimpleMatrix tempkeymatrix = new SimpleMatrix(2,2,true,tempkey);
            key = tempkeymatrix;
            decdata = Reader.intDataInput(sz2, key);
        }
        else {
            System.out.println("Chose 3x3.");
            System.out.println("Please type out your key matrix. Go from left to right and then the next column, pressing enter after every number.");
            double[] tempkey = new double[10];
            // read off every number then turn it into actual matrix
            for (int i = 0;i <=8; i++) {
                int size = read.nextInt();
                tempkey[i] = size;
            }
            SimpleMatrix tempkeymatrix = new SimpleMatrix(3,3,true,tempkey);
            key = tempkeymatrix;
            decdata = Reader.intDataInput(sz2, key);
        }
    }

    public void printDecoded() {
        System.out.println("Your decoded numbers are:");
        System.out.println(" ");
        for (int i = 0; i < decdata.size(); i++) {
            System.out.print("#" + (i+1) + ": " + decdata.get(i) + ", ");
        }
        System.out.println(" ");
        System.out.println("Your translated message is:");
        System.out.println(" ");

        for (int i = 0; i < decdata.size(); i++) {
            System.out.print(Translator.encTranslate(decdata.get(i)));
        }
    }
}
