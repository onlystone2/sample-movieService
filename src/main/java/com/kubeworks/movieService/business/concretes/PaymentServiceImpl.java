package com.kubeworks.movieService.business.concretes;

import com.kubeworks.movieService.entity.dto.UserResponseDto;
import com.kubeworks.movieService.entity.dto.EmailMessageKafkaDto;
import com.kubeworks.movieService.business.abstracts.PaymentService;
import com.kubeworks.movieService.entity.dto.TicketInformationDto;
import com.kubeworks.movieService.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaProducer kafkaProducer;
    private final WebClient.Builder webClientBuilder;

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

    @Override
    public String getUser(String userEmail) {

        Mono<UserResponseDto> User = webClientBuilder.build().get()
                .uri ("http://USERSERVICE/api/user/users/email/{userEmail}", userEmail)
                .retrieve()
                .bodyToMono(UserResponseDto.class);
//        User.subscribe(this::asyncResponse);
        User.subscribe(this::asyncResponse, error -> asyncError(error));

        return "TEST OK";
    }

    private void asyncResponse(UserResponseDto user) {

        log.info("<<<<<<<<<<<<<<<<<<< Async. Response : "+user);
    }
    private void asyncError(Throwable error) {
        log.info("<<<<<<<<<<<<<<<<<<< Async. Error : "+error.toString());
    }
}
