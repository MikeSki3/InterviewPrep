package tutes.bitmanipulation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumVsXOr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println((n == 0) ? 1 : 1L << (Long.toBinaryString(n).length() - Long.bitCount(n)));
    }
}