package client;

import system.TicketBookingCounter;
import system.TicketBookingThread;

public class BookTicket {

	public static void main(String[] args) {
		TicketBookingCounter tc=new TicketBookingCounter();
		TicketBookingThread t1=new TicketBookingThread(tc,"Mark",4);
		TicketBookingThread t2=new TicketBookingThread(tc,"Jane",3);
		t1.start();
		t2.start();
	}

}
