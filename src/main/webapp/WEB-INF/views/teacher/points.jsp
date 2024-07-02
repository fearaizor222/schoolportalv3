<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Cổng quản lý sinh viên</title>
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
                            margin-top: 80px;
                            padding-top: 20px;
                        }

                        .table-cell {
                            overflow: hidden;
                            word-wrap: break-word;
                            white-space: normal;
                            height: 250px;
                        }

                        .input-group {
                            display: flex;
                            flex-direction: row;
                            align-items: center;
                            gap: 10px;
                            /* Adds space between form elements */
                        }

                        .input-group .form-group {
                            flex: 1;
                            /* Allows each form group to grow */
                        }

                        .input-group button {
                            white-space: nowrap;
                            /* Prevents the button text from wrapping */
                        }
                    </style>
                </head>

                <body>
                    <nav class="navbar navbar-dark bg-danger fixed-top" style="z-index: 10;">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="#">Quản lý điểm</a>
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
                                            <a class="nav-link" aria-current="page" href="dashboard.htm">Thông tin giảng
                                                viên
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link active" href="points.htm">chỉnh điểm</a>
                                        </li>

                                        <c:if test="${role == 'admin'}">
                                            <li class="nav-item">
                                                <a class="nav-link" href="student-management.htm">Nhập/ xóa Sinh
                                                    viên</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="announcement.htm">Thông báo</a>
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
                    <div class="container" style="z-index: 1;">
                        <form action="timkiemdiem.htm" method="post">
                            <div class="input-group mb-3">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="nienkhoa" name="nienkhoa"
                                        placeholder="Niên khóa">
                                </div>
                                <div class="form-group">
                                    <select class="form-control" id="hocky" name="hocky">
                                        <option value="1">Học kỳ 1</option>
                                        <option value="2">Học kỳ 2</option>
                                        <option value="3">Học kỳ Hè</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <select class="form-control" id="monhoc" name="monhoc">
                                        <c:forEach items="${monhocList}" var="subject">
                                            <option value="${subject.MAMH}">${subject.TENMH}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input type="number" class="form-control" id="nhom" name="nhom"
                                        placeholder="Nhập Nhóm" max="10" min="1">
                                </div>
                                <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                            </div>
                        </form>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Mã sinh viên</th>
                                    <th>Họ tên sinh viên</th>
                                    <th>Điểm chuyên cần</th>
                                    <th>Điểm giữa kỳ</th>
                                    <th>Điểm cuối kỳ</th>
                                    <th>Điểm tổng kết</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="p" items="${points}">
                                    <c:choose>
                                        <c:when test="${role == 'KHOA'}">
                                            <c:if test="${fn:trim(lop.MAKHOA) == site}">
                                                <tr>
                                                    <form action="updatepoint.htm" method="post">
                                                        <input type="hidden" name="masv" value="${p.MASV}">
                                                        <input type="hidden" name="maltc" value="${p.MALTC}">
                                                        <td>${p.MASV}</td>
                                                        <td>${p.HOTEN}</td>
                                                        <td><input type="number" class="form-control" id="diemcc"
                                                                name="diemcc" value="${p.DIEM_CC}" max="10" min="0">
                                                        </td>
                                                        <td><input type="number" class="form-control" id="diemgk"
                                                                name="diemgk" value="${p.DIEM_GK}" max="10" min="0">
                                                        </td>
                                                        <td><input type="number" class="form-control" id="diemck"
                                                                name="diemck" value="${p.DIEM_CK}" max="10" min="0">
                                                        </td>
                                                        <td>${p.DIEM_CC * 0.1 + p.DIEM_GK * 0.3 + p.DIEM_CK * 0.6}</td>
                                                        <td>
                                                            <button class="btn btn-primary" type="submit">Lưu</button>
                                                        </td>
                                                    </form>
                                                </tr>
                                            </c:if>
                                        </c:when>
                                        <c:when test="${role == 'PGV'}">
                                            <tr>
                                                <form action="updatepoint.htm" method="post">
                                                    <input type="hidden" name="masv" value="${p.MASV}">
                                                    <input type="hidden" name="maltc" value="${p.MALTC}">
                                                    <td>${p.MASV}</td>
                                                    <td>${p.HOTEN}</td>
                                                    <td><input type="number" class="form-control" id="diemcc"
                                                            name="diemcc" value="${p.DIEM_CC}" max="10" min="0"></td>
                                                    <td><input type="text" class="form-control" id="diemgk"
                                                            name="diemgk" value="${p.DIEM_GK}"
                                                            pattern="^(10|10.0|10.00|[0-9]|0\.\d{1,2}|[1-9]\.\d{1,2})$"
                                                            title="Điểm nằm trong khoảng [1:10]"></td>
                                                    <td><input type="text" class="form-control" id="diemck"
                                                            name="diemck" value="${p.DIEM_CK}"
                                                            pattern="^(10|10.0|10.00|[0-9]|0\.\d{1,2}|[1-9]\.\d{1,2})$"
                                                            title="Điểm nằm trong khoảng [1:10]"></td>
                                                    <td>
                                                        <fmt:formatNumber
                                                            value="${p.DIEM_CC * 0.1 + p.DIEM_GK * 0.3 + p.DIEM_CK * 0.6}"
                                                            maxFractionDigits="2" pattern="#.##" />
                                                    </td>
                                                    <td>
                                                        <button class="btn btn-primary" type="submit">Lưu</button>
                                                    </td>
                                                </form>
                                            </tr>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="modal fade" id="UpdatePointModal" tabindex="-1"
                            aria-labelledby="UpdatePointModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="UpdatePointModalLabel">Chi tiết</h5>
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
                                var passwordUpdateMsg = "${UpdatePointMsg}";
                                if (passwordUpdateMsg !== '') {
                                    document.querySelector('#UpdatePointModal .modal-body').textContent = passwordUpdateMsg;

                                    var passwordUpdateModal = new bootstrap.Modal(document.getElementById('UpdatePointModal'), {});
                                    passwordUpdateModal.show();
                                }
                            });
                        </script>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                            crossorigin="anonymous"></script>
                    </div>
                </body>

                </html>