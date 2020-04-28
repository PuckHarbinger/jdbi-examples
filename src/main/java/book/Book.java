package book;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Book {
    private static enum Format{
        HARDBACK,
        PAPERBACK
    }
    private String isbn13;
    private String author;
    private String title;
    private Format format;
    private String publisher;
    private LocalDate publicationDate;
    private int pages;
    private boolean available;
}
