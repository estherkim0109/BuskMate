package org.example.buskmate.busking.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.example.buskmate.busking.dto.crud.c.BuskingCreateRequest;
import org.example.buskmate.busking.dto.crud.d.BuskingDeleteRequest;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectAllResponse;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectOneRequest;
import org.example.buskmate.busking.dto.crud.r.BuskingSelectOneResponse;
import org.example.buskmate.busking.dto.crud.u.BuskingEditRequest;
import org.example.buskmate.busking.dto.crud.u.BuskingEditResponse;
import org.example.buskmate.busking.service.BuskingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 버스킹 공연 관리를 위한 REST 컨트롤러입니다.
 *
 * <p>버스킹 생성, 전체 조회, 단일 조회, 수정, 삭제 엔드포인트를 제공합니다.
 * 각 엔드포인트는 서비스 레이어를 호출하여 실제 비즈니스 로직을 수행합니다.</p>
 */
@RestController
@RequestMapping("/api/buskings")
@RequiredArgsConstructor
public class BuskingController {

    /**
     * 버스킹 관련 비즈니스 로직을 담당하는 서비스입니다.
     */
    private final BuskingService buskingService;

    /**
     * 새로운 버스킹 공연을 생성합니다.
     *
     * @param req 생성에 필요한 정보를 담은 {@link BuskingCreateRequest} 객체
     * @return 생성 성공 시 HTTP 201 상태를 반환합니다 (본문 없음)
     */
    @PostMapping("/create")
    @Operation(
            summary = "버스킹 생성",
            description = "새로운 버스킹 공연을 생성합니다."
    )
    @ApiResponse(
            responseCode = "201",
            description = "버스킹 공연이 성공적으로 생성되었습니다.",
            content = @Content (
                    mediaType = "application/json",
                    schema = @Schema(implementation = Void.class)
            )
    )
    public ResponseEntity<Void> buskingCreate(@RequestBody BuskingCreateRequest req) {
        buskingService.buskingCreate(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 등록된 모든 버스킹 공연 정보를 조회합니다.
     *
     * @return 모든 버스킹 정보를 담은 {@link BuskingSelectAllResponse} 목록과 HTTP 200 상태를 반환합니다.
     */
    @Operation(
            summary = "전체 버스킹 조회",
            description = "등록 된 모든 버스킹 정보 반환"
    )
    @ApiResponse(
            responseCode = "200",
            description = "모든 버스킹 정보 반환 성공",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = BuskingSelectAllResponse.class)
            )
    )
    @GetMapping("/showall")
    public ResponseEntity<List<BuskingSelectAllResponse>> buskingSelectAll(){
        List<BuskingSelectAllResponse> responseList = buskingService.buskingSelectAll();
        return ResponseEntity.ok(responseList);
    }

    /**
     * 특정 조건에 맞는 단일 버스킹 공연 정보를 조회합니다.
     *
     * @param req 조회 조건을 담은 {@link BuskingSelectOneRequest} 객체 (예: id 등)
     * @return 조회된 버스킹 정보를 담은 {@link BuskingSelectOneResponse} 와 HTTP 200 상태를 반환합니다.
     */
    @GetMapping("/showone")
    @Operation(
            summary = "단일 버스킹 선택",
            description = "단일 버스킹 정보 반환"
    )
    @ApiResponse(
            responseCode = "200",
            description = "단일 정보 반환 성공",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = BuskingSelectOneResponse.class)
            )
    )
    public ResponseEntity<BuskingSelectOneResponse> buskingSelectOne(@ModelAttribute BuskingSelectOneRequest req){
        BuskingSelectOneResponse response = buskingService.buskingSelectOne(req);
        return ResponseEntity.ok(response);
    }

    /**
     * 기존 버스킹 공연 정보를 수정합니다.
     *
     * @param req 수정할 필드를 포함한 {@link BuskingEditRequest} 객체
     * @return 수정 결과를 담은 {@link BuskingEditResponse} 와 HTTP 200 상태를 반환합니다.
     */
    @PatchMapping("/edit")
    @Operation(
            summary = "버스킹 수정",
            description = "기존 버스킹 공연 정보를 수정합니다."
    )
    @ApiResponse(
            responseCode = "200",
            description = "버스킹 공연 정보가 성공적으로 수정되었습니다.",
            content = @Content (
                    mediaType = "application/json",
                    schema = @Schema(implementation = BuskingEditResponse.class)
            )
    )
    public ResponseEntity<BuskingEditResponse> buskingEdit(@RequestBody BuskingEditRequest req){
        BuskingEditResponse response = buskingService.buskingEdit(req);
        return ResponseEntity.ok(response);
    }

    /**
     * 기존 버스킹 공연 정보를 삭제합니다.
     *
     * @param req 삭제할 버스킹 식별 정보를 포함한 {@link BuskingDeleteRequest} 객체
     * @return 삭제 성공 시 HTTP 204 (No Content)를 반환합니다.
     */
    @DeleteMapping("/delete")
    @Operation(
            summary = "버스킹 삭제",
            description = "기존 버스킹 공연 정보를 삭제합니다."
    )
    @ApiResponse(
            responseCode = "204",
            description = "버스킹 공연 정보가 성공적으로 삭제되었습니다.",
            content = @Content (
                    mediaType = "application/json",
                    schema = @Schema(implementation = Void.class)
            )
    )
    public ResponseEntity<Void> buskingDelete(@RequestBody BuskingDeleteRequest req){
        buskingService.buskingDelete(req);
        return ResponseEntity.noContent().build();
    }
}
