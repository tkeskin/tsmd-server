#security
- Gelen istekler önce filtreden geçer.
- jwt varsa ilgili api request gönderilir.
- db bağımlılığı var,postgres için docker-postgres ayağa kaldırılmalı.Aşağıdaki gibi;
- docker run --name tsmd-postgres -e POSTGRES_PASSWORD=MYPASSWD -d -p 5432:5432 postgres