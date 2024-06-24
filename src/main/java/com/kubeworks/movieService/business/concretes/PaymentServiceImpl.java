package com.kubeworks.movieService.business.concretes;

import com.kubeworks.movieService.entity.dto.EmailMessageKafkaDto;
import com.kubeworks.movieService.business.abstracts.PaymentService;
import com.kubeworks.movieService.entity.dto.TicketInformationDto;
import com.kubeworks.movieService.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaProducer kafkaProducer;

    @Override
    public void sendTicketDetail(TicketInformationDto ticketInformationDto) {

        EmailMessageKafkaDto emailMessage = EmailMessageKafkaDto.builder()
                .sender("seeone.yoon@gmail.com")
                .recipient(ticketInformationDto.getEmail())
                .subtitle("CineVision Ticket Details")
                .fullName(ticketInformationDto.getFullName())
                .movieName(ticketInformationDto.getMovieName())
                .movieDay(ticketInformationDto.getMovieDay())
                .movieStartTime(ticketInformationDto.getMovieStartTime())
                .saloonName(ticketInformationDto.getSaloonName())
                .chairNumbers(ticketInformationDto.getChairNumbers())
                .build();

        kafkaProducer.sendMessage(emailMessage);
    }
}
