<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Cổng quản lý sinh viên</title>
            <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">

            <style>
                @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

                body {
                    font-family: 'Poppins', sans-serif;
                    background: #ececec;
                    margin-top: 80px;
                    padding-top: 20px;
                }

                .table-cell {
                    overflow: hidden;
                    word-wrap: break-word;
                    white-space: normal;
                    height: 250px;
                }
            </style>
        </head>

        <body>
            <nav class="navbar navbar-dark bg-danger fixed-top" style="z-index: 2;">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Học phí sinh viên</a>
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
                                    <a class="nav-link" href="points.htm">Chỉnh điểm</a>
                                </li>
                                <c:if test="${role == 'admin'}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="student-management.htm">Nhập/xóa Sinh viên</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="announcement.htm">Thông báo</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link active" href="fee.htm">Học phí sinh viên</a>
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
            <div class="container mt-5">
                <h2 class="text-center mb-3">Student Fees</h2>
                <c:if test="${not empty message}">
                        <div class="alert alert-info text-center">
                            ${message}
                        </div>
                    </c:if>
                <table class="table table-striped text-center">
                    <thead>
                        <tr>
                            <th scope="col">NIENKHOA</th>
                            <th scope="col">HOCKY</th>
                            <th scope="col">MASV</th>
                            <th scope="col">HOCPHI</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Assuming you have a list of fees, iterate over them to create table rows -->
                        <c:forEach var="fee" items="${fees}" varStatus="loop">
                            <tr>
                                <td>${fee.hocPhiId.NIENKHOA}</td>
                                <td>${fee.hocPhiId.HOCKY}</td>
                                <td>${fee.hocPhiId.MASV}</td>
                                <td>${fee.HOCPHI}</td>
                                <c:set var="myIsPaid" value="${pageContext.findAttribute('isPaid'.concat(loop.index))}" />
                                <c:choose>
                                    <c:when test="${myIsPaid == true}">
                                        <td>
                                            <a href="depaid.htm?nienkhoa=${fee.hocPhiId.NIENKHOA}&hocky=${fee.hocPhiId.HOCKY}&masv=${fee.hocPhiId.MASV}" class="btn btn-danger">Hủy Xác nhận</a>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>
                                            <a href="paid.htm?nienkhoa=${fee.hocPhiId.NIENKHOA}&hocky=${fee.hocPhiId.HOCKY}&masv=${fee.hocPhiId.MASV}" class="btn btn-success">xác nhận</a>
                                        </td>
                                    </c:otherwise>
                                </c:choose>
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
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>
        </body>

        </html>