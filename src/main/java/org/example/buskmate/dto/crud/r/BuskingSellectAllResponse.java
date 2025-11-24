package org.example.buskmate.dto.crud.r;

public record BuskingSellectAllResponse(
        String buskingId,
        String name
) {
    public static BuskingSellectAllResponse of(
            String buskingId,
            String name
    )
    {
        return new BuskingSellectAllResponse(buskingId, name);
    }
}
