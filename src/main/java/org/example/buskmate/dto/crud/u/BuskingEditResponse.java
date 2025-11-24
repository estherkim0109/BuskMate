package org.example.buskmate.dto.crud.u;

public record BuskingEditResponse(
        String buskingId,
        String name
)
{
    public static BuskingEditResponse of(
            String buskingId,
            String name
    )
    {
        return new BuskingEditResponse(buskingId, name);
    }
}
