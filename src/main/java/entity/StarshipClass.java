package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StarshipClass {
    @JsonProperty("corvette")
    CORVETTE,
    @JsonProperty("Star Destroyer")
    STARDESTROYER,
    @JsonProperty("landing craft")
    LANDINGCRAFT,
    @JsonProperty("Deep Space Mobile Battlestation")
    DEEPSPACEMOBILEBATTLESTATION,
    @JsonProperty("Light freighter")
    LIGHTFREIGHTER,
    @JsonProperty("assault starfighter")
    ASSAULT_STARFIGHTER,
    @JsonProperty("Starfighter")
    STARFIGHTER,
    @JsonProperty("Star dreadnought")
    STARDREADNOUT,
    @JsonProperty("Medium transport")
    MEDIUMTRANSPORT,
    @JsonProperty("Patrol craft")
    PATROLCRAFT,
    @JsonProperty("Armed government transport")
    ARMEDGOVERNMENTTRANSPORT,
    @JsonProperty("Escort ship")
    ESCORTSHIP,
    @JsonProperty("Star Cruiser")
    STARCRUISER,
    @JsonProperty("Assault Starfighter")
    ASSAULTSTARFIGHTER,
    @JsonProperty("Space cruiser")
    SPACECRUISER,
    @JsonProperty("Droid control ship")
    DROIDCONTROLSHIP,
    @JsonProperty("yacht")
    YACHT,
    @JsonProperty("Space Transport")
    SPACETRANSPORT,
    @JsonProperty("Diplomatic barge")
    DIPLOMATICBARGE,
    @JsonProperty("freighter")
    FREIGHTER,
    @JsonProperty("assault ship")
    ASSAULTSHIP,
    @JsonProperty("capital ship")
    CAPITALSHIP,
    @JsonProperty("transport")
    TRANSPORT,
    @JsonProperty("star destroyer")
    STAR_DESTROYER,
    @JsonProperty("starfighter")
    STAR_FIGHTER,
    @JsonProperty("cruiser")
    CRUISER
}
