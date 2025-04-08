public class Demo {
	public static void main(String[] args) {
		HelloThread ht = new HelloThread();
		CountThread ct = new CountThread();

		ht.start();
		ct.start();
	}
}