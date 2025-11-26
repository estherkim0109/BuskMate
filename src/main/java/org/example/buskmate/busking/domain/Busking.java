package org.example.buskmate.busking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 버스킹 공연 정보를 나타내는 JPA 엔티티입니다.
 *
 * <p>데이터베이스의 `buskings` 테이블과 매핑되며, 공연의 식별자, 제목,
 * 시작/종료 시간 등의 속성을 가집니다.</p>
 */
@Entity
@Table(name = "buskings")
@Getter
@Setter
@NoArgsConstructor
public class Busking {

    /**
     * 엔티티의 기본 키 (자동 생성).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 외부에서 사용하는 버스킹 고유 식별자.
     *
     * <p>데이터베이스 컬럼명은 `busking_id` 이며 최대 길이는 26입니다.</p>
     */
    @Column(nullable=false, name="busking_id", length=26)
    private String buskingId;

    /**
     * 공연 제목.
     *
     * <p>비어 있을 수 없습니다.</p>
     */
    @Column(nullable = false)
    private String title;

    /**
     * 공연 시작 시각.
     *
     * <p>비어 있을 수 없습니다.</p>
     */
    @Column(nullable = false)
    private LocalDateTime buskingStart;

    /**
     * 공연 종료 시각.
     *
     * <p>종료 시각은 선택적일 수 있습니다(예: 미정인 경우).</p>
     */
    private LocalDateTime buskingEnd;

    /**
     * 버스킹 엔티티 생성자.
     *
     * @param buskingId 외부 고유 식별자
     * @param title 공연 제목
     * @param buskingStart 공연 시작 시각
     * @param buskingEnd 공연 종료 시각 (선택)
     */
    public Busking(
            String buskingId,
            String title,
            LocalDateTime buskingStart,
            LocalDateTime buskingEnd
    ) {
        this.buskingId = buskingId;
        this.title = title;
        this.buskingStart = buskingStart;
        this.buskingEnd = buskingEnd;
    }
}
