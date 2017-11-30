package operational;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author ybd
 * @date 17-11-30.
 */
public class OpsBuffer {
	public static void main(String[] args) {
		opsOfBuffer();
	}

	private static void opsOfBuffer() {
		Flux.range(1, 100).buffer(20).subscribe(System.out::println);
		Flux.interval(Duration.ofMillis(100)).buffer(10).take(2).toStream().forEach(System.out::println);
		Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
		Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
	}
}
