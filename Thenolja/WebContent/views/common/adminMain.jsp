<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>관리자메인페이지</title>
    <link rel="stylesheet" href="resources/css/admin_select.css">
    <style>

        div{
            border : 1px solid red;
            box-sizing : border-box;
        }


        #wrap{
            width: 1200px;
            height: 1200px;
            margin: auto;
        }

  
        #wrap > div{
            width: 100%;
        }

        #header, #footer {
            height: 15%;
        }

        #content{
            height: 70%;
        }


        #content > div{
            height: 100%;
            float: left;
        }

        #content_1{
            width : 70%;
        }

        #content_2{
            width : 30%; 
        }



    </style>


</head>
<body>
    
    <div id="wrap">
        <div id="header">
	        <%@ include file="adminMenubar.jsp" %> 
        </div>
               
        <div id="content">
            <div id="content_1"></div>
            <div id="content_2"></div>
        </div>
        <div id="footer"></div>

    </div>

</body>
</html>