package xxl.core;

public abstract class IntervalFunction extends Function {

   private String _name;

    public IntervalFunction(String name){
        super(name);
    }

    protected abstract Literal compute();

    @Override
    public String toString(){
        return _name;
    }
    
}
