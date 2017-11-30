package operational;

import reactor.core.publisher.Flux;

/**
 * @author ybd
 * @date 17-11-30.
 */
public class OpsFilter {
	public static void main(String[] args) {
		opsOfFilter();
	}

	private static void opsOfFilter() {
		Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
	}
}
