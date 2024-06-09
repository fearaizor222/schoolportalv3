<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Cổng thông tin sinh viên</title>
            <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">

            <style>
                @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

                body {
                    font-family: 'Poppins', sans-serif;
                    background: #ececec;
                    margin-top: 60px;
                    padding-top: 20px;
                }
            </style>
        </head>

        <body>
            <nav class="navbar navbar-dark bg-danger fixed-top" style="z-index: 2;">
                <div class="container-fluid">
                    <a class="navbar-brand">Điểm thành phần sinh viên</a>
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
                                    <a class="nav-link" aria-current="page" href="dashboard.htm">Thông tin
                                        sinh
                                        viên</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" href="point.htm">Điểm</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="test.htm">Lịch thi</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="dangkymon.htm">Đăng ký môn</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="fee.htm">Học phí</a>
                                </li>
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
            <div class="container mt-5" style="height: 550px; overflow: auto;">
                <table class="table table-striped table-hover table-bordered">
                    <thead class="thead-dark">
                        <tr>
                            <th>Môn học</th>
                            <th>Niên khóa</th>
                            <th>Điểm chuyên cần</th>
                            <th>Điểm giữa kỳ</th>
                            <th>Điểm cuối kỳ</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${points}">
                            <tr>
                                <td>${p.loptinchi.monhoc.TENMH}</td>
                                <td>${p.loptinchi.NIENKHOA}</td>
                                <td>${p.DIEM_CC}</td>
                                <td>${p.DIEM_GK}</td>
                                <td>${p.DIEM_CK}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <footer class="navbar fixed-bottom bg-danger" style="z-index: 1;">
                <div class="container text-center">
                    <span class="text-light">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Hiếu</span>
                </div>
            </footer>
            <!-- Include Bootstrap JS and its dependencies -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>

        </html>