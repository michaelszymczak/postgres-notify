# Usage

```
./gradlew clean shadowJar
docker build -t postgresnotify-demo .
docker run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres:9.6.1
docker run -it --rm --name postgres-notifydemo-app --link my-postgres:postgres postgresnotify-demo
```


Expected output:

```
Demo!
Got notification: mymessage
Got notification: mymessage
Got notification: mymessage
^C
```


Resources:
https://www.youtube.com/watch?v=mCG-AtwMMtM
https://github.com/confluentinc/bottledwater-pg/
