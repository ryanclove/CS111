
public class StringRec {

    public static void main(String[] args) {
        System.out.println("What is the string: ");
        String compressedText = IO.readString();
        System.out.println(decompress(compressedText));
    }

    public static String decompress(String compressedText) {
        if (compressedText.length() == 1)
            return compressedText;

        else if (compressedText.charAt(0)== '1')
            return "" + decompress(compressedText.substring(1));
        
        else if (compressedText.charAt(0) >= 49 && compressedText.charAt(0) <= 57){
            return compressedText.charAt(1) + decompress(""
                    + Character.getNumericValue(compressedText.charAt(0)-1)
                    + compressedText.substring(1));
        }
        else {
            return compressedText.charAt(0) + decompress(compressedText.substring(1));
        }

    }
}
