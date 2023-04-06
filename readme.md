                                                  # Horspool Algoritması

## Horspool Algoritmasının Amacı nedir ve Ne İçin Kullanılır?

Horspool Algoritması bir metin içinde belirli deseni aramak için kullanılan bir string aramasıdır. Bu algoritmanın, diğer string arama algoritmalarından farkı daha basit ve hızlı olmasıdır. Ayrıca Horspool algoritması bellek ve işlemci kısıtlamaları olan sistemlerde tercih edilen bir algoritmadır. Özellikle büyük boyutlu metinlerde kullanıldığında oldukça etkili ve hızlı bir çözüm sunar.

## Algoritmanın Çalışma Mantığı

Horspool Algoritması, karakter dizilerinin **ASCII** kodlamasını kullanarak çalışır ve öncelikle desen içinde yer alan karakterlerin sağa doğru kaydırma miktarını oluşturur. Bu kaydırma miktarı, desende yer alan karakterin metindeki sonraki bulunuşuna bağlıdır. Bu sayede, metnin belirli bir bölümünde arama yapılırken, desen içinde yer almayan karakterlerin kaydırılması sağlanır ve bu da arama işlemini hızlandırır. Horspool sadece sağa doğru kaydırma tablosu kullanır.

## Algoritmanın Çalışma Zamanı

Horspool Algoritmasının çalışma zamanı, n metin dosyasının boyutunu ve m desenin uzunluğunu belli eder ve çalışma zamanı buna bağlıdır.

**En iyi durumda**, desen hiçbir karakterle eşleşmediğinde, yani aranan kelime metinde hiç geçmiyorsa, herhangi bir eşleşme arama işlemi yapmaz. Bu durumda çalışma zamanı `O(n)`'olur.

**En kötü durumda**, algoritma, metin dosyasının tüm karakterlerini ve aranan kelimeyi her bir karakterle karşılaştırmak zorunda kalır. Bu durumda çalışma zamanı `O(nm)` olur. Bunun nedeni, her bir karakterin ayrı ayrı karşılaştırılması gerektiğinden, her karakter için lineer bir arama yapılmasıdır.

**Ortalama durumda**, algoritma shift table'ı kullanır ve metin dosyasındaki her karakteri karşılaştırmak zorunda kalmadan aranan kelimeyi bulabilir. Bu durumda sınır `O(n)` ile `O(nm)` arasında değişir. Algoritmanın ortalama durum performansı genellikle iyi kabul edilir, ancak büyük dosyalarda veya çok sık aranan kelimelerde performans sorunları ortaya çıkabilir.

## Uygulama

Horspool algoritması kullanılarak alice_in_wonderland.txt dosyası içindeki _“upon, Dormouse, sigh, jury-box, swim”_ kelimelerinin kaç kez tekrar ettiğini bulduğumuz bir uygulamadır.
Bu uygulamayı pratik bir şekilde çalıştırmak için:

1. İlk olarak horspoolAlgoritması dosyasını indirmeniz gerekmektedir
2. horspoolAlgoritması dosyasını indirdikten sonra alice_wonderland_in.txt dosyasını bilgisayarınıza indirmelisiniz.
3. horspoolAlgoritması dosyasının bilgisayarınızda olan IDE‘lerden biriyle açmanız gerekmektedir.
4. Açılan Kodunuzda String fileName kısmına, alice_in_wonderland.txt dosyasının bilgisayarınızdaki dosya yolunu bulup yazmanız gerekmektedir.
5. Bu işlemleri yaptıktan sonra uygulamayı yapabilirsiniz.
