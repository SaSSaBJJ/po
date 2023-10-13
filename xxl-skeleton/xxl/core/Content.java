package xxl.core;

import xxl.core.exception.UnrecognizedEntryException;

public abstract class Content {
    // Abstract method to return a string representation of the content
    public abstract String toString();

    // Abstract method to get the value of the content as a Literal
    abstract Literal value();

    // Method to return the content as a string
    public String asString() {
        return toString();
    }

    //Method to return the content as an integer (assuming it's a valid integer)
    
    public int asInt() throws UnrecognizedEntryException {
        Literal literal = value();
        if (literal instanceof LiteralInteger) {
            return ((LiteralInteger) literal).asInt();
        } else {
            throw new UnsupportedOperationException("Content is not an integer.");
        }
    }
}

