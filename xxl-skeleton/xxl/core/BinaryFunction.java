package xxl.core;

public abstract class BinaryFunction extends Function {

    private String _name;

    public BinaryFunction(String name){
        super(name);
    }

    protected abstract Literal compute();

    @Override
    public String toString(){
        return _name;
    }
    
}
