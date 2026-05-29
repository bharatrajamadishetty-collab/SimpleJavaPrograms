import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class BigIntegerDemoClass {
    public static void main(String[] args) {
        BigInteger x = new BigInteger(
                "123456789012345678902748926389471923749820948592374871893648613417480914763491384701641739070913789461846917");
        BigInteger y = new BigInteger(
                "98765432109876543210987654321847583653658347578502572385082357289759028589237592735087486462384789795623642364827474642674727624729335972359729709876543210987654321098765432109876543210987654321098765432109876543210987654321");
        BigInteger sum = x.add(y);
        String sumString = sum.toString();
        System.out.println("Sum = " + sumString);
        System.out.println("Product = " + x.multiply(y));
        System.out.println("Quotient = " + y.divide(x));
        System.out.println("Square root = " + y.sqrt());
        System.out.println("Compare to = " + y.compareTo(x));
        System.out.println("Square of x = " + x.pow(2));
        System.out.println("XOR = " + y.xor(x));
        System.out.println("Square root and remainder = " + Arrays.toString(y.sqrtAndRemainder()));
        System.out.println("Modular inverse = " + y.modInverse(x));
        System.out.println("GCD = " + y.gcd(x));
        System.out.println("Multiply and Square root = " + y.parallelMultiply(x).sqrt());
        System.out.println("Probable prime = " + BigInteger.probablePrime(5, new Random()));

    }
}
