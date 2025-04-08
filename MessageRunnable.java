public class MessageRunnable implements Runnable {
	private String message;
	private static final int TIMES = 10;

 	public MessageRunnable(String message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		try {
			for (int i=0; i<TIMES; i++) {
				System.out.println(message);
				int pause = (int)(Math.random() * 3000);
				Thread.sleep(pause);
			}	
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

