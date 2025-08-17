import java.util.Scanner;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] matrix;

    // Default Constructor
    public Matrix() {
        this.rows = 0;
        this.columns = 0;
        this.matrix = null;
    }

    // Constructor to initialize a single matrix
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    // Constructor to create Identity matrix of any size
    public Matrix(int size) {
        this.rows = size;
        this.columns = size;
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    this.matrix[i][j] = 1;
                } else {
                    this.matrix[i][j] = 0;
                }
            }
        }
    }

    // Method to multiply two matrices
    public static Matrix multiplyMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.columns != matrix2.rows) {
            System.out.println("Error: Matrix dimensions do not match for multiplication.");
            return null;
        }

        int[][] result = new int[matrix1.rows][matrix2.columns];

        for (int i = 0; i < matrix1.rows; i++) {
            for (int j = 0; j < matrix2.columns; j++) {
                for (int k = 0; k < matrix1.columns; k++) {
                    result[i][j] += matrix1.matrix[i][k] * matrix2.matrix[k][j];
                }
            }
        }

        return new Matrix(matrix1.rows, matrix2.columns, result);
    }

    // Method to add two matrices
    public static Matrix addMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns) {
            System.out.println("Error: Matrix dimensions do not match for addition.");
            return null;
        }

        int[][] result = new int[matrix1.rows][matrix1.columns];

        for (int i = 0; i < matrix1.rows; i++) {
            for (int j = 0; j < matrix1.columns; j++) {
                result[i][j] = matrix1.matrix[i][j] + matrix2.matrix[i][j];
            }
        }

        return new Matrix(matrix1.rows, matrix1.columns, result);
    }

    // Method to subtract two matrices
    public static Matrix subtractMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns) {
            System.out.println("Error: Matrix dimensions do not match for subtraction.");
            return null;
        }

        int[][] result = new int[matrix1.rows][matrix1.columns];

        for (int i = 0; i < matrix1.rows; i++) {
            for (int j = 0; j < matrix1.columns; j++) {
                result[i][j] = matrix1.matrix[i][j] - matrix2.matrix[i][j];
            }
        }

        return new Matrix(matrix1.rows, matrix1.columns, result);
    }

    // Constructor for creating matrix from existing data
    private Matrix(int rows, int columns, int[][] data) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = data;
    }

    // Method to read a matrix from user input
    private static Matrix readMatrix(int rows, int columns) {
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix.matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Method to print a matrix
    private static void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                System.out.print(matrix.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        boolean exit = false;

        Matrix[] matrixArray = new Matrix[10];

        while(!exit){
        System.out.println("Matrix Operations:");
        System.out.println("1. Multiply Matrices");
        System.out.println("2. Add Matrices");
        System.out.println("3. Subtract Matrices");
        System.out.println("4. Create Identity Matrix");
        System.out.println("5. Store Matrix");
        System.out.println("6. Display Matrix");
        System.out.println("7. Exit");

        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Matrix multiplication
                    System.out.println("Enter the dimensions of the first matrix:");
                    System.out.print("Rows: ");
                    int rows1 = scanner.nextInt();
                    System.out.print("Columns: ");
                    int columns1 = scanner.nextInt();
                    System.out.println("Enter the elements of the first matrix:");
                    Matrix matrix1 = readMatrix(rows1, columns1);
                    
                    System.out.println("Enter the dimensions of the second matrix:");
                    System.out.print("Rows: ");
                    int rows2 = scanner.nextInt();
                    System.out.print("Columns: ");
                    int columns2 = scanner.nextInt();
                    System.out.println("Enter the elements of the second matrix:");
                    Matrix matrix2 = readMatrix(rows2, columns2);
                    
                    Matrix product = multiplyMatrices(matrix1, matrix2);
                    if (product != null) {
                        System.out.println("Resultant Matrix:");
                        printMatrix(product);
                    }
                    break;
                case 2:
                    // Matrix addition
                    System.out.println("Enter the dimensions of the matrices:");
                    System.out.print("Rows: ");
                    rows1 = scanner.nextInt();
                    System.out.print("Columns: ");
                    columns1 = scanner.nextInt();
                    System.out.println("Enter the elements of the first matrix:");
                    matrix1 = readMatrix(rows1, columns1);
                    
                    System.out.println("Enter the dimensions of the second matrix:");
                    System.out.print("Rows: ");
                    rows2 = scanner.nextInt();
                    System.out.print("Columns: ");
                    columns2 = scanner.nextInt();
                    System.out.println("Enter the elements of the second matrix:");
                    matrix2 = readMatrix(rows2, columns2);
                    
                    Matrix sum = addMatrices(matrix1, matrix2);
                    if (sum != null) {
                        System.out.println("Resultant Matrix:");
                        printMatrix(sum);
                    }
                    break;
                case 3:
                    // Matrix subtraction
                    System.out.println("Enter the dimensions of the matrices:");
                    System.out.print("Rows: ");
                    rows1 = scanner.nextInt();
                    System.out.print("Columns: ");
                    columns1 = scanner.nextInt();
                    System.out.println("Enter the elements of the first matrix:");
                    matrix1 = readMatrix(rows1, columns1);
                    
                    System.out.println("Enter the dimensions of the second matrix:");
                    System.out.print("Rows: ");
                    rows2 = scanner.nextInt();
                    System.out.print("Columns: ");
                    columns2 = scanner.nextInt();
                    System.out.println("Enter the elements of the second matrix:");
                    matrix2 = readMatrix(rows2, columns2);
                    
                    Matrix difference = subtractMatrices(matrix1, matrix2);
                    if (difference != null) {
                        System.out.println("Resultant Matrix:");
                        printMatrix(difference);
                    }
                    break;
                case 4:
                    // Identity matrix creation
                    System.out.println("Enter the size of the identity matrix:");
                    int size = scanner.nextInt();
                    Matrix identityMatrix = new Matrix(size);
                    System.out.println("Identity Matrix:");
                    printMatrix(identityMatrix);
                    break;
                case 5:
                // Store Matrix
                    System.out.println("Enter the index to store the matrix (0-9): ");
                    int index = scanner.nextInt();
                    System.out.println("Enter the dimensions of the matrix:");
                    System.out.print("Rows: ");
                    int rows = scanner.nextInt();
                    System.out.print("Columns: ");
                    int columns = scanner.nextInt();
                    System.out.println("Enter the elements of the matrix:");
                    matrixArray[index] = readMatrix(rows, columns);
                    System.out.println("Matrix stored successfully at index " + index);
                    break;
                case 6:
                    // Display Matrix
                    System.out.println("Enter the index of the matrix to display (0-9): ");
                    int displayIndex = scanner.nextInt();
                    if (matrixArray[displayIndex] != null) {
                        System.out.println("Matrix at index " + displayIndex + ":");
                        printMatrix(matrixArray[displayIndex]);
                    } else {
                        System.out.println("No matrix stored at index " + displayIndex);
                    }
                    break;
                case 7:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }  
}
