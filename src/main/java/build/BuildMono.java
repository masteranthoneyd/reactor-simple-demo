package build;

import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author ybd
 * @date 17-11-30.
 */
public class BuildMono {

	private static final String HELLO = "Hello";

	public static void main(String[] args) throws InterruptedException {
		buildMono();
	}

	private static void buildMono() throws InterruptedException {
		Mono.just(HELLO).subscribe(System.out::println);
		Mono.empty().subscribe(System.out::println);
		Mono.fromSupplier(() -> HELLO).subscribe(System.out::println);
		Mono.justOrEmpty(Optional.of(HELLO)).subscribe(System.out::println);
		Mono.create(sink -> sink.success(HELLO)).subscribe(System.out::println);
		Mono.delay(Duration.ofSeconds(1)).subscribe(System.out::println);
		TimeUnit.SECONDS.sleep(2);
	}
}
