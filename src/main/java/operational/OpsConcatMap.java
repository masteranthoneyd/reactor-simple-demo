package operational;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

import static java.time.Duration.ofMillis;

/**
 * @author ybd
 * @date 17-11-30
 */
public class OpsConcatMap {
	public static void main(String[] args) {
		opsOfConcatMap();
	}

	private static void opsOfConcatMap() {
		AtomicInteger atomicInteger = new AtomicInteger();
		Flux.just(5, 10)
			.concatMap(x -> Flux.interval(ofMillis(x * 10), ofMillis(100)).take(x))
			.toStream()
			.forEach(v -> System.out.println(v + " " + atomicInteger.incrementAndGet()));
	}


}
