/**
 * Maman 13 - Question 3 + Question 4 - Class Sudoku
 * @author Dima Subotin - ID: 311626519
 * @version 11/12/2021
 */
public class Sudoku {

    private Square3x3[][] _board = new Square3x3[3][3];
    private final int NUMBER_OF_ROWS = 3;
    private final int NUMBER_OF_COLUMNS = 3;
    private final int NUMBER_OF_SUBROWS = 3;
    private final int NUMBER_OF_SUBCOLUMNS = 3;

    /**
     * Constructor for objects of class Sudoku. Constructs and initializes a 2-dimensional
     * array of the size 3X3, with the values of Square3x3 in each cell (with value of -1 in each sub cell).
     */
    public Sudoku(){
        for (int row = 0; row < NUMBER_OF_ROWS; row++){
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++){
                _board[row][col] = new Square3x3();
            }
        }
    }

    /**
     * Constructs a 2-dimensional array of the size 3X3, which values are Square3X3 in each cell.
     * Each Square3x3 own values gets copied from square3x3Array to the new array.
     * @param square3x3Array the array form which values gets copied
     */
    public Sudoku(Square3x3[][] square3x3Array){
        for (int row = 0; row < NUMBER_OF_ROWS; row++){
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++){
                _board[row][col] = new Square3x3(square3x3Array[row][col]);
            }
        }
    }

    /**
     * Checks whether the Sudoku board is entirely correct based on the Sudoku rules.
     * @return a boolean value, true if Sudoku is correct or false otherwise
     */
    public boolean isValid(){
        boolean rowValidationArray[] = new boolean[10];
        boolean colValidationArray[] = new boolean[10];
        boolean allValidationArray[] = new boolean[10];

        for (int row = 0; row < NUMBER_OF_ROWS; row++){
            for (int subRow = 0; subRow < NUMBER_OF_SUBROWS; subRow++) {
                for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                    _board[row][col].whosThereRow(subRow, rowValidationArray);
                }
                if (!arrayValidator(rowValidationArray)) return false;
            }
        }


        for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
            for (int subCol = 0; subCol < NUMBER_OF_SUBCOLUMNS; subCol++) {
                for (int row = 0; row < NUMBER_OF_ROWS; row++){
                    _board[row][col].whosThereCol(subCol, colValidationArray);
                }
                if (!arrayValidator(colValidationArray)) return false;
            }
        }

        for (int row = 0, counter = 1; row < NUMBER_OF_ROWS; row++){
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                allValidationArray[counter]=_board[row][col].allThere();
                counter++;
            }
        }

        if (!arrayValidator(allValidationArray)) return false;
        else return true;
    }

    private boolean arrayValidator(boolean[] array){
        for (int val=1; val<array.length; val++){
            if (!array[val]) return false;
        }
        return true;
    }
}
