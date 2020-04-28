package book;

import book.Book;
import book.BookDao;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class Main {

    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());
        try (Handle handle = jdbi.open()) {
            BookDao dao = handle.attach(BookDao.class);
            dao.createTable();
            dao.insertBook(new Book("9781937994303","Sir Arthur Conan Doyle","The Complete Sherlock Holmes", Book.Format.HARDBACK,
                    "Race Point Publishing",2013  Sep ));
            dao.ListBook().stream().forEach(System.out::println);
    }
}
