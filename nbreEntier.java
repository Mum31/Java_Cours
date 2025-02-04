import java.util.Scanner;

public class nbreEntier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
        System.out.println("Entrez 6 nbre :");
        
        int [] tab ={1,2,3,4,5,6,7};
        double s=0;
        
            for(int value : tab) {
            s += value;

            }
            double moy = s/tab.length;
            System.out.println("Moyenne : "+moy);
    }
}
