public class test {
    public static void main(String[] args) {
        String texte = "Bonjour, comment ça va?";
        String[] mots = texte.split(" "); // Séparer par espace

        for (String mot : mots) {
            System.out.println(mot);
        }
    }
}