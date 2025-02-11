import java.util.Scanner;

public class caractere {
    public static void main (String[] arg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter une chaine de character");
        String chaine = sc.nextLine();
        System.out.println("le nombre de caractere est : "+chaine.length());

        String[] mots = chaine.split("\\s+"); // Utiliser un espace comme délimiteur
        System.out.println("Le nombre de mots est : " + mots.length);
        sc.close();
    }
}
