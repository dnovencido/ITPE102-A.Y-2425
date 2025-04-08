public class HelloThread extends Thread {
	private int pause;
	private static final int TIMES = 10;

	@Override
	public void run() {
		try {
			for (int i=0; i<TIMES; i++) {
				System.out.println("The message is hello." + "🐵");
				pause = (int) (Math.random() * 3000); // 0.25 * 3000 750ms 0.75 sec
				sleep(pause);
			}
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}	
}