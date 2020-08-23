<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 30/05/2020
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css"/>
    <title>Student's Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

    <style>

        .btnStudentHome {
            padding: 5px;
            color: white;
            border: 3px solid white;
            background-color: transparent;
            border-radius: 10px;
            font-size: 16px;
            margin: 5px;
        }


        .program-header {
            width: 100%;
            height: 10%;
            font-size: 20px;

        }

        .text4 {
            width: 100%;
            height: 200px;
            background-color: white;
            border-radius: 10px;
            overflow: auto;
        }

        .text1 {
            margin: 5px;
            color: black;
            font-size: 14px;

        }

        .title2 {
            margin: 5px;
            color: black;
            font-size: 18px;
        }


        td {

            border-bottom: 1px solid #ddd;
            text-align: center;
        }


        th {

            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        .page {
            width: 100%;
            display: flex;
            flex-direction: column;
            padding: 20px;

        }


        .card {
            font-size: 3em;
            background: linear-gradient(160deg, rgba(140, 29, 255, 1) 0%, rgba(255, 130, 0, 1) 100%);
            border-radius: 10px;
            border: 3px solid white;
            color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
        }

        .titleStudentHome {
            font-size: 18px;
            color: white;
        }

        .white {
            color: white;
        }

        .bckTransparent {
            background-color: transparent;
            border: 0px;
        }

        .textStudentHome {
            color: black;
            font-size: 16px;
        }

    </style>
</head>


<jsp:include page="navbar.jsp"></jsp:include>
<jsp:useBean id="util" scope="session" type="bean.Util"></jsp:useBean>
<jsp:useBean id="user" scope="session" type="bean.UserBean"></jsp:useBean>
<jsp:useBean id="student" scope="session" type="bean.StudentBean"></jsp:useBean>
<jsp:useBean id="homebean" scope="session" type="bean.HomeBean"></jsp:useBean>

<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

    response.setHeader("Pragma", "no-cache");

    response.setHeader("Expires", "0");


    if (session.getAttribute("user") == null) {
        response.sendRedirect("./index.jsp");
    }
%>
<div class="page">
    <div class="container-fluid col-12 row" style="margin:0px">
        <div class="col-6">
            <div class="card" style="padding:20px 5px">
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

                                        <c:set var="temp" value="${schedule.matter}" scope="application"></c:set>
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
        <div class="col-6">

            <div class="card">

                <div align="center" class="col-12">
                    <div class="col-12"><p class="titleStudentHome"><b>Homework</b></p></div>
                </div>

                <div class="col-12 row titleStudentHome" align="center" style="margin:0px">

                    <form action="StudentHomeServlet" method="post">
                        <input type="hidden" name="cmd" value="hmw">
                        <input type="hidden" name="amount" value="sub">
                        <button class="bckTransparent" onclick="this.form.submit()">
                            <i class="fa fa-arrow-left white" aria-hidden="true"></i>
                        </button>
                    </form>
                    <p class="titleStudentHome">${student.printDate()}</p>
                    <form action="StudentHomeServlet" method="post">
                        <input type="hidden" name="cmd" value="hmw">
                        <input type="hidden" name="amount" value="add">
                        <button class="bckTransparent" onclick="this.form.submit()">
                            <i class="fa fa-arrow-right white" aria-hidden="true"></i>
                        </button>
                    </form>
                </div>

                <div style="padding:15px">
                    <div class="text4">
                        <c:if test="${homebean.homework.size() == 0}">
                            <p class="text1">No homework today :) </p>
                        </c:if>
                        <c:forEach items="${homebean.homework}" var="hw">
                            <div>
                                <p class="text1">${hw.date} ${hw.matter}</p>
                                <p class=text1>${hw.text}</p>
                                <hr>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-12" style="padding:30px">
        <div class="card">
            <div class="program-header" style="padding:10px">

                Program ${student.selectedMatter}


            </div>
            <div class="list">
                <div class="col-12 row" style="margin:0px">
                    <c:forEach items="${student.matters}" var="matter">
                        <form action="StudentHomeServlet" method="post" style="margin:0px 0px 10px 0px">
                            <input type="hidden" name="cmd" value="arg">
                            <input type="hidden" name="matter" value="${matter}">
                            <button class="btnStudentHome" onclick="this.form.submit()">${matter}</button>
                        </form>
                    </c:forEach>
                </div>
                <div style="padding:15px">
                    <div class="text4" style="padding:10px">
                        <c:set var="index" scope="application" value="0"></c:set>
                        <c:if test="${homebean.argument.size() == 0}">
                            <p class="textStudentHome">No arguments </p>
                        </c:if>
                        <c:forEach items="${homebean.argument}" var="arg">
                            <div>
                                <c:set var="index" value="${index +1}"></c:set>
                                <p class="title2">Lezione:${index} ${arg.title}</p>
                                <p class=text1>${arg.text}</p>

                                <hr>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
</body>
</html>
