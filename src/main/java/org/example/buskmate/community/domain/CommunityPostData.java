package org.example.buskmate.community.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Table(name = "community_post_data")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CommunityPostData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_post_id", nullable = false)
    private CommunityPost communityPost;

    @Column(nullable = true)
    private String mediaType;

    @Column(nullable = true)
    private String url;

    @Column(nullable = true)
    private Integer sortOrder;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Builder
    private CommunityPostData(
            CommunityPost communityPost,
            String mediaType,
            String url,
            Integer sortOrder
    )
    {
        this.communityPost = communityPost;
        this.mediaType = mediaType;
        this.url = url;
        this.sortOrder = sortOrder;
    }
}
