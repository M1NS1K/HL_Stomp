package com.hacker.hl.project.controller;

import com.hacker.hl.project.db.FcmRequest;
import com.hacker.hl.project.db.entity.Fcm;
import com.hacker.hl.project.repository.FcmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class FcmController {

    private final FcmRepository fcmRepository;

    @PostMapping(path = "/save")
    public Fcm saveFcm(@RequestBody FcmRequest fcmRequest) {
        FcmRequest request = new FcmRequest();

        request.setIp(fcmRequest.getIp());
        request.setSpeed(fcmRequest.getSpeed());

        Fcm fcm1 = request.toEntity();

        log.info("Request : {}", fcm1);

        return fcm1;
    }
}
