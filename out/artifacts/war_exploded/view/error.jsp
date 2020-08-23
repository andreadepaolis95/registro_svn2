<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 18/06/2020
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            height: 100vh;
            background-image: radial-gradient(circle, rgba(193,88,236,1) 0%, rgba(140,29,255,1) 100%);
            text-align: center;
            color: #fff;
            font-family: "Helvetica Neue";
            font-size: 16px;
            line-height: 1.5;
        }
        .logo {
            margin: 40px auto;
            display: block;
        }
        h1 {
            font-size: 24px;
            line-height: 40px;
            margin: 0 auto 16px;
            padding: 0 20px;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            letter-spacing: 0.5px;
            font-weight: 600;
            max-width: 600px;
        }
        p {
            color: #d6dce0;
            font-weight: 300;
            max-width: 600px;
            margin: 0 auto 24px;
            text-shadow: 0 2px 3px rgba(0, 0, 0, 0.1);
            letter-spacing: 0.5px;
            padding: 0 20px;
        }
        p a {
            color: inherit;
        }
        p a:hover {
            color: #fff;
        }
        .button {
            color: #2ea3f2;
            background: #fff;
            border-radius: 3px;
            display: inline-block;
            padding: 12px 48px;
            text-decoration: none;
            box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
            transition: all 0.2s ease-out;
        }
        .button:hover {
            margin-top: -2px;
            box-shadow: 0 6px 24px rgba(0, 0, 0, 0.4);
        }
        .browser {
            width: 400px;
            min-width: 200px;
            min-height: 264px;
            background: #fff;
            box-shadow: 0 40px 80px 0 rgba(0, 0, 0, 0.25);
            border-radius: 3px;
            animation: bobble 1.8s ease-in-out infinite;
            position: relative;
            left: 50%;
            margin-left: -200px;
        }
        .browser .controls {
            width: 100%;
            height: 32px;
            background: #e8ecef;
            border-radius: 3px 3px 0 0;
            box-sizing: border-box;
            padding: 10px 12px;
        }
        .browser .controls i {
            height: 12px;
            width: 12px;
            border-radius: 100%;
            display: block;
            float: left;
            background: #d6dce0;
            margin-right: 8px;
        }
        .eye {
            position: absolute;
            left: 34%;
            top: 80px;
            width: 32px;
            height: 32px;
            opacity: 1;
        }
        .eye + .eye {
            right: 34%;
            left: auto;
        }
        .eye:before, .eye:after {
            position: absolute;
            left: 15px;
            content: ' ';
            height: 40px;
            width: 3px;
            border-radius: 2px;
            background-color: #ff5e5b;
        }
        .eye:before {
            transform: rotate(45deg);
        }
        .eye:after {
            transform: rotate(-45deg);
        }
        .mouth {
            position: absolute;
            width: 250px;
            top: 178px;
            left: 50%;
            margin-left: -125px;
            height: 40px;
        }
        .mouth .lips {
            position: absolute;
            left: 15px;
            content: ' ';
            height: 40px;
            width: 3px;
            border-radius: 2px;
            background-color: #ff5e5b;
            transform: rotate(-54deg);
        }
        .mouth .lips:nth-child(odd) {
            transform: rotate(54deg);
        }
        .mouth .lips:nth-child(n+2) {
            margin-left: 31px;
        }
        .mouth .lips:nth-child(n+3) {
            margin-left: 62px;
        }
        .mouth .lips:nth-child(n+4) {
            margin-left: 93px;
        }
        .mouth .lips:nth-child(n+5) {
            margin-left: 124px;
        }
        .mouth .lips:nth-child(n+6) {
            margin-left: 155px;
        }
        .mouth .lips:nth-child(n+7) {
            margin-left: 186px;
        }
        .mouth .lips:nth-child(n+8) {
            margin-left: 217px;
        }
        .mouth .lips:nth-child(n+9) {
            margin-left: 248px;
        }
        @keyframes bobble {
            0%, 100% {
                margin-top: 40px;
                margin-bottom: 48px;
                box-shadow: 0 40px 80px rgba(0, 0, 0, 0.24);
            }
            50% {
                margin-top: 54px;
                margin-bottom: 34px;
                box-shadow: 0 24px 64px rgba(0, 0, 0, 0.40);
            }
        }
        @media only screen and (min-device-width: 320px) and (max-device-width: 480px) {
            .browser {
                width: 280px;
                margin-left: -140px;
            }
            .browser .eye {
                left: 30%;
            }
            .browser .eye + .eye {
                left: auto;
                right: 30%;
            }
        }

    </style>
</head>
<body>

<div class="browser">
    <div class="controls">
        <i></i>
        <i></i>
        <i></i>
    </div>

    <div class="eye"></div>
    <div class="eye"></div>
    <div class="mouth">
        <div class="lips"></div>
        <div class="lips"></div>
        <div class="lips"></div>
        <div class="lips"></div>
        <div class="lips"></div>
        <div class="lips"></div>
        <div class="lips"></div>
        <div class="lips"></div>
    </div>
</div>

<h1>Unfortunately, something has gone wrong.</h1>
<p>We're unable to fulfill your request. Rest assured we have been notified and are looking into the issue. Please go back. If the error continues, please contact our support team.</p>

<p>Cause</p>
<%=exception.getMessage() %>
</body>
</html>
