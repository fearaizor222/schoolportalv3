<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Thêm thông báo</title>
        <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
        <title>Đăng thông báo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

            body {
                font-family: 'Poppins', sans-serif;
                background: #ececec;
                margin-top: 80px;
                padding-top: 20px;
            }
        </style>
    </head>

    <body>
        <nav class="navbar navbar-dark bg-danger fixed-top" style="z-index: 2;">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Thông báo sinh viên</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end bg-danger text-white" tabindex="-1" id="offcanvasDarkNavbar"
                    aria-labelledby="offcanvasDarkNavbarLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Menu</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"
                            aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="dashboard.htm">Thông tin giảng
                                    viên
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Nhập/Sửa Điểm</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Nhập/Sửa Môn</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Nhập/Sửa Sinh viên</a>
                            </li>
                            <c:if test="${role == 'admin'}">
                                <li class="nav-item">
                                    <a class="nav-link active" href="announcement.htm">Thông báo</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="fee.htm">Học phí sinh viên</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="settings.htm">Điều chỉnh</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>

                    <form action="logout.htm" method="post">
                        <div class="position-absolute bottom-0 start-50 translate-middle-x my-10"
                            style="margin-bottom: 10px;">
                            <button type="submit" class="btn btn-warning">Logout</button>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <div class="container">
            <form:form action="inserttb.htm" method="POST" modelAttribute="tbneedtobeupdated">
                <div class="mb-3">
                    <label for="title" class="form-label">Tiêu đề</label>
                    <form:input path="TIEUDE" id="title" class="form-control" />
                </div>
                <div class="mb-3">
                    <label for="date" class="form-label">Ngày</label>
                    <form:input path="NGAYDANG" id="date" type="date" class="form-control" />
                </div>
                <div class="mb-3">
                    <label for="noidung" class="form-label">Nội dung</label>
                    <form:textarea path="NOIDUNG" id="noidung" class="form-control" />
                </div>
                <button type="submit" class="btn btn-primary">Đăng</button>
                <div class="mb-3" style="display: none;">
                    <label for="title" class="form-label">Title</label>
                    <form:input path="MATB" id="title" class="form-control" />
                </div>
            </form:form>
        </div>
        <footer class="navbar fixed-bottom bg-danger" style="z-index: 1;">
            <div class="container text-center">
                <span class="text-light">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Hiếu</span>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    </body>

    </html>