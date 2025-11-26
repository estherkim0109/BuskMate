package org.example.buskmate.busking.repository;

import org.example.buskmate.busking.domain.Busking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 버스킹 엔티티에 대한 JPA 저장소 인터페이스입니다.
 *
 * <p>기본적인 CRUD는 {@link JpaRepository}를 통해 제공되며,
 * 도메인에 특화된 조회 메서드를 추가로 정의합니다.</p>
 */
@Repository
public interface BuskingRepository extends JpaRepository<Busking, String> {

    /**
     * 현재 진행 중인(또는 현재 시각이 시작과 종료 기간에 포함되는) 모든 버스킹을 조회합니다.
     *
     * <p>쿼리 동작: 데이터베이스에서 buskingStart <= CURRENT_TIMESTAMP
     * 그리고 buskingEnd >= CURRENT_TIMESTAMP 인 레코드를 모두 반환합니다.</p>
     *
     * @return 현재 시점에 유효한 {@link Busking} 엔티티 목록 (빈 리스트 가능)
     */
    @Query("""
        select b
        from Busking b
        where b.buskingStart <= CURRENT_TIMESTAMP
            and b.buskingEnd >= CURRENT_TIMESTAMP
    """)
    List<Busking> findAllBusking();

    /**
     * 지정한 buskingId에 해당하는 단일 버스킹을 조회합니다.
     *
     * <p>쿼리 동작: buskingId로 엔티티를 검색하며, 존재하지 않으면 {@link Optional#empty()}를 반환합니다.</p>
     *
     * @param buskingId 조회할 버스킹의 외부 식별자
     * @return 조회된 {@link Busking} 엔티티를 감싼 {@link Optional}
     */
    @Query("""
        select b
        from Busking b
        where b.buskingId = :buskingId
    """)
    Optional<Busking> findOneBusking(@Param("buskingId") String buskingId);
}
