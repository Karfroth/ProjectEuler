package q1to10;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.*;

public class Q1to10 {
	
	public static int q1() {
		int answer = IntStream.range(0, 1000)
		.filter(w -> ((w % 3 == 0) || (w % 5) == 0))
		.sum();
		return answer;
	}
	
	public static Long q2(){
		
		return Stream.iterate(new long[] {1, 1}, p -> new long[] {p[1], p[0] + p[1]})
				.map(p -> p[1])
				.limit(35)
				.filter(w -> (w % 2 == 0))
				.reduce((p1, p2) -> p1 + p2).orElse(null)
				.longValue();
	}
	
	public static long q3() {
		
		long target = 600851475143L;
		
		MyList<Long> answers = q3Helper(target);
		
		return answers.getOrElse(answers.size() - 1, 0L);
		
	}
	
	public static MyList<Long> q3Helper(long target) {
		long count = 2;
		
		MyList<Long> numList = new MyList<>();
		
		while(target != 1){
			if(target % count == 0){
				numList.add(count);
				target = target / count;
			}
			count++;
		}
		
		return numList;
	}
	
	public static long q4() {

		Set<Long> numSet = new HashSet<>();
		
		for(long i = 999; i > 99; i--){
			
			for (long j = 999; j>99; j--){
				Long productNum = i * j;
				String numStr = productNum.toString();
				String reversed = new StringBuffer(numStr).reverse().toString();
				if (numStr.equals(reversed)) {
					numSet.add(productNum);
				}
			}
			
		}
		
		return Collections.max(numSet);
		
	}
	
	public static long q5() {
		
		LongStream rangeStream = LongStream.rangeClosed(1, 20);
		return rangeStream.reduce((p1, p2) -> (p1 * p2) / gcdThing(p1, p2)).orElse(0);
		
	}
	
	private static int gcdThing(long a, long b) {
		
		// Easy GCD function from 
		// http://stackoverflow.com/questions/4009198/java-get-greatest-common-divisor
		
	    BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
	
	public static void main(String[] args) {
		System.out.println("Q1: " + q1());
		System.out.println("Q2: " + q2());
		System.out.println("Q3: " + q3());
		System.out.println("Q4: " + q4());
		System.out.println("Q5: " + q5());
	}
	
}