<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
    <style>
        .header {
            display: flex;
            align-items: left;
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
            border-collapse: separate;
            min-width: 100%;
            background-color: rgb(247, 247, 247); 
            border-radius: 5px; 
            overflow: visible; 
            border: 2px solid #ced3da; 
        }
        .rounded-table th, .rounded-table td {
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
        /* Fix for offcanvas width */
        .offcanvas {
            width: 350px !important;
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
                                <a class="nav-link active" href="student-management.htm">Nhập/xóa Sinh viên</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="announcement.htm">Thông báo</a>
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
            <!-- Button to trigger offcanvas -->
            <button class="btn btn-primary me-2" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasAddStudent" aria-controls="offcanvasAddStudent">
                +
            </button>
            <button class="btn btn-danger me-2" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasDeleteStudent" aria-controls="offcanvasDeleteStudent">
                -
            </button>
            <button class="btn btn-warning me-2" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasEditStudent" aria-controls="offcanvasEditStudent">
                Sửa
            </button>
        </div>

        <table class="table table-bordered rounded-table">
            <thead class="table-light">
                <tr>
                    <th>Mã SV</th>
                    <th>Họ</th>
                    <th>Tên</th>
                    <th>Phái</th>
                    <th>Địa chỉ</th>
                    <th>Ngày sinh</th>
                    <th>Mã Lớp</th>
                    <th>Đã nghỉ học</th>
                    <th>Email</th>
                    <th>Link ảnh</th>
                </tr>
            </thead>
            <tbody>
<c:forEach var="sinhvien" items="${dsSINHVIEN}">
                    <tr>
<td data-masv="${sinhvien.MASV}">${sinhvien.MASV}</td>
                        <td>${sinhvien.HO}</td>
                        <td>${sinhvien.TEN}</td>
                        <td>${sinhvien.PHAI ? "Nữ" : "Nam"}</td>
                        <td>${sinhvien.DIACHI}</td>
                        <td>${sinhvien.NGAYSINH}</td>
                        <td>${sinhvien.lop.MALOP}</td>
                        <td>${sinhvien.DANGHIHOC ? "Có" : "Không"}</td>
                        <td>${sinhvien.EMAIL}</td>
                        <td><a href="${sinhvien.LINKANH}" target="_blank">Xem ảnh</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    
    <!-- Add new student with spring form -->
<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasAddStudent" aria-labelledby="offcanvasAddStudentLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasAddStudentLabel">Thêm sinh viên</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <form:form action="insertsv.htm" method="get" modelAttribute="sinhvien">
            <div class="mb-3">
                <label for="masv" class="form-label">Mã sinh viên</label>
                <form:input type="text" class="form-control" path="MASV" required="true"/>
            </div>
            <div class="mb-3">
                <label for="ho" class="form-label">Họ</label>
                <form:input type="text" class="form-control" path="HO" required="true"/>
            </div>
            <div class="mb-3">
                <label for="ten" class="form-label">Tên</label>
                <form:input type="text" class="form-control" path="TEN" required="true"/>
            </div>
            <div class="mb-3">
                <label for="phai" class="form-label">Phái</label>
                <form:select class="form-select" id="phai" path="PHAI" required="true">
                    <form:option value="true">Nữ</form:option>
                    <form:option value="false">Nam</form:option>
                </form:select>
            </div>
            <div class="mb-3">
                <label for="diachi" class="form-label">Địa chỉ</label>
                <form:input type="text" class="form-control" path="DIACHI" required="true"/>
            </div>
            <div class="mb-3">
                <label for="ngaysinh" class="form-label">Ngày sinh</label>
                <form:input type="date" class="form-control" path="NGAYSINH" required="true"/>
            </div>
            <div class="mb-3">
                <label for="malop" class="form-label">Mã lớp</label>
                <form:input type="text" class="form-control" path="lop.MALOP" required="true"/>
            </div>
            <div class="mb-3">
                <label for="danghihoc" class="form-label">Đã nghỉ học</label>
<form:select class="form-select" path="DANGHIHOC" required="true">
                    <form:option value="true">Không</form:option>
                    <form:option value="false">Có</form:option>
                </form:select>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <form:input type="email" class="form-control" path="EMAIL" required="true"/>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu</label>
                <form:input type="password" class="form-control" path="PASSWORD" required="true"/>
            </div>
            <div class="mb-3">
                <label for="linkanh" class="form-label">Link ảnh</label>
                <form:input type="text" class="form-control" path="LINKANH" required="false"/>
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form:form>
    </div>
</div>

<!-- Delete student with spring form -->
<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasDeleteStudent" aria-labelledby="offcanvasDeleteStudentLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasDeleteStudentLabel">Xóa sinh viên</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <form:form action="deletesv.htm" method="get" modelAttribute="sinhvien">
            <div class="mb-3">
                <label for="masv" class="form-label">Mã sinh viên</label>
                <form:input type="text" class="form-control" path="MASV" required="true"/>
            </div>
            <button type="submit" class="btn btn-danger">Xóa</button>
        </form:form>
    </div>
</div>
 <!-- Form to edit student -->
 <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasEditStudent" aria-labelledby="offcanvasEditStudentLabel">
    <div class="offcanvas-header"><h5 class="offcanvas-title" id="offcanvasEditStudentLabel">Sửa thông tin sinh viên</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <form:form action="editStudentAction.htm" method="post" modelAttribute="sinhvien">
            <div class="mb-3">
                <label for="masvToEdit" class="form-label">Mã sinh viên</label>
                <form:input path="MASV" type="text" class="form-control form-control-lg" id="masvToEdit" required="true" readonly="true" />
            </div>
            <div class="mb-3">
                <label for="hoToEdit" class="form-label">Họ</label>
                <form:input path="HO" type="text" class="form-control form-control-lg" id="hoToEdit" required="true" />
            </div>
            <div class="mb-3">
                <label for="tenToEdit" class="form-label">Tên</label>
                <form:input path="TEN" type="text" class="form-control form-control-lg" id="tenToEdit" required="true" />
            </div>
            <div class="mb-3">
                <label for="phaiToEdit" class="form-label">Phái</label>
                <form:select path="PHAI" class="form-select form-select-lg" id="phaiToEdit">
                    <form:option value="0">Nam</form:option>
                    <form:option value="1">Nữ</form:option>
                </form:select>
            </div>
            <div class="mb-3">
                <label for="diachiToEdit" class="form-label">Địa chỉ</label>
                <form:input path="DIACHI" type="text" class="form-control form-control-lg" id="diachiToEdit" required="true" />
            </div>
            <div class="mb-3">
                <label for="ngaysinhToEdit" class="form-label">Ngày sinh</label>
                <form:input path="NGAYSINH" type="date" class="form-control form-control-lg" id="ngaysinhToEdit" required="true" />
            </div>
            <div class="mb-3">
                <label for="malopToEdit" class="form-label">Mã lớp</label>
                <form:input path="MALOP" type="text" class="form-control form-control-lg" id="malopToEdit" required="true" />
            </div>
            <div class="mb-3">
                <label for="danghihocToEdit" class="form-label">Đã nghỉ học</label>
                <form:select path="DANGHIHOC" class="form-select form-select-lg" id="danghihocToEdit">
                    <form:option value="false">Không</form:option>
                    <form:option value="true">Có</form:option>
                </form:select>
            </div>
            <div class="mb-3">
                <label for="emailToEdit" class="form-label">Email</label>
                <form:input path="EMAIL" type="email" class="form-control form-control-lg" id="emailToEdit" required="true" />
            </div>
            <div class="mb-3">
                <label for="linkanhToEdit" class="form-label">Link ảnh</label>
                <form:input path="LINKANH" type="url" class="form-control form-control-lg" id="linkanhToEdit" required="true" />
            </div>
            <button type="submit" class="btn btn-warning">Sửa</button>
        </form:form>
    </div>
</div>


        
    <!-- Footer -->
    <footer>
        <div class="container">
            <span class="text-light" style="font-size: larger;">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Hiếu</span>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>