package tasks.level.one.main;

import tasks.level.one.service.SimplifyString;

public class Main {


    public static void main(String args[]) {

        String sourceString = "e  ee c ce  ci ck c the ee  eeee tyytt teext a an";
        String resultString;

        SimplifyString simplifyString = new SimplifyString();
        resultString = simplifyString.simplifyString(sourceString);


        System.out.println(sourceString + " ->" + resultString);

    }
}
