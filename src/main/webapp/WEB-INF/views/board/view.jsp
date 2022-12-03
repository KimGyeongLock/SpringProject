<%@ page import="com.example.dao.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/12/03
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글보기</title>
    <style>
        #view {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 30%;
        }
        #view td, #view th {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .label {
            background-color: #006bb3;
            width: 100px;
            text-align:center;
            color: white;
        }

    </style>
</head>
<body>
    <h1>View Post</h1>
    <table id="view">
        <tr>
            <td class="label">Category</td><td class="content">${boardVO.getCategory()}</td>
        </tr>
        <tr>
            <td class="label">Title</td><td class="content">${boardVO.getTitle()}</td>
        </tr>
        <tr>
            <td class="label">Writer</td><td class="content">${boardVO.getWriter()}</td>
        </tr>
        <tr>
            <td class="label">Content</td><td class="content">${boardVO.getContent()}</td>
        </tr>
    </table>
    <br/>
    <button type="button" onclick="history.back()">뒤로 가기</button>
    <button type="button" onclick="location.href='../editpost/${boardVO.getSeq()}'">수정하기</button>
</body>
</html>
