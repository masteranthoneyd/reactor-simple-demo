package operational;

import reactor.core.publisher.Flux;

/**
 * @author ybd
 * @date 17-11-30
 */
public class OpsTake {
	public static void main(String[] args) {
		opsOfTake();
	}

	private static void opsOfTake() {
		Flux.range(1, 1000).take(10).subscribe(System.out::println);
		Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
		Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
		Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);
	}
}
