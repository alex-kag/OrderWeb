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
    .mytable thead tr th {
        vertical-align: middle;
    }
    .mytable th.vertical {
        transform: rotate(-90deg);
        vertical-align: middle;
    }
</style>


    <div class="container" style="margin-top: 80px">
        <div class="row">
            <div class="col-12">
                <h1>Табличка</h1>
            </div>
        </div>
        <div class = "row">
            <div class="col-12">
                <div class="table table-responsive">
                    <table class="table table-bordered text-center mytable table-striped table-hover" >
                        <thead >
                        <tr>
                            <th scope="col" rowspan = "3" >Дата</th>
                            <th colspan="5" style="height: 20%"><c:out value="${userCeh}" /></th>
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
                            <%--<c:out value="${orderTableRows}" escapeXml="false"/>--%>
                            <c:forEach items="${listRecords}" var = "oneRecord">
                                <tr>
                                    <td><c:out value="${oneRecord.dateRec}"/></td>
                                    <td><c:out value="${oneRecord.nariad}"/></td>
                                    <td><c:out value="${oneRecord.raspor}"/></td>
                                    <td><c:out value="${oneRecord.count}"/></td>
                                    <td><c:out value="${oneRecord.podrForm}"/></td>
                                    <td><c:out value="${oneRecord.podrCount}"/></td>
        <%--<td><fmt:formatDate pattern="yyyy-MMM-dd" value="${workTask.taskDate}" /></td>--%>
        <%--<td><fmt:formatDate pattern="yyyy-MMM-dd" value="${workTask.deadLine}" /></td>--%>
        <td><a href = "WorkTaskController?action=edit_order&id=<c:out value = "${oneRecord.idOneRecord}"/>">Редактировать</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>



<jsp:include page="site/footer.jsp"></jsp:include>
