package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Passenger;
import in.ashokit.binding.Ticket;
import in.ashokit.repo.TicketRepo;

@Service
public class TicketService {

	@Autowired
	private TicketRepo ticketRepo;

	public Ticket bookTicket(Passenger passenger) {
		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(passenger, ticket);
		ticket.setTicketStatus("confirmed");
		Ticket save = ticketRepo.save(ticket);
		return save;
	}

	public Optional<Ticket> getTicket(Integer ticketId) {
		return ticketRepo.findById(ticketId);
	}

	public List<Ticket> getTickets() {
		return ticketRepo.findAll();
	}

}
