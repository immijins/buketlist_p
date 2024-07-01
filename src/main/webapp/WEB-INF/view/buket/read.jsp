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
            <div class="input-group mb-3">
                <input type="hidden" name="tno" class="form-control" value="${dto.tno}" readonly/>
            </div>
          <div class="input-group mb-3">
              <span class="input-group-text">버킷리스트</span>
              <input type="text" name="title" class="form-control" value="${dto.title}" readonly/>
          </div>
          <div class="input-group mb-3">
              <span class="input-group-text">작성일</span>
              <input type="date" name="dueDate" class="form-control" value="${dto.dueDate}" readonly/>
          </div>
          <div class="form-check">
              <lable class="form-check-label">
                  달성 &nbsp;
              </lable>
              <input type="checkbox" name="finished" class="form-check-input" ${dto.finished ? "checked" : ""} disabled/>
          </div>
          <div class="my-4">
              <div class="float-end">
                  <button type="submit" class="btn btn-primary">수정</button>
                  <button type="reset" class="btn btn-secondary">목록</button>
              </div>
          </div>
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
  // 수정 이벤트 처리
  document.querySelector('.btn-primary').addEventListener('click', function () {
    self.location = '/buket/modify?tno=${dto.tno}&${pageRequestDTO.link}'
  }, false);

  // 목록 이동 이벤트 처리
  document.querySelector('.btn-secondary').addEventListener('click', function() {
    self.location = '/buket/list?${pageRequestDTO.link}';
  }, false);

</script>
</body>
</html>
