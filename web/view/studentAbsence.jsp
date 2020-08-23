<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 21/06/2020
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>Student's Absence</title>

    <script>

        const showToast = function () {
            let d = document.getElementById("toast");
            d.classList.add("show");

            setTimeout(function () {
                d.classList.remove("show");
                d.remove();
            }, 3000);
        };


        const showPanel = function (doc) {

            event.preventDefault();
            let d = document.createElement("input");
            d.type = "text";
            d.name = "email";
            doc.appendChild(d);
            d.classList.add("formPin");
            d.placeholder = "Insert valid email";

            let t = document.getElementById("btn2");
            t.classList.remove("hide");

            let x = document.getElementById("btn1");
            x.classList.add("hide");
        }

    </script>

    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="<c:url value="/css/card.css"/>" rel="stylesheet" type="text/css"/>

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

        .hide {
            visibility: hidden;
        }

        .titleAbsence {
            color: white;
            font-size: 20px;
            margin: 0px;
        }

        .cardAbsence {
            font-size: 16px;
            background: linear-gradient(160deg, rgba(140, 29, 255, 1) 0%, rgba(255, 130, 0, 1) 100%);
            border-radius: 10px;
            border: 3px solid white;
            color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
        }

        .bodyAbsence {
            background-color: white;
            border-radius: 10px;
            padding: 10px;
            color: black;
            height: 400px;
            overflow: auto;
        }

        .bodyAbsence2 {
            background-color: white;
            border-radius: 10px;
            padding: 10px;
            color: black;
            height: 500px;
            overflow: auto;
        }

        .btnJustify {
            background-color: limegreen;
            border-radius: 10px;
            padding: 5px;
            font-size: 15px;
            color: white;
            border: 0px;
        }

        .btnStudentAbsence {
            padding: 5px;
            color: white;
            border: 3px solid white;
            background-color: transparent;
            border-radius: 10px;
            font-size: 16px;
            margin: 5px;
        }

        .formPin {
            border-radius: 10px;
            padding: 5px;
            color: black;

        }

    </style>


</head>
<jsp:include page="navbar.jsp"></jsp:include>
<jsp:useBean id="user" scope="session" type="bean.UserBean"></jsp:useBean>

<body>
<jsp:useBean id="absences" scope="session" type="bean.AbsenceList"></jsp:useBean>


<div class="container-fluid col-12 row" style="margin:0px">
    <div class="col-6" style="padding:20px">
        <div class="card cardAbsence">
            <div align="center" class="head col-12">
                <div class="col-12"><p class="titleAbsence">Absence</p></div>
            </div>
            <div style="padding:20px">

                <div class="bodyAbsence col-12">
                    <c:if test="${absences.absences.size() ==0}">
                        <p style="color:black">No absences to be justified</p>
                    </c:if>
                    <c:forEach items="${absences.absences}" var="ab">
                        <form action="StudentAbsenceServlet" method="post">
                            <input type="hidden" value="justify" name="cmd">
                            <input type="hidden" value="${ab.id}" name="index">
                            <div class="row col-12" style="margin:0px; padding:0px">
                                <div class="col-7">
                                    <p style="color:black">
                                            ${ab.type} on ${ab.dateFormatted}
                                    </p>
                                </div>
                                <div class="col-5 row" style="margin:0px; padding:0px">
                                    <div style="padding:0px 10px 0px 0px">
                                        <input type="text" class="formPin" placeholder="Insert Pin" name="pin"
                                               style="width:100px;">
                                    </div>
                                    <button class="btnJustify" onclick="this.form.submit()">Justify</button>
                                </div>
                            </div>
                            <hr style="margin:5px">
                        </form>
                    </c:forEach>

                </div>
            </div>
            <form action="StudentAbsenceServlet" method="post" class="col-12" style="padding:0px 15px">


                <button id="btn1" class="btnStudentAbsence" onclick="showPanel(this.form)">New Pin</button>
                <input type="hidden" value="pin" name="cmd">
                <button id="btn2" class="hide btnStudentAbsence" onclick="this.form.submit()">Send new Pin</button>

            </form>
            <p style="font-size:13px; margin:0px; padding-left: 15px">*In case you have lost your pin, you can request a new one by email here above</p>
            <form action="StudentAbsenceServlet" method="post" class="col-12" style="padding:0px 15px">

            </form>
        </div>
    </div>
    <div class="col-6" style="padding:20px">
        <div class="card cardAbsence">
            <div align="center" class="head col-12">
                <div class="col-12">
                    <p class="titleAbsence">Absence Justified</p>
                </div>
            </div>
            <div style="padding:20px">
                <div class="col-12 bodyAbsence2">
                    <c:if test="${absences.justifiedAbsences.size() ==0}">
                        <p style="color:black">No absences justified</p>
                    </c:if>
                    <c:forEach items="${absences.justifiedAbsences}" var="ab">
                        <p style="color:black">${ab.type} on ${ab.dateFormatted}</p>
                        <hr style="margin:5px">
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
