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
                    <a class="navbar-brand" href="#">Thông tin giảng viên</a>
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
                                    <a class="nav-link active" aria-current="page" href="dashboard.htm">Thông tin giảng
                                        viên
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="class-management.htm">Chỉnh sửa lớp</a>
                                </li>
                                <li class="nav-item">
                                        <a class="nav-link" href="creditclass-management.htm">Chỉnh sửa lớp tín chỉ</a>
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
            <div class="row g-1" style="margin-left: 5px; margin-right: 5px;">
                <div class="col-md-4">
                    <div class="card">
                        <div class="row no-gutters">
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">Thông tin giảng viên</h5>
                                    <p class="card-text">Họ tên: ${GIANGVIEN.HO.concat(' ').concat(GIANGVIEN.TEN)}</p>
                                    <p class="card-text">Mã giảng viên: ${GIANGVIEN.MAGV}</p>
                                    <p class="card-text">Học hàm: ${GIANGVIEN.HOCHAM}</p>
                                    <p class="card-text">Học vị: ${GIANGVIEN.HOCVI}</p>
                                    <p class="card-text">Chuyên môn: ${GIANGVIEN.CHUYENMON}</p>
                                </div>
                            </div>
                            <div class="col-md-4 mt-3">
                                <img src="${'data:image/png;base64,'.concat(SINHVIEN.LINKANH)}" alt="avatar"
                                    class="card-img-right" style="width: 120px; height: 144px; border: 2px solid black;"
                                    onerror="this.onerror=null; this.src='/webapp/resources/gojo.png';">
                            </div>
                        </div>
                    </div>

                    <div class="card mt-3">
                        <div class="card-body">
                            <h5 class="card-title">Thông tin Khoa</h5>
                            <p class="card-text">Mã khoa: ${GIANGVIEN.MAKHOA}</p>
                        </div>
                    </div>

                    <div class="card mt-3">
                        <div class="card-body">
                            <h5 class="card-title mb-0">Thông báo</h5>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Ngày đăng</th>
                                        <th scope="col">Tiêu đề</th>
                                    </tr>
                                </thead>
                            </table>
                            <div style="height: 70px; overflow-y: auto;">
                                <table class="table">
                                    <tbody>
                                        <c:forEach var="TB" items="${dsTHONGBAO}" varStatus="loop">
                                            <tr data-bs-toggle="modal" data-bs-target="#announcementModal${loop.index}">
                                                <td>${TB.NGAYDANG}</td>
                                                <td>${TB.TIEUDE}</td>
                                            </tr>
                                            <div class="modal fade" id="announcementModal${loop.index}" tabindex="-1"
                                                aria-labelledby="announcementModalLabel${loop.index}"
                                                aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title"
                                                                id="announcementModalLabel${loop.index}">
                                                                ${TB.TIEUDE}</h5>
                                                            <button type="button" class="btn-close"
                                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            ${TB.NOIDUNG}
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                data-bs-dismiss="modal">Close</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8 d-flex flex-column">
                    <div class="card flex-grow-1">
                        <div class="container mt-5">
                            <div style="height: 620px; overflow: auto;">
                                <table class="table table-striped table-hover table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th class="center-text">Mã lớp tín chỉ</th>
                                            <th class="center-text">Niên khóa</th>
                                            <th class="center-text">Học kỳ</th>
                                            <th class="center-text">Nhóm</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="ltc" items="${AllLTCList}">
                                            <tr>
                                                <td class="center-text">${ltc.MALTC}</td>
                                                <td class="center-text">${ltc.NIENKHOA}</td>
                                                <td class="center-text">${ltc.HOCKY}</td>
                                                <td class="center-text">${ltc.NHOM}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        
                    </div>
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