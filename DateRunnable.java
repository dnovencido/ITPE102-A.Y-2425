import java.util.Date;
public class DateRunnable implements Runnable {
	private Date date;
	private static final int TIMES = 10;

	public DateRunnable(Date date) {
		this.date = date;
	}

	@Override
	public void run() {
		try {
			for (int i=0; i<TIMES; i++) {
				Date nowDate = new Date();
				System.out.println("Started :" + date + " Now : " + nowDate);
				int pause = (int)(Math.random() * 3000);
				Thread.sleep(pause);
			} 			
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}


