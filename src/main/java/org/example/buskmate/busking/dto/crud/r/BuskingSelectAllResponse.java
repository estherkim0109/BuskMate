package org.example.buskmate.busking.dto.crud.r;

import org.example.buskmate.busking.domain.Busking;

import java.time.LocalDateTime;

/**
 * 모든 버스킹 공연 조회 응답 DTO.
 *
 * <p>클라이언트가 모든 버스킹 공연 정보를 조회할 때 반환되는 데이터를 담습니다.
 *
 * @param buskingId 버스킹 공연 고유 ID
 * @param title 공연 제목
 * @param buskingStart 공연 시작 시각
 * @param buskingEnd 공연 종료 시각
 */
public record BuskingSelectAllResponse(
        String buskingId,
        String title,
        LocalDateTime buskingStart,
        LocalDateTime buskingEnd
) {

    /**
     * {@link Busking} 엔터티를 기반으로 {@link BuskingSelectAllResponse} 객체를 생성합니다.
     *
     * <p>정적 팩토리 메서드로, 엔터티의 데이터를 DTO로 변환하는 역할을 수행합니다.
     *
     * @param b 변환할 {@link Busking} 엔터티
     * @return 새로운 {@link BuskingSelectAllResponse} 객체
     */
    public static BuskingSelectAllResponse of(Busking b) {
        return new BuskingSelectAllResponse(
                b.getBuskingId(),
                b.getTitle(),
                b.getBuskingStart(),
                b.getBuskingEnd()
        );
    }
}
