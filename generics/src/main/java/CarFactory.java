/**
 * Created by santoshk on 2/12/18.
 */
public class CarFactory {

              public static <T> CarEnum<T> getEnumInstance(Class<? extends CarEnum<T>> enumClass, Object value){


                  for(CarEnum<T> enumInstance: enumClass.getEnumConstants()){
                      if(enumInstance.getValue().equals(value)) {
                          return enumInstance;
                      }

                  }
                  throw new  RuntimeException("No matching enum found");


    }
}
