package org.example.buskmate.busking.dto.crud.d;

public record BuskingDeleteResponse(
        String result
)
{
    public static BuskingDeleteResponse of(
            String result
    )
    {
        return new BuskingDeleteResponse(result);
    }
}
