package com.diegoczajka.BookService.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class CreateBookCommand {
    @TargetAggregateIdentifier
    private String bookId;
    private String title;
    private String author;
    private BigDecimal price;
    private Integer quantity;
}
