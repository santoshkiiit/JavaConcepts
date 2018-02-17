/**
 * Created by santoshk on 2/12/18.
 */
public enum CarTransmissionType implements CarEnum<String> {

    AUTOMATIC("auto") , MANUAL("man");

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value;

    CarTransmissionType(String value) {
        this.value = value;
    }


}
