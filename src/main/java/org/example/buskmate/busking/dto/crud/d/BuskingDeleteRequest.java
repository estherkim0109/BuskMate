package org.example.buskmate.busking.dto.crud.d;

/**
 * 버스킹 공연 삭제 요청 DTO.
 *
 * <p>클라이언트가 특정 버스킹 공연을 삭제할 때 전달하는 데이터를 담습니다.
 *
 * @param buskingId 삭제할 버스킹 공연의 고유 ID
 */
public record BuskingDeleteRequest(
        String buskingId
) { }
