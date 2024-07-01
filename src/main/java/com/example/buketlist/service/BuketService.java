package com.example.buketlist.service;

import com.example.buketlist.dto.BuketDTO;
import com.example.buketlist.dto.PageRequestDTO;
import com.example.buketlist.dto.PageResponseDTO;

import java.util.List;

public interface BuketService {
    void register(BuketDTO buketDTO); // 추가
    // List<BuketDTO> getAll(); // 목록 조회 - 페이징 작업 이전
    PageResponseDTO<BuketDTO> getList(PageRequestDTO pageRequestDTO);
    BuketDTO getOne(Long tno); // 개별 조회
    void remove(Long tno); // 삭제
    void modify(BuketDTO buketDTO); // 수정
}
