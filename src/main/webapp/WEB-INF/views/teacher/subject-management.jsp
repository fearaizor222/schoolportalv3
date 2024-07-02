<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quản lý môn học</title>
    <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

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
    </style>
</head>

<body>
    <nav class="navbar navbar-dark bg-danger fixed-top navbar-fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand">Danh sách môn</a>
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
    <div class="container mt-5">
        <div class="header">
            <!-- Button to trigger offcanvas for adding -->
            <button class="btn btn-primary me-2" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasAddSubject" aria-controls="offcanvasAddSubject">
                Thêm
            </button>
            <!-- Button to trigger offcanvas for deleting -->
            <button class="btn btn-danger me-2" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasDeleteSubject" aria-controls="offcanvasDeleteSubject">
                Xoá
            </button>
            <!-- Button to trigger offcanvas for editing -->
            <button class="btn btn-warning me-2" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasEditSubject" aria-controls="offcanvasEditSubject">
                Sửa
            </button>
            <!-- Button to trigger offcanvas for restoring -->
            <button class="btn btn-info me-2" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasRestoreSubject" aria-controls="offcanvasRestoreSubject">
                Phục hồi
            </button>
        </div>
    </div>

    <style>
        .buttons-container {
            display: flex;
            justify-content: center;
            gap: 10px; /* Khoảng cách giữa các nút */
            padding: 20px;
        }
    
        .btn {
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            outline: none;
            color: white; /* Màu chữ cho nút Thoát */
            background-color: #6c757d; /* Màu nền cho nút Thoát */
        }
    
        .btn:hover {
            opacity: 0.8;
        }
    
        .btn-primary {
            background-color: #007bff;
        }
    
        .btn-primary:hover {
            background-color: #0056b3;
        }
    
        .btn-warning {
            background-color: #ffc107;
            color: black;
        }
    
        .btn-warning:hover {
            background-color: #e0a800;
        }

        .btn-danger {
            background-color: #dc3545;
        }

        .btn-danger:hover {
            background-color: #a71d2a;
        }

        .btn-success {
            background-color: #28a745;
        }

        .btn-success:hover {
            background-color: #1e7e34;
        }

        .btn-info {
            background-color: #17a2b8;
        }
    </style>

    
    <div class="container mt-5" style="height: 550px; overflow: auto;">
        <table class="table table-striped table-hover table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Mã môn</th>
                    <th>Tên môn</th>
                    <th>Số tiết lý thuyết</th>
                    <th>Số tiết thực hành</th>
                    <th>Số tín chỉ</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="subject" items="${dsMonHoc}">
                    <tr>
                        <td>${subject.MAMH}</td>
                        <td>${subject.TENMH}</td>
                        <td>${subject.SOTIET_LT}</td>
                        <td>${subject.SOTIET_TH}</td>
                        <td>${subject.SOTINCHI}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!--Form insertsubject-->
    <div class="modal fade" id="InsertSubjectModal" tabindex="-1" aria-labelledby="InsertSubjectModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="InsertSubjectModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <p>${InsertSubjectMsg}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasAddSubject" aria-labelledby="offcanvasAddSubjectLabel">
            <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasAddSubjectLabel">Thêm môn học</h5>
                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
            <form action="insertsubject.htm" method="post">
                    <div class="mb-3">
                    <label class="form-label">Mã môn</label>
                    <input type="text" class="form-control" name="MAMH" required="true" >
                    </div>
                    <div class="mb-3">
                    <label  class="form-label">Tên môn</label>
                    <input type="text" class="form-control" name="TENMH" required="true">
                    </div>
                    <div class="mb-3">
                    <label  class="form-label">Số tiết lý thuyết</label>
                    <input type="text" class="form-control" name="SOTIET_LT" required="true">
                    </div>
                    <div class="mb-3">
                    <label  class="form-label">Số tiết thực hành</label>
                    <input type="text" class="form-control" name="SOTIET_TH" required="true">
                    </div>
                    <div class="mb-3">
                    <label  class="form-label">Số tín chỉ</label>
                    <input type="text" class="form-control" name="SOTINCHI" required="true">
                    </div>
                        <button type="submit" class="btn btn-primary">Thêm</button>
            </form>
        </div>
    </div>
    <!--Form deleteMonHoc-->
        <!-- Thông báo -->
    <div class="modal fade" id="deleteSubjectModal" tabindex="-1" aria-labelledby="deleteSubjectModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteSubjectModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <p>${DeleteSubjectMsg}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasDeleteSubject" aria-labelledby="offcanvasDeleteSubjectLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasDeleteSubjectLabel">Xoá môn học</h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <form action="deletesubject.htm" method="post">
                <div class="mb-3">
                    <label for="mamh" class="form-label">Mã môn</label>
                    <input type="text" class="form-control" name="MAMH" required="true">
                </div>
                    <button type="submit" class="btn btn-danger">Xoá</button>
                </form>
            </div>
        </div>
    </div>
    <!--Form updateMonHoc-->
    <div class="modal fade" id="updateSubjectModal" tabindex="-1" aria-labelledby="updateSubjectModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateSubjectModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body
                    text-center">
                    <p>${UpdateSubjectMsg}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasEditSubject" aria-labelledby="offcanvasEditSubjectLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasEditSubjectLabel">Sửa môn học</h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <form action="updatesubject.htm" method="post">
                <div class="mb-3">
                    <label for="mamh" class="form-label">Mã môn</label>
                    <input type="text" class="form-control" name="MAMH" required="true">
                </div>
                <div class="mb-3">
                    <label for="tenmh" class="form-label">Tên môn</label>
                    <input type="text" class="form-control" name="TENMH" required="true">
                </div>
                <div class="mb-3">
                    <label for="sotiet_lt" class="form-label">Số tiết lý thuyết</label>
                    <input type="text" class="form-control" name="SOTIET_LT" required="true">
                </div>
                <div class="mb-3">
                    <label for="sotiet_th" class="form-label">Số tiết thực hành</label>
                    <input type="text" class="form-control" name="SOTIET_TH" required="true">
                </div>
                <div class="mb-3">
                    <label for="sotinchi" class="form-label">Số tín chỉ</label>
                    <input type="text" class="form-control" name="SOTINCHI" required="true">
                </div>
                <button type="submit" class="btn btn-warning">Sửa</button>
            </form>
        </div>
    </div>
    
            <footer class="navbar fixed-bottom bg-danger" style="z-index: 1;">
            </footer>
        <div class="container text-center">
            <span class="text-light">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Thư</span>
        </div>
    </footer>

    <script>
        document.addEventListener('DOMContentLoaded', (event) => {
            var passwordUpdateMsg = "${InsertSubjectMsg}";
            if (passwordUpdateMsg != "") {
                var myModal = new bootstrap.Modal(document.getElementById('InsertSubjectModal'), {
                    keyboard: false
                });
                myModal.show();
            }
        });

        document.addEventListener('DOMContentLoaded', (event) => {
            var passwordUpdateMsg = "${DeleteSubjectMsg}";
            if (passwordUpdateMsg != "") {
                var myModal = new bootstrap.Modal(document.getElementById('deleteSubjectModal'), {
                    keyboard: false
                });
                myModal.show();
            }
        });

        document.addEventListener('DOMContentLoaded', (event) => {
            var passwordUpdateMsg = "${UpdateSubjectMsg}";
            if (passwordUpdateMsg != "") {
                var myModal = new bootstrap.Modal(document.getElementById('updateSubjectModal'), {
                    keyboard: false
                });
                myModal.show();
            }
        });

    </script>
    <!-- Include Bootstrap JS and its dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>