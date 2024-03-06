package org.dni;

public class Dni {
    private String dni;
    private static final TablaAsignacion tabla = new TablaAsignacion();

    public Dni(){
        this.dni = "";
    }
    public Dni(String dni){
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "DNI{" +
                "dni='" + dni + '\'' +
                '}';
    }

    public boolean isDniNumero(String DniNum){

        for (char digit : DniNum.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }
    public char extraerParteAlfabeticaDni(){
        return dni.charAt(dni.length()-1);
    }
    public String extraerParteNumericaDni(){
        return dni.substring(0,dni.length()-1);
    }
    public char obtenerLetra(){
        return tabla.calcularLetra(extraerParteNumericaDni());
    }
    private boolean checkLongitudNumDni(){
        return extraerParteNumericaDni().length() == 8;
    }
    public boolean checkNumeroDni(){
        String partNumDni = extraerParteNumericaDni();
        return  checkLongitudNumDni() && isDniNumero(partNumDni);
    }
    public boolean checkLetra(){
        return extraerParteAlfabeticaDni() == obtenerLetra();
    }
    public boolean checkDni(){
        return checkNumeroDni() && checkLetra();
    }

}
