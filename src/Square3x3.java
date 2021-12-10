/**
 * Maman 13 - Question 1 + Question 2 - Class Square3x3
 * @author Dima Subotin - ID: 311626519
 * @version 11/12/2021
 */
public class Square3x3 {

    private int[][] _boardCell = new int[3][3];
    private final int DEFAULT_CELL_VALUE = -1;
    private final int NUMBER_OF_ROWS = 3;
    private final int NUMBER_OF_COLUMNS = 3;

    /**
     * Constructor for objects of class Square3X3. Constructs and initializes a 2-dimensional
     * array of the size 3X3, with the values of –1 in each cell.
     */
    public Square3x3(){
        for (int row=0; row<NUMBER_OF_ROWS; row++){
            for (int col=0; col<NUMBER_OF_COLUMNS; col++){
                _boardCell[row][col] = DEFAULT_CELL_VALUE;
            }
        }
    }

    /**
     * Constructs a 2-dimensional array of the size 3X3, which values are taken from the given
     * array. If the given array’s size is bigger than 3X3, only the first 3X3 cells are taken. If the
     * given array is smaller, the rest of the cells are initialized to –1.
     * @param array the array from which values gets copied.
     */
    public Square3x3(int[][] array){
        this();

        for (int row=0; row<array.length || row<NUMBER_OF_ROWS; row++){
            for (int col=0; col<array[row].length || col<NUMBER_OF_COLUMNS; col++){
                _boardCell[row][col] = array[row][col];
            }
        }
    }

    /**
     * Copy constructor. Constructs a 2-dimensional array of the size 3X3, whose values are
     * taken from the array of the given Square3x3 object.
     * @param other The Square3x3 from which to construct the new object.
     */
    public Square3x3(Square3x3 other){
        for (int row=0; row<NUMBER_OF_ROWS; row++){
            for (int col=0; col<NUMBER_OF_COLUMNS; col++){
                _boardCell[row][col] = other._boardCell[row][col];
            }
        }
    }

    /**
     * Returns the value in the (row, col) cell. If the row and/or col are out of the
     * array bounds, returns –1. Legal values for row/col are 0,1,2.
     * @param row the row coordinate.
     * @param col the column coordinate.
     * @return The value in the (row, col) cell.
     */
    public int getCell(int row, int col){
        if (row>=0 && row<NUMBER_OF_ROWS && col>=0 && col<NUMBER_OF_COLUMNS) return _boardCell[row][col];
        else return -1;
    }

    /**
     * Sets the cell (row, col) in the array to the given value. If the row and/or col
     * are out of the array bounds – does nothing. Legal values for row/col are 0,1,2.
     * @param row the row coordinate.
     * @param col the column coordinate.
     * @param value the value to set in the (row, col) cell.
     */
    public void setXY(int row, int col, int value){
        if (row>=0 && row<NUMBER_OF_ROWS && col>=0 && col<NUMBER_OF_COLUMNS) _boardCell[row][col]=value;
    }

    /**
     * Returns a String representation of the array.
     * @return a String representation of the array.
     */
    public String toString(){
        String str = new String();
        for (int row=0; row<NUMBER_OF_ROWS; row++){
            for (int col=0; col<NUMBER_OF_COLUMNS; col++){
                if (col!=2) str+=_boardCell[row][col]+"\t";
                else str+=_boardCell[row][col]+"\n";
            }
        }
        return str;
    }

    /**
     * Checks whether the array in Square3x3 contains all numbers from 1 to 9.
     * Returns true if it does and false it doesn't.
     * @return a boolean value based on the check result.
     */
    public boolean allThere() {
        boolean[] validationArray = new boolean[10];
        for (int row = 0; row < NUMBER_OF_ROWS; row++){
            whosThereRow(row, validationArray);
        }

        for (int val=1; val<validationArray.length; val++){
            if (!validationArray[val]) return false;
        }
        return true;
    }

    /**
     * Checks a user specified row in a Square3X3 (only 0,1,2 rows are valid).
     * If the row contains any cell with a number between 1-9, the given array (only array with a length of 10 is valid)
     * will get a true value in the cell with the index equal to the value.
     * Example when a cell got a value of 4, the array will get a true value in values[4] cell.
     * @param row the row index
     * @param values the validation array
     */
    public void whosThereRow(int row, boolean[] values ){
        if (row>=0 && row<NUMBER_OF_ROWS && values.length==10){
            for (int val = 1; val < 10; val++){
                for(int col = 0; col < NUMBER_OF_COLUMNS ; col++){
                    if (_boardCell[row][col]==val) values[val]=true;
                }
            }
        }
    }

    /**
     * Checks a user specified column in a Square3X3 (only 0,1,2 columns are valid).
     * If the column contains any cell with a number between 1-9, the given array (only array with a length of 10 is valid)
     * will get a true value in the cell with the index equal to the value.
     * Example when a cell got a value of 4, the array will get a true value in values[4] cell.
     * @param col the column index
     * @param values the validation array
     */
    public void whosThereCol(int col, boolean[] values ){
        if (col>=0 && col<NUMBER_OF_COLUMNS && values.length==10){
            for (int val = 1; val < 10; val++){
                for(int row = 0; row < NUMBER_OF_ROWS ; row++){
                    if (_boardCell[row][col]==val) values[val]=true;
                }
            }
        }
    }
}
