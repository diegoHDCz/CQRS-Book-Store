package com.diegoczajka.BookService.command.api.data;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
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
