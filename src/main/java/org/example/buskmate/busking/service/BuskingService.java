package org.example.buskmate.busking.service;

import org.example.buskmate.busking.dto.crud.c.BuskingCreateRequest;
import org.example.buskmate.busking.dto.crud.d.BuskingDeleteRequest;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectAllResponse;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectOneRequest;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectOneResponse;
import org.example.buskmate.busking.dto.crud.u.BuskingEditRequest;
import org.example.buskmate.busking.dto.crud.u.BuskingEditResponse;

import java.util.List;

/**
 * 버스킹 공연 관련 비즈니스 로직을 정의하는 서비스 인터페이스.
 *
 * <p>버스킹 공연 생성, 조회, 수정, 삭제 기능을 제공합니다.
 */
public interface BuskingService {

    /**
     * 새로운 버스킹 공연을 생성합니다.
     *
     * @param req 버스킹 공연 생성 요청 DTO
     * @throws IllegalArgumentException 요청 데이터가 유효하지 않은 경우
     */
    void buskingCreate(BuskingCreateRequest req);

    /**
     * 모든 버스킹 공연 정보를 조회합니다.
     *
     * @return 전체 버스킹 공연 조회 응답 리스트
     */
    List<BuskingSelectAllResponse> buskingSelectAll();

    /**
     * 특정 버스킹 공연 정보를 조회합니다.
     *
     * @param req 조회할 버스킹 공연 정보 요청 DTO
     * @return 단일 버스킹 공연 조회 응답 DTO
     * @throws IllegalArgumentException 요청한 공연이 존재하지 않을 경우
     */
    BuskingSelectOneResponse buskingSelectOne(BuskingSelectOneRequest req);

    /**
     * 기존 버스킹 공연 정보를 수정합니다.
     *
     * @param req 버스킹 공연 수정 요청 DTO
     * @return 수정된 버스킹 공연 정보 응답 DTO
     * @throws IllegalArgumentException 요청 데이터가 유효하지 않거나, 수정 대상 공연이 존재하지 않을 경우
     */
    BuskingEditResponse buskingEdit(BuskingEditRequest req);

    /**
     * 특정 버스킹 공연을 삭제합니다.
     *
     * @param req 삭제할 버스킹 공연 요청 DTO
     * @throws IllegalArgumentException 삭제 대상 공연이 존재하지 않을 경우
     */
    void buskingDelete(BuskingDeleteRequest req);
}
