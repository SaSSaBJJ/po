package xxl.core;

import java.util.*;

public class Reference extends Content{
    private int _row;
    private int _column;

    private Spreadsheet _spreadsheet;

    public Reference(int row, int column){
        _row = row;
        _column = column;
    }
    
    @Override
    public String toString() {
        return  _row + ";" + _column;
    }

    Literal value() {
       List<Cell> _cells = _spreadsheet.getCells();
       for(Cell c: _cells){
        if (c.getRow()==_row & c.getColumn()==_column){
            return c.getContent().value();
        }
       }
       return null;
    }
}
