package xxl.core;

public class LiteralString extends Literal{
    private String _value;

    public LiteralString(String value){
        _value = value;
    }

    public String toString() {
        return  _value;
    }

    Literal value() {
        // Return this instance since it represents the literal value
        return this;
    }
}
