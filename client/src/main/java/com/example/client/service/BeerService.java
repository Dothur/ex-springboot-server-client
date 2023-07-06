package com.example.client.service;

import com.example.client.client.BeerClient;
import com.example.client.client.BeerRestClient;
import com.example.client.client.BeerWebClient;
import com.example.client.dto.BeerGetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerService {
    // Service 는 맥주정보를 어떻게 가져왔는지 중요 X
    private final BeerClient client;

    public BeerService(@Qualifier("beerWebClient") BeerClient client) {
        this.client = client;
    }

    public void drinkBeer() {
        log.info("Order Beer");
        // TODO API 를 활용해 맥주 정보 받아오기
        // 핵심은 맥주 정보
        // 맥주 정보를 받아오는 방법은 비즈니스 로직에서 벗어났다 할 수 있지 않을까?
        BeerGetDto result = client.getBeer();
        log.info("{} 맛있다.", result.getName());
    }

    //    private final BeerRestClient client;
//
//    public BeerService(BeerRestClient client) {
//        this.client = client;
//    }
//
//    public void drinkBeer() {
//        log.info("Order Beer");
//        // TODO API 를 활용해 맥주 정보 받아오기
//        // 핵심은 맥주 정보
//        // 맥주 정보를 받아오는 방법은 비즈니스 로직에서 벗어났다 할 수 있지 않을까?
//        BeerGetDto result = client.getBeer();
//        log.info("{} 맛있다.", result.getName());
//    }
//    private final BeerWebClient client;
//
//    public BeerService(BeerWebClient client) {
//        this.client = client;
//    }
//
//    public void drinkBeer() {
//        log.info("Order Beer");
//        // TODO API 를 활용해 맥주 정보 받아오기
//        // 핵심은 맥주 정보
//        // 맥주 정보를 받아오는 방법은 비즈니스 로직에서 벗어났다 할 수 있지 않을까?
//        BeerGetDto result = client.getBeer();
//        log.info("{} 맛있다.", result.getName());
//    }
}
