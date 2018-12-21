package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 11/11/2018<br/>
 * Time: 20:09<br/>
 * To change this template use File | Settings | File Templates.
 */
public class OldTimerQueries {

    private PreparedStatement selectAllMembers;
    private PreparedStatement selectAllCars;
    private PreparedStatement insertNewMember;
    private PreparedStatement insertNewCar;
    private PreparedStatement deleteMember;
    private PreparedStatement deleteCar;
    private PreparedStatement selectMembersByLastName;
    private int memberID;


    public OldTimerQueries() {

        try {

            SingletonOldTimer oldTimer = SingletonOldTimer.getInstance();
            selectAllMembers = oldTimer.laadDataBase().prepareStatement("SELECT * FROM members ORDER  BY Name");
            insertNewMember = oldTimer.laadDataBase().prepareStatement("INSERT INTO members "+"(Name,FirstName,Street,Number,ZipCode,City,Country,Phone,Mobile,Email) " + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            insertNewCar = oldTimer.laadDataBase().prepareStatement("INSERT INTO cars " + "(MemberNumber,Constructor,Model,Year,Color ) "+"VALUES(?,?,?,?,?)");
            selectMembersByLastName = oldTimer.laadDataBase().prepareStatement("SELECT * FROM members Where Name LIKE ?");



        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit(1);
        }


    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int addMember(String name,String firstName,String street,int number,int zipCode,String city,String country,String phone,String mobile,String email){
        Members member = new Members();
        member.setName(name);
        member.setFirstName(firstName);
        member.setStreet(street);
        member.setNumber(number);
        member.setZipCode(zipCode);
        member.setCity(city);
        member.setCountry(country);
        member.setPhone(phone);
        member.setMobile(mobile);
        member.setEmail(email);

        try{
            insertNewMember.setString(1,member.getName());
            insertNewMember.setString(2,member.getFirstName());
            insertNewMember.setString(3,member.getStreet());
            insertNewMember.setInt(4,member.getNumber());
            insertNewMember.setInt(5,member.getZipCode());
            insertNewMember.setString(6,member.getCity());
            insertNewMember.setString(7,member.getCountry());
            insertNewMember.setString(8,member.getPhone());
            insertNewMember.setString(9,member.getMobile());
            insertNewMember.setString(10,member.getEmail());

            return insertNewMember.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
            return 0;
        }
    }

    public int addCar( int membernumber,String constructor,String model,int year,String color){


        Cars car = new Cars();
        car.setMembernumber(membernumber);
        car.setConstructor(constructor);
        car.setModel(model);
        car.setYear(year);
        car.setColor(color);

        try{

            insertNewCar.setInt(1,car.getMembernumber());
            insertNewCar.setString(2,car.getConstructor());
            insertNewCar.setString(3,car.getModel());
            insertNewCar.setInt(4,car.getYear());
            insertNewCar.setString(5,car.getColor());
            return insertNewCar.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
            return 0;
        }
    }



    public List<Members> filterByFirstName(String name) {

        try {

            selectMembersByLastName.setString(1, name);
        }
        catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit(1);
        }
        try (ResultSet resultSet = selectMembersByLastName.executeQuery()) {

            List<Members> results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(

                        resultSet.getInt("MemberNumber"),
                        resultSet.getString("Name"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("Street"),
                        resultSet.getInt("Number"),
                        resultSet.getInt("ZipCode"),
                        resultSet.getString("City"),
                        resultSet.getString("Country"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Mobile"),
                        resultSet.getString("Email")));

            }
            return results;
        } catch (SQLException sqlException) {

            sqlException.printStackTrace();

        }
        return null;
    }

    public void deleteCars(int carID){
        try {
            SingletonOldTimer oldTimer = SingletonOldTimer.getInstance();
            deleteCar = oldTimer.laadDataBase().prepareStatement("DELETE FROM cars WHERE CarID = " +carID+" ");
            deleteCar.executeUpdate();
        }
        catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit(1);
        }

    }
    public void deleteMember(int memberID){

        try {
            SingletonOldTimer oldTimer = SingletonOldTimer.getInstance();
            deleteMember = oldTimer.laadDataBase().prepareStatement("DELETE FROM members WHERE MemberNumber = " +memberID+"");
            deleteMember.executeUpdate();
        }
        catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit(1);
        }

    }

    public void laadCars(int ID) {

        try {
            SingletonOldTimer oldTimer = SingletonOldTimer.getInstance();
            selectAllCars = oldTimer.laadDataBase().prepareStatement("SELECT * FROM cars Where MemberNumber = ? ");
            selectAllCars.setString(1, Integer.toString(ID));

        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public List<Cars> getAllCars() {
        try (ResultSet resultSet = selectAllCars.executeQuery()) {

            List<Cars> results = new ArrayList<Cars>();

            while (resultSet.next()) {
                results.add(new Cars(
                        resultSet.getInt("CarID"),
                        resultSet.getInt("MemberNumber"),
                        resultSet.getString("Constructor"),
                        resultSet.getString("Model"),
                        resultSet.getInt("Year"),
                        resultSet.getString("Color")));

            }
            return results;
        } catch (SQLException sqlException) {

            sqlException.printStackTrace();

        }
        return null;
    }

    public List<Members> getAllMembers() {
        try (ResultSet resultSet = selectAllMembers.executeQuery()) {

            List<Members> results = new ArrayList<Members>();

            while (resultSet.next()) {
                results.add(new Members(

                        resultSet.getInt("MemberNumber"),
                        resultSet.getString("Name"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("Street"),
                        resultSet.getInt("Number"),
                        resultSet.getInt("ZipCode"),
                        resultSet.getString("City"),
                        resultSet.getString("Country"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Mobile"),
                        resultSet.getString("Email")));

            }
            return results;
        } catch (SQLException sqlException) {

            sqlException.printStackTrace();

        }
        return null;
    }
}
