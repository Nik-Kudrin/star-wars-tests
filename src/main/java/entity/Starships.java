package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

public class Starships extends PagedEntityBase {
    @JsonProperty("results")
    @JsonDeserialize(using = StarshipsDeserializer.class)
    public ArrayList<Starship> items = new ArrayList<>();
}

class StarshipsDeserializer extends ItemsDeserializer<Starship> {
    public StarshipsDeserializer() {
        super(Starship.class);
    }
}

