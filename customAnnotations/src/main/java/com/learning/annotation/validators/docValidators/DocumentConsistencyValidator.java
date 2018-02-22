package com.learning.annotation.validators.docValidators;

import com.learning.annotation.documents.Aadhar;
import com.learning.annotation.documents.BankStatement;
import com.learning.annotation.documents.BaseDocument;
import com.learning.annotation.documents.PanCard;

import java.util.Map;

public class DocumentConsistencyValidator{

    AnnotationsHandler annotationsHandler = new AnnotationsHandler();



    private Aadhar aadhar;

    private PanCard panCard;

    private BankStatement bankStatement;

    private static final String AADHARPANNAMEMISMATCH = "Name mismatch in Aadhar and PAN";
    private static final String AADHARPANDOBMISMATCH = "DOB mismatch in Aadhar and PAN";
    private static final String AADHARBANKSTATEMENTNAMEMISMATCH = "Name mismatch in Aadhar and Bank Statement";
    private static final String AADHARBANKSTATEMENTADDRESSMISMATCH = "Address mismatch in Aadhar and Bank Statement";




        public void validate(BaseDocument document,Map<String,Integer> issuesMap) {


            aadhar = (Aadhar)document;

            panCard = aadhar.getPanCard();

            bankStatement = aadhar.getBankStatement();


            // PAN and Aadhar validations

            if(!aadhar.getPanCard().getFullname().equals(panCard.getFullname())){

                updateIssuesMap(issuesMap,AADHARPANNAMEMISMATCH);
          }

        if(!aadhar.getPanCard().getDob().equals(aadhar.getDob())) {
            updateIssuesMap(issuesMap,AADHARPANDOBMISMATCH);

        }

            //Aadhar and bank statement validations

        if(!aadhar.getAddress().equals(aadhar.getBankStatement().getAddress())){
            updateIssuesMap(issuesMap,AADHARBANKSTATEMENTADDRESSMISMATCH);

        }

            if(!aadhar.getFullname().equals(aadhar.getBankStatement().getCustomerName())){
                updateIssuesMap(issuesMap,AADHARBANKSTATEMENTNAMEMISMATCH);

            }


        }

    private void updateIssuesMap( Map<String,Integer> issuesmap, String reason) {

        if(issuesmap.containsKey(reason)){
            issuesmap.put(reason,issuesmap.get(reason)+1);

        }else{
            issuesmap.put(reason,1);

        }
    }




}
