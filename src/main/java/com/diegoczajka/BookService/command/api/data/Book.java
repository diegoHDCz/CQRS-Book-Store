package com.diegoczajka.BookService.command.api.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Book {
    @Id
    private String bookId;
    private String title;
    private String author;
    private BigDecimal price;
    private Integer quantity;
}
