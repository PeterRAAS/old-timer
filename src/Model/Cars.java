package Model;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 11/11/2018<br/>
 * Time: 17:12<br/>
 * To change this template use File | Settings | File Templates.
 */
public class Cars {

    private String constructor;
    private String model;
    private int year;
    private String color;

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
