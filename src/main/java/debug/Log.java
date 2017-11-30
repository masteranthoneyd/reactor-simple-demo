package debug;

import reactor.core.publisher.Flux;

/**
 * @author ybd
 * @date 17-11-30
 */
public class Log {
	public static void main(final String[] args) {
		Flux.range(1, 2).log().subscribe(System.out::println);
	}
}
