package com.example.buketlist.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuketDTO {
    private Long tno; // 순번

    @NotEmpty
    private String title; // 항목

    private LocalDate dueDate; // 입력날짜

    private boolean finished; // 완료여부
}
