import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Classe que gerencia as reservas da rede de hoteis
public class HotelReservation {
    
    //Lista de Hoteis possíveis de serem reservados
    private List<Hotel> hotels;


    //Método construtor para inicialização dos dados de teste
    //Em uma aplicação real a inicialização e acesso seria em um banco de dados
    public HotelReservation(){
        hotels = new ArrayList<Hotel>();
        String[] names = {"Lakewood","Bridgewood","Ridgewood"};
        Double[][] prices = {{110.0,80.0},{90.0,80.0},{160.0,110.0},{60.0,50.0},{220.0,100.0},{150.0,40.0}};
        int[] classif = {3,4,5};
        Hotel hotelInit = new Hotel();
        for(int i=0, j=0;i<names.length;i++,j=j+2){
            hotelInit = new Hotel(names[i],classif[i],prices[j],prices[j+1]); // construtor classe Hotel
            hotels.add(hotelInit);
        }             
    }
    

   
    public String getCheapestHotel (String input){
        //Parsing do input, separa em String da tarifa(participante ou nao do programa de fidelidade)
        // e lista com as datas
        String[] splittedText = input.split(":\\s");
        String type = splittedText[0];
        List<String> days = Arrays.asList(splittedText[1].split(",\\s"));
        //inicializa variaveis auxiliare para a comparação de preço 
        double price = Double.MAX_VALUE;
        String name = new String();
        Hotel hotel2 = new Hotel();

        for(Hotel hotel : hotels){

            if(hotel.getPrice(type, days) < price){ //confere o menor
                price = hotel.getPrice(type, days); 
                name = hotel.getName();                
                hotel2 = hotel; //adiciona-o em uma variavel auxiliar em caso de empate
            }
            //lida com o empate
            else if(hotel.getPrice(type, days) == price){
                    if(hotel.getClassif() > hotel2.getClassif() ){ //compara a classificação do hotel
                        price = hotel.getPrice(type, days);
                        name = hotel.getName();
                    }
            }
        }

        return name;
    }
}
