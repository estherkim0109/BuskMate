package org.example.buskmate.dto.crud.d;

public record BuskingDeleteResponse(
        String buskingId,
        String name
)
{
    public static BuskingDeleteResponse of(
            String buskingId,
            String name
    )
    {
        return new BuskingDeleteResponse(buskingId, name);
    }
}
