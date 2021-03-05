package kafka.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.model.Hotel;
import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class JsonHotelSerializerTest {
    private final String id = "0";
    private final String name = "Test Hotel";
    private final String country = "Test Country";
    private final String city = "Test City";
    private final String address = "Test Address";
    private final Double latitude = 0.0;
    private final Double longitude = 0.0;
    private final String geoHash = "TestGeoHash";

    @Test
    void serialize() throws IOException {
        JsonHotelSerializer ser = new JsonHotelSerializer();
        ObjectMapper om = new ObjectMapper();

        Hotel hotel = new Hotel(id, name, country, city, address, latitude, longitude, geoHash);
        byte[] bytes = ser.serialize("ignored", hotel);

        String hotelString = "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", geoHash='" + geoHash + '\'' +
                '}';

        byte[] hotelSerialized = om.writeValueAsString(hotelString).getBytes();
        assertArrayEquals(hotelSerialized, bytes);

        Hotel nullHotel = new Hotel();
        byte[] nullHotelBytes = ser.serialize("ignored", nullHotel);

        String nullHotelString = "{" +
                "id='" + null + '\'' +
                ", name='" + null + '\'' +
                ", country='" + null + '\'' +
                ", city='" + null + '\'' +
                ", address='" + null + '\'' +
                ", latitude=" + null +
                ", longitude=" + null +
                ", geoHash='" + null + '\'' +
                '}';

        byte[] nullHotelSerialized = om.writeValueAsString(nullHotelString).getBytes();
        assertArrayEquals(nullHotelSerialized, nullHotelBytes);
    }

    @Test
    void demo() {
        Hotel hotel = new Hotel(id, name, country, city, address, latitude, longitude, geoHash);
        System.out.println("Original String:");
        System.out.println(hotel.toString() + "\n");

        JsonHotelSerializer ser = new JsonHotelSerializer();

        byte[] bytes = ser.serialize("ignored", hotel);
        String base64Encoded = DatatypeConverter.printBase64Binary(bytes);
        System.out.println("Encoded Json:");
        System.out.println(base64Encoded + "\n");

        byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64Encoded);
        System.out.println("Decoded Json:");
        System.out.println(new String(base64Decoded));
    }
}