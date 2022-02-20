package com.pancitoCoder.discordbot.services.api;

import com.pancitoCoder.discordbot.beans.valorant.EventValorantBean;
import com.pancitoCoder.discordbot.beans.valorant.ResponseEventBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ValorantApiService extends ApiService {

    @Value("${valorant.url}")
    private String url;

    public List<EventValorantBean> getEvents() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url + "/events")
                .queryParam("language", "{language}")
                .encode()
                .toUriString();

        Map<String, String> params = new HashMap<>();
        params.put("language", "es-ES");

        ResponseEntity<ResponseEventBean> response
                = this.restTemplate.exchange(urlTemplate,
                HttpMethod.GET,
                entity,
                ResponseEventBean.class,
                params);
        ResponseEventBean body = response.getBody();
        if (Objects.isNull(body)) {
            return null;
        }
        return body.getData();
    }

}
