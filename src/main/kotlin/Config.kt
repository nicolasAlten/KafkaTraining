import io.streamthoughts.kafka.clients.consumer.KafkaConsumerConfigs
import io.streamthoughts.kafka.clients.consumer.consumerConfigsOf
import io.streamthoughts.kafka.clients.producer.KafkaProducerConfigs
import io.streamthoughts.kafka.clients.producer.producerConfigsOf
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer

internal fun getConsumerConfig() : KafkaConsumerConfigs {
    val brokerAddress = "localhost:9092"
    val consumerGroupId = "demo-consumer-group"

    return consumerConfigsOf()
        .client { bootstrapServers(brokerAddress) }
        .groupId(consumerGroupId)
        .keyDeserializer(StringDeserializer::class.java.name)
        .valueDeserializer(StringDeserializer::class.java.name)
}

internal fun getProducerConfig() : KafkaProducerConfigs {
    val brokerAddress = "localhost:9092"

    return producerConfigsOf()
        .client { bootstrapServers(brokerAddress) }
        .keySerializer(StringSerializer::class.java.name)
        .valueSerializer(StringSerializer::class.java.name)
}