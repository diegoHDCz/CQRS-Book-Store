package com.diegoczajka.BookService.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class BookRestModel {
    private String title;
    private String author;
    private BigDecimal price;
    private Integer quantity;
}
