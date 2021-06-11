package system;

import client.BookTicket;

public class TicketBookingThread extends Thread {

	TicketBookingCounter tc;
	String pname;
	int tickets;
	public TicketBookingThread(TicketBookingCounter tc,String pname,int tickets) {
		this.tc=tc;
		this.pname=pname;
		this.tickets=tickets;
		
		
	}
	public void run() 
	{
		tc.bookTicket(pname,tickets);
		
	}

}
