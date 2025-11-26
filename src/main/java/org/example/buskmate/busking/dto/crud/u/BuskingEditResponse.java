package org.example.buskmate.busking.dto.crud.u;

import org.example.buskmate.busking.domain.Busking;

import java.time.LocalDateTime;

/**
 * 버스킹 공연 수정 응답 DTO.
 *
 * <p>클라이언트가 버스킹 공연 수정 요청을 보낸 후, 수정된 공연 정보를 반환하는 데이터를 담습니다.
 *
 * @param title 수정된 공연 제목
 * @param buskingStart 수정된 공연 시작 시각
 * @param buskingEnd 수정된 공연 종료 시각
 */
public record BuskingEditResponse(
        String title,
        LocalDateTime buskingStart,
        LocalDateTime buskingEnd
) {

    /**
     * {@link Busking} 엔터티를 기반으로 {@link BuskingEditResponse} 객체를 생성합니다.
     *
     * <p>정적 팩토리 메서드로, 엔터티의 데이터를 DTO로 변환하는 역할을 수행합니다.
     *
     * @param b 변환할 {@link Busking} 엔터티
     * @return 새로운 {@link BuskingEditResponse} 객체
     */
    public static BuskingEditResponse of(Busking b) {
        return new BuskingEditResponse(
                b.getTitle(),
                b.getBuskingStart(),
                b.getBuskingEnd()
        );
    }
}
