package org.example.buskmate.dto.crud.c;

public record BuskingCreateResponse(
        String buskingId,
        String name
)
{
    public static BuskingCreateResponse of(
            String buskingId,
            String name
    )
    {
        return new BuskingCreateResponse(buskingId, name);
    }
}
