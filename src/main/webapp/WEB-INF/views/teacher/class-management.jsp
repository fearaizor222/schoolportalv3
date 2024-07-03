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
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                        crossorigin="anonymous">

                    <style>
                        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

                        .header {
                            display: flex;
                            align-items: left;
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
                    </style>
                </head>

                <body>
                    <nav class="navbar navbar-dark bg-danger fixed-top navbar-fixed-top" style="z-index: 100;">
                        <div class="container-fluid">
                            <a class="navbar-brand">Danh sách lớp</a>
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
                                                    <a class="nav-link active" href="class-management.htm">Chỉnh sửa lớp</a>
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
                                                    <a class="nav-link" href="fee.htm">Xem học phí</a>
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
                    <div class="container mt-5">
                        <div class="header">
                            <a class="btn btn-danger me-2" href="dashboard.htm">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-arrow-return-left" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
                                        d="M14.5 1.5a.5.5 0 0 1 .5.5v4.8a2.5 2.5 0 0 1-2.5 2.5H2.707l3.347 3.346a.5.5 0 0 1-.708.708l-4.2-4.2a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 8.3H12.5A1.5 1.5 0 0 0 14 6.8V2a.5.5 0 0 1 .5-.5" />
                                </svg>
                            </a>
                            <button class="btn btn-success me-2" type="button" data-bs-toggle="offcanvas"
                                data-bs-target="#offcanvasAddClass" aria-controls="offcanvasAddClass">
                                +
                            </button>
                        </div>

                        <!-- Add new class with spring form -->
                        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasAddClass"
                            aria-labelledby="offcanvasAddClassLabel">
                            <div class="offcanvas-header">
                                <h5 class="offcanvas-title" id="offcanvasAddClassLabel">Thêm lớp</h5>
                                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                                    aria-label="Close"></button>
                            </div>
                            <div class="offcanvas-body">
                                <form action="insertclass.htm" method="post">
                                    <div class="mb-3">
                                        <label for="malop" class="form-label">Mã lớp</label>
                                        <input type="text" class="form-control" name="MALOP" required="true" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="tenlop" class="form-label">Tên lớp</label>
                                        <input type="text" class="form-control" name="TENLOP" required="true" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="khoahoc" class="form-label">Khóa học</label>
                                        <input type="text" class="form-control" name="KHOAHOC" required="true" />
                                    </div>
                                    <c:choose>
                                        <c:when test="${role == 'KHOA'}">
                                            <input type="hidden" name="MAKHOA" value="${site}" />
                                        </c:when>
                                        <c:when test="${role == 'PGV'}">
                                            <div class="mb-3">
                                                <label for="makhoa" class="form-label">Mã khoa</label>
                                                <select class="form-control" name="MAKHOA" required="true">
                                                    <c:forEach var="khoa" items="${toanbokhoa}">
                                                        <option value="${khoa.MAKHOA}">${khoa.TENKHOA}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </c:when>
                                    </c:choose>

                                    <div class="d-grid gap-2 justify-content-center">
                                        <button type="submit" class="btn btn-primary">Thêm</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="container mt-5">
                        <div style="height: 550px; overflow: auto;">
                            <table class="table table-striped table-hover table-bordered">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Khoa</th>
                                        <th>Mã lớp</th>
                                        <th>Tên lớp</th>
                                        <th>Khóa học</th>
                                        <th colspan="3" style="text-align: center;">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="lop" items="${dsLop}" varStatus="loop">
                                        <c:choose>
                                            <c:when test="${role == 'KHOA'}">
                                                <c:if test="${fn:trim(lop.MAKHOA) == site}">
                                                    <tr>
                                                        <td>${lop.TENKHOA}</td>
                                                        <td>${lop.MALOP}</td>
                                                        <td>${lop.TENLOP}</td>
                                                        <td>${lop.KHOAHOC}</td>
                                                        <td>
                                                            <div class="d-flex justify-content-center">
                                                                <a class="btn btn-secondary"
                                                                    href="student-management.htm?malop=${lop.MALOP}">Chi
                                                                    tiết</a>
                                                            </div>
                                                        </td>
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
                                                                <a href="deleteclass.htm?malop=${lop.MALOP}&makhoa=${lop.MAKHOA}"
                                                                    class="btn btn-danger">Xóa</a>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:if>
                                            </c:when>
                                            <c:when test="${role == 'PGV'}">
                                                <tr>
                                                    <td>${lop.TENKHOA}</td>
                                                    <td>${lop.MALOP}</td>
                                                    <td>${lop.TENLOP}</td>
                                                    <td>${lop.KHOAHOC}</td>
                                                    <td>
                                                        <div class="d-flex justify-content-center">
                                                            <a class="btn btn-secondary"
                                                                href="student-management.htm?malop=${lop.MALOP}">Chi
                                                                tiết</a>
                                                        </div>
                                                    </td>
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
                                                            <a href="deleteclass.htm?malop=${lop.MALOP}&makhoa=${lop.MAKHOA}"
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
                                                <form action="updateclass.htm" method="post">
                                                    <div class="mb-3">
                                                        <label for="malop" class="form-label">Mã lớp</label>
                                                        <input type="text" class="form-control" name="MALOP"
                                                            required="true" value="${lop.MALOP}" readonly />
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="tenlop" class="form-label">Tên lớp</label>
                                                        <input type="text" class="form-control" name="TENLOP"
                                                            required="true" value="${lop.TENLOP}" />
                                                        </ <div class="mb-3">
                                                        <label for="khoahoc" class="form-label">Khóa học</label>
                                                        <input type="text" class="form-control" name="KHOAHOC"
                                                            required="true" value="${lop.KHOAHOC}" />
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
                    <div class="modal fade" id="InsertClassModal" tabindex="-1" aria-labelledby="InsertClassModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="InsertClassModalLabel">Chi tiết</h5>
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
                    <div class="modal fade" id="DeleteClassModal" tabindex="-1" aria-labelledby="DeleteClassModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="DeleteClassModalLabel">Chi tiết</h5>
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
                    <div class="modal fade" id="UpdateClassModal" tabindex="-1" aria-labelledby="UpdateClassModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="UpdateClassModalLabel">Chi tiết</h5>
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
                            var passwordUpdateMsg = "${InsertClassMsg}";
                            if (passwordUpdateMsg !== '') {
                                document.querySelector('#InsertClassModal .modal-body').textContent = passwordUpdateMsg;

                                var passwordUpdateModal = new bootstrap.Modal(document.getElementById('InsertClassModal'), {});
                                passwordUpdateModal.show();
                            }
                        });
                        document.addEventListener('DOMContentLoaded', (event) => {
                            var passwordUpdateMsg = "${DeleteClassMsg}";
                            if (passwordUpdateMsg !== '') {
                                document.querySelector('#DeleteClassModal .modal-body').textContent = passwordUpdateMsg;

                                var passwordUpdateModal = new bootstrap.Modal(document.getElementById('DeleteClassModal'), {});
                                passwordUpdateModal.show();
                            }
                        });
                        document.addEventListener('DOMContentLoaded', (event) => {
                            var passwordUpdateMsg = "${UpdateClassMsg}";
                            if (passwordUpdateMsg !== '') {
                                document.querySelector('#UpdateClassModal .modal-body').textContent = passwordUpdateMsg;

                                var passwordUpdateModal = new bootstrap.Modal(document.getElementById('UpdateClassModal'), {});
                                passwordUpdateModal.show();
                            }
                        });
                    </script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>
                </body>

                </html>