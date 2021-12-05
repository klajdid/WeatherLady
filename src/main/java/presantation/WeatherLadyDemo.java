package presantation;

import bussinessLogic.AvgDatas;
import services.ServiceCall;
import services.Weather2;
import services.Weather3;

import java.util.Scanner;

public class WeatherLadyDemo {
    public static void main(String[] args) throws Exception {

        boolean check=true;
        Scanner scanner=new Scanner(System.in);
        while (check){
            System.out.println("Press 1 to add specific location");
            System.out.println("Press 2 to display added locations");
            System.out.println("Press 3 to download weather values");
            System.out.println("Press 0 to exit");
            int numberOfChoice=scanner.nextInt();
            switch (numberOfChoice){
                case 1:
                    Scanner sc=new Scanner(System.in);
                    String location=sc.nextLine();
                    AvgDatas avgDatas=new AvgDatas();
                    avgDatas.downloadData(location);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    check=false;
                    System.out.println("Exiting now pip pip pip pip pauuu");
                    break;
                default:
                    System.out.println("None of the answers is correct");
            }

        }


        scanner.close();


    }
}
