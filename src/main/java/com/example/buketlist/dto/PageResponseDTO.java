package com.example.buketlist.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Getter
@ToString
@Log4j2
public class PageResponseDTO<E> {
    // DTO의 목록, 전체 데이터 수, 시작 페이지번호 / 끝 페이지 번호

    @Builder(builderMethodName = "widthAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        log.info(pageRequestDTO);
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int) (Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9;

        int last = (int)(Math.ceil((total/(double)size)));
        this.end = end > last ? last : end;

        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
    private int page; // 현재 페이지
    private int size; // 표시할 개수
    private int total; // 전체 게시물 숫자
    private int start; // 시작 페이지 번호
    private int end; // 끝 페이지 번호
    private boolean prev; // 이전 페이지의 존재 여부
    private boolean next; // 다음 페이지의 존재 여부
    private List<E> dtoList;
}
