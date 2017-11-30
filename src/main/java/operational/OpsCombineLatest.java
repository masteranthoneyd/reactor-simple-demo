package operational;

import reactor.core.publisher.Flux;

import java.util.Arrays;

import static java.time.Duration.ofMillis;

/**
 * @author ybd
 * @date 17-11-30
 */
public class OpsCombineLatest {
	public static void main(String[] args) {
		opsOfCombineLatest();
	}

	private static void opsOfCombineLatest() {
		Flux.combineLatest(
				Arrays::toString,
				Flux.interval(ofMillis(100)).take(6),
				Flux.interval(ofMillis(50), ofMillis(100)).take(5)
		).toStream().forEach(System.out::println);
	}
}
