import java.util.Scanner;

/** @author Ozan Ege Çalışır
 *  @date   1.12.2022
 */
public class StoreUsingArrays_20220808003 {
    public static Scanner scan = new Scanner (System.in);
    public static void main(String[] args) {



        String[] item = {"bread", "cola", "snickers", "AYRAN"};
        int[] quantity = {10, 15, 12, 30};
        double [] price = {.75, 2.5, 2.25, 1};
        storeRun(item,quantity,price);
        //these items were the ones given to us as an example, and I decided to leave one of them
        //fully capitalized to test my capitalizeString and capitalizeArray methods

    }
    public static int menu(String[] item, double[] price, Scanner input){
        for (int j = 0 ; j< item.length; j++){
            System.out.print( "\n" + (j+1) + " - for " + item[j] + " " + "(" + price[j] + ")");
            //this option will show the menu of predetermined items in the array when the method is called
        }
        System.out.print("\n0 - to checkout");
        //this option needs to be outside of the for loop for it the not be printed 4 times in a row
        int choice = input.nextInt();
        return choice;
    }
    public static String returnedAmounts(double amount){
        System.out.println("Here is your change money. Have a good day. ");
        //if the customer doesn't pay any money or doesn't buy anything no amount of money will be shown
        String money = "";
        while(amount != 0) {
            if (amount / 200 >= 1) {
                money += (int)(amount / 200) + " - 200\n";
                amount = amount % 200;
            } else if (amount / 100 >= 1) {
                money += (int)(amount / 100) + " - 100\n";
                amount = amount % 100;
            } else if (amount / 50 >= 1) {
                money += (int)(amount / 50) + " - 50\n";
                amount = amount % 50;
            } else if (amount / 20 >= 1) {
                money += (int)(amount / 20) + " - 20\n";
                amount = amount % 20;
            } else if (amount / 10 >= 1) {
                money += (int)(amount / 10) + " - 10\n";
                amount = amount % 10;
            } else if (amount / 5 >= 1) {
                money += (int)(amount / 5) + " - 5\n";
                amount = amount % 5;
            } else if (amount / 1 >= 1) {
                money += (int)(amount / 1) + " - 1\n";
                amount = amount % 1;
            } else if (amount / 0.5 >= 1) {
                money += (int)(amount / 0.5) + " - 0.5\n";
                amount = amount % 0.5;
            } else if (amount / 0.25 >= 1) {
                money += (int)(amount / 0.25) + " - 0.25\n";
                amount = amount % 0.25;
            } else if (amount / 0.10 >= 1) {
                money += (int)(amount / 0.10) + " - 0.10\n";
                amount = amount % 0.10;
            } else if (amount / 0.05 >= 1) {
                money += (int)(amount / 0.05) + " - 0.05\n";
                amount = amount % 0.05;
            } else if (amount / 0.01 >= 1) {
                money += (int)(amount / 0.01) + " - 0.01\n";
                amount = amount % 0.01;
            }
            else break;
        }
        return money;
    }
    public static void storeRun(String[] item, int[] quantity, double[] price) {
        capitalizeArray(item);
        System.out.println("****** Store Inventory ******");
        //baseline of this code was used within last homework
        int choice;
        int chosen1;
        int chosen2;
        int chosen3;
        int chosen4;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        int remaining1 = quantity[0];
        int remaining2 = quantity[1];
        int remaining3 = quantity[2];
        int remaining4 = quantity[3];
        do {
            System.out.println("Welcome to our store. We have the following." +
                    " Please enter what you would like: ");
            choice = menu(item,price,scan);
            if (choice == 1) {
                System.out.print("How many " + item[0] + " would you like: ");
                chosen1 = scan.nextInt();
                if (remaining1 >= chosen1 && chosen1 > 0) {
                    sum1 += chosen1;
                    remaining1 = quantity[0] - sum1;
                } else if (chosen1 <= 0)
                    System.out.println("ERROR: Invalid requested amount. ");
                else if (chosen1 > remaining1)
                    System.out.println("ERROR: We do not have that many remaining. ");
            }
            if (choice == 2) {
                System.out.println("How many " + item[1] + " would you like: ");
                chosen2 = scan.nextInt();
                if (remaining2 >= chosen2 && chosen2 > 0) {
                    sum2 += chosen2;
                    remaining2 = quantity[1] - sum2;
                } else if (chosen2 <= 0)
                    System.out.println("ERROR: Invalid requested amount. ");
                else if (chosen2 > remaining2)
                    System.out.println("ERROR: We do not have that many remaining. ");
            }
            if (choice == 3) {
                System.out.print("How many " + item[2] + " would you like: ");
                chosen3 = scan.nextInt();
                if (remaining3 >= chosen3 && chosen3 > 0) {
                    sum3 += chosen3;
                    remaining3 = quantity[2] - sum3;
                } else if (chosen3 <= 0)
                    System.out.println("ERROR: Invalid requested amount. ");
                else if (chosen3 > remaining3)
                    System.out.println("ERROR: We do not have that many remaining. ");
            }
            if (choice == 4) {
                System.out.println("How many " + item[3] + " would you like: ");
                chosen4 = scan.nextInt();
                if (remaining4 >= chosen4 && chosen4 > 0) {
                    sum4 += chosen4;
                    remaining4 = quantity[3] - sum4;
                } else if (chosen4 <= 0)
                    System.out.println("ERROR: Invalid requested amount. ");
                else if (chosen4 > remaining4)
                    System.out.println("ERROR: We do not have that many remaining. ");
            }
            if (choice > 4 || choice < 0)
                System.out.println("ERROR: Invalid menu option.");
        }
        while (choice != 0);
        double sumtotal = (sum1 * price[0]) + (sum2 * price[1]) + (sum3 * price[2])
                + (sum4 * price[3]);
        if (sumtotal > 0) {
        System.out.println("****** Customer Total ******");
        if(sum1 != 0)
        System.out.println(item[0] + " - " + sum1 + " X " + price[0] + " = " + sum1 * price[0]);
        if(sum2 != 0)
        System.out.println(item[1] + " - " + sum2 + " X " + price[1] + " = " + sum2 * price[1]);
        if(sum3 != 0)
        System.out.println(item[2] + " - " + sum3 + " X " + price[2] + " = " + sum3 * price[2]);
        if(sum4 != 0)
        System.out.println(item[3] + " - " + sum4 + " X " + price[3] + " = " + sum4 * price[3]);
        System.out.println("---------------------------");
            System.out.println("Total due - " + sumtotal);
            double paid;
            double finalmoney;
            do {
                System.out.print("Please specify the amount you would like to pay: ");
                paid = scan.nextDouble();
                finalmoney = (paid - sumtotal);
                System.out.println("\nThe amount you paid is not enough, please try again.\n");
            } while (sumtotal > paid);
            System.out.println(returnedAmounts(finalmoney));
        }
        else
            System.out.println("You did not buy anything. Good day.");
        //if none of the options were chosen when the items were being bought
        //the program will consider this as the ending and will close, not forcing
        //the customer to buy anything else
                    }
    public static String capitalizeString(String text){
        text = text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
        //this method is used in the capitalizeArray method to make the whole job easier
return text;
    }
    public static void capitalizeArray(String[] name){
        for(int i = 0; i < name.length ;i++) {
            name[i] = capitalizeString(name[i]);
        }
        }
}