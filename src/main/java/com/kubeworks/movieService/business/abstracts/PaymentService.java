package com.kubeworks.movieService.business.abstracts;

import com.kubeworks.movieService.entity.dto.TicketInformationDto;

public interface PaymentService {

    void sendTicketDetail(TicketInformationDto ticketInformationDto);
    public String getUser(String userEmail);
}
