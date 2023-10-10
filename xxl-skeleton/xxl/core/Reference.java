package xxl.core;

public class Reference extends Content{
    private int _row;
    private int _column;

    public Reference(int row, int column){
        _row = row;
        _column = column;
    }
    
    public String toString() {
        return  _row + ";" + _column;
    }

    Literal value() {
        return null;
    }
}
