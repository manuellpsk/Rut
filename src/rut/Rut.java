package rut;
import javax.swing.*;
public	class Rut {
    public static void main(String[] args) {
        
        String rut;
        rut=JOptionPane.showInputDialog("Ingrese RUT");
        if(Valrut(rut)) JOptionPane.showMessageDialog(null,"Rut Valido","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
        else    JOptionPane.showMessageDialog(null,"Rut Invalido","Confirmacion",JOptionPane.ERROR_MESSAGE);
    }//main
    
    static boolean Valrut(String rut){
        
        int separador=rut.indexOf('-');
        int nrut[]=new int[separador];
        int resnrut[]=new int[separador];
        // valida si el rut es numerico
        if (Valnrut(rut.substring(0,separador))){
            //transforma de caracter a numero
            for(int i=0;i<separador;i++){
            nrut[i]=rut.charAt(i)-48;
            }
        }
        else return false;
        
        //inicio del algoritmo modulo 11/multiplica y suma
        int mult=2,suma=0;
        for(int i=separador-1;i>=0;i--){
            resnrut[i]=nrut[i]*mult;
            if(mult<7)mult++;
            else mult=2;
            suma=suma+resnrut[i];
         }
        //hallar modulo y digito verificador        
        int nv,mod;
        mod=suma%11;
        nv=11-mod;
        
        String rnv;
        if((nv!=10)&&(nv!=11)){
            rnv=Integer.toString(nv);
        }
        else{
            if(nv==10)  {rnv="k";}
               else {rnv="0";} 
        }
        //comparando el digito verificador obtenido a partir del rut, con el que dio el usuario
        return rnv.equalsIgnoreCase(rut.substring(separador+1));
    }//funcion valrut
    
    static boolean Valnrut(String x){
        return x.matches("[0-9]*");
    }//funcion valnrut
    
}//public class