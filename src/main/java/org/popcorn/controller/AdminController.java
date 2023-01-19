package org.popcorn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;

import org.popcorn.domain.CatVO;
import org.popcorn.domain.GoodsVO;
import org.popcorn.service.AdminService;
import org.popcorn.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

import static sun.awt.shell.Win32ShellFolderManager2.checkFile;


@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping ("/admin/*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final AdminService service ;
    private final String uploadPath = "C:\\pop";

    @GetMapping("/index")
    public void getIndex() throws Exception {
        logger.info("index..........");

    }

    //등록
    @GetMapping("/register")
    public void getGoodsRegister(Model model) throws Exception {
            logger.info("register............");

        }

    @PostMapping ("/register")
    public String POSTGoodsRegister(
            GoodsVO GoodsVO, @RequestParam(name = "attachFile", required = false) MultipartFile file,
            HttpServletRequest request, RedirectAttributes rttr) throws Exception {
        logger.info("write post ...........");
        logger.info(GoodsVO.toString());

        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId");

        if (!file.getOriginalFilename().equals("") && checkFile(file))
        {
            GoodsVO.setGdsImage(uploadFile(file.getOriginalFilename(), file.getBytes()));
        } else {
            GoodsVO.setGdsImage("");
        }

        if(userId!=null) {
            GoodsVO.setUserId(userId);
        }else {
            GoodsVO.setUserId("userId1");
        }
        AdminService.register(GoodsVO);

        rttr.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/admin/index";
    }

//
    private boolean checkFile(MultipartFile m) {
        if(m.getOriginalFilename()==null||m.getOriginalFilename()=="") {
            return false;
        }else {
            if (m.getOriginalFilename().substring(m.getOriginalFilename().length() - 3).toUpperCase().equals("JPG")
                    || m.getOriginalFilename().substring(m.getOriginalFilename().length() - 3).toUpperCase().equals("JPEG")
                    || m.getOriginalFilename().substring(m.getOriginalFilename().length() - 3).toUpperCase().equals("GIF")
                    || m.getOriginalFilename().substring(m.getOriginalFilename().length() - 3).toUpperCase().equals("PNG"))
                return true;
            return false;
        }

    }

    private String uploadFile(String originalName, byte[] fileData) throws Exception {

        UUID uid = UUID.randomUUID();

        String savedName = uid.toString() + "_" + originalName;

        File target = new File(uploadPath, savedName);

        FileCopyUtils.copy(fileData, target);

        return savedName;

    }

    //



    }







