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
                            <th colspan="6" style="height: 20%">Цех1</th>
                        </tr>
                        <tr>
                            <th scope="col" rowspan = "2" class="vertical">Наряды</th>
                            <th scope="col" rowspan = "2" class="vertical"  >Распоряжения</th>
                            <th scope="col" rowspan = "2" class="vertical" >Численность</th>
                            <th colspan="2" style="height: 30%">Подрядные организации</th>
                            <th colspan="2" style="height: 30%"> - </th>
                        </tr>
                        <tr>
                            <th class="vertical" style="white-space: nowrap">Форма работы<br/>(наряд./распор.)</th>
                            <th class="vertical">Численность</th>
                        </tr>
                        </thead>
                        <tbody>
                            <form class="form-inline" method="post" action="WorkTaskController" name="frmAddOrder">
                                <input type="hidden" name="action" value="save_order">
    <td><input type="date" name="dateRec" class="form-control" value="2017-12-30"></td>
    <td><input type="text" name="nariad" class="form-control"></td>
    <td><input type="text" name="raspor" class="form-control"></td>
    <td><input type="text" name="count" class="form-control"></td>
    <td><input type="text" name="podrForm" class="form-control"></td>
    <td><input type="text" name="podrCount" class="form-control"></td>
    <td><button type="submit" class="btn btn-primary">Сохранить</button></td>
                            </form>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>



<jsp:include page="site/footer.jsp"></jsp:include>
