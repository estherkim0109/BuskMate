package org.example.buskmate.busking.dto.crud.c;

import java.time.LocalDateTime;

/**
 * 새로운 버스킹 공연 생성 요청 DTO.
 *
 * <p>클라이언트로부터 버스킹 공연 정보를 전달받기 위해 사용합니다.
 *
 * @param buskingId 버스킹 공연 고유 ID
 * @param title 공연 제목
 * @param buskingStart 공연 시작 시각
 * @param buskingEnd 공연 종료 시각
 */
public record BuskingCreateRequest(
        String buskingId,
        String title,
        LocalDateTime buskingStart,
        LocalDateTime buskingEnd
) { }
