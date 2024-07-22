package com.kubeworks.movieService.controller;

import com.kubeworks.movieService.business.abstracts.MovieService;
import com.kubeworks.movieService.business.abstracts.PaymentService;
import com.kubeworks.movieService.entity.Actor;
import com.kubeworks.movieService.entity.dto.TicketInformationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movie/payments/")
@RequiredArgsConstructor
//@CrossOrigin
public class PaymentController {

    private final PaymentService paymentService;
    private final MovieService movieService;

    @PostMapping("sendTicketDetail")
    public void sendTicketDetail(@RequestBody TicketInformationDto ticketInformationDto) {
        paymentService.sendTicketDetail(ticketInformationDto);
    }

    @GetMapping("getUser/{userEmail}")
    public String getUser (@PathVariable String userEmail) {
        return paymentService.getUser(userEmail);
    }
}
