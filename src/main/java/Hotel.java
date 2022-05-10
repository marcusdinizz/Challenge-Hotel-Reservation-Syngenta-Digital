import java.util.List;
import java.util.Scanner;

public class Hotel {

    private String name;
    private int classif; 
    private Double[] weekPrice; //Preço em dia de semana, com posição 0 do array para clientes regulares e 1 para do programa de fidelidade
    private Double[] weekendPrice; //Preço em final de semana, com posição 0 do array para clientes regulares e 1 para do programa de fidelidade

  
    
    
    //Métodos contrutores
    public Hotel(String name, int classif, Double[] weekPrice, Double[] weekendPrice){
        this.name = name;
        this.classif = classif; 
        this.weekPrice = weekPrice;
        this.weekendPrice = weekendPrice;
    }
    public Hotel(){
    }

    //Métodos get e set para os atributos da classe
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getClassif(){
        return this.classif;
    }
    public void setClassif(int classif){

        this.classif = classif;
    }
    public Double[] getWeekPrice(){
        return this.weekPrice;
    }
    public void setWeekPrice(Double[] weekPrice){
        this.weekPrice = weekPrice;
    }
    public Double[] getWeekendPrice(){
        return this.weekendPrice;
    }
    public void setWeekendPrice(Double[] weekendPrice){
        this.weekendPrice = weekendPrice;
    }

    //Método que calcula o preço da estadia
    public double getPrice(String type, List<String> days){
        //inicialização das variaveis
        int fare = 0;
        double price = 0.0;

        //confere o tipo de tarifa do hotel
        if(type.equals("Rewards")){
            fare = 1;
        }
        //itera sobre a lista de dias e calcula o valor da estadia
        for(String day : days){
            switch(dayofWeek(day)){
                case 0: //o método chamado retorna 0 caso seja dia de semana
                    price = price + weekPrice[fare];
                    break;
                case 1: // e 1 caso seja final de semana
                    price = price + weekendPrice[fare];
                    break;
                default: System.out.println("Data em formato incorreto"); //caso default para caso não seja encontrado o dia
            }
        }
        return price;
    }

    //Método para verificar o dia da semana
    //Não foi implementada em uma classe externa por se tratar do um método simples
    private static int dayofWeek(String input){
        //usa da biblioteca scan para filtrar a data e separar o dia da semana
        Scanner scan = new Scanner(input.substring(0,input.length()-1)).useDelimiter(".*\\(");
        String day = scan.next(); //recebe o dia da semana
        int answ;

        scan.close();
        //Switch Case para verificar o dia da semana, caso seja dia de semana define resposta como 0
        //caso seja final de semana, como 1 e 2 caso o formato esteja diferente.
        switch(day){
            case "mon":
                answ = 0;
                break;
            case "tues":
                answ = 0;
                break;
            case "wed":
                answ = 0;
                break;
            case "thur":
                answ = 0;
                break;
            case "fri":
                answ = 0;
                break;
            case "sat":
                answ = 1;
                break;
            case "sun":
                answ = 1;
                break;
            default: answ = 2;
        }
        return answ;    
       



    }
        
}
