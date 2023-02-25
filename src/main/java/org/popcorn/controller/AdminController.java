package org.popcorn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.popcorn.util.MediaUtils;
import org.popcorn.domain.GoodsVO;
import org.popcorn.domain.OrderListVO;
import org.popcorn.domain.OrderVO;
import org.popcorn.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
        logger.info("register post ...........");
        logger.info(GoodsVO.toString());

/*
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("userId"); */

        if (!file.getOriginalFilename().equals("") && checkFile(file))
        {
            GoodsVO.setGdsImage(uploadFile(file.getOriginalFilename(), file.getBytes()));
        } else {
            GoodsVO.setGdsImage("");
        }
/*
        if(userId!=null) {
            GoodsVO.setUserId(userId);
        }else {
            GoodsVO.setUserId("userId1");
        }*/

        service.register(GoodsVO);

        rttr.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/admin/index";
    }



    @ResponseBody
    @GetMapping("/displayFile")
    public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        logger.info("FILE NAME: " + fileName);

        try {

            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

            MediaType mType = MediaUtils.getMediaType(formatName);

            HttpHeaders headers = new HttpHeaders();

            in = new FileInputStream(uploadPath + "/" + fileName);

            if (mType != null) {
                headers.setContentType(mType);
            } else {

                fileName = fileName.substring(fileName.indexOf("_") + 1);
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.add("Content-Disposition",
                        "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
            }

            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
            System.out.println("entity=" + entity);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;
    }

    @ResponseBody
    @GetMapping("/displayAttach")
    public ResponseEntity<byte[]> displayAttach(String fileName) throws Exception {

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;

        logger.info("FILE NAME: " + fileName);

        try {


            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);


            MediaType mType = MediaUtils.getMediaType(formatName);
            HttpHeaders headers = new HttpHeaders();


            in = new FileInputStream(uploadPath + "/detail/" + fileName);

            if (mType != null) {
                headers.setContentType(mType);
            } else {

                fileName = fileName.substring(fileName.indexOf("_") + 1);
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.add("Content-Disposition",
                        "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
            }

            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
            System.out.println("entity=" + entity);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;
    }






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
    public void getGoodsModify(@RequestParam("n") int gdsId, Model model) throws Exception {
        // @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장

        logger.info("modify.......");

        GoodsVO goods = service.goodsView(gdsId);  // GoodsViewVO형태 변수 goods에 상품 정보 저장
        model.addAttribute("goods", goods);
    }

    @PostMapping("/modify")
    public String modifyPOST(
            GoodsVO GoodsVO,@RequestParam(name = "attachFile", required = false) MultipartFile file, HttpServletRequest req
           ) throws Exception {
        logger.info("mod post............");
        if (!file.getOriginalFilename().equals("") && checkFile(file)){
            GoodsVO.gdsImage(uploadFile(file.getOriginalFilename(), file.getBytes()));
        } else {
            GoodsVO.setGdsImage(req.getParameter("gdsImage"));
        }
         service.goodsModify(GoodsVO);

        return "redirect:/admin/view?n=" + GoodsVO.getGdsId();
    }

    @PostMapping("/delete")
    public String postGoodsDelete(@RequestParam("n") int gdsId) throws Exception {
        // @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 gdsNum에 저장

        logger.info("post goods delete");
        service.goodsDelete(gdsId);
        return "redirect:/admin/list";
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

    // 주문 상세 목록 - 상태 변경
    @PostMapping("/orderView")
    public String delivery(OrderVO order) throws Exception {
        logger.info("post order view");

        service.delivery(order);

        // 새로운 Service → Mapper 를 사용하지 않고, 기존에 있던 Service를 사용
        List<OrderListVO> orderView =service.orderView(order);

        // 생성자 사용
        GoodsVO goods = new GoodsVO();

        for(OrderListVO i : orderView) {
            goods.setGdsId(i.getGdsId());
            goods.setGdsStock(i.getCartStock());
            service.changeStock(goods);
        }


        return "redirect:/admin/orderList";
    }

    @GetMapping("/orderDelete")
    public String getOrderDelete(@RequestParam("n") String orderId) throws Exception {

        logger.info("post order delete");
        service.orderDelete(orderId);

        return "redirect:/admin/orderList";
    }

    @GetMapping("/pos")
    public void getPos(OrderVO order, Model model) throws Exception {

        logger.info("pos...");


        List<OrderVO> orderList = service.orderList();


        model.addAttribute("orderList", orderList);
    }
}







