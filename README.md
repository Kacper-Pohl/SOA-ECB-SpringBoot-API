# SOA-ECB-SpringBoot-Api
#### Aplikacja SpringBoot mająca na celu pobieranie danych z bazy SQLite i publikowanie ich na REST API oraz wyliczanie cen dla różnych walut

### Na chwilę obecną:
Aplikacja Spring Boot przy uruchomieniu pobiera dane na 90 dni wstecz z XML'a ECB oraz ma schedule pobierania daily danych od poniedziałku do piątku(poza świętami) o godz. 16:10(dane pojawiają się na ECB około 16), następnie wysyłe je do kafki

### Jak włączyć:  
1. Uruchomić Kafka Zookeeper  
2. Uruchomić Kafka Server  
3. Uruchomić [drugi mikroserwis](https://github.com/KamilPalubicki/SOA-ECB-SpringBoot-Consumer)  
4. Uruchomić [pierwszy mikroserwis](https://github.com/bchanowski/SOA-ECB-SpringBoot-Producer-With-Kafka)  
5. Uruchomić aplikację  
6. Aby sprawdzić działanie przejść do localhost:8083/api/currency/rates/WalutaZ/WalutaNa lub  localhost:8083/api/currency/rates/rok/miesiac/dzien/WalutaZ/WalutaNa
