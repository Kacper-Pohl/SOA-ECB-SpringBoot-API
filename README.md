# SOA-ECB-SpringBoot-Api
#### Aplikacja SpringBoot mająca na celu pobieranie danych z bazy SQLite i publikowanie ich na REST API oraz wyliczanie cen dla różnych walut

### Na chwilę obecną:
Aplikacja Spring Boot umożliwia użytkownikowi korzystanie z api, które pobiera dane z bazy danych umieszczonej w drugim mikroserwisie. Po żądaniu użytkownika aplikacja pobiera dane z bazy i jeśli jest potrzeba to oblicza odpowiednio kurs waluty.

### Jak włączyć:  
1. Uruchomić Kafka Zookeeper  
2. Uruchomić Kafka Server  
3. Uruchomić [drugi mikroserwis](https://github.com/KamilPalubicki/SOA-ECB-SpringBoot-Consumer)  
4. Uruchomić [pierwszy mikroserwis](https://github.com/bchanowski/SOA-ECB-SpringBoot-Producer-With-Kafka)  
5. Uruchomić aplikację  
6. Aby sprawdzić działanie przejść do localhost:8082/currency/rates/WalutaZ/WalutaNa lub  localhost:8082/currency/rates/WalutaZ/WalutaNa/rok/miesiac/dzien
