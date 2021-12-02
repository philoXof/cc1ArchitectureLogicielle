package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CreditCard creditCard = new CreditCard("4929573268781875",new Date(),"lucas jehanno","453");

        //User user = new User("1","lucas","jehanno","ljehanno@myges.fr","pass", creditCard);

        Date date = new Date("2020/01");
        System.out.println(date);

        //System.out.println( user.toString());
    }


}
