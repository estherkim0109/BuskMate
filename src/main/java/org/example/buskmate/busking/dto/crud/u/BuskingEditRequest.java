package org.example.buskmate.busking.dto.crud.u;

import java.time.LocalDateTime;

/**
 * 버스킹 공연 수정 요청 DTO.
 *
 * <p>클라이언트가 기존 버스킹 공연 정보를 수정할 때 전달하는 데이터를 담습니다.
 *
 * @param buskingId 수정할 버스킹 공연의 고유 ID
 * @param title 수정할 공연 제목
 * @param buskingStart 수정할 공연 시작 시각
 * @param buskingEnd 수정할 공연 종료 시각
 */
public record BuskingEditRequest(
        String buskingId,
        String title,
        LocalDateTime buskingStart,
        LocalDateTime buskingEnd
) { }
