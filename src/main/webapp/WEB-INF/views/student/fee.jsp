<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>Cổng thông tin sinh viên</title>
                <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <style>
                    body {
                        font-family: 'Poppins', sans-serif;
                        background: #ececec;
                    }
                    .header {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        margin-bottom: 20px;
                    }

                    .total-row {
                        font-weight: bold;
                    }

                    .total-label {
                        font-weight: bold;
                        color: red;
                    }

                    .chuadong {
                        color: red;
                        font-weight: bold;
                        font-size: 16px;
                    }

                    footer {
                        background-color: #dc3545;
                        color: white;
                        padding: 10px 0;
                        text-align: left;
                        position: fixed;
                        width: 100%;
                        bottom: 0;
                        z-index: 1;
                    }

                    body {
                        min-height: 100vh;
                        padding-bottom: 60px;
                        background-color: #ececec
                    }

                    .rounded-table {
                        border-collapse: collapse;
                        width: 100%;
                        background-color: rgb(247, 247, 247);
                        border-radius: 5px;
                        overflow: hidden;
                        border: 2px solid #ced3da;
                    }

                    .rounded-table th,
                    .rounded-table td {
                        border: none;
                        text-align: center;
                        padding: 12px;
                        font-size: 18px;

                    }

                    .rounded-table thead th {
                        border: none;
                    }

                    .rounded-table tbody td {
                        background-color: rgb(252, 252, 252);
                        border-top: 1px solid #ced3da;
                    }

                    .total-table {
                        margin-top: 20px;
                        border-collapse: collapse;
                        width: 100%;
                        border-radius: 5px;
                        overflow: hidden;
                        border: 2px solid #ced3da;
                    }

                    .total-table td,
                    .total-table th {
                        border-top: 1px solid #ced3da;
                        padding: 12px;
                        text-align: center;
                        font-size: 18px;
                    }

                    .total-table .total-label {
                        font-weight: bold;
                        color: rgb(14, 13, 13);

                    }

                    .total-table .bold-text {
                        font-weight: bold;
                        font-size: 32px;
                    }
                </style>
            </head>

            <body>
                <nav class="navbar navbar-dark bg-danger fixed-top" style="z-index: 2;">
                    <div class="container-fluid">
                        <a class="navbar-brand">Học phí sinh viên</a>
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
                                        <a class="nav-link" aria-current="page" href="dashboard.htm">Thông tin sinh
                                            viên</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="dangkymon.htm">Đăng ký môn</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link active" href="fee.htm">Học phí</a>
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

                <div class="container mt-5">
                    <div class="header">
                    </div>

                    <table class="table table-bordered rounded-table">
                        <thead class="table-light">
                            <tr>
                                <th>Niên Khóa</th>
                                <th>Học Kỳ</th>
                                <th>Học phí</th>
                                <th>Đã Đóng</th>
                                <th>Ngày đóng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="hp" items="${list}">
                                <tr>
                                    <td>${hp.NIENKHOA}</td>
                                    <td>${hp.HOCKY}</td>
                                    <td>${hp.HOCPHI}</td>
                                    <td>${hp.PAID}</td>
                                    <td>${hp.NGAYDONG == '1970-01-01'? 'Chưa đóng': hp.NGAYDONG}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

                <!-- Footer -->
                <footer>
                    <div class="container">
                        <span class="text-light" style="font-size: larger;">Copyright &copy; 2024 Nhóm 8 được hướng dẫn
                            bởi thầy Thư</span>
                    </div>
                </footer>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
            </body>

            </html>