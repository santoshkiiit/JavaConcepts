/**
 * Created by santoshk on 2/12/18.
 */
public enum CarDisplacement implements CarEnum<Integer> {


    BASIC(800) , POWERFUL(1200);

  Integer value;
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    CarDisplacement(Integer value){
        this.value = value;
    }

}
