<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review Edit</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script
            src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
    <!-- Popper JS -->
    <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        #content {
            overflow-y: scroll;
            -ms-overflow-style: none; /* 인터넷 익스플로러 */
            scrollbar-width: none; /* 파이어폭스 */
        }
        #content::-webkit-scrollbar {
            display: none; /* 크롬, 사파리, 오페라, 엣지 */
        }
    </style>
</head>
<body>
<div class="row">

    <div align="center" id="bbs" class="col-md-8 offset-md-2 my-4">
        <h2>Review Edit</h2>
        <p>
            <a href="write">글쓰기</a>| <a href="list">글목록</a>
        <p>

        <form name="bf" id="bf" role="form" action="write" method="post" >
            <!-- hidden data---------------------------------  -->
            <input type="hidden" name="num" value=""/>
            <input type="hidden" name="mode" value="">
            <!-- 원본글쓰기: mode=> write
                 답변글쓰기: mode=> rewrite
                  글수정  : mode=> edit
             -->
            <!-- -------------------------------------------- -->
            <table class="table">
                <tr>
                    <td style="width:20%"><b>제목</b></td>
                    <td style="width:80%">
                        <input type="text" name="subject" id="subject" class="form-control" value="${vo.review_title}">
                    </td>
                </tr>

                <tr>
                    <td style="width:20%"><b>작성자</b></td>
                    <td style="width:80%">
                        <input type="text" name="#" id="#" value="${vo.user_id}" readonly />
                    </td>
                </tr>
                <tr>
                    <td style="width:20%"><b>글내용</b></td>
                    <td style="width:80%">
                        <textarea name="content" id="bcontent" rows="10" cols="50" class="form-control">${vo.review_content}</textarea>
                    </td>
                </tr>

                <tr>
                    <td colspan="2" class="text-center">
                        <button type="submit" id="btnWrite" class="btn btn-success">글수정</button>
                        <button type="reset" id="btnReset" class="btn btn-warning">다시쓰기</button>
                    </td>
                </tr>
            </table>
        </form>
    </div><!-- .col end-->
</div><!-- .row end-->
</body>
</html>