import org.junit.Test;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * Created by santoshk on 3/15/18.
 */
public class QueryValidationUtil {



    static final String AND_JOIN ="AND";

    static final String OR_JOIN ="OR";

    static final String IN_JOIN ="IN";

    static final String startTag ="(";


    static final String endTag =")";

    Logger logger = Logger.getLogger(QueryValidationUtil.class.getName());


    @Test
    public void validateQuery(){

        String query = "( A OR B ) and ( E OR ( F AND G ) )";
        checkValidRegularExpression(query);

       logger.info("Query validation returned: " + checkValidRegularExpression(query));

    }

    private boolean checkValidRegularExpression(String query) {

        if(query==null || query.isEmpty()){
            logger.warning("Input query is empty");
            return false;
        }

        Stack expressionStack = new Stack();

        int openTags =0;
        //takes care of improper matching brackets

        String [] tokens = query.split("\\s+");


        for(int i=0;i<tokens.length;i++){

            String token = tokens[i];

            if(token.equals(startTag)){
                expressionStack.push(token);
                openTags++;
            }
            else if(token.equals(endTag)){
                if(expressionStack.isEmpty()){
                    logger.warning("can't start expression with closing tag ) ");
                    return false;
                }
                if(isOperator((String) expressionStack.peek()))
                    return false;
                expressionStack.push(token);
                openTags--;
            } else if(isOperand(token)){
                if(!expressionStack.isEmpty()){
                    if(isOperand((String)expressionStack.peek())) {
                        logger.warning("two operands continously , invalid query");

                        return false;
                    }else{
                        expressionStack.push(token);
                    }
                }else{
                    expressionStack.push(token);
                }
            }else{ if(isOperator(token)){

                if(expressionStack.isEmpty()){
                     logger.warning("cannot start query with operand, invalid query");
                    return false;
                }
                if(isOperator((String)expressionStack.peek())){
                    logger.warning("two operators continously , invalid query");
                    return false;

                }else{
                    expressionStack.push(token);
                }
            }
            }
            if(openTags <0){
                logger.warning("brackets not closed properly, invalid query");
                return false;
            }

        }
        if(openTags!=0){
            logger.warning("brackets not closed properly, invalid query");
            return false;
        }
        return true;
    }

    private boolean isOperand(String token) {
        if(isOperator(token)){
            return false;
        }
        if(token.equals(startTag)||token.equals(endTag)){
            return false;

        }
        return true;
    }

    private boolean isOperator(String token) {

        if(token.equals(AND_JOIN) || token.equals(OR_JOIN) || token.equals(IN_JOIN)){
            return true;
        }
        return false;
    }


    private QueryExpression buildQueryExpression(Stack expressionStack){
        QueryExpression queryExpression = new QueryExpression();
        return queryExpression;
    }

}
