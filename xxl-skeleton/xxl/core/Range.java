package xxl.core;

import java.util.*;

public class Range {
    
    private int _firstRow;
    private int _firstColumn;
    private int _lastRow;
    private int _lastColumn;

    private Spreadsheet _spreadsheet;

    public Range(int br, int bc, int er, int ec) {

        _firstRow = br;
        _firstColumn = bc;
        _lastRow = er;
        _lastColumn = ec;
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
    
    List<Cell> getCells() {
        List <Cell>_cellsInRange = new ArrayList<Cell>();
        for (Cell c: _spreadsheet.getCells()) { 
            if (c.getRow() >= _firstRow & c.getRow() <= _lastRow & c.getColumn() >= _firstColumn & c.getColumn() <= _lastColumn) {
                _cellsInRange.add(c);
            }
        }
        return _cellsInRange;
    }
    
}
