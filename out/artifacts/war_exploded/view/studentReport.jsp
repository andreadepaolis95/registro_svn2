<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GianMarcoColagrossi
  Date: 16/06/2020
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" scope="session" type="bean.StudentBean"/>

<jsp:useBean id="report" scope="session" type="bean.ReportBean"/>

<html>
<head>
    <style>
        .cardReport{
            background: linear-gradient(160deg, rgba(140,29,255,1) 0%, rgba(255,130,0,1) 100%);
            border-radius: 10px !important;
            border: 3px solid white !important;
            color: white;
            box-shadow: 0 0 10px rgba(0,0,0,0.6);

        }

        .scrollReport{
            overflow: auto;
            height:368px;
            background-color: white;
            color:black;
            border-radius: 10px;
            padding:15px;
            margin:0px;
        }

        .pagella{
            height:500px;
            background-color: white;
            color:black;
            border-radius: 10px;
            padding:15px;
            margin:0px;
        }

        .btnStudentReport{
            padding:5px;
            color:white;
            border:3px solid white;
            background-color: transparent;
            border-radius: 10px;
            font-size:16px;
            margin:5px;
        }
    </style>
    <title>Student's Report</title>
    <link href="<c:url value="/css/card.css"/>"   rel="stylesheet" type="text/css" >

    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container-fluid col-12 row" style="padding:20px">

    <div class="container-fluid col-6">

            <div class="card cardReport" id="flp">
                    <div align="center" class="head col-12">
                        <div class="col-12"><p class="title">Subjects</p></div>
                    </div>

                    <div class="row" style="margin:0px; padding:0px 15px">
                    <c:forEach items="${student.matters}" var="mat">

                        <form action="StudentReportServlet" method="post">
                            <input type="hidden" value="change" name="cmd">
                            <input type="hidden" name="matter" value="${mat}">
                            <button class="btnStudentReport" onclick="this.form.submit()">${mat}</button>
                        </form>


                    </c:forEach>
                    </div>
                   <div class="card-body" style="padding:20px">
                    <div class="scrollReport col-12">
                        Selected Subject: <b>${student.selectedMatter}</b> <br>
                        <c:if test="${report.allGrades.size() == 0}">
                            No Marks available
                        </c:if>
                        <c:forEach items="${report.allGrades}" var="grade">
                            <b>${grade.value}</b> ${grade.type}  on ${grade.dateFormatted}<br>
                        </c:forEach>
                    </div>

                   </div>

        </div>

    </div>

    <div class="container-fluid col-6">
        <div class="card cardReport col-12" style="padding:0px">

            <div align="center" class="head col-12">
                <div class="col-12"><p class="title">School Report</p></div>
            </div><div class="card-body" >
            <div class="pagella col-12">
                <!-- poi sistemo bene come metterle-->

            <c:forEach items="${report.reportList}" var="item">
                <div class="col-12">
                <b>${item.matter}</b>: ${item.media}
                </div>
                <hr>
            </c:forEach>
            </div>
</div>
        </div>



    </div>




</div>

</body>
</html>
