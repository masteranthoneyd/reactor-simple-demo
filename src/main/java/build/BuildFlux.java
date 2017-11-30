package build;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author ybd
 * @date 17-11-29.
 */
public class BuildFlux {
	public static void main(String[] args) throws InterruptedException {
//		generateSimpleFlux();
//		fluxGenerate();
		fluxCreate();
	}

	private static void generateSimpleFlux() throws InterruptedException {
		Flux.just("Hello", "World").subscribe(System.out::println);
		Integer[] array = {1, 2, 3};
		Flux.fromArray(array).subscribe(System.out::println);
		Flux.fromStream(Stream.of(array)).subscribe(System.out::println);
		Flux.fromIterable(Arrays.asList(array)).subscribe(System.out::println);
		Flux.empty().subscribe(System.out::println);
		Flux.range(1, 10).subscribe(System.out::println);
		Flux.interval(Duration.ofSeconds(1)).subscribe(System.out::println);
		TimeUnit.SECONDS.sleep(5);
	}

	private static void fluxGenerate() {
		Flux.generate(sink -> {
			sink.next("Hello");
			sink.complete();
		}).subscribe(System.out::println);


		Random random = new Random();
		Flux.generate(ArrayList::new, (list, sink) -> {
			int value = random.nextInt(100);
			list.add(value);
			sink.next(value);
			sink.next(value);
			if (list.size() == 10) {
				sink.complete();
			}
			return list;
		}).subscribe(System.out::println);
	}

	private static void fluxCreate() {
		Flux.create(sink -> {
			for (int i = 0; i < 10; i++) {
				sink.next(i);
			}
			sink.complete();
		}).subscribe(System.out::println);
	}
}
