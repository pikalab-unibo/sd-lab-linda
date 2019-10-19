public class AsyncCounter1 {
	
	private final ExecutorService executor;
	private int value;
	
	public AsyncCounter1(int x, ExecutorService e) {
		executor = e;           value = x;
	}
	
	public void countUpTo(int max) {
		executor.execute(() -> countUpToImpl(max));
	}
	
	private void countUpToImpl(int max) {
		value++;
		if (value < max) {
			countUpTo(max); // indirect, async recursion!
		}
	}
}
