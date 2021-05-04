
public class TwoLargest {

    public static void main(String[] args) {
        System.out.println("Input a terminating number: ");
        Double terminate = IO.readDouble();
        System.out.println("Enter numbers (at least two): ");
        double number = IO.readDouble();
        double largest = -999999999;
        double second = -999999999;

        while (number != terminate) {
            if (number > largest) {
                second = largest;
                largest = number;
            } else {
                if (number > second) {
                    second = number;
                }
                
            }
            number = IO.readDouble();
        }

        System.out.println(
                "The largest and second largest numbers are: ");
        IO.outputDoubleAnswer(largest);

        IO.outputDoubleAnswer(second);

    }
}
