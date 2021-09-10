/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcont.include;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author esteban
 */
public class comonFunc {
 	
    
    
    public comonFunc(){
        
        
    }
    
	public static Boolean validaRut ( String rut ) {
		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rut);
		if ( matcher.matches() == false ) 
			return false;
		String[] stringRut = rut.split("-");
		return stringRut[1].toLowerCase().equals(comonFunc.dv(stringRut[0]));
		
	}
	public static String dv ( String rut ) {
		Integer M=0,S=1,T=Integer.parseInt(rut);
		for (;T!=0;T=(int) Math.floor(T/=10))
			S=(S+T%10*(9-M++%6))%11;
		return ( S > 0 ) ? String.valueOf(S-1) : "k";		
	}
	




public String nombreDTE(String tipodte){
    switch(tipodte){
        case "33":
                  return "FACTURA ELECTRONICA";
        
    }
    
    
    return "";
}




}
