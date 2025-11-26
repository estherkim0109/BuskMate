package org.example.buskmate.busking.dto.crud.r;

import org.example.buskmate.busking.domain.Busking;

import java.time.LocalDateTime;

public record BuskingSelectAllResponse(
        String buskingId,
        String title,
        LocalDateTime buskingStart,
        LocalDateTime buskingEnd
) {
    public static BuskingSelectAllResponse of(Busking b)
    {
        return new BuskingSelectAllResponse(
                b.getBuskingId(),
                b.getTitle(),
                b.getBuskingStart(),
                b.getBuskingEnd()
        );
    }
}
