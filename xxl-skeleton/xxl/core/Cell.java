package xxl.core;

//import javax.swing.text.AbstractDocument.Content;

public class Cell {
    private int _row;
    private int _column;


    // Constructor
    public Cell(int row, int column) {
        _row = row;
        _column = column;
    }

    // toString method to represent the cell as a string
    public String toString() {
        return  _row + ";" + _column;
    }

    /*the content of the cell
    protected void setContent(Content c) {
        content = c;
    }*/

    /*  Get the value of the cell (assuming it holds a Literal)
    Literal value() {
        if (content instanceof Literal) {
            return (Literal) content;
        } else {
            // Handle the case when content is not a Literal
            return null; // You can return an appropriate value or handle this differently
        }
    }*/
}
