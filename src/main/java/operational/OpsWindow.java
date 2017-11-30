package operational;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author ybd
 * @date 17-11-30.
 */
public class OpsWindow {
	public static void main(String[] args) {
		opsOfWindow();
	}

	private static void opsOfWindow() {
		Flux.range(1, 100).window(20).subscribe(System.out::println);
		System.out.println();
		Flux.interval(Duration.ofMillis(100)).window(Duration.ofMillis(1001)).take(2).toStream().forEach(System.out::println);
	}
}
