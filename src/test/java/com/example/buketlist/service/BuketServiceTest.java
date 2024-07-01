package com.example.buketlist.service;

import com.example.buketlist.dto.BuketDTO;
import com.example.buketlist.dto.PageRequestDTO;
import com.example.buketlist.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BuketServiceTest {
    @Autowired
    private BuketService buketService;

    @Test
    public void testRegister() { // 추가
        BuketDTO buketDTO = BuketDTO.builder()
                .title("DTO 테스트")
                .dueDate(LocalDate.now())
                .build();
        buketService.register(buketDTO);
    }

    /*
    @Test
    public void testGetAllTests() { // 목록 조회
        List<BuketDTO> buketDTOS = buketService.getAll();
        log.info(buketDTOS);
    } */

    @Test
    public void testDelete() { // 삭제
        Long bno = 2L;
        buketService.remove(bno);
    }

    @Test
    public void testModify() { // 수정
        BuketDTO buketDTO = BuketDTO.builder()
                .tno(5L)
                .title("타이틀수정")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        buketService.modify(buketDTO);
        log.info(buketDTO);
    }

    @Test
    public void testPaging() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(3).build();
        PageResponseDTO<BuketDTO> pageResponseDTO = buketService.getList(pageRequestDTO);
        log.info(pageResponseDTO);

        for (BuketDTO buketDTO : pageResponseDTO.getDtoList()) {
            log.info(buketDTO);
        }
    }

}