package schedule;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author ybd
 * @date 17-11-30
 */
public class UseScheduler {
	public static void main(String[] args) throws InterruptedException {
		useScheduler();
	}

	private static void useScheduler() throws InterruptedException {
		Flux.create(sink -> {
			sink.next(Thread.currentThread().getName());
			sink.complete();
		})
			.publishOn(Schedulers.single())
			.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
			.publishOn(Schedulers.elastic())
			.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
			.subscribeOn(Schedulers.parallel())
			.toStream()
			.forEach(System.out::println);
	}
}
