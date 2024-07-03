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
                    <nav class="navbar navbar-dark bg-danger fixed-top navbar-fixed-top">
                        <div class="container-fluid">
                            <a class="navbar-brand">Báo cáo</a>
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
                                                    <a class="nav-link active" href="reportDSSVLTC.htm">In danh sách đăng ký lớp tín chỉ</a>
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
                    <div class="container" style="z-index: 1;">
                        <form action="timkiemdssvloptinchi.htm" method="post">
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
                                    <input type="text" class="form-control" id="mamonhoc" name="mamonhoc" placeholder="Mã môn học">
                                </div>
                                <div class="form-group">
                                    <input type="number" class="form-control" id="nhom" name="nhom" placeholder="Nhóm">
                                </div>
                                <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                                <button class="btn btn-primary" onclick="printdiv('printable_div_id')">In ấn</button>
                            </div>
                        </form>
                        <div id='printable_div_id' style="display: none;">
                            <h1 style="text-align: center;">Khoa: ${site}</h1>
                            <h3 style="text-align: center;">Niên khóa: ${nienkhoa} Học kỳ: ${hocky}</h3>
                            <h3 style="text-align: center;">Môn học: ${mamonhoc} Nhóm: ${nhom}</h3>
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">Mã sinh viên</th>
                                        <th scope="col">Họ</th>
                                        <th scope="col">Tên</th>
                                        <th scope="col">Phái</th>
                                        <th scope="col">Mã lớp</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="sv" items="${listsvltc}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${sv.MASV}</td>
                                            <td>${sv.HO}</td>
                                            <td>${sv.TEN}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${sv.PHAI}">
                                                        Nữ
                                                    </c:when>
                                                    <c:otherwise>
                                                        Nam
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${sv.MALOP}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <h4>Số sinh viên đã đăng ký: ${listsvltc.size()}</h4>
                        </div>
                        <!-- <div class="modal fade" id="UpdatePointModal" tabindex="-1"
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
                        </div> -->
                        <footer class="navbar fixed-bottom bg-danger" style="z-index: 1;">
                            <div class="container text-center">
                                <span class="text-light">Copyright &copy; 2024 Nhóm 8 được hướng dẫn bởi thầy Thư</span>
                            </div>
                        </footer>
                        <script>
                            function printdiv(elem) {
                                old_title = document.title;
                                new_title = "Danh sách sinh viên lớp tín chỉ";
                                var new_str = document.getElementById(elem).innerHTML;
                                var old_str = document.body.innerHTML;
                                document.body.innerHTML = new_str;
                                document.title = new_title;
                                window.print();
                                document.title = old_title;
                                document.body.innerHTML = old_str;
                                return false;
                            }
                            document.addEventListener('DOMContentLoaded', (event) => {
                                var passwordUpdateMsg = "${msg}";
                                if (passwordUpdateMsg !== '') {
                                    document.getElementById('printable_div_id').style.display = 'block';
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