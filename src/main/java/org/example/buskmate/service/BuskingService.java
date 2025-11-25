package org.example.buskmate.service;

import org.example.buskmate.dto.crud.c.BuskingCreateRequest;
import org.example.buskmate.dto.crud.c.BuskingCreateResponse;
import org.example.buskmate.dto.crud.d.BuskingDeleteRequest;
import org.example.buskmate.dto.crud.d.BuskingDeleteResponse;
import org.example.buskmate.dto.crud.r.BuskingSelectAllRequest;
import org.example.buskmate.dto.crud.r.BuskingSelectAllResponse;
import org.example.buskmate.dto.crud.r.BuskingSelectOneRequest;
import org.example.buskmate.dto.crud.r.BuskingSelectOneResponse;
import org.example.buskmate.dto.crud.u.BuskingEditRequest;
import org.example.buskmate.dto.crud.u.BuskingEditResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BuskingService {
    // 1. 생성
    void buskingCreate(BuskingCreateRequest req);
    // 2. 조회
    List<BuskingSelectAllResponse> buskingSelectAll();
    BuskingSelectOneResponse buskingSelectOne(BuskingSelectOneRequest req);
    // 3. 수정
    BuskingEditResponse buskingEdit(BuskingEditRequest req);
    // 4. 삭제
    BuskingDeleteResponse buskingDelete(BuskingDeleteRequest req);
}
