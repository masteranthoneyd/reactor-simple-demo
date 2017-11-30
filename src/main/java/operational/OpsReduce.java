package operational;

import reactor.core.publisher.Flux;

/**
 * @author ybd
 * @date 17-11-30
 */
public class OpsReduce {
	public static void main(String[] args) {
		opsOfReduce();
	}

	private static void opsOfReduce() {
		Flux.range(1, 10000).reduce((x, y) -> x + y).subscribe(System.out::println);
		Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);
	}


}
