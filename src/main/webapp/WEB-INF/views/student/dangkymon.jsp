<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page buffer="8192kb" autoFlush="true" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Cổng thông tin sinh viên</title>
                    <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
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
                    <nav class="navbar navbar-dark bg-danger fixed-top" style="z-index: 10;">
                        <div class="container-fluid">
                            <a class="navbar-brand">Cổng đăng ký môn học</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                                data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar"
                                aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="offcanvas offcanvas-end bg-danger text-white" tabindex="-1"
                                id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
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
                                            <a class="nav-link active" href="dangkymon.htm">Đăng ký môn</a>
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
                    <div class="container">
                        <c:if test="${not empty message}">
                            <div class="alert alert-info text-center">
                                <div class="d-flex justify-content-between align-items-center">
                                    <span>${message}</span>
                                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                </div>
                            </div>
                        </c:if>
                        <div style="z-index: 1;">
                            <form action="timkiem.htm" method="post">
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" placeholder="Nhập niên khóa"
                                        name="nienkhoa" required>
                                    <input type="text" class="form-control" placeholder="Nhập học kỳ"
                                        name="hocky" required>
                                    <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                                </div>
                            </form>
                        </div>
                        <div style="height: 550px; overflow-y: auto;">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col" class="text-center">Mã môn</th>
                                        <th scope="col" class="text-center">Môn học</th>
                                        <th scope="col" class="text-center">Nhóm</th>
                                        <th scope="col" class="text-center">Niên khóa</th>
                                        <th scope="col" class="text-center">Học kỳ</th>
                                        <th scope="col" class="text-center">Giảng viên</th>
                                        <th scope="col" class="text-center">Sĩ số</th>
                                        <th scope="col" class="text-center">Đăng ký</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="p" items="${ltc}">
                                        <tr>
                                            <td class="text-center">${p.MAMH}</td>
                                            <td class="text-center">${p.TENMH}</td>
                                            <td class="text-center">${p.NHOM}</td>
                                            <td class="text-center">${p.NIENKHOA}</td>
                                            <td class="text-center">${p.HOCKY}</td>
                                            <td class="text-center">${p.HOTENGV}</td>
                                            <td class="text-center">${p.SOSVDANGKY}</td>
                                            <td class="text-center">
                                                <c:choose>
                                                    <c:when test="${p.DADANGKY == true}">
                                                        <a href="huydangky.htm?maltc=${p.MALTC}"
                                                            class="btn btn-danger">Hủy đăng
                                                            ký</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="dangky.htm?maltc=${p.MALTC}"
                                                            class="btn btn-primary">Đăng ký</a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <footer class="navbar fixed-bottom bg-danger" style="z-index: 1;">
                        <div class="container text-center">
                            <span class="text-light">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Thư</span>
                        </div>
                    </footer>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>
                </body>

                </html>