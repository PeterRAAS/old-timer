package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 11/11/2018<br/>
 * Time: 17:12<br/>
 * To change this template use File | Settings | File Templates.
 */
public class Cars {

    private int carnumber;
    private int membernumber;
    private String constructor;
    private String model;
    private int year;
    private String color;

    public Cars (int membernumber){

        this.membernumber = membernumber;
    }

    public Cars(int carnumber,int membernumber,String constructor, String model, int year, String color) {

        this.carnumber = carnumber;
        this.membernumber = membernumber;
        this.constructor = constructor;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Cars(){

    }

    public int getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(int carnumber) {
        this.carnumber = carnumber;
    }

    public int getMembernumber() {
        return membernumber;
    }

    public void setMembernumber(int membernumber) {
        this.membernumber = membernumber;
    }

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {

        if (!constructor.isEmpty()) {

            this.constructor = constructor;
        }
        else{

            throw new IllegalArgumentException("Opslaan mislukt, geen constructor");
        }

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {

        if (!model.isEmpty()) {

            this.model = model;
        }
        else{

            throw new IllegalArgumentException("Opslaan mislukt, geen model");
        }

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1990 && year >= 1900) {

            if (testCarsOpJaarTal(this.membernumber,year)) {

                this.year = year;
            }
            else{
                throw new IllegalArgumentException("Opslaan old timer mislukt, bouwjaar bestaat al");
            }
        }
        else{
            throw new IllegalArgumentException("Opslaan old timer mislukt, bouwjaar niet ok (1900-1989)");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {

        if (!color.isEmpty()) {

            this.color = color;
        }
        else{
            this.color = "Kleur niet gekend";
        }
    }
    
    public boolean testCarsOpJaarTal(int id, int year){
        
        OldTimerQueries qry = new OldTimerQueries();
        List<Cars> carsList = new ArrayList<Cars>();
        int aantal = 0;
        
        qry.laadCars(id);
        carsList = qry.getAllCars();

        for (Cars test : carsList){
            if (test.year != year){

                aantal = aantal;
            }
            else{

                ++aantal;
            }
        }
       if (aantal == 0){

           return true;
       }
       else{
           return false;
       }
    }
}
