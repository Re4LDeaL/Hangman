import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static public void raden(String woord, int leven){

        char[] blanko = new char[woord.length()]; //Voor blanko deel
        int i = 0;
        while (i<woord.length()){
            blanko[i]='-';
            if(woord.charAt(i) == ' '){
                blanko[i]=' ';
            }
            i++;
        }
        System.out.println("Hallo! Je moet het woord raden! Om het te doen, moet je alleen een letter intoetsen.");
        System.out.print("Typ in [play] als je wilt spelen of [stop] als je wilt stoppen");

        Scanner commando = new Scanner(System.in);
        String lolo;
        while(true){
            lolo = commando.nextLine();
            if((lolo.equalsIgnoreCase("play")) ||
                    lolo.equalsIgnoreCase("stop"));
            break;
        }

        if(lolo.equalsIgnoreCase("play")){
            System.out.print(blanko);
            System.out.println("        Aantal levens=" + leven);
        }
        else{
            System.out.println("Okee, doei!");
        }

        Scanner s = new Scanner(System.in); //Scanner om letters te lezen

        ArrayList<Character> l=new ArrayList<Character>();

        while (leven>0){
            char x=s.next().charAt(0);

            if(l.contains(x)){
                System.out.println("Is al geweest, probeer een andere letter!");
                continue; //Doorgaat
            }

            l.add(x);

            if (woord.contains(x+"")){
                for (int y=0;y<woord.length();y++){ //loop voor index
                    if(woord.charAt(y) == x){  //de letter en die "-" zou vervangen
                        blanko[y]=x;  //de letter
                    }
                }
            }
            else{
                leven--;
            }
            if(woord.equals(String.valueOf(blanko))){ //Het checkt of de blanko deel is gelijk aan woord
                System.out.println(blanko);
                System.out.println("Jij hebt gewonnen!");
                break;
            }

            System.out.print(blanko);
            System.out.println("     Aantal levens=" + leven);
        }
        if(leven == 0){
            System.out.println("Jij hebt verloren!");
        }
    }

    public static void main(String[] args) {
       String woord = "wasmachine";
       int leven = 5;
       raden(woord,leven);
    }
}
