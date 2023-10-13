package xxl.core;

public abstract class Function extends Content {
    
    private String _name;

    public Function(String name) {
        _name = name;
    }

    protected abstract Literal compute();

    
    public String toString(){
       return compute().toString();
    }

    public int asInt(){
        return compute().asInt();
       
    }

    public Literal Value(){
        return compute();
    }
    
}
