package xxl.core;

public class Add extends BinaryFunction {

    private Content _arg1;

    private Content _arg2;

    public Add(Content a, Content b) {
        super("ADD");
        _arg1=a;
        _arg2=b;
    }

    @Override
    public Literal compute() {

        Literal _operand1 = _arg1.value();
        Literal _operand2 = _arg2.value();

        int result = _operand1.asInt() + _operand2.asInt();
        return new LiteralInteger(result);
    }

    @Override
    public String toString() {
        return "ADD(" + _arg1 + "," + _arg2 + ")";
    }

    @Override
    public Literal value() {
        return compute();
    }
}
