<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

                    .header {
                        display: flex;
                        align-items: left;
                        justify-content: left;
                        margin-bottom: 20px;
                    }

                    body {
                        font-family: 'Poppins', sans-serif;
                        background: #ececec;
                        margin-top: 10px;
                        padding-top: 5px;
                    }

                    .department-name {
                        text-align: left;
                        font-size: 24px;
                        font-weight: bold;
                    }

                    .offcanvas {
                        width: 350px !important;
                    }

                    .navbar-fixed-top {
                        z-index: 2;
                    }

                    .navbar-offcanvas {
                        z-index: 1;
                    }

                    .search-bar {
                        display: flex;
                        align-items: left;
                        justify-content: left;
                        margin-top: 10px;
                    }

                    .search-input {
                        width: 150px;
                        margin-right: 10px;
                    }

                    .center-text {
                        text-align: center;
                    }
                </style>
            </head>

            <body>
                <nav class="navbar navbar-dark bg-danger fixed-top navbar-fixed-top">
                    <div class="container-fluid">
                        <a class="navbar-brand">Danh sách lớp tín chỉ</a>
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
                                                <a class="nav-link active" href="creditclass-management.htm">Chỉnh sửa lớp tín chỉ</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="subject-management.htm">Chỉnh sửa môn</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="points-management.htm">Chỉnh sửa điểm</a>
                                            </li>
                                        </c:when>
                                        <c:when test="${role == 'PKT'}">
                                            <li class="nav-item">
                                                <a class="nav-link" href="fee.htm">Xem học phí</a>
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

                <div class="container mt-5">
                    <div class="header">
                        <!-- Button to trigger offcanvas -->
                        <button class="btn btn-success me-2" type="button" data-bs-toggle="offcanvas"
                            data-bs-target="#offcanvasAddStudent" aria-controls="offcanvasAddStudent">
                            +
                        </button>
                    </div>

                    <!-- Add new class with spring form -->
                    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasAddStudent"
                        aria-labelledby="offcanvasAddStudentLabel">
                        <div class="offcanvas-header">
                            <h5 class="offcanvas-title" id="offcanvasAddStudentLabel">Thêm lớp</h5>
                            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                                aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body">
                            <form action="insertltc.htm" method="post">
                                <div class="mb-3">
                                    <label for="nienkhoa" class="form-label">Niên khóa</label>
                                    <input type="text" class="form-control" name="NIENKHOA" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label for="hocky" class="form-label">Học kỳ</label>
                                    <input type="number" class="form-control" name="HOCKY" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label for="mamh" class="form-label">Mã môn học</label>
                                    <input type="text" class="form-control" name="MAMH" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label for="nhom" class="form-label">Nhóm</label>
                                    <input type="number" class="form-control" name="NHOM" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label for="magv" class="form-label">Mã giảng viên</label>
                                    <input type="text" class="form-control" name="MAGV" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label for="makhoa" class="form-label">Mã khoa</label>
                                    <input type="text" class="form-control" name="MAKHOA" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label for="sosvtoithieu" class="form-label">Số sinh viên tối thiểu</label>
                                    <input type="text" class="form-control" name="SOSVTOITHIEU" required="true" />
                                </div>
                                <div class="d-grid gap-2 justify-content-center">
                                    <button type="submit" class="btn btn-primary">Thêm</button>
                                </div>
                            </form>
                        </div>
                    </div>

                <div class="container mt-5">
                    <div style="height: 620px; overflow: auto;">
                        <table class="table table-striped table-hover table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th class="center-text">Mã lớp tín chỉ</th>
                                    <th class="center-text">Niên khóa</th>
                                    <th class="center-text">Học kỳ</th>
                                    <th class="center-text">Mã môn</th>
                                    <th class="center-text">Nhóm</th>
                                    <th class="center-text">Mã giảng viên</th>
                                    <th class="center-text">Mã khoa</th>
                                    <th class="center-text">Số sinh viên tối thiểu</th>
                                    <th colspan="3" style="text-align: center;">Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="ltc" items="${AllLTCList}" varStatus="loop">
                                    <c:choose>
                                        <c:when test="${role == 'KHOA'}">
                                            <c:if test="${fn:trim(ltc.MAKHOA) == site}">
                                                <tr>
                                                    <td class="center-text">${ltc.MALTC}</td>
                                                    <td class="center-text">${ltc.NIENKHOA}</td>
                                                    <td class="center-text">${ltc.HOCKY}</td>
                                                    <td class="center-text">${ltc.MAMH}</td>
                                                    <td class="center-text">${ltc.NHOM}</td>
                                                    <td class="center-text">${ltc.MAGV}</td>
                                                    <td class="center-text">${ltc.MAKHOA}</td>
                                                    <td class="center-text">${ltc.SOSVTOITHIEU}</td>
                                                    <td>
                                                        <div class="d-flex justify-content-center">
                                                            <button class="btn btn-primary me-2" type="button"
                                                                data-bs-toggle="offcanvas"
                                                                data-bs-target="#offcanvasEditClass${loop.index}"
                                                                aria-controls="offcanvasEditClass${loop.index}">
                                                                Cập nhật
                                                            </button>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex justify-content-center">
                                                            <a href="deleteltc.htm?maltc=${ltc.MALTC}&makhoa=${ltc.MAKHOA}"
                                                                class="btn btn-danger">Xóa</a>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:when>
                                        <c:when test="${role == 'PGV'}">
                                            <tr>
                                                <td class="center-text">${ltc.MALTC}</td>
                                                <td class="center-text">${ltc.NIENKHOA}</td>
                                                <td class="center-text">${ltc.HOCKY}</td>
                                                <td class="center-text">${ltc.MAMH}</td>
                                                <td class="center-text">${ltc.NHOM}</td>
                                                <td class="center-text">${ltc.MAGV}</td>
                                                <td class="center-text">${ltc.MAKHOA}</td>
                                                <td class="center-text">${ltc.SOSVTOITHIEU}</td>
                                                <td>
                                                    <div class="d-flex justify-content-center">
                                                        <button class="btn btn-primary me-2" type="button"
                                                            data-bs-toggle="offcanvas"
                                                            data-bs-target="#offcanvasEditClass${loop.index}"
                                                            aria-controls="offcanvasEditClass${loop.index}">
                                                            Cập nhật
                                                        </button>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="d-flex justify-content-center">
                                                        <a href="deleteltc.htm?maltc=${ltc.MALTC}&makhoa=${ltc.MAKHOA}"
                                                            class="btn btn-danger">Xóa</a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:when>
                                    </c:choose>
                                    <div class="offcanvas offcanvas-end" tabindex="-1"
                                            id="offcanvasEditClass${loop.index}"
                                            aria-labelledby="offcanvasEditClassLabel">
                                            <div class="offcanvas-header">
                                                <h5 class="offcanvas-title" id="offcanvasEditClassLabel">Sửa lớp</h5>
                                                <button type="button" class="btn-close text-reset"
                                                    data-bs-dismiss="offcanvas" aria-label="Close"></button>
                                            </div>
                                            <div class="offcanvas-body">
                                                <form action="updateltc.htm" method="post">
                                                    <div class="mb-3">
                                                        <label for="maltc" class="form-label">Mã lớp tín chỉ</label>
                                                        <input type="number" class="form-control" name="MALTC"
                                                            required="true" value="${ltc.MALTC}" readonly/>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="nienkhoa" class="form-label">Niên khóa</label>
                                                        <input type="text" class="form-control" name="NIENKHOA"
                                                            required="true" value="${ltc.NIENKHOA}" />
                                                        </ <div class="mb-3">
                                                        <label for="hocky" class="form-label">Học kỳ</label>
                                                        <input type="number" class="form-control" name="HOCKY"
                                                            required="true" value="${ltc.HOCKY}" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="nhom" class="form-label">Nhóm</label>
                                                        <input type="number" class="form-control" name="NHOM"
                                                            required="true" value="${ltc.NHOM}" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="sosvtoithieu" class="form-label">Số sinh viên tối thiểu</label>
                                                        <input type="number" class="form-control" name="SOSVTOITHIEU"
                                                            required="true" value="${ltc.SOSVTOITHIEU}" />
                                                    </div>
                                                    <div class="d-grid gap-2 justify-content-center">
                                                        <button type="submit" class="btn btn-warning">Sửa</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="modal fade" id="InsertLTCModal" tabindex="-1" aria-labelledby="InsertLTCModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="InsertLTCModalLabel">Thông báo</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="UpdateLTCModal" tabindex="-1" aria-labelledby="UpdateLTCModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="UpdateLTCModalLabel">Thông báo</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="deleteLTCModal" tabindex="-1" aria-labelledby="deleteLTCModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="deleteLTCModalLabel">Thông báo</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
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
                        var passwordUpdateMsg = "${InsertLTCMsg}";
                        if (passwordUpdateMsg !== '') {
                            document.querySelector('#InsertLTCModal .modal-body').textContent = passwordUpdateMsg;

                            var passwordUpdateModal = new bootstrap.Modal(document.getElementById('InsertLTCModal'), {});
                            passwordUpdateModal.show();
                        }
                    });
                    
                    document.addEventListener('DOMContentLoaded', (event) => {
                        var passwordUpdateMsg = "${DeleteLTCtMsg}";
                        if (passwordUpdateMsg != "") {
                            var myModal = new bootstrap.Modal(document.getElementById('deleteLTCModal'), {
                                keyboard: false
                            });
                            myModal.show();
                        }
                    });

                    document.addEventListener('DOMContentLoaded', (event) => {
                        var passwordUpdateMsg = "${UpdateLTCMsg}";
                        if (passwordUpdateMsg !== '') {
                            document.querySelector('#UpdateLTCModal .modal-body').textContent = passwordUpdateMsg;

                            var passwordUpdateModal = new bootstrap.Modal(document.getElementById('UpdateLTCModal'), {});
                            passwordUpdateModal.show();
                        }
                    });
                </script>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
            </body>

            </html>