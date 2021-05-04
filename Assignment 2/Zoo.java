
public class Zoo {

    public static void main(String[] args) {
        System.out.print("How many zoos are there? ");
        int numbersZoo = IO.readInt();
        int numZoo = 1;
        int prevGiraffes = 0;
        int prevLions = 0;
        int prevSnakes = 0;
        while (numZoo <= numbersZoo) {
            System.out.print("In this zoo, how many giraffes: ");
            int giraffes = IO.readInt();
            System.out.print("Lions: ");
            int lions = IO.readInt();
            System.out.print("Snakes: ");
            int snakes = IO.readInt();
            prevGiraffes = giraffes + prevGiraffes;
            prevLions = lions + prevLions;
            prevSnakes = snakes + prevSnakes;
            numZoo++;
        }
        System.out.println("In these zoos there are a total of: ");
        System.out.print("Giraffes: ");
        IO.outputIntAnswer(prevGiraffes);
        System.out.print("Lions: ");
        IO.outputIntAnswer(prevLions);
        System.out.print("Snakes: ");
        IO.outputIntAnswer(prevSnakes);

    }

}
