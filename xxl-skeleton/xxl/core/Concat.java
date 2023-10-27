package xxl.core;

public class Concat extends IntervalFunction {
    
    private Range _range;

    public Concat(Range range) {

        super("CONCAT");

        _range = range;
    }

    @Override
    public Literal compute() {
        StringBuilder result = new StringBuilder();
        result.append('\'');
        for (Cell c: _range.getCells()){
            result.append(c.getContent().asString().substring(1));
        }
        return new LiteralString(result.toString());
    }
        

    @Override
    public String toString() {
        return "CONCAT(" + _range.getFirstRow() + ";" + _range.getFirstColumn() + ":" + _range.getLastRow() + ";" + _range.getLastColumn() + ")";
    }

    @Override
    public Literal value() {
        return compute();
    }
}
