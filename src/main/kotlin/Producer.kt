import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata

fun runProducer(topic: String) {
    val producer = KafkaProducer<String, String>(getProducerConfig())


    producer.use {
        while (true) {
            val message = getRandomDnaString()
            val record = ProducerRecord<String, String>(topic, message)
            producer.send(record) { m: RecordMetadata, e: Exception? ->
                when (e) {
                    null -> println("Record was successfully sent (topic=${m.topic()}, partition=${m.partition()}, offset= ${m.offset()})")
                    else -> e.printStackTrace()
                }
            }
        }
    }
}

private fun getRandomDnaString() : String {
    val alphabet = "ACTG"
    return (1..16)
        .map { alphabet.random() }
        .joinToString(separator="")
}
