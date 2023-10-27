package xxl.core;

import java.io.Serializable;
import java.util.*;

public class Range implements Serializable {
    
    private int _firstRow;
    private int _firstColumn;
    private int _lastRow;
    private int _lastColumn;

    private Spreadsheet _spreadsheet;

    public Range(int br, int bc, int er, int ec, Spreadsheet spreadsheet) {
        _spreadsheet = spreadsheet;
        _firstRow = br;
        _firstColumn = bc;
        _lastRow = er;
        _lastColumn = ec;
//        System.out.println("RANGE IS CREATED: "+spreadsheet+", br: " + br + ", bc: " + bc + ", er:" + er + ", ec: " + ec);
    }

    public int getFirstRow(){
        return _firstRow;
    }

    public int getFirstColumn(){
        return _firstColumn;
    }

    public int getLastRow(){
        return _lastRow;
    }

    public int getLastColumn(){
        return _lastColumn;
    }
    
    public List<Cell> getCells() {
        List <Cell>_cellsInRange = new ArrayList<Cell>();
//        System.out.println("RANGE: getting cells in range" + getFirstRow() + ";" + getFirstColumn() + ":" + getLastRow() + ";" + getLastColumn());
        for (Cell c: _spreadsheet.getCells()) {
            if (c.getRow() >= _firstRow & c.getRow() <= _lastRow & c.getColumn() >= _firstColumn & c.getColumn() <= _lastColumn) {
//                System.out.println("RANGE: getting cell " + c);
                _cellsInRange.add(c);
            }
        }
        return _cellsInRange;
    }
    
}
