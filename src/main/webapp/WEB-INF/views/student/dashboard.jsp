<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page buffer="8192kb" autoFlush="true" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html lang="en">

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
                        <a class="navbar-brand">Thông tin sinh viên</a>
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
                                        <a class="nav-link active" aria-current="page" href="dashboard.htm">Thông tin
                                            sinh
                                            viên</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="point.htm">Điểm</a>
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
                <div class="row g-1" style="margin-left: 5px; margin-right: 5px;">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="row no-gutters">
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">Thông tin sinh viên</h5>
                                        <p class="card-text">Họ tên: ${SINHVIEN.HO.concat(' ').concat(SINHVIEN.TEN)}</p>
                                        <p class="card-text">Mã sinh viên: ${SINHVIEN.MASV}</p>
                                        <p class="card-text">Giới tính: ${SINHVIEN.PHAI == True? "Nữ": "Nam"}</p>
                                        <p class="card-text">Địa chỉ: ${SINHVIEN.DIACHI}</p>
                                        <p class="card-text">Ngày sinh: ${SINHVIEN.NGAYSINH}</p>
                                    </div>
                                </div>
                                <div class="col-md-4 mt-3">
                                    <img src="${'data:image/png;base64,'.concat(SINHVIEN.LINKANH)}" alt="avatar"
                                        class="card-img-right"
                                        style="width: 120px; height: 144px; border: 2px solid black;"
                                        onerror="this.onerror=null; this.src='/webapp/resources/heh.png';">
                                </div>
                            </div>
                        </div>

                        <div class="card mt-3">
                            <div class="card-body">
                                <h5 class="card-title">Thông tin lớp</h5>
                                <p class="card-text">Mã lớp: ${LOP.MALOP}</p>
                                <p class="card-text">Tên lớp: ${LOP.TENLOP}</p>
                                <p class="card-text">Niên khóa: ${LOP.KHOAHOC}</p>
                                <!-- <p class="card-text">Khoa: ${LOP.khoa.TENKHOA}</p> -->
                            </div>
                        </div>

                        <div class="card mt-3">
                            <div class="card-body">
                                <h5 class="card-title">Thông báo</h5>
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
                                                <tr data-bs-toggle="modal"
                                                    data-bs-target="#announcementModal${loop.index}">
                                                    <td>${TB.NGAYDANG}</td>
                                                    <td>${TB.TIEUDE}</td>
                                                </tr>
                                                <div class="modal fade" id="announcementModal${loop.index}"
                                                    tabindex="-1" aria-labelledby="announcementModalLabel${loop.index}"
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
                            <div class="card-body d-flex flex-column">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h5 id="titleWeek" class="card-title mb-0">${'Thời khóa biểu
                                        '.concat('(').concat(firstDayOfWeek).concat(' ->
                                        ').concat(lastDayOfWeek).concat(')')}</h5>
                                    <div class="d-flex">
                                        <form action="truoc.htm" method="get">
                                            <button id="prevWeek" class="btn btn-primary"
                                                style="margin-right: 10px;">Trước</button>
                                        </form>
                                        <form action="sau.htm" method="get">
                                            <button id="nextWeek" class="btn btn-primary">Sau</button>
                                        </form>
                                    </div>
                                </div>
                                <table class="table flex-grow-1">
                                    <thead>
                                        <tr>
                                            <th scope="col">Time/Day</th>
                                            <th scope="col">Thứ hai</th>
                                            <th scope="col">Thứ ba</th>
                                            <th scope="col">Thứ tư</th>
                                            <th scope="col">Thứ năm</th>
                                            <th scope="col">Thứ sáu</th>
                                            <th scope="col">Thứ bảy</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row" class="align-middle">Tiết 1-4</th>
                                            <c:forEach var="Buoi" items="${dsLICHSANG}">
                                                <c:if test="${Buoi.TIETBD == 1}">
                                                    <td class="table-cell">
                                                        ${Buoi.loptinchi.monhoc.TENMH}<br>
                                                        Phòng: ${Buoi.PHONG}
                                                    </td>
                                                </c:if>
                                                <c:if test="${Buoi.TIETBD != 1}">
                                                    <td class="table-cell"></td>
                                                </c:if>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <th scope="row" class="align-middle">Tiết 7-10</th>
                                            <c:forEach var="Buoi" items="${dsLICHCHIEU}">
                                                <c:if test="${Buoi.TIETBD == 7}">
                                                    <td class="table-cell">
                                                        ${Buoi.loptinchi.monhoc.TENMH}<br>
                                                        Phòng: ${Buoi.PHONG}
                                                    </td>
                                                </c:if>
                                                <c:if test="${Buoi.TIETBD != 7}">
                                                    <td class="table-cell"></td>
                                                </c:if>
                                            </c:forEach>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
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