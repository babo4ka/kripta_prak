package org.example;

import org.example.QuickExp.QuickEx;
import org.example.QuickExp.QuickExpMod;

import java.math.BigInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        System.out.println(QuickEx.quickExp(new BigInteger(String.valueOf(5)), new BigInteger(String.valueOf(3))));

        System.out.println(QuickExpMod.quickExpMod(new BigInteger(String.valueOf(3)),
                new BigInteger(String.valueOf(45)), new BigInteger(String.valueOf(7))));
    }
}