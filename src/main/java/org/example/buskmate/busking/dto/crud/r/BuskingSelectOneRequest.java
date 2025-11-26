package org.example.buskmate.busking.dto.crud.r;

/**
 * 특정 버스킹 공연 조회 요청 DTO.
 *
 * <p>클라이언트가 단일 버스킹 공연 정보를 조회할 때 사용됩니다.
 *
 * @param buskingId 조회할 버스킹 공연의 고유 ID
 */
public record BuskingSelectOneRequest(
        String buskingId
) { }
