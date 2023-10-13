package xxl.core;

public class Coalesce extends IntervalFunction {
    private Range _range;

    public Coalesce(Range range) {

        super("COALESCE");

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
