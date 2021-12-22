import java.util.Scanner;

public class Main {
    private static int[][] getMatrixFromInput() {
        System.out.print("Введіть розмір булевої матриці: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine(); //thanks to the java devs!!1
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; ++i) {
            System.out.print("Введіть " + (i + 1) + "-й рядок булевої матриці: ");
            String matrixLine = sc.nextLine();
            String[] matrixLineArray = matrixLine.split(" ");

            for (int j = 0; j < size; ++j) {
                matrix[i][j] = Integer.parseInt(matrixLineArray[j]);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = getMatrixFromInput();

        System.out.println();
        if(MatrixProperties.isSymmetrical(matrix)){
            System.out.println("The graph can be both directed and not directed.");
        }else{
            System.out.println("The graph is directed.");
        }

        Node node = new Node("/");

        node.left = new Node("+");
        node.left.left = new Node("12");
        node.left.right = new Node("8");

        node.right = new Node("-");
        node.right.right = new Node("1");
        node.right.left = new Node("*");
        node.right.left.left = new Node("3");
        node.right.left.right = new Node("7");

        System.out.print("Normal:   ");
        node.printPolish(false);
        System.out.print("\nInverted: ");
        node.printPolish(true);
        System.out.println();

        System.out.println("Result: " + node.calculate());
    }
}
