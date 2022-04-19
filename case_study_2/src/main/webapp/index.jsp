<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 4/18/2022
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body class="bg-light">
<div class="row">
    <div class="col-8 col-md-8">
        <a href="#"><img src="\furama_img\logo.png" alt=""></a>
        <h1 class="col d-flex justify-content-end" style="text-decoration-line: underline">FURMA MANAGEMENT PROGRAM</h1>
    </div>
    <div class="col-4 col-md-4">
        <h1>Mình có thực lực</h1>
        <h2>Mình buồn</h2>
        <h3>Mình ko có</h3>
        <h4>Sao phải buồn</h4>
    </div>
</div>
<div class="row w-100">
    <div class="col-12 w-100">
        <nav class="navbar navbar-expand-lg navbar-light bg-dark">
            <a class="navbar-brand text-white" href="#">Fumara Menu</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse d-flex justify-content-between" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link text-white p-3" href="/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-white p-3" href="/employee">Employee</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-white p-3" href="/customer?action=list">Customer</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-white p-3" href="#">Service</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-white p-3" href="#">Contract</a>
                    </li>
                </ul>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0 text-white" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
</div>
<!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
<div class="row">
    <div class="col-2">
        <ul>
            <li><a href="#">item1</a></li>
            <li><a href="#">item2</a></li>
            <li><a href="#">item3</a></li>
        </ul>
    </div>
<%--    this is body--%>
    <div class="col-10">
        this is body
    </div>
</div>
<!-- Columns are always 50% wide, on mobile and desktop -->
<div class="row">
    <div class="col-6">1</div>
    <div class="col-6">2</div>
</div>
<footer class="row-100">
    <div class="col-12">footer</div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
</body>
</html>
