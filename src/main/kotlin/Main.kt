fun main (args: Array<String>) {
    if (args.size < 2)
        throw Exception("Needs 2 arguments (mode, topic_name) but got only ${args.size}")

    when (args[0]) {
        "producer" -> runProducer(args[1])
        "consumer" -> runConsumer(args[1])
        else -> throw Exception("Invalid mode ${args[0]} chosen! Valid modes are [producer, consumer].")
    }
}