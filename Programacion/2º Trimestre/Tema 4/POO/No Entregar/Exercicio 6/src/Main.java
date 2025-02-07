public class Main {
    public static void main(String[] args) throws Exception {
        
        Portatil portatil1 = new Portatil("iMac", "176234A", Cor.Verde);
        System.out.println("\n" + portatil1.getModelo() + ", " + portatil1.getNumSerie() + ", " + portatil1.getCorPortatil());

        portatil1.setCorPortatil(Cor.Negro);

        System.out.println("\n" + portatil1.getModelo() + ", " + portatil1.getNumSerie() + ", " + portatil1.getCorPortatil());
    }
}