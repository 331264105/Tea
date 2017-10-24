<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>后台管理登录</title>
  <style>
    *{
      margin: 0;
      padding: 0;
    }
    body{
      width: 100%;
      height: 100%;
      min-width: 1200px;
      background: url('http://www.cycphp.top/Didu/images/banner1.jpg');
      position: relative;
    }
    form{
      width: 300px;
      height:200px;
      background-color: white;
      position: absolute;
      top: 160px;
      left: 50%;
      transform: translateX(-50%);
      text-align: center;
      line-height: 40px;
      /*opacity: 0.6;*/
      border: none;
      border-radius: 10px;
      padding: 10px;
    }
    form input{
      margin: 0 auto;
      width: 200px;
      height: 30px;
      outline:none;
    }
    form button{
      width: 160px;
      height: 40px;
      margin-top: 20px;
      background-color: skyblue;
      border-radius: 10px;
      border: none;
      color: white;
    }
  </style>
</head>
<body>
<!-- 登录  表 id  number（管理编号001以后 001的权限最高） username password -->
<form id="addform" action="login" method="post" onsubmit="return check();">
  <input class="number ip1" name="num" type="text" placeholder="请输入管理员编号"><br>
  <input class=" ip2" name="username" type="text" placeholder="请输入管理员姓名"><br>
  <input class=" ip3" name="password" type="password" placeholder="请输入密码">
  <br>
  <button class="button" type="submit" >提交</button>
</form>
<%--<button class="button2" type="submit">sdfs</button>--%>
<script src="js/jquery-1.12.3.min.js"></script>
<script>
  function check(){
    if (($(".ip1").val()!="")&($(".ip2").val()!="")&($(".ip3").val()!="")) {
      ajax1();
    }else{
      alert('登陆失败哦！请检查输入内容')
      return false;
    }
  }
 function ajax1(){
   $.post({
     url:"login",   //同action
     type:'post',
     dataType: 'json',
     success:function(data)
     {
       console.log(1);
       console.log(data);
       alert('登陆成功')
       location.href='WEB-INF/html/gly.html';
     },
     error :function(data)
     {
       console.log(2)
       console.log(data)
     },
   })
 }
</script>
</body>
</html>