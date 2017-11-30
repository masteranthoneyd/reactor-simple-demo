package debug;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author ybd
 * @date 17-11-30
 */
public class Hot {
	public static void main(String[] args) throws InterruptedException {
		final Flux<Long> source = Flux.interval(Duration.ofSeconds(1))
									  .take(10)
									  .publish()
									  .autoConnect();
		source.subscribe();
		Thread.sleep(5000);
		source.toStream()
			  .forEach(System.out::println);
	}
}
