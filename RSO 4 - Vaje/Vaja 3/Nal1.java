import java.math.BigInteger;
import java.util.*;

class Nal1 {
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {

        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) {
            return x.multiply(y);
        }

        N = (N / 2) + (N % 2);

        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac    = karatsuba(a, c);
        BigInteger bd    = karatsuba(b, d);
        BigInteger abcd  = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Vnesi prvo število:");
        BigInteger a = x.nextBigInteger();
        System.out.println("Vnesi drugo število:");
        BigInteger b = x.nextBigInteger();

        BigInteger produkt = karatsuba(a, b);
        
        System.out.println("Produkt je:");
        System.out.println(produkt);
    }
}