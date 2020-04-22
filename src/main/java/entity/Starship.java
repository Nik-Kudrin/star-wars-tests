package entity;

// TODO: we may use Lombok: generate Getters, Setters and so on

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Range;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Data model for Starship
 */
public class Starship extends EntityBase {

    private String replaceCommaWithEmpty(String source) {
        return source.replace(",", "");
    }

    private boolean isUnknownValue(String value) {
        return value == null || value.isBlank() || value.equals("n/a") || value.equals("unknown");
    }

    private String name;

    public void setName(String value) {
        name = value;
    }

    public String getName() {
        return name;
    }

    private String model;

    public void setModel(String value) {
        model = value;
    }

    public String getModel() {
        return model;
    }

    private String manufacturer;

    public void setManufacturer(String value) {
        manufacturer = value;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    private Optional<BigDecimal> costInCredits;

    @JsonProperty("cost_in_credits")
    public void setCostInCredits(String value) {
        if (isUnknownValue(value))
            costInCredits = Optional.empty();
        else
            costInCredits = Optional.of(new BigDecimal(value));
    }

    @JsonProperty("cost_in_credits")
    public Optional<BigDecimal> getCostInCredits() {
        return costInCredits;
    }

    private Double length;

    public void setLength(String value) {
        length = Double.valueOf(replaceCommaWithEmpty(value));
    }

    public Double getLength() {
        return length;
    }

    private String maxAtmospheringSpeed;

    @JsonProperty("max_atmosphering_speed")
    public void setMaxAtmospheringSpeed(String value) {
        maxAtmospheringSpeed = value;
    }

    @JsonProperty("max_atmosphering_speed")
    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    private Optional<Range<Integer>> crew;

    public void setCrew(String value) {
        if (isUnknownValue(value)) {
            crew = Optional.empty();
            return;
        }

        var splitRange = value.replace(",", "").split("-");
        var startRange = Integer.valueOf(splitRange[0]);
        Optional<Integer> endRange = Optional.empty();

        if (splitRange.length > 1) {
            endRange = Optional.of(Integer.valueOf(splitRange[1]));
        }

        if (endRange.isEmpty())
            crew = Optional.of(Range.singleton(startRange));
        else
            crew = Optional.of(Range.closed(startRange, endRange.get()));
    }

    public Optional<Range<Integer>> getCrew() {
        return crew;
    }

    private Optional<Integer> passengers;

    public void setPassengers(String value) {
        value = replaceCommaWithEmpty(value);

        if (isUnknownValue(value))
            passengers = Optional.empty();
        else
            passengers = Optional.of(Integer.valueOf(value));
    }

    public Optional<Integer> getPassengers() {
        return passengers;
    }

    private Optional<Long> cargoCapacity;

    @JsonProperty("cargo_capacity")
    public void setCargoCapacity(String value) {
        if (isUnknownValue(value))
            cargoCapacity = Optional.empty();
        else
            cargoCapacity = Optional.of(Long.valueOf(value));
    }

    @JsonProperty("cargo_capacity")
    public Optional<Long> getCargoCapacity() {
        return cargoCapacity;
    }

    private Optional<Double> hyperdriveRating;

    @JsonProperty("hyperdrive_rating")
    public void setHyperdriveRating(String value) {
        if (isUnknownValue(value))
            hyperdriveRating = Optional.empty();
        else
            hyperdriveRating = Optional.of(Double.valueOf(value));
    }

    @JsonProperty("hyperdrive_rating")
    public Optional<Double> getHyperdriveRating() {
        return hyperdriveRating;
    }

    private String mglt;

    @JsonProperty("MGLT")
    public void setMglt(String value) {
        mglt = value;
    }

    @JsonProperty("MGLT")
    public String getMglt() {
        return mglt;
    }

    @JsonProperty("starship_class")
    public StarshipClass starshipClass;
}
