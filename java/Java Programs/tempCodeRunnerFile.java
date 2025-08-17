
import java.util.*;

public class Matrix {
  private int rows;
  private int columns;
  private int[][] matrix;

  // Array to store multiple matrices
  private Matrix[] matrices;

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

  // Constructor to initialize multiple matrices
  public Matrix(int numMatrices, int rows, int columns) {
      this.matrices = new Matrix[numMatrices];
      for (int i = 0; i < numMatrices; i++) {
          matrices[i] = new Matrix(rows, columns);
      }
  }

  //Constructor to create Indentity matrix of any size 
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

    Matrix resultMatrix = new Matrix(matrix1.rows, matrix2.columns);
    resultMatrix.matrix = result;
    return resultMatrix;
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

  Matrix resultMatrix = new Matrix(matrix1.rows, matrix1.columns);
  resultMatrix.matrix = result;
  return resultMatrix;
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

  Matrix resultMatrix = new Matrix(matrix1.rows, matrix1.columns);
  resultMatrix.matrix = result;
  return resultMatrix;
}

  // Getter for matrices array
  public Matrix[] getMatrices() {
      return matrices;
  }

  // Setter for matrices array
  public void setMatrices(Matrix[] matrices) {
      this.matrices = matrices;
  }
  
}

public class MatrixMain {
  public static void main(String[] args) {
      // Create a single matrix
      Matrix matrix1 = new Matrix(2, 3);
      

      // Create another single matrix
      Matrix matrix2 = new Matrix(3, 2);
      

      // Multiply matrices
      Matrix resultMultiply = Matrix.multiplyMatrices(matrix1, matrix2);
      if (resultMultiply != null) {
          System.out.println("Result of matrix multiplication:");
          for (int i = 0; i < resultMultiply.rows; i++) {
              for (int j = 0; j < resultMultiply.columns; j++) {
                  System.out.print(resultMultiply.matrix[i][j] + " ");
              }
              System.out.println();
          }
      }

      // Add matrices
      Matrix resultAdd = Matrix.addMatrices(matrix1, matrix2);
      if (resultAdd != null) {
          System.out.println("Result of matrix addition:");
          for (int i = 0; i < resultAdd.rows; i++) {
              for (int j = 0; j < resultAdd.columns; j++) {
                  System.out.print(resultAdd.matrix[i][j] + " ");
              }
              System.out.println();
          }
      }

      // Subtract matrices
      Matrix resultSubtract = Matrix.subtractMatrices(matrix1, matrix2);
      if (resultSubtract != null) {
          System.out.println("Result of matrix subtraction:");
          for (int i = 0; i < resultSubtract.rows; i++) {
              for (int j = 0; j < resultSubtract.columns; j++) {
                  System.out.print(resultSubtract.matrix[i][j] + " ");
              }
              System.out.println();
          }
      }
  }
}
