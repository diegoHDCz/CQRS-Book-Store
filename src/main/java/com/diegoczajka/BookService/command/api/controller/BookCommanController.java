package com.diegoczajka.BookService.command.api.controller;

import com.diegoczajka.BookService.command.api.commands.CreateBookCommand;
import com.diegoczajka.BookService.command.api.model.BookRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookCommanController {

    private CommandGateway commandGateway;

    public BookCommanController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addBook(@RequestBody BookRestModel bookRestModel) {

        CreateBookCommand createBookCommand =
                CreateBookCommand.builder().bookId(UUID.randomUUID().toString())
                        .title(bookRestModel.getTitle())
                        .author(bookRestModel.getAuthor())
                        .quantity(bookRestModel.getQuantity())
                        .price(bookRestModel.getPrice())
                        .build();
        String result = commandGateway.sendAndWait(createBookCommand);
        return result;
    }
}
