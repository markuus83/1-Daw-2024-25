public abstract class Componhente extends Produto {
    
    public Componhente(String marca, String modelo, double prezo){
        super(marca, modelo, prezo);
    }

    /**
     * Convierte bytes a gigabytes
     * @param bytes -> bytes a convertir
     * @return -> double con el valor en gigabytes
     */
    public static double bytesToGigabytes(long bytes){
        return (double) bytes / 1073741824;
    }

    /**
     * Convierte gigabytes a bytes
     * 
     * @param gigaBytes -> gigabytes a convertir
     * @return -> long con el valor en bytes
     */
    public static long gigaBytesToBytes(double gigaBytes){
        return (long) (gigaBytes * 1073741824);
    }

    /**
     * Convierte megabytes a bytes
     * 
     * @param hz -> megabytes a convertir
     * @return -> long con el valor en bytes
     */
    public static double hzToMhz(long hz){
        return (double) hz / 1000000;
    }

    /**
     * Convierte megabytes a bytes
     * 
     * @param ghz -> megabytes a convertir
     * @return -> long con el valor en bytes
     */
    public static long gigaHzToHz(double ghz){
        return (long) (ghz * 1000000000);
    }

}
