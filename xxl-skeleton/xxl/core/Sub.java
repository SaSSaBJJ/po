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

        int result = _operand1.asInt() - _operand2.asInt();
        return new LiteralInteger(result);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    @Override
    Literal value() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'value'");
    }
    
}
