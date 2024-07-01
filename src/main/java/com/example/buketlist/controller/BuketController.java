package com.example.buketlist.controller;

import com.example.buketlist.dto.BuketDTO;
import com.example.buketlist.dto.PageRequestDTO;
import com.example.buketlist.dto.PageResponseDTO;
import com.example.buketlist.service.BuketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/buket") // 클래스 매핑
@RequiredArgsConstructor
public class BuketController {
    private final BuketService buketService;

    // 생성 GET
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET register...");
    }

    // 생성 POST
    @PostMapping("/register")
    public String registerPOST(@Valid BuketDTO buketDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST register...");

        // 유효성 검사
        if(bindingResult.hasErrors()) {
            log.info("has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/buket/register";
        }
        log.info(buketDTO);

        buketService.register(buketDTO);
        return "redirect:/buket/list";
    }

    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        PageResponseDTO pageResponseDTO = buketService.getList(pageRequestDTO);
        int totalCount = pageResponseDTO.getTotal(); // 게시물 개수
        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }

        model.addAttribute("responseDTO", pageResponseDTO);
        model.addAttribute("totalCount", totalCount);
    }

    /*
    @GetMapping({"/read", "/modify"})
    public void read(Long tno, Model model) {
        BuketDTO buketDTO = buketService.getOne(tno);
        log.info(buketDTO);

        model.addAttribute("dto", buketDTO);
    }*/

    // 페이징 처리 추가
    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam Long tno, @Valid PageRequestDTO pageRequestDTO, Model model) {
        BuketDTO buketDTO = buketService.getOne(tno);
        PageResponseDTO pageResponseDTO = buketService.getList(pageRequestDTO);
        int totalCount = pageResponseDTO.getTotal(); // 전체 게시물 수

        log.info(buketDTO);

        model.addAttribute("dto", buketDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("totalCount", totalCount);
    }


    @PostMapping("/remove")
    public String remove(Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
        log.info("remove..." + tno);
        buketService.remove(tno);

        return "redirect:/buket/list?" + pageRequestDTO.getLink();
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid BuketDTO buketDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        // 유효성 검사
        if(bindingResult.hasErrors()) {
            log.info("has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", buketDTO.getTno());
            return "redirect:/buket/modify";
        }
        log.info(buketDTO);
        buketService.modify(buketDTO);

        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        return "redirect:/buket/list";
    }
}
