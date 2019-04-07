package com.fordiJ;

// coded by Jace Fordi

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import org.ejml.simple.SimpleMatrix;
import com.fordiJ.Reader;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome! Type 1 for encoding or 2 for decoding.");
        int decide = reader.nextInt();
        System.out.println("Type 2 if you're using a 2x2 matrix or 3 for a 3x3 matrix.");
        int size = reader.nextInt();
        boolean size2;
        if (size == 2) {size2 = true;}
        else {size2 = false;}

        if (decide == 1) {
            Encoder encode =  new Encoder(size2);
            encode.printEncoded();
        }

        else {
            Decoder decode = new Decoder(size2);
            decode.printDecoded();
        }


    }
}
