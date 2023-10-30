package xxl.core;

public class Mod extends BinaryFunction {

    private Content _arg1;

    private Content _arg2;

    public Mod(Content a, Content b) {
        super("MOD");
        _arg1=a;
        _arg2=b;
    }

    @Override
    public Literal compute() {

        Literal _operand1 = _arg1.value();
        Literal _operand2 = _arg2.value();
        try {
            int result = _operand1.asInt() % _operand2.asInt();
            return new LiteralInteger(result);
        }catch (Exception e){
            return new LiteralInteger(-1);
        }
    }

    @Override
    public String toString() {
        return "MOD(" + _arg1 + "," + _arg2 + ")";
    }

    @Override
    public Literal value() {
        return compute();
    }
}
