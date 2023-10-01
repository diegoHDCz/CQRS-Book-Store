package com.diegoczajka.BookService.command.api.events;

import com.diegoczajka.BookService.command.api.data.Book;
import com.diegoczajka.BookService.command.api.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BookEventsHandler {


    private BookRepository bookRepository;

    public BookEventsHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventHandler
    public void on(BookCreatedEvent event) {
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book);
    }
}
