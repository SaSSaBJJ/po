package xxl.core;

import java.util.*;

public class Range {
    
    private int _beginRow;
    private int _beginColumn;
    private int _endRow;
    private int _endColumn;

    private Spreadsheet _spreadsheet;

    public Range(int br, int bc, int er, int ec) {

        _beginRow = br;
        _beginColumn = bc;
        _endRow = er;
        _endColumn = ec;
    }

    
    List<Cell> getCells() {
        return _spreadsheet.getCells();
    }
    
}
