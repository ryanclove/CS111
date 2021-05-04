
public class DonateToPaws {

    public static void main(String[] args) {
        System.out.println("How much would you like to donate?: ");
        double donationAmount = IO.readDouble();
        System.out.println("You're fee is: " +
        DonateToPaws.donationFee(donationAmount));
    }

    public static double donationFee(double donationAmount) {
        double fee = 0;
        if (donationAmount <= 150) {
            return fee = 3;
        } else if (donationAmount > 150 && donationAmount < 1500) {
            double f1 = donationAmount * 0.04;
            double f2 = 8;
            if (f1 > f2) {
                return fee = f1;
            } else {
                return fee = f2;
            }
        } else if (donationAmount >= 1500 && donationAmount < 15000) {
            double f1 = donationAmount * 0.01;
            double f2 = 20;
            if (f1 > f2) {
                return fee = f1;
            } else {
                return fee = f2;
            }
        } else if (donationAmount >= 15000) {
            double f1 = 15000 * 0.01;
            double f2 = 4000 * 0.02;
            double f3 = (donationAmount - 19000) * 0.03;
            return fee = f1 + f2 + f3;
        }
        return fee;
    }

    }
