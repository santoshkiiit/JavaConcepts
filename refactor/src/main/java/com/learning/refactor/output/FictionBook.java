package com.learning.refactor.output;

import java.util.Date;


public class FictionBook extends Book {


    private static final long serialVersionUID = -43465912712L;
    private static int THRESHOLD = 2;
    private static final int  POINTS=1;
    private static final double BOOKPRICE=1.5;

    public FictionBook(Long id, String title, Date releaseDate) {
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
