# SOA-ECB-SpringBoot-Api
#### Aplikacja SpringBoot mająca na celu pobieranie danych z bazy SQLite i publikowanie ich na REST API oraz wyliczanie cen dla różnych walut

### Na chwilę obecną:  
Aplikacja Spring Boot pobiera dane z bazy danych, publikuje je i odpowiednio oblicza cenę

### Jak włączyć:  
Uruchomić Kafka Zookeeper  
Uruchomić Kafka Server  
Uruchomić [drugi mikroserwis](https://github.com/KamilPalubicki/SOA-ECB-SpringBoot-Consumer)  
Uruchomić [pierwszy mikroserwis](https://github.com/bchanowski/SOA-ECB-SpringBoot-Producer-With-Kafka)  
Uruchomić aplikację  
Aby sprawdzić działanie przejść do localhost:8083/api/currency/rates/WalutaZ/WalutaNa  

Do zrobienia  
Dodanie pokazywania danych dla danej daty  