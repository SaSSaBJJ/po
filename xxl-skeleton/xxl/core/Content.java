package xxl.core;

public abstract class Content {
    // Abstract method to return a string representation of the content
    public abstract String toString();

    // Abstract method to get the value of the content as a Literal
    abstract Literal value();

    // Method to return the content as a string
    public String asString() {
        return toString();
    }

    /*  Method to return the content as an integer (assuming it's a valid integer)
    public int asInt() {
        Literal literal = value();
        if (literal instanceof LiteralInt) {
            return ((LiteralInt) literal).getValue();
        } else {
            throw new UnsupportedOperationException("Content is not an integer.");
        }
    }*/
}
