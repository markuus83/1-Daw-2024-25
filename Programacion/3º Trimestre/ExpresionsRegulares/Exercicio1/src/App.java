import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Dia> datasCorrectas = new ArrayList<>();

        String[] datas = {
            "2024-06-15",       
            "15/06/2024",       
            "6/15/2024",       
            "15-06-2024",       
            "2024.06.15",
            "15/6/2015",        
            "15.06.24",         
            "15 Xuño 2024",     
            "Xuño 15, 2024",    
            "2024/06/15",
            "1/1/2000",     
            "15 de Xuño de 2024",
            "31/04/99", 
        };

        for (String data : datas) {

            try {
                Dia dia = new Dia(data);
                datasCorrectas.add(dia);

            } catch (ExcepcionDataInvalida e) {
                System.out.println("Erro: " + e.getMessage());
            } catch(Exception e){
                System.out.println("Erro: " + e);
            }
        }

        System.out.println("\nDatas correctas:");
        for (Dia dias : datasCorrectas) {
            System.out.println(dias);
        }
    }
}