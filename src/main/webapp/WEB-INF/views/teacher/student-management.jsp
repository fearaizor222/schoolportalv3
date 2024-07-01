<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Danh sách sinh viên</title>
                <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
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
                <nav class="navbar navbar-dark bg-danger fixed-top" style="z-index: 2;">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Quản lý sinh viên</a>
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
                                            <a class="nav-link active" href="student-management.htm">Nhập/xóa Sinh
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

                <div class="container mt-5">
                    <div class="header">
                        <a class="btn btn-danger me-2" href="class-management.htm">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-arrow-return-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                    d="M14.5 1.5a.5.5 0 0 1 .5.5v4.8a2.5 2.5 0 0 1-2.5 2.5H2.707l3.347 3.346a.5.5 0 0 1-.708.708l-4.2-4.2a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 8.3H12.5A1.5 1.5 0 0 0 14 6.8V2a.5.5 0 0 1 .5-.5" />
                            </svg>
                        </a>
                        <button class="btn btn-success me-2" type="button" data-bs-toggle="offcanvas"
                            data-bs-target="#offcanvasAddStudent" aria-controls="offcanvasAddStudent">
                            +
                        </button>
                    </div>
                    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasAddStudent"
                        aria-labelledby="offcanvasAddStudentLabel">
                        <div class="offcanvas-header">
                            <h5 class="offcanvas-title" id="offcanvasAddStudentLabel">Thêm sinh viên</h5>
                            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                                aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body">
                            <form action="insertsv.htm" method="post">
                                <div class="mb-3">
                                    <label class="form-label">Mã sinh viên</label>
                                    <input type="text" class="form-control" name="MASV" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Họ</label>
                                    <input type="text" class="form-control" name="HO" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Tên</label>
                                    <input type="text" class="form-control" name="TEN" required="true" />
                                </div>
                                <div class="mb-3 d-flex align-items-center">
                                    <label class="form-label">Phái:</label>
                                    <div>
                                        <input type="radio" id="male" name="PHAI" value="0" required>
                                        <label for="male">Nam</label>
                                    </div>
                                    <div>
                                        <input type="radio" id="female" name="PHAI" value="1" required>
                                        <label for="female">Nữ</label>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Địa chỉ</label>
                                    <input type="text" class="form-control" name="DIACHI" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Ngày sinh</label>
                                    <input type="date" class="form-control" name="NGAYSINH" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Mật khẩu</label>
                                    <input type="text" class="form-control" name="PASSWORD" required="true" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Mã lớp</label>
                                    <input type="text" class="form-control" name="MALOP" required="true"
                                        value="${malop}" readonly />
                                </div>
                                <div class="d-grid gap-2 justify-content-center">
                                    <button type="submit" class="btn btn-primary">Thêm</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <table class="table table-bordered rounded-table">
                        <thead class="table-light">
                            <tr>
                                <th>Mã SV</th>
                                <th>Họ tên</th>
                                <th>Phái</th>
                                <th>Địa chỉ</th>
                                <th>Ngày sinh</th>
                                <th>Mã Lớp</th>
                                <th>Đã nghỉ học</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="sinhvien" items="${dsSV}" varStatus="loop">
                                <tr>
                                    <td>${sinhvien.MASV}</td>
                                    <td>${sinhvien.HO.concat(' ').concat(sinhvien.TEN)}</td>
                                    <td>${sinhvien.PHAI ? "Nữ" : "Nam"}</td>
                                    <td>${sinhvien.DIACHI}</td>
                                    <td>${sinhvien.NGAYSINH}</td>
                                    <td>${sinhvien.MALOP}</td>
                                    <td>${sinhvien.DANGHIHOC ? "Có" : "Không"}</td>
                                    <td>
                                        <div class="d-flex justify-content-center">
                                            <button class="btn btn-primary me-2" type="button"
                                                data-bs-toggle="offcanvas"
                                                data-bs-target="#offcanvasEditStudent${loop.index}"
                                                aria-controls="offcanvasEditStudent${loop.index}">
                                                Cập nhật
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                                <div class="offcanvas offcanvas-end" tabindex="-1"
                                    id="offcanvasEditStudent${loop.index}" aria-labelledby="offcanvasEditStudentLabel">
                                    <div class="offcanvas-header">
                                        <h5 class="offcanvas-title" id="offcanvasEditStudentLabel">Sửa sinh viên</h5>
                                        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                                            aria-label="Close"></button>
                                    </div>
                                    <div class="offcanvas-body">
                                        <form action="updatesv.htm" method="post">
                                            <div class="mb-3">
                                                <label class="form-label">Mã sinh viên</label>
                                                <input type="text" class="form-control" name="MASV" required="true" value="${sinhvien.MASV}" readonly/>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Họ</label>
                                                <input type="text" class="form-control" name="HO" value="${sinhvien.HO}" required="true" />
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Tên</label>
                                                <input type="text" class="form-control" name="TEN" value="${sinhvien.TEN}" required="true" />
                                            </div>
                                            <div class="mb-3 d-flex align-items-center">
                                                <label class="form-label">Phái:</label>
                                                <div>
                                                    <input type="radio" id="male" name="PHAI" value="0" ${sinhvien.PHAI == false? 'checked':''} required>
                                                    <label for="male">Nam</label>
                                                </div>
                                                <div>
                                                    <input type="radio" id="female" name="PHAI" value="1" ${sinhvien.PHAI == true? 'checked':''} required>
                                                    <label for="female">Nữ</label>
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Địa chỉ</label>
                                                <input type="text" class="form-control" name="DIACHI" value="${sinhvien.DIACHI}" required="true" />
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Ngày sinh</label>
                                                <input type="date" class="form-control" name="NGAYSINH" value="${sinhvien.NGAYSINH}" required="true" />
                                            </div>
                                            <div class="mb-3 d-flex align-items-center">
                                                <label class="form-label">Trạng thái:</label>
                                                <div>
                                                    <input type="radio" id="male" name="DANGHIHOC" value="1" ${sinhvien.DANGHIHOC == true? 'checked':''} required>
                                                    <label for="male">Đã nghỉ học</label>
                                                </div>
                                                <div>
                                                    <input type="radio" id="female" name="DANGHIHOC" value="0" ${sinhvien.DANGHIHOC == false? 'checked':''} required>
                                                    <label for="female">Còn học</label>
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Mật khẩu</label>
                                                <input type="text" class="form-control" name="PASSWORD" value="${sinhvien.PASSWORD}" required="true" />
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Mã lớp</label>
                                                <input type="text" class="form-control" name="MALOP" required="true"
                                                    value="${malop}" readonly />
                                            </div>
                                            <div class="d-grid gap-2 justify-content-center">
                                                <button type="submit" class="btn btn-primary">Sửa</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="modal fade" id="InsertSVModal" tabindex="-1" aria-labelledby="InsertSVModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="InsertSVModalLabel">Chi tiết</h5>
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
                <div class="modal fade" id="UpdateSVModal" tabindex="-1" aria-labelledby="UpdateSVModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="UpdateSVModalLabel">Chi tiết</h5>
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
                <footer class="navbar fixed-bottom bg-danger" style="z-index: 1;">
                    <div class="container text-center">
                        <span class="text-light">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Thư</span>
                    </div>
                </footer>

                <script>
                    document.addEventListener('DOMContentLoaded', (event) => {
                        var passwordUpdateMsg = "${InsertSVMsg}";
                        if (passwordUpdateMsg !== '') {
                            document.querySelector('#InsertSVModal .modal-body').textContent = passwordUpdateMsg;

                            var passwordUpdateModal = new bootstrap.Modal(document.getElementById('InsertSVModal'), {});
                            passwordUpdateModal.show();
                        }
                    });

                    document.addEventListener('DOMContentLoaded', (event) => {
                        var passwordUpdateMsg = "${UpdateSVMsg}";
                        if (passwordUpdateMsg !== '') {
                            document.querySelector('#UpdateSVModal .modal-body').textContent = passwordUpdateMsg;

                            var passwordUpdateModal = new bootstrap.Modal(document.getElementById('UpdateSVModal'), {});
                            passwordUpdateModal.show();
                        }
                    });
                </script>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
            </body>

            </html>