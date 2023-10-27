package xxl.core;

public class Product  extends IntervalFunction {
    private Range _range;

    public Product(Range range) {

        super("PRODUCT");

        _range = range;
    }

    @Override
    public Literal compute() {
        //
        int i = 1;
        for (Cell c: _range.getCells()) {
            if(c.getContent().asString().isEmpty() || c.getContent().asString().charAt(0) == '\''){
                return new LiteralString("");
            }
            i *= c.getContent().asInt();
        }
        return new LiteralInteger(i);
    }
        

    @Override
    public String toString() {
        return "PRODUCT(" + _range.getFirstRow() + ";" + _range.getFirstColumn() + ":" + _range.getLastRow() + ";" + _range.getLastColumn() + ")";
    }

    @Override
    public Literal value() {
        return compute();
    }
}
