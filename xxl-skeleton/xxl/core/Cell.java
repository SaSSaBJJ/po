package xxl.core;

//import javax.swing.text.AbstractDocument.Content;

public class Cell {

    private int _row;

    private int _column;

    private Content _content;


    // Constructor
    public Cell(int row, int column, Content content) {
        _row = row;
        _column = column;
        _content = content;
    }

    // toString method to represent the cell as a string
    public String toString() {
        return  _row + ";" + _column;
    }

    protected void setContent(Content c) {
        _content = c;
    }

    public int getRow(){
        return _row;
    }

    public int getColumn(){
        return _column;
    }

    public Content getContent(){
        return _content;
    }

    // Get the value of the cell (assuming it holds a Literal)
    Literal value() {
        if (_content instanceof Literal) {
            return (Literal) _content;
        } else {
            // Handle the case when content is not a Literal
            return null; // You can return an appropriate value or handle this differently
        }
    }
}
