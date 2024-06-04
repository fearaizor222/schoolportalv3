<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                }
            </style>
        </head>

        <body>
            <div class="d-flex">
                <div>
                    <img src="/webapp/resources/heh.png" alt="placeholder" width="250" height="400"
                        style="border: 2px solid black; margin-left: 5px; margin-top: 60px; border-radius: 5px;">
                    <br>
                    <button type="button" class="btn btn-info"
                        style="margin-top: 10px; margin-left: 5px;">Update</button>
                </div>
                <div style="margin-left: 20px; margin-top: 60px;">
                    <p>Mã sinh viên: ${SINHVIEN.MASV}</p>
                    <p>Họ tên: ${SINHVIEN.HO.concat(' ').concat(SINHVIEN.TEN)}</p>
                    <p>Giới tính: ${SINHVIEN.PHAI == True? "Nữ": "Nam"}</p>
                    <p>Địa chỉ: ${SINHVIEN.DIACHI}</p>
                    <p>Ngày sinh: ${SINHVIEN.NGAYSINH}</p>
                    <p>Lớp: ${SINHVIEN.MALOP}</p>
                </div>
            </div>
            <nav class="navbar navbar-dark bg-danger fixed-top">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Thông tin sinh viên</a>
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
                                    <a class="nav-link active" aria-current="page" href="dashboard.htm">Thông tin sinh
                                        viên</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Điểm</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Lịch học</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Lịch thi</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Đăng ký môn</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Học phí</a>
                                </li>
                            </ul>
                        </div>
                        <div class="position-absolute bottom-0 start-50 translate-middle-x my-10">
                            <button type="button" class="btn btn-warning">Logout</button>
                        </div>

                    </div>
                </div>
            </nav>
            <footer class="navbar fixed-bottom bg-danger">
                <div class="container text-center">
                    <span class="text-light">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Hiếu</span>
                </div>
            </footer>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>
        </body>

        </html>