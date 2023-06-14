package multi.backend.project.review.Service;

import multi.backend.project.review.VO.pagingVO;
import multi.backend.project.review.VO.reviewVO;

import java.util.List;


public interface reviewService {

    //    1. Create
    int insertReview(reviewVO vo);

    //    2. Read
    List<reviewVO> selectReviewAll(pagingVO paging);

    //    2_1. Read (특정 게시글 가져오기)
    reviewVO selectReviewOne(int review_id);

    //    3. Update
    int updateReview(reviewVO vo);

    //    4. delete
    int deleteReview(int id);

    //    5. 조회수 증가
    int updateReview_views(reviewVO boardVO);

    //    6. 총 게시글 수
    int getTotalCount();

    //    6_1. 총게시글 or 검색한 총게시글
    int getTotalCount(pagingVO paging);
}
