package com.fordiJ;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import org.ejml.simple.SimpleMatrix;
import com.fordiJ.Translator;

public class Reader {
    // next part makes an array full of encoded nums
    public static ArrayList<Integer> stringDataInput (boolean sz2, SimpleMatrix key) {
        Scanner readyou = new Scanner(System.in);
        System.out.println("Please type out every letter you wish to decode, pressing enter every letter. Type END to stop.");
        boolean inputgo = true;
        ArrayList<Integer> encdata = new ArrayList<Integer>();
        if (sz2) {
            while (inputgo) {
                String strtemp1 = readyou.nextLine();
                String strtemp2 = readyou.nextLine();

                if (strtemp1.compareTo("END") == 0 || strtemp1.compareTo("end") == 0) {
                    inputgo = false;
                }
                else if (strtemp2.compareTo("END") == 0 || strtemp2.compareTo("end") == 0) {
                    inputgo = false;
                }
                else {
                    // make matrix
                    SimpleMatrix nummatrix = new SimpleMatrix(2, 1, true, new double[]{Translator.numTranslate(strtemp1), Translator.numTranslate(strtemp2)});
                    SimpleMatrix multed = key.mult(nummatrix);
                    encdata.add((int) multed.get(0));
                    encdata.add((int) multed.get(1));
                }
            }
        }


        else {
            while (inputgo) {
                String strtemp1 = readyou.nextLine();
                String strtemp2 = readyou.nextLine();
                String strtemp3 = readyou.nextLine();
                if (strtemp1.compareTo("END") == 0 || strtemp1.compareTo("end") == 0) {
                    inputgo = false;
                }
                else if (strtemp2.compareTo("END") == 0 || strtemp2.compareTo("end") == 0) {
                    inputgo = false;
                }
                else if (strtemp3.compareTo("END") == 0 || strtemp3.compareTo("end") == 0) {
                    inputgo = false;
                }
                else {
                    // make matrix
                    SimpleMatrix nummatrix = new SimpleMatrix(3, 1, true, new double[]{Translator.numTranslate(strtemp1), Translator.numTranslate(strtemp2),Translator.numTranslate(strtemp3)});
                    SimpleMatrix multed = key.mult(nummatrix);
                    encdata.add((int) multed.get(0));
                    encdata.add((int) multed.get(1));
                    encdata.add((int) multed.get(2));
                }
            }
        }

        return encdata;
    }

    public static ArrayList<Integer> intDataInput (boolean sz2, SimpleMatrix key) {
        Scanner readyou = new Scanner(System.in);
        System.out.println("Please type out every encoded number, pressing enter every number. Type 0 to stop.");
        boolean inputgo = true;
        ArrayList<Integer> encdata = new ArrayList<Integer>();
        SimpleMatrix invertkey = key.invert();
        System.out.println("Inversed key:");
        invertkey.print();
        if (sz2) {
            while (inputgo) {
                int inttemp1 = readyou.nextInt();
                int inttemp2 = readyou.nextInt();
                if (inttemp1 == 0 || inttemp2 == 0) {
                    inputgo = false;
                }
                else {
                    // make matrix
                    SimpleMatrix nummatrix = new SimpleMatrix(2, 1, true, new double[]{inttemp1,inttemp2});
                    SimpleMatrix multed = invertkey.mult(nummatrix);
                    encdata.add((int) multed.get(0));
                    encdata.add((int) multed.get(1));
                }
            }
        }

        else {
            while (inputgo) {
                int inttemp1 = readyou.nextInt();
                int inttemp2 = readyou.nextInt();
                int inttemp3 = readyou.nextInt();
                if (inttemp1 == 0 || inttemp2 == 0 || inttemp3 == 0) {
                    inputgo = false;
                }
                else {
                    // make matrix
                    SimpleMatrix nummatrix = new SimpleMatrix(3, 1, true, new double[]{inttemp1,inttemp2,inttemp3});
                    SimpleMatrix multed = invertkey.mult(nummatrix);
                    encdata.add((int) multed.get(0));
                    encdata.add((int) multed.get(1));
                    encdata.add((int) multed.get(2));
                }
            }
        }

        return encdata;
    }
}
