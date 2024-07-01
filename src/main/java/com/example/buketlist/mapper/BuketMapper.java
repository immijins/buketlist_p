package com.example.buketlist.mapper;

import com.example.buketlist.domain.BuketVO;
import com.example.buketlist.dto.PageRequestDTO;

import java.util.List;

public interface BuketMapper { // 추상 메서드 작업
    String getTime(); // 테스트
    void insert(BuketVO buketVO); // 추가
    List<BuketVO> selectAll(); // 목록 조회
    BuketVO selectOne(Long tno); // 개별 조회
    void delete(Long tno); // 삭제
    void update(BuketVO buketVO); // 수정
    List<BuketVO> selectList(PageRequestDTO pageRequestDTO); // 페이징
    int getCount(PageRequestDTO pageRequestDTO); // 페이지 번호
}
