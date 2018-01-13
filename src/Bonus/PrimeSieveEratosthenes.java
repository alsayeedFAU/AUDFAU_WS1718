import java.math.BigInteger;

public class PrimeSieveEratosthenes {
	BigInteger big = BigInteger.ONE.add(BigInteger.ONE);
	PrimeSieveEratosthenes prime;

	public BigInteger getNextPrime() {
		if (prime == null) {
			prime = new PrimeSieveEratosthenes();
			prime.big = big;
		} else {
			big = big.add(BigInteger.ONE);
			PrimeSieveEratosthenes tmp = prime;
			while (tmp != null) {
				if (big.mod(tmp.big).equals(BigInteger.ZERO)) {
					big = big.add(BigInteger.ONE);
					tmp = prime;
				}
				tmp = tmp.prime;
			}
			PrimeSieveEratosthenes next = new PrimeSieveEratosthenes();
			next.big = big;
			next.prime = prime;
			prime = next;
		}

		return big;
	}

}
