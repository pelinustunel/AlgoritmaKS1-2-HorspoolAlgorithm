import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // alice_in_wonderland.txt dosyasına erişildiği kısım
        String fileName = "/Users/pelinustunel/Desktop/alice_in_wonderland.txt";
        String[] kelimeler = {"upon", "sigh", "Dormouse", "jury-box", "swim"};

        Scanner scanner = new Scanner(System.in);

        // kullanıcıya birden fazla kelime araması yapabilmesi için while döngüsünün kullanılması
        while (true) {

            System.out.println("Aranabilecek kelimeler: " + Arrays.toString(kelimeler));
            System.out.print("Aranacak kelimeyi girin: ");
            String aranilacakKelime = scanner.nextLine();

            // Aranılan kelimenin, kelimeler dizisinde bulunup bulunmadığının kontrolü
            boolean kelimeBulunuyorMu = false;
            for (String anahtarKelime : kelimeler) {
                if (anahtarKelime.equals(aranilacakKelime)) {
                    kelimeBulunuyorMu = true;
                    break;
                }
            }
            if (!kelimeBulunuyorMu) {
                System.out.println("Hata: Aranılacak kelimeler arasında bulunamadı.");
                continue;
            }

            // Kelimenin kaç kez tekrar ettiğinin ekrana bastırılması
            int count = kelimeyiBul(fileName, aranilacakKelime);
            System.out.println(aranilacakKelime + " kelimesi " + count + " kez tekrar edildi.");


            // Başka kelime aramak istenilmesine göre sorgu kısmı
            System.out.print("Başka bir kelime aramak istiyor musunuz? (E/H): ");
            String secim = scanner.nextLine();
            if (secim.equalsIgnoreCase("h")) {
                scanner.close();
                break;
            }
        }
        scanner.close();

    }


    public static int kelimeyiBul(String dosyaIsmi, String kelime) {
        int count = 0;
        try {
            // BufferedReader nesnesi oluşturulup, metni satır satır okur.
            BufferedReader reader = new BufferedReader(new FileReader(dosyaIsmi));
            int length = kelime.length();  // desenin uzunluğu
            int[] shiftTable = createShiftTable(kelime);

            String satir;
            while ((satir = reader.readLine()) != null) {
                int satirUzunlugu = satir.length();
                int i = length - 1;

                // kelime'in son karakterinden başlayarak belirtilen
                // kelime ile satır arasında eşleşen her karakteri saydığı kısım
                while (i < satirUzunlugu) {
                    int k = 0;
                    while (k < length && kelime.charAt(length - 1 - k) == satir.charAt(i - k)) {
                        k++;
                    }
                    if (k == length) {
                        count++;
                    }
                    i += shiftTable[satir.charAt(i)]; //dosyanın son satırına gelininceğe kadar shifttable güncellenmesi
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();  // Hata yakalama
        }
        return count;
    }

    /* Shift table oluşturulması. Shift table, bir string ifadesinin aranacak bir desende
     bulunamaması durumunda, ne kadar kaydırılacağını belirlemek için kullanılır. Desenin hiçbir
     karakterinin eşleşmediği durumlarda kullanılacak kaydırma mesafesini belirtir ve
     aranan desenin bir kısmının eşleştiği durumlarda,eşleşmenin devam etmesi için
     hangi karakterlerin kaç karakter kaydırılacağını belirler.
     */
    public static int[] createShiftTable(String pattern) {

        int[] shiftTable = new int[256];
        int length = pattern.length();

        for (int i = 0; i < 256; i++) {
            shiftTable[i] = length;
        }

        for (int i = 0; i < length - 1; i++) {
            shiftTable[pattern.charAt(i)] = length - 1 - i;
        }

        return shiftTable;
    }
}

