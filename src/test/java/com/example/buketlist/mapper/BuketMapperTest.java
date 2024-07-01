package com.example.buketlist.mapper;

import com.example.buketlist.domain.BuketVO;
import com.example.buketlist.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BuketMapperTest {
    @Autowired(required = false)
    private BuketMapper buketMapper;

    @Test
    public void testGetTime() {
        log.info(buketMapper.getTime());
    }

    @Test
    public void testInsert() {
        BuketVO buketVO = BuketVO.builder()
                .title("테스트")
                .dueDate(LocalDate.of(2024, 06, 25))
                .build();
        buketMapper.insert(buketVO);
    }

    @Test
    public void testSelectAll() {
        List<BuketVO> voList = buketMapper.selectAll();
        for(BuketVO buketVO : voList) {
            log.info(buketVO);
        }
    }

    @Test
    public void testSelectOne() {
        BuketVO buketVO = buketMapper.selectOne(2L);
        log.info(buketVO);
    }

    @Test
    public void testDelete() {
        Long tno = 1L;
        log.info(buketMapper.selectOne(tno));
        buketMapper.delete(tno);
        log.info(buketMapper.selectOne(tno));
    }

    @Test
    public void testUpdate() {
        Long tno = 3L;
        log.info(buketMapper.selectOne(tno));
        BuketVO buketVO = BuketVO.builder()
                .tno(tno)
                .title("수정")
                .dueDate(LocalDate.parse("2024-06-30"))
                .finished(true)
                .build();
        buketMapper.update(buketVO);
        log.info(buketMapper.selectOne(tno));
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(5).build();
        List<BuketVO> list = buketMapper.selectList(pageRequestDTO);
        for (BuketVO buketVO : list) {
            log.info(buketVO);
        }
    }

    @Test
    public void testGetCount() {
        log.info(buketMapper.getCount(PageRequestDTO.builder().build()));
    }
}