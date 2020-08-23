<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 30/05/2020
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/view/error.jsp" %>
<html>
<head>
  <title>Login</title>
  <script  type="text/javascript" async src="javascript/common.js"></script>
    <script  type="text/javascript" async src="javascript/login.js"></script>
     <link type="text/css" rel="stylesheet" href="css/common.css" >

  <style>

      .transi{
          transition-delay: 1.0s;
          transition: visibility;

      }

      :root {
          --main-bg-color: #071a52;
          --main-bg-color2:#086972;
          --main-txt-color: #a7ff83;
          --main-bg-color3: #17b978;
      }


      .hide{
          visibility: hidden;
      }



      body{
          height: 100vh;
          background-image: background: linear-gradient(214deg, rgba(255,255,255,1) 0%, rgba(223,220,214,0.5564600840336135) 100%);;
          margin: 0px;
          transition: all .5s ease-in-out;

      }

      p{
          margin: 5px;
          color:var(--main-txt-color);
      }

      .container{
          width: 80%;
          height: 80%;
          background-color: var(--main-bg-color2);
          border-radius: 0px;
          margin: 0px;
          clip-path: circle(50% at 0% 0%);
          transition: all 2s ease-in-out;
      }

      .app{
          width: 100%;
          height: 100%;
          clip-path: circle(100%);
      }

      .subc{
          width:30%;
          position: fixed;
          top: 0;
          left: 0;
      }

      .tran{
          transition:all 2s ease-in-out;


      }

      .backG{
          background: linear-gradient(160deg, rgba(140,29,255,1) 0%, rgba(255,130,0,1) 100%);
      }


      .buttonLog1{
          padding:5px;
          color:white;
          border:3px solid white;
          background-color: transparent;
          border-radius: 10px;
          font-size:16px;
          margin:5px;
          position: relative;
          top: 30%;
          left: 10%;
      }
      .buttonLog2{

          color:white;
          border:3px solid white;
          background-color: blueviolet;
          border-radius: 10px;
          font-size:16px;
          margin:5px;
          position: absolute;
          bottom: 15%;
          right: 10%;

      }

      .textLogin{
          color:white;
          font-size:20px;
          font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
      }

      .prof{
          top: 50%;
          left: 70%;
      }

      .formLogin{
          border-radius: 5px;
          border:0px !important;
          height:28px;
          width:200px;
          border: 3px white;
          box-shadow: 0 0 6px grey;

      }


  </style>
</head>
<body>

<div id="cnt" class="container backG transi">

    <div id="sbc" class="subc tran" style="padding:20px">
        <p class="textLogin" id="show_name"></p><br>
        <form action="LoginServlet" method="post">
        <p class="textLogin"> Insert Username</p>
        <input class="text formLogin" type="text" name="username"> <br>
        <p class="textLogin">Insert Password</p>
        <input class="text formLogin" type="password" name="password">
        <input id="flag" type="hidden" name="isProfessor" value="false"><br><br>
        <input class="buttonLog" type="submit" value="Login">
        </form>
    </div>
    <button onclick="cust()"  id="lg1" class="buttonLog1  transi hide">Login as Student</button>

</div>

<div class="transi"><button onclick="cust()"  id="lg2" class="buttonLog2 transi">Login as professor</button></div>



</body>
</html>