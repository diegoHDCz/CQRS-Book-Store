package com.diegoczajka.BookService.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book,String> {
}
