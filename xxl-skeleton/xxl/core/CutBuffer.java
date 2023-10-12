package xxl.core;

import java.util.*;

public class CutBuffer {

    private List<Cell> _cells;
    
    public CutBuffer(){

    }

    List<Cell> getCells(){
        List<Cell> copy = new ArrayList<>(_cells);
        return copy;
    }
}
