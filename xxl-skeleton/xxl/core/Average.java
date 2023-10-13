package xxl.core;

public class Average extends IntervalFunction {

    private Range _range;

    public Average(Range range) {

        super("AVERAGE");

        _range = range;
    }

    @Override
    public Literal compute() {
        if (_range.getFirstRow()==_range.getLastRow()){
            //FIX ME
            return null;
        }
        return null;
    }
        

    @Override
    public String toString() {
        return compute().toString();
    }

    @Override
    Literal value() {
        return compute();
    }
}
