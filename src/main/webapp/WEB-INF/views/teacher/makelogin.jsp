<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Quản lý điểm sinh viên tín chỉ</title>
                    <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                        crossorigin="anonymous">
                </head>

                <body>
                    <nav class="navbar navbar-dark bg-danger fixed-top navbar-fixed-top">
                        <div class="container-fluid">
                            <a class="navbar-brand">Tạo login</a>
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
                                                    <a class="nav-link active" aria-current="page" href="dashboard.htm">Thông tin giảng viên</a>
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
                                                    <a class="nav-link" href="reportDSLTC.htm">In danh sách lớp tín chỉ</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="reportDSSVLTC.htm">In danh sách đăng ký lớp tín chỉ</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="reportPHIEUDIEMSV.htm">In phiếu điểm</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="taologin.htm">Tạo tài khoản</a>
                                                </li>
                                            </c:when>
                                            <c:when test="${role == 'PKT'}">
                                                <li class="nav-item">
                                                    <a class="nav-link" href="fee.htm">Xem học phí</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="reportHOCPHI.htm">In danh sách đóng học phí</a>
                                                </li>
                                            </c:when>
                                        </c:choose>
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
                        <div class="row justify-content-center">
                            <div class="col-md-6">
                                <div class="card mt-5">
                                    <div class="card-body">
                                        <form action="makelogin-action.htm" method="post">
                                            <div class="mb-3">
                                                <label for="magvDropdown" class="form-label">Mã giảng viên</label>
                                                <select class="form-select" id="magvDropdown" name="LGNAME">
                                                    <c:forEach var="teacher" items="${allmagv}">
                                                        <option value="${teacher.MAGV}">${teacher.MAGV}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="passwordInput" class="form-label">Mật khẩu</label>
                                                <input type="password" class="form-control" id="passwordInput"
                                                    name="PASSWORD">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Vai trò</label>
                                                <c:choose>
                                                    <c:when test="${role == 'PGV'}">
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio" name="ROLE"
                                                                id="role1" value="PGV">
                                                            <label class="form-check-label" for="role1">
                                                                Phòng giáo vụ
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio" name="ROLE"
                                                                id="role2" value="KHOA">
                                                            <label class="form-check-label" for="role2">
                                                                Khoa
                                                            </label>
                                                        </div>

                                                    </c:when>
                                                    <c:when test="${role == 'KHOA'}">
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio" name="ROLE"
                                                                id="role2" value="KHOA">
                                                            <label class="form-check-label" for="role2">
                                                                Khoa
                                                            </label>
                                                        </div>
                                                    </c:when>
                                                    <c:when test="${role == 'PKT'}">
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio" name="ROLE"
                                                                id="role2" value="PKT">
                                                            <label class="form-check-label" for="role3">
                                                                Phòng kế toán
                                                            </label>
                                                        </div>
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="UpdatePointModal" tabindex="-1" aria-labelledby="UpdatePointModalLabel"
                        aria-hidden="true">
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
                            var passwordUpdateMsg = "${message}";
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
                </body>

                </html>