package com.fordiJ;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import org.ejml.simple.SimpleMatrix;

public class Encoder {

    private SimpleMatrix key;
    private boolean size2;
    private ArrayList<Integer> encdata;

    public Encoder(boolean sz2) {
        Scanner read = new Scanner(System.in);
        size2 = sz2;
        System.out.println("Chose encoding.");
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
            encdata = Reader.stringDataInput(sz2, key);
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
            encdata = Reader.stringDataInput(sz2, key);
        }
    }

    public void printEncoded() {
        System.out.println("Your encoded numbers are:");
        for (int i = 0; i < encdata.size(); i++) {
            System.out.println("#" + (i+1) + ": " + encdata.get(i));
        }
    }
}
