package xxl.core;

public abstract class Function extends Content {
    
    private String _name;

    protected abstract Literal compute();

    /* FIX ME
    public String asString(){

    }

    public int asInt(){

    }

    public Literal Value(){

    }
    */
}
