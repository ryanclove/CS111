
public class AppendRec {

    public static void main(String[] args) {
        System.out.println("Input a string: ");
        String original = IO.readString();
        System.out.println("How many times?: ");
        int n = IO.readInt();
        System.out.println(appendNTimes(original, n));
    }

    public static String appendNTimes(String original, int n) {
        if (n == 0 || n < 0) {
            return original;
        } else {
            return original + (appendNTimes(original, n - 1));

        }
    }
