package com.pluralsight;
import java.util.*;

public class FullNameParser{
    public static void main(String[] args) {
        Scanner kbScanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String fullName =  kbScanner.nextLine().trim(), firstName ="", middleName = "", lastName = "";
        int fName1 = 0, fName2 = 0, mName1 = 0, mName2 = 0, lName1 = 0, whitespaceCounter = 0, lName2 = fullName.length(), temp = 0;

        for (int w = 0; w < fullName.length(); w++){
            if (Character.isWhitespace(fullName.charAt(w))) {
                whitespaceCounter++;
            }
        }
        //Only First Name
        if (whitespaceCounter == 0){
            fName2 = fullName.length();
            firstName = fullName.substring(fName1, fName2);
            middleName = "(none)";
            lastName = "(none)";

            System.out.println("First Name: " + firstName + "\nMiddle Name: " + middleName + "\nLast Name: " + lastName);
        }
        //No Middle Name
        if (whitespaceCounter == 1){
            for(int n = 0; n < fullName.length(); n++){
                if(Character.isWhitespace(fullName.charAt(n))){
                    fName2 = n;
                    lName1 = n + 1;
                }
            }
            firstName = fullName.substring(fName1, fName2);
            middleName = "(none)";
            lastName = fullName.substring(lName1, lName2);

            System.out.println("First Name: " + firstName+ "\nMiddle Name: " + middleName + "\nLast Name: " + lastName);
        }
        //Has Middle Name
        if(whitespaceCounter == 2){
            for(int m = 0; m < fullName.length(); m++){
                if(Character.isWhitespace(fullName.charAt(m)) && temp == 0){
                    fName2 = m;
                    mName1 = m + 1;
                    temp++;
                }
                else if(Character.isWhitespace(fullName.charAt(m)) && temp == 1){
                    mName2 = m;
                    lName1 = m + 1;
                }
            }
            firstName = fullName.substring(fName1, fName2);
            middleName = fullName.substring(mName1, mName1 + 1);
            lastName = fullName.substring(lName1, lName2);

            System.out.println("First Name: " + firstName+ "\nMiddle Name: " + middleName + ".\nLast Name: " + lastName);
        }

    }
}
