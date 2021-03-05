package kafka.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Objects;

@JsonRootName("hotel")
public class Hotel implements Serializable {
    private String id;
    private String name;
    private String country;
    private String city;
    private String address;
    private Double latitude;
    private Double longitude;
    private String geoHash;

    public Hotel() {
        this.id = null;
        this.name= null;
        this.country = null;
        this.city = null;
        this.address = null;
        this.latitude = null;
        this.longitude = null;
        this.geoHash = null;
    }

    @JsonCreator
    public Hotel(@JsonProperty("Id") String id, @JsonProperty("Name") String name,
                 @JsonProperty("Country") String country, @JsonProperty("City") String city,
                 @JsonProperty("Address") String address, @JsonProperty("Latitude") Double latitude,
                 @JsonProperty("Longitude") Double longitude, @JsonProperty("GeoHash") String geoHash) {
        this.id = id;
        this.name= name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.geoHash = geoHash;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", geoHash='" + geoHash + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Hotel hotel = (Hotel) obj;
        return Objects.equals(id, hotel.id) && Objects.equals(name, hotel.name) &&
                Objects.equals(country, hotel.country) && Objects.equals(city, hotel.city) &&
                Objects.equals(address, hotel.address) && Objects.equals(latitude, hotel.latitude) &&
                Objects.equals(longitude, hotel.longitude) && Objects.equals(geoHash, hotel.geoHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, city, address, latitude, longitude, geoHash);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getGeoHash() {
        return geoHash;
    }

    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash;
    }
}
