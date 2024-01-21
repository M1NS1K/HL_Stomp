package com.hacker.hl.project.db;

import com.hacker.hl.project.db.entity.Fcm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FcmRequest {
    private Double ip;
    private Long speed;

    public Fcm toEntity() {
        return Fcm.builder()
                .ip(this.ip)
                .speed(this.speed)
                .build();
    }
}
