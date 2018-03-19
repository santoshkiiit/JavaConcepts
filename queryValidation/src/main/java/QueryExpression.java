import java.util.ArrayList;
import java.util.List;

/**
 * Created by santoshk on 3/16/18.
 */
public class QueryExpression {



    //can be null
    String firstOperand;

    //can be null
    String secondOperand;

    //String operator;
        //there might be n operators in one query , not correct to maintain them

    public String getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(String firstOperand) {
        this.firstOperand = firstOperand;
    }

    public String getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(String secondOperand) {
        this.secondOperand = secondOperand;
    }

//    public String getOperator() {
//        return operator;
//    }


    QueryExpression(){

    }

    public QueryExpression( List<QueryExpression> expressions, String secondOperand, String firstOperand,  String operator) {
        this.expressions = expressions;
        this.secondOperand = secondOperand;
        this.firstOperand = firstOperand;

       // this.operator = operator;
    }


    public List<QueryExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<QueryExpression> expressions) {
        this.expressions = expressions;
    }



    List<QueryExpression> expressions = new ArrayList<QueryExpression>();


    public void addQueryExpression(QueryExpression queryExpression){
        this.expressions.add(queryExpression);


    }


}
