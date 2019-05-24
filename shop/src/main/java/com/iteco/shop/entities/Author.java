package com.iteco.shop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedEntityGraph(
        name = "authorGraph",
        attributeNodes = {
                @NamedAttributeNode("books")
        })
@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    @Column(name = "id")
    @GenericGenerator(
            name = "author_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "authors_seq"),
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    private int id;

    @Column(name = "fio")
    @JsonProperty("author_name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "login")
    private String login;

    @Column(name = "hash_password")
    private String hasPassword;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "authors_books",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(String hasPassword) {
        this.hasPassword = hasPassword;
    }

    @Override
    public String toString() {
        return "\nid = " + this.id +
                "\nname = " + this.name +
                "\nage = " + this.age +
                "\naddress = " + this.address;
    }
}
