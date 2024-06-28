<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!doctype html>
        <html lang="en">

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Cổng thông tin sinh viên</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <!-- <link rel="stylesheet" href="/webapp/resources/loginpage/loginpage.css"> -->
            <link rel="shortcut icon" type="image/x-icon" href="/webapp/resources/logo.png">
        </head>

        <body>
            <!----------------------- Main Container -------------------------->
            <div class="container d-flex justify-content-center align-items-center min-vh-100">
                <!----------------------- Login Container -------------------------->
                <div class="row border rounded-5 p-3 bg-white shadow box-area">
                    <!--------------------------- Left Box ----------------------------->
                    <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box"
                        style="background: #ebeef8;">
                        <div class="featured-image mb-3">
                            <img src="/webapp/resources/loginpage/images/1.png" class="img-fluid" style="width: 250px;">
                        </div>
                        <p class="text-black fs-2"
                            style="font-family: 'Courier New', Courier, monospace; font-weight: 600;">PTIT</p>
                        <small class="text-black text-wrap text-center"
                            style="width: 17rem;font-family: 'Courier New', Courier, monospace;">Posts and
                            Telecommunications Institute of Technology.</small>
                    </div>
                    <!-------------------- ------ Right Box ---------------------------->
                    <div class="col-md-6 right-box" style="height: 400px;">
                        <div class="row align-items-center">
                            <div class="header-text mb-4">
                                <h2>Hello,Again</h2>
                                <p>We are happy to have you back.</p>
                            </div>
                            <form action="login-action.htm" method="post" autocomplete="off">
                                <div class="input-group mb-3">
                                    <input type="username" class="form-control form-control-lg bg-light fs-6"
                                        placeholder="Username" name="username" autocomplete="off">
                                </div>
                                <div class="input-group mb-1">
                                    <input type="password" class="form-control form-control-lg bg-light fs-6"
                                        placeholder="Password" name="password" autocomplete="off">
                                </div>
                                <div class="input-group mb-5">
                                    <select class="form-select" name="databaseSite">
                                        <option selected value="0">Sinh viên</option>
                                        <c:forEach var="site" items="${listSite}" varStatus="loop">
                                            <option value="${loop.index + 1}">Nhân viên ${site}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="input-group mb-3">
                                    <button type="submit" class="btn btn-lg btn-primary w-100 fs-6">Login</button>
                                </div>
                            </form>
                        </div>
                        <div>
                            <c:if test="${not empty message}">
                                <div class="alert alert-danger">
                                    ${message}
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>
        </body>

        </html>