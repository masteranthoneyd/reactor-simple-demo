package operational;

import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.time.Duration.ofMillis;

/**
 * @author ybd
 * @date 17-11-30
 */
public class OpsFlatMap {
	public static void main(String[] args) throws InterruptedException {
//		opsOfFlatMap();
		opsOfFlatMapSequential();
	}

	private static void opsOfFlatMap() throws InterruptedException {
		AtomicInteger atomicInteger = new AtomicInteger();
		Flux.just(5, 10)
			.flatMap(x -> Flux.interval(ofMillis(x * 10), ofMillis(100)).take(x))
			.subscribe(v -> System.out.println(v + " " + atomicInteger.incrementAndGet()));
		TimeUnit.SECONDS.sleep(1);
		System.out.println();
	}

	private static void opsOfFlatMapSequential() {
		AtomicInteger atomicInteger = new AtomicInteger();
		Flux.just(5, 10)
			.flatMapSequential(x -> Flux.interval(ofMillis(x * 10), ofMillis(100)).take(x))
			.toStream()
			.forEach(v -> System.out.println(v + " " + atomicInteger.incrementAndGet()));
	}
}
