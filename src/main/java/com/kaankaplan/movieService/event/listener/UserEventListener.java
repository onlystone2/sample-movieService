package com.kaankaplan.movieService.event.listener;

import com.kaankaplan.movieService.business.abstracts.CommentService;
import com.kaankaplan.movieService.common.dtos.UserCommentCreatedEventDto;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@AllArgsConstructor
@Component
public class UserEventListener {
    private final CommentService commentService;

    @RabbitListener(queues = "${amqp.queues.user_created}", ackMode = "MANUAL")
    public void handleUserCommentCreatedEvent(UserCommentCreatedEventDto userCommentCreatedEventDto, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) Long tag)
            throws IOException {
        try {
            commentService.addUserComment(userCommentCreatedEventDto);
            channel.basicAck(tag, false);
        } catch (RuntimeException | IOException ex) {
            ex.printStackTrace();
            channel.basicNack(tag, false, false);
        }
    }
}
