package com.example.buketlist.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuketVO {
    private Long tno; // 순번
    private String title; // 항목
    private LocalDate dueDate; // 입력날짜
    private boolean finished; // 완료 여부
}
