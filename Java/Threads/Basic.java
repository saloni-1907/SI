package threads;


public class P1 extends Thread {

	public void run()
	{
		System.out.println("The thread is running");
	}
	 
	public static void main(String[] args) {

		P1 t1= new P1();
		t1.start();
		P1 t2=new P1();
		t2.start();

	}

}
