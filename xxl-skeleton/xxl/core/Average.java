package xxl.core;

import java.util.List;

public class Average extends IntervalFunction {

    private Range _range;

    public Average(Range range) {

        super("AVERAGE");

        _range = range;
    }

    @Override
    public Literal compute() {
        int i = 0;
        int sum = 0;
        for (Cell c: _range.getCells()) {
            if(c.getContent().asString().isEmpty()){
                return new LiteralString("");
            }
            sum += c.getContent().asInt();
            i ++;
        }
        return new LiteralInteger(sum/i);
    }

    @Override
    public String toString() {
        return "AVERAGE(" + _range.getFirstRow() + ";" + _range.getFirstColumn() + ":" + _range.getLastRow() + ";" + _range.getLastColumn() + ")";
    }

    @Override
    public Literal value() {
        return compute();
    }
}
