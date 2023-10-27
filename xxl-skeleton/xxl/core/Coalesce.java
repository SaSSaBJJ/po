package xxl.core;

public class Coalesce extends IntervalFunction {
    private Range _range;

    public Coalesce(Range range) {

        super("COALESCE");

        _range = range;
    }

    @Override
    public Literal compute() {
        for (Cell c : _range.getCells()){
            if (!c.getContent().value().asString().isEmpty()){
                if(c.getContent().value().asString().charAt(0) == '\''){
                    return c.getContent().value();
                }
            }
        }
        return new LiteralString("");
    }
        

    @Override
    public String toString() {
        return "COALESCE(" + _range.getFirstRow() + ";" + _range.getFirstColumn() + ":" + _range.getLastRow() + ";" + _range.getLastColumn() + ")";
    }

    @Override
    public Literal value() {
        return compute();
    }
}
