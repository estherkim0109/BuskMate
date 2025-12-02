package org.example.buskmate.community.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Table(name = "community_posts",
        indexes = {
            @Index(name = "idx_community_post_id", columnList = "community_post_id"),
            @Index(name = "idx_authorUser", columnList = "user_id")
        },
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_postid_userid",
                        columnNames = {"community_post_id", "user_id"}
                )
        }
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CommunityPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "community_post_id", nullable = false, length = 26)
    private String communityPostId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User authorUser;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private DeleteStatus isDeleted;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Version
    @Column(nullable = false)
    private Long version;

    @Builder
    private CommunityPost(
            String communityPostId,
            User authorUser,
            String title,
            String content,
            DeleteStatus isDeleted
    )
    {
        this.authorUser = authorUser;
        this.communityPostId = communityPostId;
        this.title = title;
        this.content = content;
        this.isDeleted = isDeleted;
    }

    // 필요한 메서드만 열어두기
    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void softDelete(){
        this.isDeleted = DeleteStatus.DELETED;
    }
}



// 향 후 삭 제
/*
낙관적lock / 비관적 lock -> version 사용이유
 */