import java.util.Scanner;

public class Average {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);

        System.out.print("Enter three number:");

        double num1=input.nextDouble();
        double num2=input.nextDouble();
        double num3=input.nextDouble();

        double average=(num1+num2+num3)/3;

        System.out.println("The average of these three number is:"+average);

    }

}
