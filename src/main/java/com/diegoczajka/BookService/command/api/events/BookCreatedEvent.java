package com.diegoczajka.BookService.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCreatedEvent {
    private String bookId;
    private String title;
    private String author;
    private BigDecimal price;
    private Integer quantity;
}
