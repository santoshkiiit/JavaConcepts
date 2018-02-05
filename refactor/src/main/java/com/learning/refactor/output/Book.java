package com.learning.refactor.output;

import java.io.Serializable;
import java.util.Date;


public abstract  class Book implements Serializable{



    private static final long serialVersionUID = -473647236473L;

    private long id;
    private String title;

    public Book(long id, String title, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Book(){

    }

    private Date releaseDate;

    public abstract int getThreshold();

    public abstract int getPoints();
    public abstract  double getPrice();










}
