package com.kaankaplan.movieService.event.publisher;

import com.kaankaplan.movieService.common.dtos.UserCommentEventDto;
import com.kaankaplan.movieService.common.enums.UserCommentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentEventPublisher {
    @Value("${amqp.exchange.comment_events}")
    private String commentEventsExchange;
    @Value("${amqp.routingKey.comment_created}")
    private String commentCompletedRoutingKey;
    @Value("${amqp.routingKey.comment_failed}")
    private String commentFailedRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void publishCommentEvent(UserCommentEventDto userCommentEventDto) {
        if (userCommentEventDto.getUserCommentStatus().equals(UserCommentStatus.COMMENT_COMPLETED)) {
            rabbitTemplate.convertAndSend(commentEventsExchange, commentCompletedRoutingKey, userCommentEventDto);
        } else {
            rabbitTemplate.convertAndSend(commentEventsExchange, commentFailedRoutingKey, userCommentEventDto);
        }
    }
}
