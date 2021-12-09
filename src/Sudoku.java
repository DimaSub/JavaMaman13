/**
 * Maman 13 - Question 3 + Question 4 - Class Sudoku
 * @author Dima Subotin - ID: 311626519
 * @version 11/12/2021
 */
public class Sudoku {

    private Square3x3[][] _sudoku = new Square3x3[3][3];
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
                _sudoku[row][col] = new Square3x3();
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
                _sudoku[row][col] = new Square3x3(square3x3Array[row][col]);
            }
        }
    }

    /**
     *
     * @return
     */
    public boolean isValid(){
        boolean rowValidationArray[] = new boolean[10];
        boolean colValidationArray[] = new boolean[10];
        boolean allValidationArray[] = new boolean[10];

        for (int row = 0; row < NUMBER_OF_ROWS; row++){
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                for (int subRow = 0; subRow < NUMBER_OF_SUBROWS; subRow++) {
                    _sudoku[row][col].whosThereRow(subRow, rowValidationArray);
                }
                for (int val=1; val<rowValidationArray.length; val++){
                    if (!rowValidationArray[val]) return false;
                }
            }
        }

        for (int row = 0; row < NUMBER_OF_ROWS; row++){
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                for (int subCol = 0; subCol < NUMBER_OF_SUBCOLUMNS; subCol++) {
                    _sudoku[row][col].whosThereCol(subCol, colValidationArray);
                }
                for (int val=1; val<colValidationArray.length; val++){
                    if (!colValidationArray[val]) return false;
                }
            }
        }

        int counter = 1;
        for (int row = 0; row < NUMBER_OF_ROWS; row++){
            for (int col = 0; col < NUMBER_OF_COLUMNS; col++) {
                allValidationArray[counter]=_sudoku[row][col].allThere();
                counter++;
            }
            for (int val=1; val<allValidationArray.length; val++){
                if (!allValidationArray[val]) return false;
            }
        }
        return true;
    }
}
