package multi.backend.project.review.Mapper;

import multi.backend.project.review.VO.pagingVO;
import multi.backend.project.review.VO.reviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface reviewMapper {

//    1. insert ( 게시글 추가하기 )
    int insertReview(reviewVO vo);

//    2. Read (전체 게시판 목록 가져오기)
    List<reviewVO> selectReviewAll(pagingVO paging);

//    2_1. Read (특정 게시글 가져오기)
    reviewVO selectReviewOne(int user_id);

//    3. Update (게시글 수정하기)
    int updateReview(reviewVO vo);

//    4. delete (게시글 삭제하기)
    int deleteReview(int id);

//    5. 조회수 증가
    int updateReview_views(reviewVO boardVO);

//    6. 총 게시글 수
    int getTotalCount();

//    6_1. 총게시글 or 검색한 총게시글
    int getTotalCountpaging(pagingVO paging);
}
