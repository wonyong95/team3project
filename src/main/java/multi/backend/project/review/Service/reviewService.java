package multi.backend.project.review.Service;

import multi.backend.project.review.VO.reviewVO;

import java.util.List;
import java.util.Map;

public interface reviewService {

    //    1. Create
    int insertReview(reviewVO vo);

    //    2. Read
    List<reviewVO> selectReviewAll();

    reviewVO selectReviewOne(int review_id);

    //    3. Update
    int updateReview(reviewVO vo);

    //    4. delete
    int deleteReview(int id);

    //    5. 조회수 증가
    int updateReview_views(reviewVO boardVO);

    //    6. 총 게시글 수
    int getTotalCount();
}
