package multi.backend.project.review.VO;

import lombok.Data;

import javax.servlet.http.HttpSession;


@Data
public class pagingVO {
    private int cpage; // 현재 페이지 번호
    private int pageSize; // 페이지당 보여줄 목록개수
    private int totalCount; // 총 게시글 수
    private int pageCount; // 페이지 수

    // DB에서 레코드를 끊어오기 위한 프로퍼티
    private int start;
    private int end;

    private int pagingBlock = 10; // 한 블럭당 보여줄 페이지수
    private int prevBlock;    // 이전 10개 (이전블록)
    private int nextBlock;   // 이후 10개 (이후 블록)

    private String findType; //검생유형
    private String keyword; // 검색 키워드

    // 페이징 처리 연산 수행하는 메서드
    public void init(HttpSession session){
        if(session!=null){
            session.setAttribute("pageSize", pageSize);
        }

        //페이지 수 구하기
        pageCount = (totalCount - 1) / pageSize + 1;

        if(cpage<1)
            cpage=1; // 1페이지를 디폴트값으로 지정
        if(cpage>pageCount)
            cpage = pageCount; // 마지막 페이지로 설정

        start = (cpage-1)*pageSize;
        end = (cpage*pageSize)+1;


        prevBlock = (cpage - 1)/pagingBlock*pagingBlock;
        nextBlock= prevBlock+(pagingBlock+1);
    }

    public String getPageNevi(String myctx, String loc){
        if(findType==null){
            findType="";
        }
        if(keyword==null){
            keyword="";
        }

        String link=myctx+"/"+loc;
        String qStr="?pageSize"+pageSize+"&findType"+findType+"&keyword="+keyword;
        link+=qStr;
        StringBuilder buf=new StringBuilder();
        buf.append("<ul class=\"pagination justify-content-center\" >");
        if(prevBlock > 0){
            buf.append("<li class=\"page-item\">")
                    .append("<a class='page-link' href='"+link+"&cpage="+prevBlock+"'>")
                    .append("Prev")
                    .append("</a>")
                    .append("</li>");
        }
        for(int i=prevBlock+1;i<nextBlock-1 && i<=pageCount;i++){
            String css=(i==cpage)?"active":"";
            buf.append("<li class='page-item"+css+"'>");
            buf.append("<a class='page-link' href='"+link+"&cpage="+i+"'>");
            buf.append(i);
            buf.append("</a>");
            buf.append("</li>");
        }
        if(nextBlock > 0){
            buf.append("<li class=\"page-item\">")
                    .append("<a class='page-link' href='"+link+"&cpage="+nextBlock+"'>")
                    .append("next")
                    .append("</a>")
                    .append("</li>");
        }
        buf.append("</ul>");

        return buf.toString();
    }






}
