<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 07/06/2020
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script>

        var i = 0;

        const showToast = function () {
            let d = document.getElementById("toast");
            d.classList.add("show");
            setTimeout(function () {
                d.classList.remove("show");
                d.remove();
            }, 3000);
        };


        function f3() {
            let f = document.getElementById("form4");
            f.submit();
            setTimeout(() => flip(), 500
        )
            ;
        }


        function index() {
            i = i + 1;
            return i;
        }

        function test() {

            let d = document.getElementById("form1");
            d.submit();
        }

        function f2() {
            let f = document.getElementById("form2");
            f.submit();
            setTimeout(() => flip(), 500
        )
            ;
        }

        function flip2() {

            let t = document.getElementById("flp2");
            if (t.classList.contains("flipped"))
                t.classList.remove("flipped");
            else
                t.classList.add("flipped");
            let d = document.getElementById("hmw");
            d.value = "";
            let tm = document.getElementById("datepick");
            tm.valueAsDate = new Date();

        }

        function flip() {
            console.log("flipp")
            let tm = document.getElementById("datepick2");
            tm.valueAsDate = new Date();

            let t = document.getElementById("flp");
            if (t.classList.contains("flipped"))
                t.classList.remove("flipped");
            else
                t.classList.add("flipped");

        }
    </script>

    <style>

        .right {
            float: right !important;
            text-align: end !important;
        }

        .cardProj {
            border: 0px !important;
            background-color: transparent !important;
        }

        .iconx {
            color: red;
            cursor: pointer;
            font-size: 20px;
        }

        .head {
            width: 100%;
            height: 10%;
            display: flex;
            flex-flow: row;
        }

        .icon {
            cursor: pointer;
            color: white;

            margin-left: 58%;

        }

        .btn-add {
            border-radius: 30px;
        }

        .cardSubjHome {
            font-size: 16px;
            background: linear-gradient(160deg, rgba(140, 29, 255, 1) 0%, rgba(255, 130, 0, 1) 100%);
            border-radius: 10px;
            border: 3px solid white;
            color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
        }

        .container2 {
            margin-left: 3%;
            margin-right: 3%;
            width: 100%;
            height: 100%;
            display: flex; /* or inline-flex */
            flex-direction: row;

        }

        .pox {
            margin: 5%;

        }

        .cnt2 {
            margin: 10px;
            padding: 5px;
            width: auto;
            height: auto;
            background-image: linear-gradient(160deg, rgba(140, 29, 255, 1) 0%, rgba(255, 130, 0, 1) 100%);
            border-radius: 10px;
            border: 3px solid white;
            color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);

        }

        .activeBtn {
            background-color: blue !important;
        }

        td {
            margin: 0 !important;
            padding: 0 !important;
            border-bottom: 1px solid #ddd;
            text-align: center;
            font-size: 12px;
        }


        th {
            width: auto !important;
            margin: 0 !important;
            padding: 0 !important;
            border-bottom: 1px solid #ddd;
            text-align: center;
            min-width: 100px;
        }

        .btn-card {
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid white;
            color: black;
        }

        .formDate {
            border-radius: 5px;
            border: 0px !important;
            height: 28px;
            width: 200px;
        }

        .cnt3 {
            height: 50%;
            width: 50%;
            margin: 5%;
        }

        .btnSubj {
            padding: 5px;
            color: white;
            border: 3px solid white;
            background-color: transparent;
            border-radius: 10px;
            font-size: 16px;
            margin: 5px;
        }

        .cls-btn {
            border-radius: 10px;
            width: 70%;
            vertical-align: center;
            background-image: linear-gradient(160deg, rgba(140, 29, 255, 1) 0%, rgba(255, 130, 0, 1) 100%);
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
            border: 3px solid white;
        }

        .cls-p {
            vertical-align: center;
            margin-top: 8px;
        }
    </style>
    <link href="<c:url value="/css/card.css"/>" rel="stylesheet" type="text/css">

    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css"/>


    <title>Professor's Home</title>

    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>

</head>
<body>

<jsp:include page="navbar.jsp"></jsp:include>
<jsp:useBean id="util" scope="session" type="bean.Util"></jsp:useBean>
<jsp:useBean id="user" scope="session" type="bean.UserBean"></jsp:useBean>
<jsp:useBean id="homebean" scope="session" type="bean.HomeBean"></jsp:useBean>
<jsp:useBean id="professor" scope="session" type="bean.ProfessorBean"></jsp:useBean>

<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

    response.setHeader("Pragma", "no-cache");

    response.setHeader("Expires", "0");


    if (session.getAttribute("user") == null) {
        response.sendRedirect("./index.jsp");
    }
%>
<div class="container-fluid col-12 row" style="margin:0px; padding:20px 30px 0px 30px">
    <div class="container-fluid col-6 justify-content-start" style="padding:10px 40px  20px 20px;">
        <div class="cardSubjHome" style="padding:10px">
            <p style="padding:5px 15px"><b>Select class:</b></p>
            <div class="row" style="margin:0px; padding:0px 15px">

                <c:forEach items="${professor.matterList}" var="temp">
                    <form action="ProfessorHomeServlet" method="post">
                        <input type="hidden" name="cmd" value="class">
                        <input type="hidden" name="index" value="${temp.index}">
                        <button class="btnSubj" onclick="this.form.submit()">
                                ${temp.nameExtended()}
                        </button>
                    </form>
                </c:forEach>
            </div>
        </div>
    </div>


    <div class="container-fluid col-6" style="margin:0px; padding:0px 20px 20px 30px">


        <div class="cnt2" style="width:auto">

            <table class="table table-borderless table-sm text-center">

                <tr>
                    <th><p>Schedule</p></th>
                    <c:forEach items="${util.days}" var="day">
                        <th><p>${day}</p></th>
                    </c:forEach>
                </tr>
                <c:forEach items="${util.hours}" var="hour">
                    <tr>
                        <td>
                            <p>${hour}:00</p>
                        </td>
                        <c:forEach items="${util.intDays}" var="day">

                            <c:forEach items="${homebean.schedule}" var="schedule">
                                <c:if test="${schedule.day == day && schedule.hour == hour}">

                                    <c:set var="temp" value="${schedule.matter.concat(' ').concat(schedule.course)}"
                                           scope="application"></c:set>
                                </c:if>
                            </c:forEach>
                            <c:if test="${temp.equals('void')}">
                                <td><p></p></td>
                            </c:if>
                            <c:if test="${!temp.equals('void')}">
                                <td><p>${temp}</p></td>
                                <c:set var="temp" value="${'void'}" scope="application"></c:set>

                            </c:if>

                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
<div class="container2 col-12 row" style="margin:0px">
    <div class="flipCard col-6" style="padding:0px 40px">
        <div class="card cardProj" id="flp">
            <div class="side front">
                <div align="center" class="head col-12">
                    <div class="col-6"><p class="title">Topics</p></div>
                    <div class="col-6"><p class="title">${professor.matter.nameExtended()}</p></div>

                </div>

                <div class="text">
                    <c:set var="i" scope="application" value="0"></c:set>
                    <c:if test="${homebean.argument.size() == 0}">
                        <p class="text1">No Argument already assigned </p>
                    </c:if>
                    <c:forEach items="${homebean.argument}" var="arg">
                        <div>
                            <c:set var="i" value="${i +1}"></c:set>
                            <div class="row align-items-center" style="margin:0px; padding:0px">

                                <div style="margin:0px; padding:0px"><p class="title2">Lezione:${i} ${arg.title}</p>
                                </div>
                                <div style="margin:0px; padding:0px">
                                    <form style="margin:0px; padding:0px" action="AssignmentServlet" method="post">
                                        <input type="hidden" name="cmd" value="del_arg">
                                        <input type="hidden" name="index" value="${arg.id}">
                                        <i class="fa fa-times iconx" aria-hidden="true"
                                           onclick="this.parentNode.submit()"></i>
                                    </form>
                                </div>
                            </div>

                            <p class="text1">${arg.text}</p>

                            <hr>
                        </div>
                    </c:forEach>
                </div>
                <div align="center" class="col-12" style="padding:0px 0px 10px 0px">
                    <div class="col-12" style="margin:0px; padding:0px">
                        <button class="btnSubj" onclick="flip()">Add Lesson</button>
                    </div>
                </div>
            </div>
            <div class="side back">

                <form id="form2" method="post" action="SaveAssignmentServlet">
                    <div class="col-12">
                        <input name="cmd" type="hidden" value="arg">
                        <p class="col-12" style="margin:0px"><b>Insert Title</b><i class="fa fa-times right"
                                                                                   aria-hidden="true"
                                                                                   onclick="flip()"></i></p><br>
                        <input type="text" class="textarea" name="title">

                    </div>
                    <div style="padding:15px" class="col-12">
                        <p style="margin:0px"><b>Insert Description</b></p><br>

                        <textarea style="resize: none;" class="textarea" name="desc"></textarea>
                    </div>
                    <div class="col-12" style="padding:15px">
                        <p style="margin:0px"><b>Date:</b></p><br>

                        <input class="formDate" type="date" name="date" id="datepick2">
                    </div>
                    <br>
                    <button class="btnSubj" onclick="f2()">Save</button>
                </form>
            </div>

        </div>
    </div>


    <div class="flipCard col-6" style="padding:0px 40px">
        <div class="card cardProj" id="flp2">
            <div class="side front">
                <div align="center" class="head col-12">
                    <div class="col-6"><p class="title">Homework</p></div>
                    <div class="col-6"><p class="title">${professor.matter.nameExtended()}</p></div>

                </div>

                <div class="text">

                    <c:if test="${homebean.homework.size() == 0}">
                        <p class="text1">No homework already assigned </p>
                    </c:if>
                    <c:forEach items="${homebean.homework}" var="hw">
                        <div>
                            <div class="row align-items-center" style="margin:0px; padding:0px">
                                <div style="margin:0px; padding:0px">

                                    <p class="title2">Assigned on ${hw.date}</p>
                                </div>
                                <div style="margin:0px; padding:0px">
                                    <form style="margin:0px; padding:0px" action="AssignmentServlet" method="post">
                                        <input type="hidden" name="cmd" value="del_hmw">
                                        <input type="hidden" name="index" value="${hw.id}">
                                        <i class="fa fa-times iconx" aria-hidden="true"
                                           onclick="this.parentNode.submit()"></i>
                                    </form>
                                </div>
                            </div>
                            <p class=text1>${hw.text}</p>

                            <hr>
                        </div>
                    </c:forEach>
                </div>
                <div align="center" class="col-12" style="padding:0px 0px 10px 0px">
                    <div class="col-12" style="margin:0px; padding:0px">
                        <button class="btnSubj" onclick="flip2()">Add Homework</button>
                    </div>
                </div>
            </div>
            <div class="side back">
                <form id="form4" action="SaveAssignmentServlet" method="post">
                    <div class="col-12">

                        <input type="hidden" name="cmd" value="homework">
                        <p class="col-12" style="margin:0px"><b>Homework:</b><i class="fa fa-times right"
                                                                                aria-hidden="true"
                                                                                onclick="flip2()"></i></p><br>
                        <textarea style="resize: none;" class="textarea" id="hmw" name="desc"></textarea>
                    </div>
                    <br>
                    <p style="margin:0px"><b>Date:</b></p><br>

                    <input class="formDate" type="date" name="date" id="datepick">
                </form>
                <br>

                <button class="btnSubj" onclick="f3()">Save</button>

            </div>

        </div>
    </div>


</div>


</body>
</html>
