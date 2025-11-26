package org.example.buskmate.recruit.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class CreateRecruitPostResponseDto {
    private String postId;
    private String bandId;
    private String title;
}
