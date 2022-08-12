# Kafka Producer/Consumer Example in Kotlin

A small example to accompany the presentation I gave for my colleagues.

## Usage
Start the Kafka broker by running it in docker containers (requires Docker, obviously) by running the following from the root folder:
```
docker-compose up
```

Then, build the application:

On Unix, type:
```
./gradlew jar
```

On Windows, use:
```
gradlew.bat jar
```

Then open two new terminals and start the application: Once as a producer, once as a consumer:
``` 
java -jar build/libs/kafka_example-1.0-SNAPSHOT.jar producer mytopic
java -jar build/libs/kafka_example-1.0-SNAPSHOT.jar consumer mytopic 
```

You should now see that messages are being written and being read constantly until you shut off the producer.
