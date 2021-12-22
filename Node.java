public class Node {
    public String value;
    public Node left;
    public Node right;

    public Node(String value) {
        this.value = value;
    }

    void printPolish(boolean inverted) {
        if (!inverted) {
            System.out.print(value + " ");

            if (left != null) {
                left.printPolish(false);
                right.printPolish(false);
            }

            return;
        }

        if (left != null) {
            left.printPolish(true);
            right.printPolish(true);
        }

        System.out.print(value + " ");
    }

    double calculate() {
        switch (value) {
            case "/":
                return left.calculate() / right.calculate();
            case "*":
                return left.calculate() * right.calculate();
            case "-":
                return left.calculate() - right.calculate();
            case "+":
                return left.calculate() + right.calculate();
            default:
                return Double.parseDouble(value);
        }
    }
}