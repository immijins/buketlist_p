<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>My Buket List</title>
</head>
<body>
<div class="container-md">
    <div class="row">
        <div class="row">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-md">
                    <a class="navbar-brand" href="/buket/list">Buket</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/buket/list">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/buket/register">Add</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>

    <div class="row content">
        <div class="col">
            <div class="card border border-secondary">
                <div class="card-header bg-secondary bg-gradient">
                    <span class="text-white fw-bold">죽기 전에 하고 싶은 100가지, 버킷리스트</span>
                </div>
                <div class="card-body">
                    <h5 class="card-title fst-italic text-secondary float-start">My Buket List</h5>
                    <p class="float-end">현재 나의 버킷리스트는 ${totalCount}개 입니다</p>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">버킷리스트</th>
                            <th scope="col">작성일</th>
                            <th scope="col">달성</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="dto" items="${responseDTO.dtoList}" varStatus="status">
                            <tr>
                                <th scope="row">${totalCount - ((pageRequestDTO.page - 1) * pageRequestDTO.size + status.index)}</th>
                                <td>
                                    <a href="/buket/read?tno=${dto.tno}&${pageRequestDTO.link}" class="text-decoration-none text-secondary fw-bold"
                                        data-tno="${dto.tno}">
                                    <c:out value="${dto.title}"/>
                                    </a>
                                </td>
                                <td><c:out value="${dto.dueDate}"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${dto.finished}">
                                            <span class="text-success fw-bold">성공!</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="text-black-50">대기중</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <div class="float-start">
                        <button type="button" class="btn btn-primary">추가</button>
                    </div>

                    <div class="float-end">
                        <ul class="pagination flex-wrap">
                            <c:forEach var="num" begin="${responseDTO.start}" end="${responseDTO.end}">
                                <li class="page-item ${responseDTO.page == num ? "active" : ""}">
                                    <a class="page-link" data-num="${num}">${num}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <script>
                        document.querySelector('.pagination').addEventListener('click', function(e) {
                            e.preventDefault();
                            e.stopPropagation();

                            const target = e.target;
                            if (target.tagName !== 'A') {
                                return;
                            }
                            const num = target.getAttribute('data-num');
                            self.location = `/buket/list?page=\${num}`;
                        })
                    </script>
                </div>
            </div>
        </div>
    </div>

    <div class="row footer">
        <div class="row fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">My Buket List</p>
            </footer>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
    // 추가 버튼
    document.querySelector('.btn-primary').addEventListener('click', function () {
        self.location = "/buket/register"
    })
</script>
</body>
</html>
