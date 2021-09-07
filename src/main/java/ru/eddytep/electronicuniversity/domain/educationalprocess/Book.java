package ru.eddytep.electronicuniversity.domain.educationalprocess;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    @Id
    private Long id;

    private String name;
    private String author;
    private String ISBN;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getName().equals(book.getName()) && getAuthor().equals(book.getAuthor()) && getISBN().equals(book.getISBN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getISBN());
    }
}