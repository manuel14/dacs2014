/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import java.math.BigDecimal;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "validarTarjeta")
public class validarTarjeta {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "validar")
     public boolean isValidCardNumber(@WebParam String nroTarjeta){

        try {
            nroTarjeta = nroTarjeta.replaceAll("\\D", "");
            char[]      nroTarjetaArry    = nroTarjeta.toCharArray();

            int         checkSum        = 0;
            for(int i = nroTarjetaArry.length - 1; i >= 0; i--){

                char            ccDigit     = nroTarjetaArry[i];

                if((nroTarjetaArry.length - i) % 2 == 0){
                    int doubleddDigit = Character.getNumericValue(ccDigit) * 2;
                    checkSum    += (doubleddDigit % 9 == 0 && doubleddDigit != 0) ? 9 : doubleddDigit % 9;

                }else{
                    checkSum    += Character.getNumericValue(ccDigit);
                }

            }

            return (checkSum != 0 && checkSum % 10 == 0);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
}
