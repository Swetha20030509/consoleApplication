package game.snackegame;
import java.util.*;

public class SnackeGame {
    String[][] matrix = new String[8][8];
    ArrayList<Cell> position = new ArrayList<>();
    int row;
    int column;

    public void foodAllocated() {
        Random rand = new Random();
        do {
            row = rand.nextInt(8);
            column = rand.nextInt(8);
        } while (matrix[row][column].equals("o")); 
        matrix[row][column] = "*";
    }

    public void addCell(int x, int y) {
        Cell cell = new Cell(x, y);
        position.add(cell);
    }

    public void print() {
        initializeBoard();
        for (Cell cell : position) {
            matrix[cell.getX()][cell.getY()] = "o";
        }
        matrix[row][column] = "*";
        System.out.println("##########");
        for (String[] row : matrix) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
        System.out.println("##########");
    }

    public void initializeBoard() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = " ";
            }
        }
    }

    public void move(int dx, int dy) {
    	System.out.println(position.size()+"......");
        int headX = position.get(0).getX();
        int headY = position.get(0).getY();
        int newX = headX + dx;
        int newY = headY + dy;

        if (newX < 0 || newX >= 8 || newY < 0 || newY >= 8 || matrix[newX][newY].equals("o")) {
            System.out.println("Game Over!");
            System.exit(0);
        }
        if (newX == row && newY == column) {
            position.add(0, new Cell(newX, newY)); 
            foodAllocated();
        } else {
            position.add(0, new Cell(newX, newY)); 
            Cell tail = position.remove(position.size() - 1); 
            matrix[tail.getX()][tail.getY()] = " ";
        }
    }

    public void moveLeft() {
        move(0, -1);
    }

    public void moveRight() {
        move(0, 1);
    }

    public void moveUp() {
        move(-1, 0);
    }

    public void moveDown() {
        move(1, 0);
    }

    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. left");
            System.out.println("2. right");
            System.out.println("3. up");
            System.out.println("4. down");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    moveLeft();
                    break;
                case 2:
                    moveRight();
                    break;
                case 3:
                    moveUp();
                    break;
                case 4:
                    moveDown();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }
            print();
        }
    }

    public static void main(String[] args) {
        System.out.println("Snake Game Starting...");
        SnackeGame snakeGame = new SnackeGame();
        snakeGame.initializeBoard();
        snakeGame.addCell(0, 0);
        snakeGame.foodAllocated();
        snakeGame.print();
        snakeGame.gameStart();
    }
}

class Cell {
    private int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
