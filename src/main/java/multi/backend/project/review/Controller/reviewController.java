package multi.backend.project.review.Controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import multi.backend.project.review.Service.reviewServiceImpl;
import multi.backend.project.review.VO.pagingVO;
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
    public String listReview(Model m,HttpServletRequest req, @ModelAttribute pagingVO page){
        HttpSession session =  req.getSession();
        int totalCount =  this.service.getTotalCount(); // 전체 게시글 수
        page.setTotalCount(totalCount);
        //System.out.println("totalCount"+ totalCount); 정상적으로 전체 글 개수 확인 완료
        page.setPagingBlock(11); //페이징 블럭 단위 값: 10

        page.init(session); //페이징 관련 연산 수행 메서드


        List<reviewVO> list = service.selectReviewAll(page);
        String myctx=req.getContextPath();
        String loc="review/list";

        String pageNevi=page.getPageNevi(myctx,loc);

//        for(reviewVO vo : list){
//            log.info(vo.toString());
//        }
        /*
        => 정상적으로 list를 가져옴
        */

        m.addAttribute("list",list);
        m.addAttribute("paging",page);
        m.addAttribute("pageNevi",pageNevi);
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
        //System.out.print(review.toString());
        //-> 정상적으로 출력
        int n = service.insertReview(review);

        return "redirect:/review/list";
    }



//    게시글 수정&삭제 폼 이동
    @GetMapping("/edit")
    public String editForm(Model m, HttpServletRequest seq){
        String id = seq.getParameter("review_id");
        // System.out.println(id); => 정상적으로 값을 받아옴을 확인
        reviewVO vo = service.selectReviewOne(Integer.valueOf(id));
        //System.out.println(vo.toString());
        m.addAttribute("vo",vo);
    return "review/edit";
    }

    @PostMapping("/delete")
    public String deleteReview(Model m , HttpServletRequest seq){
        String id = seq.getParameter("review_id");
        // System.out.println(id); 정상적으로 받아오기 완료

        int n = service.deleteReview(Integer.parseInt(id));
        String str = (n>0)? "정상적으로 삭제 완료":"삭제 실패 지져스";
        System.out.println(str);
        return "redirect:/review/list";
    }

    @PostMapping("/update")
    public String updateReview(Model m, @ModelAttribute reviewVO vo, HttpServletRequest seq){
        System.out.println("불어온 vo");
        System.out.println(vo.toString());
        int n = service.updateReview(vo);
        return "redirect:/review/list";
    }
}
