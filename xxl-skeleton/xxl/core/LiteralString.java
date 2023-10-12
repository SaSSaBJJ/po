package xxl.core;

public class LiteralString extends Literal{
    private String _value;

    public LiteralString(String value){
        _value = value;
    }
    
    @Override
    public String toString() {
        return  asString();
    }

    public String asString() {
        return  _value;
    }

    public int asInt() {
       try {
            int _asInt = Integer.parseInt(_value);
            return _asInt;
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input: " + _value);
            return 0;
        }
    }

    Literal value() {
        return this;
    }
}
