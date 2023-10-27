package xxl.core;

public class LiteralInteger extends Literal{
    private int _value;

    public LiteralInteger(int value){
        _value = value;
    }

    @Override
    public String toString() {
        return  asString();
    }

    public String asString() {
        return  Integer.toString(_value);
    }

    public int asInt() {
        return _value;
    }

    public Literal value() {
        return this;
    }
    
}
