package com.cleancode.knuth;

public class PrimePrinter {

    private static final int numberOfNumbers = 1000;
    private static final int linesPerPage = 50;
    private static final int columns = 4;

    public static void main(String[] args) {
        PrimePrinterHelper helper = new PrimePrinterHelper(numberOfNumbers);
        int[] primes = helper.getPrimes();

        NumberPrinter printer = new NumberPrinter(linesPerPage, columns);
        printer.printNumbers(primes, numberOfNumbers);
    }
}
