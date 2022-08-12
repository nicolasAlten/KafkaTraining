import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.consumer.KafkaConsumer

fun runConsumer(topic: String) {
    val consumer = KafkaConsumer<String, String>(getConsumerConfig())

    consumer.use {
        consumer.subscribe(listOf(topic))
        while(true) {
            consumer
                .poll(java.time.Duration.ofSeconds(1000))
                .forEach { record : ConsumerRecord<String, String> ->
                    println(
                        "Received record with key ${record.key()} " +
                                "and value ${record.value()} from topic ${record.topic()} and partition ${record.partition()}"
                    )
                }
        }
    }
}