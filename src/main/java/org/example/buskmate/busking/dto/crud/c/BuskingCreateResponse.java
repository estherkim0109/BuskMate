package org.example.buskmate.busking.dto.crud.c;

import java.time.LocalDateTime;

/**
 * 버스킹 공연 생성 응답 DTO.
 *
 * <p>새로운 버스킹 공연이 생성된 후, 클라이언트에 반환되는 정보를 담습니다.
 *
 * @param buskingId 생성된 버스킹 공연의 고유 ID
 * @param title 생성된 공연 제목
 * @param buskingStart 공연 시작 시각
 * @param buskingEnd 공연 종료 시각
 */
public record BuskingCreateResponse(
        String buskingId,
        String title,
        LocalDateTime buskingStart,
        LocalDateTime buskingEnd
) {

    /**
     * 주어진 정보를 바탕으로 {@link BuskingCreateResponse} 객체를 생성합니다.
     *
     * <p>정적 팩토리 메서드로, 생성자 호출을 감싸서 코드 가독성을 높입니다.
     *
     * @param buskingId 생성된 버스킹 공연의 고유 ID
     * @param title 생성된 공연 제목
     * @param buskingStart 공연 시작 시각
     * @param buskingEnd 공연 종료 시각
     * @return 새로운 {@link BuskingCreateResponse} 객체
     */
    public static BuskingCreateResponse of(
            String buskingId,
            String title,
            LocalDateTime buskingStart,
            LocalDateTime buskingEnd
    ) {
        return new BuskingCreateResponse(
                buskingId,
                title,
                buskingStart,
                buskingEnd
        );
    }
}
