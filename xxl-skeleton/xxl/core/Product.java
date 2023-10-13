package xxl.core;

public class Product  extends IntervalFunction {
    private Range _range;

    public Product(Range range) {

        super("PRODUCT");

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
