package error;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ybd
 * @date 17-11-30
 */
public class OnErrorHandleHandle {

	public static void main(String[] args) {
//		subscribe();
//		onErrorReturn();
//		onErrorResume();
		retry();
	}

	private static void subscribe() {
		Flux.just(1, 2)
			.concatWith(Mono.error(new NullPointerException()))
			.subscribe(System.out::println, System.err::println);
	}

	private static void onErrorReturn() {
		Flux.just(1, 2)
			.concatWith(Mono.error(new IllegalStateException()))
			.onErrorReturn(0)
			.subscribe(System.out::println);
	}

	private static void onErrorResume() {
		Flux.just(1, 2)
			.concatWith(Mono.error(new IllegalArgumentException()))
			.onErrorResume(e -> {
				if (e instanceof IllegalStateException) {
					return Mono.just(0);
				} else if (e instanceof IllegalArgumentException) {
					return Mono.just(-1);
				}
				return Mono.empty();
			})
			.subscribe(System.out::println);
	}

	private static void retry() {
		Flux.just(1, 2)
			.concatWith(Mono.error(new IllegalStateException()))
			.retry(1)
			.subscribe(System.out::println);
	}

}
