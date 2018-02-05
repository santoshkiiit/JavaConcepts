package com.learning.refactor.output;

import java.util.Date;


public class BookFactory {


    public Book getBook(Long id, String title, String bookType, Date releaseDate){

        if (bookType.equals(BookType.CHILDEN.toString())) {
           return new ChildrenBook(id,title,releaseDate);
       }
        if(bookType.equals(BookType.FICTION.toString())){
            return new FictionBook(id, title, releaseDate);
       }
        if(bookType.equals(BookType.NONFICTION.toString())){
            return new NonFictionBook(id, title, releaseDate);
        }

        return null;

    }
}
