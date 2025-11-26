package org.example.buskmate.busking.service;

import com.github.f4b6a3.ulid.UlidCreator; // ulid 라이브러리
import lombok.RequiredArgsConstructor;
import org.example.buskmate.busking.domain.Busking;
import org.example.buskmate.busking.dto.crud.c.BuskingCreateRequest;
import org.example.buskmate.busking.dto.crud.d.BuskingDeleteRequest;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectAllResponse;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectOneRequest;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectOneResponse;
import org.example.buskmate.busking.dto.crud.u.BuskingEditRequest;
import org.example.buskmate.busking.dto.crud.u.BuskingEditResponse;
import org.example.buskmate.busking.repository.BuskingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 버스킹 관련 비즈니스 로직을 구현하는 서비스 클래스입니다.
 *
 * <p>버스킹 생성, 전체 조회, 단일 조회, 수정, 삭제 기능을 제공합니다.
 * 각 메서드는 필요한 트랜잭션 경계를 가지며 저장소를 통해 엔티티를 관리합니다.</p>
 */
@Service
@RequiredArgsConstructor
public class BuskingServiceImpl implements BuskingService {

    private final BuskingRepository buskingRepo;

    /**
     * 새로운 버스킹을 생성합니다.
     *
     * <p>동작: ULID를 생성하여 {@link Busking} 엔티티를 구성하고 저장소에 저장합니다.</p>
     *
     * @param req 생성에 필요한 데이터가 담긴 {@link BuskingCreateRequest}
     * @throws IllegalArgumentException 구현상 파라미터 검증을 추가할 경우 발생할 수 있음
     */
    @Transactional
    public void buskingCreate(BuskingCreateRequest req) {
        String ulid = UlidCreator.getUlid().toString();
        Busking busking = new Busking(
                ulid,
                req.title(),
                req.buskingStart(),
                req.buskingEnd()
        );
        buskingRepo.save(busking);
    }

    /**
     * 등록된 모든 버스킹 정보를 조회합니다.
     *
     * <p>동작: 저장소에서 모든 버스킹 정보를 조회하여 {@link BuskingSelectAllResponse} 리스트로 변환하여 반환합니다.</p>
     *
     * @return 모든 버스킹 정보를 담은 {@link List} of {@link BuskingSelectAllResponse}
     */
    @Transactional(readOnly = true)
    public List<BuskingSelectAllResponse> buskingSelectAll() {
        return buskingRepo.findAllBusking()
                .stream()
                .map(BuskingSelectAllResponse :: of)
                .toList();
    }

    /**
     * 단일 버스킹 정보를 조회합니다.
     *
     * <p>동작: 요청한 buskingId로 저장소에서 엔티티를 조회하여 {@link BuskingSelectOneResponse}로 변환하여 반환합니다.</p>
     *
     * @param req 조회 조건을 담은 {@link BuskingSelectOneRequest} (예: buskingId)
     * @return 조회된 버스킹 정보를 담은 {@link BuskingSelectOneResponse}
     * @throws IllegalArgumentException 지정한 버스킹을 찾을 수 없을 때 발생
     */
    @Transactional(readOnly = true)
    public BuskingSelectOneResponse buskingSelectOne(BuskingSelectOneRequest req) {
        return buskingRepo.findOneBusking(req.buskingId())
                .map(BuskingSelectOneResponse :: of)
                .orElseThrow(() -> new IllegalArgumentException("해당 버스킹 없음"));
    }

    /**
     * 기존 버스킹 정보를 수정합니다.
     *
     * <p>동작: 요청된 buskingId로 엔티티를 조회한 뒤, 제목 및 시간 정보를 갱신합니다. 수정된 엔티티를 기반으로 {@link BuskingEditResponse}를 반환합니다.</p>
     *
     * @param req 수정할 데이터를 담은 {@link BuskingEditRequest} (수정 대상 buskingId 포함)
     * @return 수정 결과를 담은 {@link BuskingEditResponse}
     * @throws IllegalArgumentException 지정한 버스킹을 찾을 수 없을 때 발생
     */
    @Transactional
    public BuskingEditResponse buskingEdit(BuskingEditRequest req) {
        Busking busking = buskingRepo.findOneBusking(req.buskingId())
                .orElseThrow(() -> new IllegalArgumentException("해당 버스킹 없음"));
        busking.setTitle(req.title());
        busking.setBuskingStart(req.buskingStart());
        busking.setBuskingEnd(req.buskingEnd());
        return BuskingEditResponse.of(busking);
    }

    /**
     * 기존 버스킹을 삭제합니다.
     *
     * <p>동작: 요청된 buskingId로 엔티티를 조회한 뒤 삭제합니다.</p>
     *
     * @param req 삭제할 버스킹 식별 정보를 담은 {@link BuskingDeleteRequest}
     * @throws IllegalArgumentException 지정한 버스킹을 찾을 수 없을 때 발생
     */
    @Transactional
    public void buskingDelete(BuskingDeleteRequest req) {
        Busking busking = buskingRepo.findOneBusking(req.buskingId())
                .orElseThrow(() -> new IllegalArgumentException("해당 버스킹 없음"));
        buskingRepo.delete(busking);
    }
}
