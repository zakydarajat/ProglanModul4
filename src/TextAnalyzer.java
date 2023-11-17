import java.util.Scanner;

public class TextAnalyzer {
    private String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    public int hitungKarakter() {
        if (!isEmpty()) {
            return text.length();
        } else {
            return 0;
        }
    }

    public int hitungKata() {
        if (!isEmpty()) {
            String[] words = text.split("\\s+");
            return words.length;
        } else {
            return 0;
        }
    }

    public int cariKata(String word) {
        if (!isEmpty()) {
            String[] words = text.split("\\s+");
            int count = 0;
            for (String w : words) {
                if (w.equalsIgnoreCase(word)) {
                    count++;
                }
            }
            return count;
        } else {
            return 0;
        }
    }

    private boolean isEmpty() {
        return text == null || text.trim().isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int pilih;

        do {
            System.out.println("\n=== MENU TEKS ANALYZER ===");
            System.out.println("1. Masukkan teks");
            System.out.println("2. Hitung jumlah karakter");
            System.out.println("3. Hitung jumlah kata");
            System.out.println("4. Cari kata dalam teks");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan (1/2/3/4/5): ");
            pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan teks untuk dianalisis: ");
                    scanner.nextLine();
                    input = scanner.nextLine();
                    System.out.println("text telah dimasukkan!!\n");
                    break;
                case 2:
                    TextAnalyzer analyzer1 = new TextAnalyzer(input);
                    int karakter = analyzer1.hitungKarakter();
                    System.out.println("Jumlah karakter: " + karakter);
                    break;
                case 3:
                    TextAnalyzer analyzer2 = new TextAnalyzer(input);
                    int kata = analyzer2.hitungKata();
                    System.out.println("Jumlah kata: " + kata);
                    break;
                case 4:
                    TextAnalyzer analyzer3 = new TextAnalyzer(input);
                    System.out.print("Masukkan kata yang dicari: ");
                    String cari = scanner.next();
                    int ketemu = analyzer3.cariKata(cari);
                    System.out.println("Kata \"" + cari + "\" ditemukan sebanyak: " + ketemu + " kali dalam teks");
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilih != 5);

        scanner.close();
    }
}