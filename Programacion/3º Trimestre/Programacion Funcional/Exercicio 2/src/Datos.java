import java.time.LocalDate;

public record Datos(LocalDate data, Integer position, String song, String artist, Integer duration_ms) {

    public LocalDate getData() {
        return data;
    }

    public Integer getPosition() {
        return position;
    }

    public String getSong() {
        return song;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getDuration_ms() {
        return duration_ms;
    }
    
}
