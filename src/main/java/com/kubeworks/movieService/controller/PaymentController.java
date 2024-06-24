package com.kubeworks.movieService.controller;

import com.kubeworks.movieService.business.abstracts.PaymentService;
import com.kubeworks.movieService.entity.dto.TicketInformationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movie/payments/")
@RequiredArgsConstructor
//@CrossOrigin
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("sendTicketDetail")
    public void sendTicketDetail(@RequestBody TicketInformationDto ticketInformationDto) {
        paymentService.sendTicketDetail(ticketInformationDto);
    }
}
