package com.learning.refactor.output;


import java.util.List;


public class RentalManager {

    public int  getPointsForCustomer(Customer customer){
        int  points =0;
        for(Rental rental:customer.getRentals()){
            points = points+ getPointsForRental(rental);
        }
        return points;

    }



    public double calculateTotalPriceForCustomer(Customer customer){

        double totalPrice =0.0;

        List<Rental> rentals = customer.getRentals();


        for(Rental rental: rentals) {
            totalPrice = totalPrice + getPriceForRental(rental);
        }

          return totalPrice;
    }


    public double getPriceForRental(Rental rental){

        return rental.getBook().getPrice()* rental.getDaysRented();


    }


    public int getPointsForRental(Rental rental){

        if(rental.getDaysRented() > rental.getBook().getThreshold()){
            return rental.getDaysRented()* rental.getBook().getPoints();
        }else
            return 0;


    }

    public String getStatemntForCustomer(Customer customer){

        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");


        result.append(BookRentalConstants.RECORD_FOR).append(String.valueOf(calculateTotalPriceForCustomer(customer))).append("\n");
        result.append(BookRentalConstants.AMOUNT_OWED).append(String.valueOf(getPointsForCustomer(customer))).append("\n");
        result.append(BookRentalConstants.POINTS_EARNED).append(String.valueOf(getPointsForCustomer(customer))).append(BookRentalConstants.POINTS_EARNED);

        return result.toString();
    }





}
