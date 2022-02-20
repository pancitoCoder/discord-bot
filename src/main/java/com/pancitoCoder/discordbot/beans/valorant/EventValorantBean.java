package com.pancitoCoder.discordbot.beans.valorant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EventValorantBean implements Serializable {
    private String uuid;
    private String displayName;
    private String shortDisplayName;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private String assetPath;
}
