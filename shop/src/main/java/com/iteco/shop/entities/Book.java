package com.iteco.shop.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedEntityGraph(
        name = "bookGraph",
        attributeNodes = {
                @NamedAttributeNode("authors")
        }
)
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @Column(name = "id")
    @GenericGenerator(
            name = "book_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "books_seq"),
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    private int id;

    @Column(name = "name")
    @JsonProperty("book_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "authors_books",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;

    @Column(name = "publishing_house")
    private String publishingHouse;

    @Column(name = "date_of_publish")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.mm.yyyy")
    private Date datePublishing;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return this.publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Date getDatePublishing() {
        return this.datePublishing;
    }

    public void setDatePublishing(Date datePublishing) {
        this.datePublishing = datePublishing;
    }

    @Override
    public String toString() {
        return "\nid = " + this.id +
                "\nname = " + this.name +
                "\nauthor + " + authors.toString();
    }

}
