package com.pancitoCoder.discordbot.beans.valorant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class ResponseEventBean implements Serializable {
    private int status;
    private List<EventValorantBean> data;
}
