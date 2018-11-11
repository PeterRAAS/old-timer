package Model;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 11/11/2018<br/>
 * Time: 20:09<br/>
 * To change this template use File | Settings | File Templates.
 */
public class OldTimerQueries {

    public OldTimerQueries() {

        SingletonOldTimer oldTimer = SingletonOldTimer.getInstance();
        oldTimer.laadDataBase();


    }
}
