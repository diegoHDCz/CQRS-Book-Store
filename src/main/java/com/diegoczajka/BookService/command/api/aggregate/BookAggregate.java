package com.diegoczajka.BookService.command.api.aggregate;

import com.diegoczajka.BookService.command.api.commands.CreateBookCommand;
import com.diegoczajka.BookService.command.api.events.BookCreatedEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class BookAggregate {
    @AggregateIdentifier
    private String bookId;
    private String title;
    private String author;
    private BigDecimal price;
    private Integer quantity;

    public BookAggregate() {
    }

    public BookAggregate(CreateBookCommand createBookCommand) {
        //validate data if needed
        BookCreatedEvent bookCreatedEvent = new BookCreatedEvent();
        BeanUtils.copyProperties(createBookCommand, bookCreatedEvent);
        AggregateLifecycle.apply(bookCreatedEvent);

    }

    @EventSourcingHandler
    public void on(BookCreatedEvent bookCreatedEvent) {
        this.quantity = bookCreatedEvent.getQuantity();
        this.bookId = bookCreatedEvent.getBookId();
        this.author = bookCreatedEvent.getAuthor();
        this.price = bookCreatedEvent.getPrice();
        this.title = bookCreatedEvent.getTitle();
    }
}
