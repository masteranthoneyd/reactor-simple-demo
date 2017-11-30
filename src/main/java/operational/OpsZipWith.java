package operational;

import reactor.core.publisher.Flux;

/**
 * @author ybd
 * @date 17-11-30.
 */
public class OpsZipWith {
	public static void main(String[] args) {
		opsOfZipWith();
	}

	private static void opsOfZipWith() {
		Flux.just("a", "b")
			.zipWith(Flux.just("c", "d"))
			.subscribe(System.out::println);
		Flux.just("a", "b")
			.zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
			.subscribe(System.out::println);
	}
}
