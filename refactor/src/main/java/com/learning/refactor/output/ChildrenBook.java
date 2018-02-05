package com.learning.refactor.output;

import java.util.Date;


public class ChildrenBook extends Book {


    private static final long serialVersionUID = -6354671528L;
    private static int THRESHOLD = 1;
    private static final int  POINTS=1;
    private static final double BOOKPRICE=1.5;




    public ChildrenBook(Long id, String title, Date releaseDate) {
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
