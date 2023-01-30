package org.popcorn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.popcorn.domain.GoodsVO;
import org.popcorn.domain.OrderListVO;
import org.popcorn.domain.OrderVO;
import org.popcorn.service.AdminService;
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
        service.register(GoodsVO);

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

    @GetMapping("/list")
    public void getGoodsList(Model model) throws Exception {
        logger.info("get member list");
        //	logger.info(cri.toString());

        List<GoodsVO> list = service.goodsList();

        //	model.addAttribute("list", adminMemberService.listSearchCriteria(cri));
        model.addAttribute("list", list);


    }
    @GetMapping("/view")
    public void getGoodsView(@RequestParam("n") int gdsId, Model model) throws Exception {
        logger.info("get goods view");

        GoodsVO goods = service.goodsView(gdsId);
        model.addAttribute("goods", goods);
    }


    @GetMapping("/modify")
    public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception {
        // @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장

        logger.info("modify.......");
    }

    @PostMapping("/modify")
    public String modifyPOST(
            GoodsVO GoodsVO,@RequestParam(name = "attachFile", required = false) MultipartFile file,
            RedirectAttributes rttr) throws Exception {
        logger.info("mod post............");
        if (!file.getOriginalFilename().equals("") && checkFile(file)){
            GoodsVO.gdsImage(uploadFile(file.getOriginalFilename(), file.getBytes()));
        } else {
            GoodsVO.gdsImage("");
        }
         service.goodsModify(GoodsVO);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/admin/view?gdsId=" + GoodsVO.getGdsId();
    }

    @PostMapping("/delete")
    public String postGoodsDelete(@RequestParam("n") int gdsId) throws Exception {
        // @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장

        logger.info("post goods delete");
        service.goodsDelete(gdsId);
        return "redirect:/admin/index";
    }

    // 주문 목록
    @GetMapping("/orderList")
    public void getOrderList(Model model) throws Exception {
        logger.info("get order list");

        List<OrderVO> orderList = service.orderList();

        model.addAttribute("orderList", orderList);
    }

    // 주문 상세 목록
    @GetMapping("/orderView")
    public void getOrderList(@RequestParam("n") String orderId,
                             OrderVO order, Model model) throws Exception {
        logger.info("get order view");

        order.setOrderId(orderId);
        List<OrderListVO> orderView = service.orderView(order);

        model.addAttribute("orderView", orderView);
    }


}







