package xxl.core;

public class Sub extends BinaryFunction {

    private Content _arg1;

    private Content _arg2;

    public Sub(Content a, Content b) {
        super("SUB");
        _arg1=a;
        _arg2=b;
    }

    @Override
    public Literal compute() {

        Literal _operand1 = _arg1.value();
        Literal _operand2 = _arg2.value();
        if(_arg1.value().asString().isEmpty() || _arg2.value().asString().isEmpty()){
            return new LiteralString("");
        }

        int result = _operand1.asInt() - _operand2.asInt();
        return new LiteralInteger(result);
    }

    @Override
    public String toString() {
        return "SUB(" + _arg1 + "," + _arg2 + ")";
    }

    @Override
    public Literal value() {
        return compute();
    }
    
}
