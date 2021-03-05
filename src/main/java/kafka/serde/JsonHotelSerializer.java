package kafka.serde;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.model.Hotel;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class JsonHotelSerializer implements Serializer<Hotel> {
    private final ObjectMapper om = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String topic, Hotel hotel) {
        byte[] serialized;
        try {
            serialized = om.writeValueAsString(hotel.toString()).getBytes();
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
        return serialized;
    }

    @Override
    public void close() {

    }
}
