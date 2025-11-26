package org.example.buskmate.busking.dto.crud.u;

import java.time.LocalDateTime;

public record BuskingEditRequest(
        String buskingId,
        String title,
        LocalDateTime buskingStart,
        LocalDateTime buskingEnd
)
{ }
