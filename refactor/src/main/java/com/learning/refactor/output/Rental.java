package com.learning.refactor.output; /**
 *
 */


import java.io.Serializable;


public class Rental implements Serializable {

    private static final long serialVersionUID = 1256869448913370768L;


    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    private int daysRented;


    public Rental(Book book, int daysRented) {
        super();
        this.book = book;
        this.daysRented = daysRented;
    }


    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }


}