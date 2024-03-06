package org.dni;
import com.google.common.primitives.Chars;
public class TablaAsignacion {
    private char[] letras;

    public TablaAsignacion() {
        letras = new char[]{'T', 'R', 'W', 'A', 'G', 'M',
                            'Y', 'F', 'P', 'D', 'X', 'B',
                            'N', 'J', 'Z', 'S', 'Q', 'V',
                            'H', 'L', 'C', 'K', 'E'};
    }

    public char getLetra(int index) throws ArrayIndexOutOfBoundsException {
       try {
           return letras[index];
       }catch (ArrayIndexOutOfBoundsException excep){
           throw new ArrayIndexOutOfBoundsException(
                   "Posicion introducida fuera de los límites de la tabla");
       }
    }

    public boolean letraPermitida(char letra){
        return Chars.contains(letras, letra);
    }

   public char calcularLetra(String parteNumericaDni){
       int dni = Integer.parseInt(parteNumericaDni);
       int posicion = dni % 23;
       return getLetra(posicion);
   }

}
