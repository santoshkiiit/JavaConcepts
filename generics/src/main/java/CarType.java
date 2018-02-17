/**
 * Created by santoshk on 2/12/18.
 */
public enum CarType implements CarEnum<String> {
    HATCHBACK("hatchBack"),SUV("suv"),MPV("mpv"),SEDAN("sedan");



    String value;

    CarType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
