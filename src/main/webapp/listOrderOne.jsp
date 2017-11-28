<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="site/header.jsp"></jsp:include>

<style>
    .mytable thead tr{
        height: 150px;
        vertical-align: middle;
    }
    .mytable thead tr {
        vertical-align: middle;
    }
    .mytable thead th {
        vertical-align: middle;
    }
    .mytable th.vertical {
        transform: rotate(-90deg);
        transform-origin: center center;
        vertical-align: middle;
        max-width: 30px;
        margin: 0;
        padding: 0;
        position: relative;
        bottom: -35px;
    }

</style>


<%--<div class="panel panel-default">--%>
    <%--<div class="panel-heading">--%>
        <%--<h1 class="panel-title">заполнить количество на дату</h1>--%>
    <%--</div>--%>
    <%--<div class="panel-body">--%>
        <%--<form name="orderForm" method="POST" action="WorkTaskController">--%>
            <%--<input type = "hidden" name="action" value="order"/>--%>
    <%--</div>--%>
<%--</div>--%>

    <div class="container" style="margin-top: 80px">
        <div class="row">
            <div class="col-12">
                <h1>Табличка</h1>
            </div>
        </div>
    </div>
    <div class="col-12">
        <div class = "row">
            <div class="table table-responsive">
                <table class="table table-bordered text-center mytable table-striped table-hover" >
                    <thead >
                    <tr>
                        <th scope="col" rowspan = "3" >Дата</th>
                        <th colspan="5" style="height: 20%">Цех1</th>
                    </tr>
                    <tr>
                        <th scope="col" rowspan = "2" class="vertical">Наряды</th>
                        <th scope="col" rowspan = "2" class="vertical"  >Распоряжения</th>
                        <th scope="col" rowspan = "2" class="vertical" >Численность</th>
                        <th colspan="2" style="height: 30%">Подрядные организации</th>
                    </tr>
                    <tr>
                        <th class="vertical" style="white-space: nowrap">Форма работы<br/>(наряд./распор.)</th>
                        <th class="vertical">Численность</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:out value="${orderTableRows}" escapeXml="false"/>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


<jsp:include page="site/footer.jsp"></jsp:include>
