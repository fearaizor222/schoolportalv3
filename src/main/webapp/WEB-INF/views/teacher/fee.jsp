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
                    <nav class="navbar navbar-dark bg-danger fixed-top navbar-fixed-top">
                        <div class="container-fluid">
                            <a class="navbar-brand">Học phí</a>
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
                                        <c:choose>
                                            <c:when test="${role != 'PKT'}">
                                                <li class="nav-item">
                                                    <a class="nav-link" aria-current="page" href="dashboard.htm">Thông tin giảng viên</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="class-management.htm">Chỉnh sửa lớp</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="creditclass-management.htm">Chỉnh sửa lớp tín chỉ</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="subject-management.htm">Chỉnh sửa môn</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="points-management.htm">Chỉnh sửa điểm</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="reportDSLTC.htm">In danh sách lớp tín chỉ</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="reportDSSVLTC.htm">In danh sách đăng ký lớp tín chỉ</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="reportPHIEUDIEMSV.htm">In phiếu điểm</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="reportBANGDIEM.htm">In điểm của lớp</a>
                                                </li>
                                                
                                            </c:when>
                                            <c:when test="${role == 'PKT'}">
                                                <li class="nav-item">
                                                    <a class="nav-link active" href="fee.htm">Xem học phí</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="reportHOCPHI.htm">In danh sách đóng học phí</a>
                                                </li>
                                            </c:when>
                                        </c:choose>
                                        <li class="nav-item">
                                            <a class="nav-link" href="taologin.htm">Tạo tài khoản</a>
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
                        <div style="z-index: 1;">
                            <form action="timkiemhocphi.htm" method="post">
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" placeholder="Nhập mã sinh viên" name="masv"
                                        required>
                                    <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                                </div>
                            </form>
                        </div>
                        <table class="table table-bordered rounded-table">
                            <thead class="table-light">
                                <tr>
                                    <th>Niên Khóa</th>
                                    <th>Học Kỳ</th>
                                    <th>Học phí</th>
                                    <th>Số tiền đã đóng</th>
                                    <th>Số tiền cần đóng</th>
                                    <th>Xác nhận</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="hp" items="${listfee}" varStatus="loop">
                                    <tr>
                                        <td data-bs-toggle="modal" data-bs-target="#feeModal${loop.index}">${hp.NIENKHOA}</td>
                                        <td data-bs-toggle="modal" data-bs-target="#feeModal${loop.index}">${hp.HOCKY}</td>
                                        <td data-bs-toggle="modal" data-bs-target="#feeModal${loop.index}">${hp.HOCPHI}</td>
                                        <td data-bs-toggle="modal" data-bs-target="#feeModal${loop.index}">${hp.PAID}</td>
                                        <td data-bs-toggle="modal" data-bs-target="#feeModal${loop.index}">${hp.PAID == 0? hp.HOCPHI : hp.PAID}</td>
                                        <td>
                                            <a class="btn btn-primary" href="xacnhandadong.htm?nienkhoa=${hp.NIENKHOA}&hocky=${hp.HOCKY}&masv=${hocphisearchmasv}&sotien=${hp.HOCPHI}">Đã đóng tiền</a>
                                        </td>
                                    </tr>
                                    <div class="modal fade" id="feeModal${loop.index}" tabindex="-1"
                                        aria-labelledby="feeModal${loop.index}Label" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="feeModal${loop.index}Label">Chi tiết</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Ngày đóng: ${hp.NGAYDONG == '1970-01-01'? 'chưa đóng': hp.NGAYDONG}</p>
                                                    <p>Số tiền đã đóng: ${hp.PAID}</p>
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
                    <div class="modal fade" id="ConfirmFeeModal" tabindex="-1" aria-labelledby="ConfirmFeeModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="ConfirmFeeModalLabel">Chi tiết</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary"
                                    data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="navbar fixed-bottom bg-danger" style="z-index: 1;">
                    <div class="container text-center">
                        <span class="text-light">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Thư</span>
                    </div>
                </footer>
                    <script>
                        document.addEventListener('DOMContentLoaded', (event) => {
                        var passwordUpdateMsg = "${ConfirmFeeMsg}";
                        if (passwordUpdateMsg !== '') {
                            document.querySelector('#ConfirmFeeModal .modal-body').textContent = passwordUpdateMsg;

                            var passwordUpdateModal = new bootstrap.Modal(document.getElementById('ConfirmFeeModal'), {});
                            passwordUpdateModal.show();
                        }
                    });
                    </script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>
                </body>

                </html>