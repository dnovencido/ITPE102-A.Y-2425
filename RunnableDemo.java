import java.util.Date;
public class RunnableDemo {
	public static void main(String[] args) {
		MessageRunnable mr = new MessageRunnable("Hello");
		DateRunnable dr = new DateRunnable(new Date());

		Thread mt = new Thread(mr);
		Thread dt = new Thread(dr);

		mt.setPriority(Thread.MAX_PRIORITY); // 10
		dt.setPriority(Thread.MIN_PRIORITY); // 1

		mt.start();
		dt.start();
	}
}


