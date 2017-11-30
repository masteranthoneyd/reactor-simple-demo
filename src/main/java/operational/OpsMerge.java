package operational;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author ybd
 * @date 17-11-30
 */
public class OpsMerge {
	public static void main(String[] args) throws InterruptedException {
		opsOfMerge();
	}

	private static void opsOfMerge() throws InterruptedException {
		Flux.merge(Flux.interval(Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5)).subscribe(System.out::println);
		TimeUnit.SECONDS.sleep(2);
		System.out.println();
		Flux.mergeSequential(Flux.interval(Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
			.toStream()
			.forEach(System.out::println);
	}
}
