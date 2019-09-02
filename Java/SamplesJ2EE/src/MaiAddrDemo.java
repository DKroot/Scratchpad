import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


/**
 * MaiAddrDemo is an implementation of something
 *
 * @author      Full Name/Company
 * @version     [version]
 */
public class MaiAddrDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String addr;
        while(true) {
            try {
                System.out.print("Enter the address: ");
                InternetAddress a = new InternetAddress(br.readLine());
                System.out.println("The address is valid: [" +
                        a.getPersonal() + " at " + a.getAddress() + "]");
            } catch (Exception e) {
                System.out.println("The address is NOT valid");
                e.printStackTrace();
            }
        }
    }
}
