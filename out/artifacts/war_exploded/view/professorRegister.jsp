<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 11/06/2020
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Professor's Register</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="<c:url value="/css/modal.css"/>" rel="stylesheet" type="text/css"/>
    <!-- Compiled and minified JavaScript -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <script>


        window.onload = function () {

            $(document).ready(function () {
                $('select').formSelect();
            });

        };


        const showToast = function () {
            let d = document.getElementById("toast");
            d.classList.add("show");

            setTimeout(function () {
                d.classList.remove("show");
                d.remove();
            }, 3000);
        };


        window.onclick = function (event) {
            var modal1 = document.getElementById("remove1");
            var modal2 = document.getElementById("remove2");
            var modal3 = document.getElementById("modal1");
            var modal4 = document.getElementById("modal2");


            if (event.target === modal1) {
                modal1.style.display = "none";
            }
            if (event.target === modal2) {
                modal2.style.display = "none";
            }
            if (event.target === modal3) {
                modal3.style.display = "none";
            }
            if (event.target === modal4) {
                modal4.style.display = "none";
            }
        };

        const showdrop = function () {
            let d = document.getElementById("drop");
            if (d.classList.contains("hide"))
                d.classList.remove("hide");
            else
                d.classList.add("hide");
        };

        const showAddGradesForm = function () {

            let d = document.getElementById("modal1");
            d.style.display = "block";

        };

        const showAddAbsenceForm = function () {

            let d = document.getElementById("modal2");
            d.style.display = "block";

        };


        const del = function (index) {

            let d = document.getElementById("remove1");
            let d2 = document.getElementById("remove2");

            if (index === 1)
                d.classList.remove("hide");
            else
                d2.classList.remove("hide");


        };

        const closeMod = function (id, event) {
            console.log(id);
            console.log("closing modal");

            if (event != null)
                event.preventDefault();

            if (id === 1) {
                let d = document.getElementById("remove1");
                d.style.display = 'none';

            }
            if (id === 2) {
                let d = document.getElementById("remove2");
                d.style.display = 'none';

            }
            if (id === 3) {
                let d = document.getElementById("modal1");
                d.style.display = 'none';

            }
            if (id === 4) {
                let d = document.getElementById("modal2");
                d.style.display = 'none';
            }

        };


        const showModalDelete = function (id, item) {

            console.log(id);
            console.log(item.innerText);
            if (item.innerText === "R" || item.innerText === "A") {
                let d = document.getElementById("remove1");
                let form = document.getElementById("del1");
                let x = document.createElement("div");
                x.innerHTML = '<input type="hidden" name="index" value="' + id + '">';
                form.appendChild(x);
                d.style.display = "block";
            } else {
                let d = document.getElementById("remove2");
                let form = document.getElementById("del2");
                let x = document.createElement("div");
                x.innerHTML = '<input type="hidden" name="index" value="' + id + '">';
                form.appendChild(x);
                d.style.display = "block";
            }
        };

        const today = () => {

            let d = document.getElementById("tdy");
            d.submit();
        };

        const back = () => {
            let d = document.getElementById("back");
            d.submit();

        };
        const next = () => {

            let d = document.getElementById("next");
            d.submit();

        };
    </script>

    <style>

        .dot {
            height: 25px;
            width: 25px;
            border-radius: 50%;
            display: inline-block;
        }

        .red {
            background-color: red !important;
        }

        .green {
            background-color: #17b978 !important;
        }

        .blu {
            background-color: blue !important;
        }



        p {
            font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";        }

        .register {
            width: 78%;
            height: 100%;
            margin-top: 4%;
            margin-left: 1%;
            border-radius: 10px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
            display: flex;
            flex-direction: column;
            margin-bottom: 10%;
        }

        .header {
            border-radius: 10px 10px 0px 0px;
            display: flex;
            flex-direction: row;
            vertical-align: center;
            width: 100%;
            height: 10%;
            background-image: linear-gradient(160deg, rgba(140, 29, 255, 1) 0%, rgba(255, 130, 0, 1) 100%);

        }

        th {
            margin-left: 0;
            height: 20px;
            width: 20px;
            font-size: 14px;
        }

        td {
            text-align: center;
            vertical-align: middle;
            margin: 5px;
            height: 20px;
            width: 3%;

        }

        .buttonModalX {
            border: 0px !important;
        }

        table {
            border-collapse: collapse;
        }


        table tr:last-child {
            border: 0;
        }

        .temp {
            margin-left: 19%;
        }

        .row {
            width: 25%;
        }

        .border {
            outline: thin;
        }

        .title {
            display: table-cell;

            position: relative;
            font-size: 20px;
            padding-left: 10px;
            padding-top: 15px;
            color: white;
        }

        .insuff {
            color: red !important;
        }

        .curs {
            cursor: pointer !important;
            transition-delay: 0.1s;
        }

        .curs:hover {
            font-size: 24px !important;
            color: blueviolet !important;
        }


        .tabl {

            margin: 0%;

            width: 100%;
            height: 100%;
            font-size: 10px;

        }

        .ico {
            color: white;
            cursor: pointer;

        }

        .right {
            float: right !important;
            text-align: end !important;
        }

        .first {
            width: 20%;
        }

        .name {
            text-align: left !important;
            vertical-align: middle;
            font-size: 14px;
            color: black
        }

        .page {
            display: flex;
            flex-direction: row;
            align-content: stretch;
        }

        .legenda {
            width: 15%;
            margin: 4%;
            height: 100%;
            display: flex;
            flex-direction: column;
            margin-right: 2% !important;

        }

        .dropShow {
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            background-color: transparent;
            padding: 5px;
        }

        .legendaTitle {
            font-size: 20px;
            color: black;
            margin: 0px 0px 5px 0px;
        }

        .modal-content {
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
            border-radius: 10px;
            border: 0px;
            text-align: center !important;

        }

        .buttonShowSubj {
            background: linear-gradient(160deg, rgba(140, 29, 255, 1) 0%, rgba(255, 130, 0, 1) 100%);
            border-radius: 10px;
            border: 3px solid white;
            color: white;
            padding: 5px;
            font-size: 14px;
            -webkit-box-shadow: 0px 0px 5px 0px rgba(170, 170, 170, 1);
            -moz-box-shadow: 0px 0px 5px 0px rgba(170, 170, 170, 1);
            box-shadow: 0px 0px 5px 0px rgba(170, 170, 170, 1);
        }

        .plusLegenda {
            color: rgba(140, 29, 255, 1);
            font-size: 20px;
        }

        label {
            font-size: 16px !important;
            color: black !important;
        }

        .minHeight {
            min-height: 100vh !important;
        }

        .buttonShow {
            background-color: transparent;
            border: 3px solid white;
            border-radius: 10px;
            color: white;
            padding: 5px;
        }

        .showSubj {
            padding: 25px;
        }

        .record {
            font-size: 20px;
        }

        .oral {
            color: green;
        }

        .lab {
            color: blue;
        }

        .drop {
            width: auto;
            height: auto;
            z-index: 1;
            display: flex;
            overflow: auto;
            background: white;
            color: black;
            font-size: 10px;
        }

        .hide {
            visibility: hidden;
        }


    </style>
</head>
<body>
<jsp:useBean id="homebean" scope="session" type="bean.HomeBean"></jsp:useBean>
<jsp:useBean id="register" scope="session" type="bean.RegisterBean"></jsp:useBean>
<jsp:include page="navbar.jsp"></jsp:include>

<jsp:useBean id="professor" scope="session" type="bean.ProfessorBean"/>


<div class="page">
    <div class="register">
        <div id="drop" class="drop hide dropShow">
            <c:forEach items="${professor.matterList}" var="elem">
                <form action="ProfessorRegisterServlet" method="post" id="matter">

                    <input type="hidden" name="cmd" value="matter">
                    <input type="hidden" name="index" value="${elem.index}">
                    <div style="margin:0px; padding:10px 5px 0px 5px">
                        <button class="buttonShowSubj"
                                onclick="this.form.submit()">${elem.matter} ${elem.course}</button>
                    </div>

                </form>
            </c:forEach>
        </div>

        <div class="header">
            <p class="title">Register</p>
            <p class="title" style="margin-left:30%">${professor.matter.matter} ${professor.matter.course}</p>


            <div class="showSubj">
                <button class="buttonShow" onclick="showdrop()">Show</button>
            </div>
            <form id="back" class="title temp" action="ProfessorRegisterServlet" method="post">
                <i class="fa fa-arrow-left ico" aria-hidden="true" onclick="back()"></i>
                <input type="hidden" name="cmd" value="back">
            </form>
            <form id="tdy" class="title" action="ProfessorRegisterServlet" method="post">
                <p style="cursor:pointer" onclick="today()">Today</p>
                <input type="hidden" name="cmd" value="today">
            </form>
            <form id="next" class="title" action="ProfessorRegisterServlet" method="post">
                <i class="fa fa-arrow-right  ico" aria-hidden="true" onclick="next()"></i>
                <input type="hidden" name="cmd" value="next">
            </form>

        </div>

        <table class="striped responsive-table tabl">
            <tr>
                <th class="first name" style="margin-left: 10%">
                    ${register.month.name} ${register.month.year}
                </th>
                <c:forEach begin="1" end="${register.month.days}" var="day">
                    <th class="${register.month.sundays.contains(day)? 'sunday' : 'none'}">
                            ${day}
                    </th>
                </c:forEach>
                <th>AVG</th>
            </tr>

            <c:forEach items="${register.students}" var="student">
                <tr class="row">
                    <td><p class="name">${student.fullname}</p></td>
                    <c:forEach begin="1" end="${register.month.days}" var="day">
                        <c:forEach items="${student.record}" var="record">
                            <c:set var="val" value="" scope="application"></c:set>
                            <c:set var="id" value="" scope="application"></c:set>
                            <c:set var="css" value="" scope="application"></c:set>
                            <c:if test="${record.dayAsIndex == day}">
                                <c:set var="val" value="${record.value}"></c:set>
                                <c:set var="id" value="${record.ID}"></c:set>
                                <c:set var="css" value="${record.type}"></c:set>
                            </c:if>

                        </c:forEach>
                        <td>
                            <div class="record" onclick="showModalDelete(${id},this)"><a class="curs ${css}">${val}</a>
                            </div>
                        </td>
                        <c:set var="val" value=""></c:set>
                        <c:set var="id" value=""></c:set>
                        <c:set var="css" value=""></c:set>
                    </c:forEach>
                    <td>
                            ${student.media}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="legenda">
        <p class="legendaTitle">Legenda:</p>
        <label>
            <a>R:</a> Delay
        </label>
        <label>
            <a>A:</a> Absence
        </label>
        <label> <span class="dot black"></span> Written</label>
        <label> <span class="dot green"></span> Oral</label>
        <label> <span class="dot blu"></span> Lab</label>
        <label>
            <hr>
            <i class="fa fa-plus icon plusLegenda" aria-hidden="true" onclick="showAddGradesForm()"></i>&nbsp;&nbsp;Add
            Grades
        </label>
        <label>
            <i class="fa fa-plus icon plusLegenda" aria-hidden="true" onclick="showAddAbsenceForm()"></i>&nbsp;&nbsp;Add
            Absence
        </label>
    </div>


</div>

<div id="" class="modal">

</div>

<div id="remove1" class="modal minHeight">
    <div class="modal-content">
        <form id="del1" action="DeleteRecordServlet" method="post">
            <span class="col-12 right" onclick="closeMod(1)" class="close">&times;</span>

            <input type="hidden" value="absence" name="cmd">
            Are you sure to delete this abs?
            <button onclick="this.form.submit()"> ok</button>
        </form>
    </div>
</div>

<div id="remove2" class="modal minHeight">
    <div class="modal-content">
        <span class="col-12 right" onclick="closeMod(2)" class="close">&times;</span>

        <form id="del2" action="DeleteRecordServlet" method="post">
            <input type="hidden" value="grade" name="cmd">
            Are you sure to delete this grade?
            <button onclick="this.form.submit()"> ok</button>
        </form>
    </div>
</div>


<div id="modal1" class="modal minHeight">
    <div class="modal-content">
        <form id="add1" method="post" action="SaveRecordServlet">
            <input type="hidden" name="cmd" value="newgrade">
            <div class="col-12 right">
                <button class="buttonModalX" onclick="closeMod(3,event)">&times</button>
            </div>

            <div class="row">
                <label>Insert Student</label>
                <div class="input-field">
                    <select name="id">
                        <option selected disabled hidden>Select Student</option>
                        <c:forEach items="${register.students}" var="stud">
                            <option value="${stud.id}"><p>${stud.fullname}</p></option>
                        </c:forEach>
                    </select>
                </div>

            </div>
            <div class="row">
                <label>Insert Category </label>
                <select name="type">
                    <option value="written">
                        Written
                    </option>
                    <option value="oral">
                        Oral
                    </option>
                    <option value="lab">
                        Lab/Pratice
                    </option>
                </select>


            </div>
            <div class="row">

                <label>Insert voto
                    <input type="text" name="value" placeholder="1 to 10">
                </label>

            </div>
            <div class="row">

                <label>Insert Date
                    <input type="date" name="date">
                </label>

            </div>
            <button onclick="this.form.submit()">Save</button>
        </form>
    </div>
</div>

<div id="modal2" class="modal minHeight">
    <div class="modal-content">
        <form id="add2" method="post" action="SaveRecordServlet">
            <input type="hidden" name="cmd" value="newabsence">
            <div class="col-12 right">
                <button class="buttonModalX" onclick="closeMod(4,event)">&times</button>
            </div>

            <div class="row">
                <label>Insert Student</label>
                <div class="input-field">
                    <select name="id">
                        <option selected disabled hidden>Select Student</option>
                        <c:forEach items="${register.students}" var="stud">
                            <option value="${stud.id}"><p>${stud.fullname}</p></option>
                        </c:forEach>
                    </select>
                </div>

            </div>
            <div class="row">
                <label>Insert Category </label>
                <div class="input-field">
                    <select name="category">
                        <option value="ritardo">
                            Delay
                        </option>
                        <option value="absence">
                            Absence
                        </option>

                    </select>
                </div>

            </div>

            <div class="row">

                <label>Insert Date
                    <input type="date" name="date">
                </label>

            </div>
            <button onclick="this.form.submit()">Save</button>
        </form>
    </div>
</div>
</body>
</html>
