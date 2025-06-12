# QuizCraft

QuizCraft, Swing kullanılarak oluşturulmuş grafik kullanıcı arayüzüne (GUI) sahip basit bir Java tabanlı quiz uygulamasıdır. Kullanıcıların çoktan seçmeli soruları yanıtlamasına olanak tanır ve sonunda bir puan sağlar.

## Özellikler
- Çoktan seçmeli sorular
- Modern görünüm ve his ile grafik kullanıcı arayüzü
- Basit ve sezgisel tasarım
- Sorular Open Trivia Database API'sinden dinamik olarak çekilir

## Kurulum Talimatları
1. **Depoyu klonlayın:**
   ```bash
   git clone <repository-url>
   ```
2. **Proje dizinine gidin:**
   ```bash
   cd quizcraft
   ```
3. **Java dosyalarını derleyin:**
   ```bash
   javac -d out src/app/Main.java src/wiew/QuizGUI.java src/model/*.java src/controller/*.java src/utils/*.java src/data/*.java
   ```
4. **Uygulamayı çalıştırın:**
   ```bash
   java -cp out app.Main
   ```

## Kullanım
- Uygulamayı çalıştırarak quizi başlatın.
- Soruları yanıtlamak için uygun seçeneği seçin ve "Sonraki" butonuna tıklayın.
- Quiz sonunda puanınız gösterilecektir.

## Lisans
Bu proje MIT Lisansı altında lisanslanmıştır - detaylar için LICENSE dosyasına bakın. 