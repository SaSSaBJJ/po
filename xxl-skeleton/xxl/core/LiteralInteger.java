package xxl.core;

public class LiteralInteger extends Literal{
    private int _value;

    public LiteralInteger(int value){
        _value = value;
    }

    public String toString() {
        return  Integer.toString(_value);
    }

    Literal value() {
        // Return this instance since it represents the literal value
        return this;
    }
}
