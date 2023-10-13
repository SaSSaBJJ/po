package xxl.core;

public class Concat extends IntervalFunction {
    
    private Range _range;

    public Concat(Range range) {

        super("CONCAT");

        _range = range;
    }

    @Override
    public Literal compute() {
        //FIX ME
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
