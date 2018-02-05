package com.learning.refactor.output;

import java.util.Date;


public class NonFictionBook extends Book {


    private static final long serialVersionUID = -1523912830L;
    private static int THRESHOLD = 2;
    private static final int  POINTS=3;
    private static final double BOOKPRICE=2.0;


    public NonFictionBook(Long id, String title, Date releaseDate) {
        super(id, title, releaseDate);
    }


    @Override
    public double getPrice() {
        return BOOKPRICE;
    }


    @Override
    public int getThreshold() {
        return this.THRESHOLD;
    }

    @Override
    public int getPoints() {
        return this.POINTS;
    }



}
