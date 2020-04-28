package book;


import book.Book;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Book.class)
public interface BookDao {

    @SqlUpdate("""
            CREATE TABLE book(
            id IDENTITY PRIMARY KEY,
            number VARCHAR NOT NULL,
            year INTEGER NOT NULL,
            pieces INTEGER NOT NULL
            )
            """
            )
    void createTable();

    @SqlUpdate("INSERT INTO book (isbn13, author, title,format,publisher,publicationDate,pages,available) " +
            "VALUES (:isbn13, :author, :title,:format,:publisher,;publicationDate,:pages,:available)")
    @GetGeneratedKeys
    void insert(Book book);

    @SqlQuery("SELECT * FROM book WHERE isbn13=:isbn13")
    Optional<Book> find(String isbn13);

    @SqlQuery("DELETE * FROM book")
    void delete(Book book);


    @SqlQuery("SELECT * FROM book ORDER BY isbn13")
    List<Book> findAll();
}
