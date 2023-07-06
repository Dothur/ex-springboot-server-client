package com.example.client.client;

import com.example.client.dto.BeerGetDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
//@Primary
public class BeerWebClient implements BeerClient{
    public BeerGetDto getBeer() {
        WebClient webClient = WebClient.builder().build();
        String url = "https://random-data-api.com/api/v2/beers";
        // 어떤 HTTP 메소드로 요청을 보낼지를 get() post() 메소드 등으로 결정
        // 만일 다른 메소드를 쓰고 싶다면 method()
        return webClient.get()   // webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve() // 여기 전까지는 요청을 정의한 부분
                // 이제 부터 정의하는건 응답을 어떻게 처리할 것인지
                .bodyToMono(BeerGetDto.class) // 응답이 한번 돌아올것이며, 그 응답의 body를 String 으로 해석
                .block(); // 동기식으로 처리하겠다.
    }
}
