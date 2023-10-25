package xxl.core;

public class Mul extends BinaryFunction {
    private Content _arg1;

    private Content _arg2;

    public Mul(Content a, Content b) {
        super("MUL");
        _arg1=a;
        _arg2=b;
    }

    @Override
    public Literal compute() {

        Literal _operand1 = _arg1.value();
        Literal _operand2 = _arg2.value();

        int result = _operand1.asInt() * _operand2.asInt();
        return new LiteralInteger(result);
    }
    @Override
    public String toString() { return "MUL(" + _arg1 + "," + _arg2 + ")";}

    @Override
    Literal value() {
        return compute();
    }
}
