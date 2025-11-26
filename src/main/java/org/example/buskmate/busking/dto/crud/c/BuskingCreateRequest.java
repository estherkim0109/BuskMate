package org.example.buskmate.busking.dto.crud.c;

import java.time.LocalDateTime;

public record BuskingCreateRequest(
        String buskingId,
        String title,
        LocalDateTime buskingStart,
        LocalDateTime buskingEnd
) { }
