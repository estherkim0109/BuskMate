package org.example.buskmate.dto.crud.r;

public record BuskingSellectOneResponse(
        String buskingId,
        String name
)
{
    public static BuskingSellectOneResponse of(
            String buskingId,
            String name
    )
    {
        return new BuskingSellectOneResponse(buskingId, name);
    }
}
