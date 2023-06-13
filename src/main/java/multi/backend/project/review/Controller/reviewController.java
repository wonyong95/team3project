package multi.backend.project.review.Controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import multi.backend.project.review.Service.reviewServiceImpl;
import multi.backend.project.review.VO.reviewVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@RequestMapping("/review")
@Log4j2
@org.springframework.stereotype.Controller
public class reviewController {

    @Resource(name = "reviewService")
    private reviewServiceImpl service;

    /*@GetMapping("/test")
    public String reviewForm(Model mod){
        mod.addAttribute("");
        return "review";
    }
    => 테스트 완료 후 주석 처리
    */


//  게시글 전체 출력
    @GetMapping("list")
    public String listReview(Model m){
        //HttpSession session =  req.getSession();
        int totalCount =  this.service.getTotalCount(); // 전체 게시글 수
        //System.out.println("totalCount"+ totalCount); 정상적으로 전체 글 개수 확인 완료

        List<reviewVO> list = service.selectReviewAll();

        for(reviewVO vo : list){
            log.info(vo.toString());
        }
        /*
        => 정상적으로 list를 가져옴
        */

        m.addAttribute("list",list);
        return "review/review";
    }


//  게시글 삽입 폼 이동
    @GetMapping("/write")
    public String reviewEdit(){
        return "review/write";
    }

//    게시글 insert
    @PostMapping("/write")
    public String insertReiew(Model m, @ModelAttribute reviewVO review, HttpSession session){
        System.out.print(review.toString());
        //-> 정상적으로 출력
        int n = service.insertReview(review);

        return "redirect:/review/list";
    }



//    게시글 수정&삭제 폼 이동
    @GetMapping("/edit")
    public String editForm(Model m, @RequestParam(defaultValue = "1") int review_id){
        log.fatal(review_id);
    return "review/edit";
    }




}
