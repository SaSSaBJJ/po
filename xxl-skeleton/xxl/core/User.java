package xxl.core;

import java.util.List;

public class User {
    

    private String _name;

    private List<Spreadsheet> _spreadsheets;

    public User(String n){
        _name=n;
    }

    public Boolean equals(Object obj){
    
    }

    public int hashCode(){

    }

    void add(Spreadsheet sheet){
        _spreadsheets.add(sheet);
    }

    public List<Spreadsheet> getSpreadsheets(){
        return _spreadsheets;
    }

    public String getName(){
        return _name;
    }
}
