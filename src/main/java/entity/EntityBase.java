package entity;

import java.net.URL;
import java.time.ZonedDateTime;

/**
 * Base entity for Star Wars API entities
 */
public class EntityBase {
    private ZonedDateTime created;

    public void setCreated(String value) {
        created = ZonedDateTime.parse(value);
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    private ZonedDateTime edited;

    public void setEdited(String value) {
        edited = ZonedDateTime.parse(value);
    }

    public ZonedDateTime getEdited() {
        return edited;
    }

    public URL url;
}
