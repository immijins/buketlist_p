package com.example.buketlist.service;

import com.example.buketlist.domain.BuketVO;
import com.example.buketlist.dto.BuketDTO;
import com.example.buketlist.dto.PageRequestDTO;
import com.example.buketlist.dto.PageResponseDTO;
import com.example.buketlist.mapper.BuketMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BuketServiceImpl implements BuketService {
    private final BuketMapper buketMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(BuketDTO buketDTO) {
        log.info(buketDTO);
        BuketVO buketVO = modelMapper.map(buketDTO, BuketVO.class);
        log.info(buketVO);
        buketMapper.insert(buketVO);
    }

    @Override
    public PageResponseDTO<BuketDTO> getList(PageRequestDTO pageRequestDTO) {
        List<BuketVO> voList = buketMapper.selectList(pageRequestDTO);
        List<BuketDTO> dtoList = new ArrayList<>();
        for (BuketVO buketVO : voList) {
            dtoList.add(modelMapper.map(buketVO, BuketDTO.class));
        }
        int total = buketMapper.getCount(pageRequestDTO);

        PageResponseDTO<BuketDTO> pageResponseDTO = PageResponseDTO.<BuketDTO>widthAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }

    /*
    @Override
    public List<BuketDTO> getAll() {
        List<BuketVO> voList = buketMapper.selectAll();
        List<BuketDTO> dtoList = new ArrayList<>();
        for(BuketVO buketVO : voList) {
            BuketDTO buketDTO = modelMapper.map(buketVO, BuketDTO.class);
            dtoList.add(buketDTO);
        }
        return dtoList;
    }*/

    @Override
    public BuketDTO getOne(Long tno) {
        BuketVO buketVO = buketMapper.selectOne(tno);
        BuketDTO buketDTO = modelMapper.map(buketVO, BuketDTO.class);

        return buketDTO;
    }

    @Override
    public void remove(Long tno) {
        buketMapper.delete(tno);
    }

    @Override
    public void modify(BuketDTO buketDTO) {
        log.info("modify...");
        BuketVO buketVO = modelMapper.map(buketDTO, BuketVO.class);
        log.info(buketVO);
        buketMapper.update(buketVO);
    }
}
