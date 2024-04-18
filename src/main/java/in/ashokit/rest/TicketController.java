package in.ashokit.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Passenger;
import in.ashokit.binding.Ticket;
import in.ashokit.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping(value = "/ticket", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {
		Ticket bookTicket = ticketService.bookTicket(passenger);
		return new ResponseEntity<>(bookTicket, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{ticketId}", produces = "application/json")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") Integer ticketId) {
		Optional<Ticket> ticket = ticketService.getTicket(ticketId);
		if (ticket.isPresent()) {
			Ticket ticket2 = ticket.get();
			return new ResponseEntity<>(ticket2, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/tickets", produces = "application/json")
	public ResponseEntity<List<Ticket>> getTickets() {
		List<Ticket> tickets = ticketService.getTickets();
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

}
