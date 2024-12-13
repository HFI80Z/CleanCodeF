package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int[] primes;
    private final int ordmax = 30;
    private final int[] multiples = new int[ordmax + 1];
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n = 0;

    public PrimePrinterHelper(int numberOfNumbers) {
        primes = new int[numberOfNumbers + 1];
        primes[1] = 2;
        generatePrimes(numberOfNumbers);
    }

    public void generatePrimes(int numberOfNumbers) {
        while (primeIndex < numberOfNumbers) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;
        }
    }

    public int[] getPrimes() {
        return primes;
    }
}
