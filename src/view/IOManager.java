package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOManager {

    private Scanner input;

    public IOManager() {
        input = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public short readShort(String message) {
        this.showMessage(message);
        return input.nextShort();
    }

    public int readInt(String message) {
        this.showMessage(message);
        return input.nextInt();
    }

    public byte readByte(String message){
        this.showMessage(message);
        return input.nextByte();
    }

    public void clear(){
        input.next();
    }


    public double readDouble(String message) {
        this.showMessage(message);
        boolean dobleNumber=false;
        double number=0;

        do{
            try{
                number = input.nextDouble();
                dobleNumber=true;
            }catch (InputMismatchException e){
                showMessage("it's has to be a number");
                clear();
            }
        }while (!dobleNumber);

        return number;
    }


    public String readString(String message) {
        this.showMessage(message);
        return input.next();
    }

    public short readMenu() {
        String menuText = "1.Enter employee\n" +
                "2.Print company data\n" +
                "3.Print all employees\n"+
                "4.Print certain employee\n"+
                "5.Sort employee\n"+
                "6.Payroll\n"+
                "7.fired\n"+
                "8.Count employees\n"+
                "9. historic Data\n"+
                "10.exit";
        return readShort(menuText);
    }
}