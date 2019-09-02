import romannumerals.InvalidRomanNumeralException;
import romannumerals.RomanNumeral;

import org.apache.axis.AxisFault;

/**
 * @author DK
 */
public class RomanNumService {

    public int fromRomanNum(String romanNum) throws InvalidRomanNumeralException {
        return new RomanNumeral(romanNum).getValue();
    }

    public int fromRomanNumWithFault(String romanNum) throws AxisFault {
        try {
            return new RomanNumeral(romanNum).getValue();
        } catch (InvalidRomanNumeralException e) {
            throw new AxisFault("soapenv:Client.InvalidArgument",
                                e.getMessage() + " in " + romanNum,
                                null,
                                null);
        } 
    }
    
    public int[] fromRomanNumArray(String[] romanNumArray) throws AxisFault {
        int[] result = new int[romanNumArray.length];
        for (int i = 0; i < romanNumArray.length; i++) {
            result[i] = fromRomanNumWithFault(romanNumArray[i]);
        }
        return result;
    }
}
