
import java.net.URL;
//import java.util.Arrays;

import org.apache.axis.client.Call;
import org.apache.axis.utils.Options;

public class RomanNumClient {

    public static void main(String[] args) throws Exception {
        //The Options class is a container for the
        // inputs on the command line
        Options options = new Options(args);

        //The args are the command line arguements
        args = options.getRemainingArgs();

        //check to see if the right number of args were passed in
        if (args == null) {
            System.err.println("Usage: RomanNumClient -lWebServiceURL RomanNumeral1 ...");
            return;
        }

        //The endpoint is really a URL
        URL endpoint = new URL(options.getURL());

        //The name of the method to call
        //final String METHOD = "fromRomanNumArray";
        final String METHOD = "fromRomanNum";
        
        //JDK 1.5
        //System.out.println("Calling the web service at " + endpoint + "?" + METHOD + "(" + Arrays.toString(args) + ")");
        
        System.out.println("Calling the web service at " + endpoint + "?" + METHOD + "(" + args[0] + ")");
        
        //Build call instance from the WSDL
        Call wsCall = new Call(endpoint + "?wsdl");

        /* ...or build manually

        //The Service object will contain a handle 
        //to the web service
        Service ws = new Service();

        //The Call object will contain a handle to one call
        // to the web service
        Call call = (Call) ws.createCall();
            
        //tell the Call object what endpoint to access
        call.setTargetEndpointAddress(endpoint);

        //tell the Call object what method to call
        call.setOperationName(methodName);

        //Set up the parameter types and the return type
        call.addParameter("RomanNumArgument", XMLType.XSD_STRING, ParameterMode.IN);
        call.setReturnType(XMLType.XSD_INT);
        */
        
        //invoke Web Service ( METHOD, [param1, param2, ...] )
        //our param1 is an array here
        Integer result = (Integer) wsCall.invoke(METHOD, new Object[] { args[0] });
        
        //JDK 1.5
        //System.out.println("The result is : " + Arrays.toString(result));
        
        System.out.println("The result is : " + result);
    }
}
