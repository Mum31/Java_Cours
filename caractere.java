import java.util.Scanner;

public class caractere {
    public static void main (String[] arg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter une chaine de character");
        String chaine = sc.nextLine();
        System.out.println("le nombre de caractere est : "+chaine.length());
        sc.close();
    }
}
