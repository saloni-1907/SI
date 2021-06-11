package system;

public class TicketBookingCounter {

	private int availableTickets=5;
	 public synchronized void bookTicket(String passengerName,int tickets)
	 {
		 if(availableTickets>=tickets && tickets>0)
		 {
			 System.out.println("Hi "+passengerName+", your "+ tickets+" tickets are booked!");
			 availableTickets-=tickets;
		 }
		 else
		 {
			 System.out.println("Sorry "+passengerName+"! Tickets not available!");
		 }
	 }
}
