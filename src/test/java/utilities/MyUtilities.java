package utilities;

import java.util.concurrent.ThreadLocalRandom;

public class MyUtilities {
    public static String monthName() {
        String[] month;
        month = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int randInd = ThreadLocalRandom.current().nextInt(0, 12);
        return (month[randInd]);
    }
}