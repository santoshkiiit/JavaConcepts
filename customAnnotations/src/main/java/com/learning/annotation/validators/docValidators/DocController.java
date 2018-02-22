package com.learning.annotation.validators.docValidators;

import com.learning.annotation.documents.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by santoshk on 2/20/18.
 */
public class DocController {


   DocumentValidator documentValidator = new DocumentValidator();

    @Test
    public void checkDocumentConsistency() throws IllegalAccessException {



        Date date = new Date(2012,1,12);
        Date date1 = new Date(2015,1,14);
        Date date2= new Date(2019,1,11);
        PanCard panCard = new PanCard("John7","BSGAH8371E","John E","MH",date);
        PanCard panCard1 = new PanCard("San7","BSGAH6hdfaE","San V","TG",date1);
        PanCard panCard2 = new PanCard("Smith","BSGAH8371E","Smith E","MH",date2);

        Transaction t = new Transaction("12323","amount credit",21323.0,new Date());

        List<Transaction> transactions  = new ArrayList();
        transactions.add(t);

        BankStatement bankStatement = new BankStatement("1632557","Smith",transactions,"","7612376191","abc@xyz.com");


        Aadhar aadhar = new Aadhar ("Smith","M","101,James Street", date, panCard, bankStatement);

        List<BaseDocument> docsList = new ArrayList<>();

        docsList.add(aadhar);

        System.out.print(documentValidator.fetchValidationResultForDocuments(docsList));

    }
}
