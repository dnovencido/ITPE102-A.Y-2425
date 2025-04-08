public class CountThread extends Thread {
	private int pause;
	private static final int TIMES = 10;

	@Override
	public void run() {
		try {
			for (int i=0; i<TIMES; i++) {
				System.out.println("The value of i is " + i);
				pause = (int) (Math.random() * 3000);
				sleep(pause);
			}
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}